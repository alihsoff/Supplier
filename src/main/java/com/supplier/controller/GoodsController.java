package com.supplier.controller;

import com.supplier.TCPServer.TCPConnection;
import com.supplier.model.GoodsRequest;
import com.supplier.model.dto.GoodsDTO;
import com.supplier.model.entity.TGoods;
import com.supplier.model.entity.TOrder;
import com.supplier.service.GoodsService;
import com.supplier.service.OrderService;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/goods")
@RestController
public class GoodsController {

    private final GoodsService service;
    private final OrderService oService;

    public GoodsController(GoodsService service, OrderService oService) {
        this.service = service;
        this.oService = oService;
    }

    @ApiOperation("get all goods by id")
    @GetMapping
    public List<GoodsDTO> getGoods() {
        return service.getAllGoodss();
    }

    @ApiOperation("Send goods to buyer")
    @PostMapping("/{gId}/{qty}/buyer/{bId}")
    public GoodsDTO sendGoods(
            @PathVariable("gId") int gId,
            @PathVariable("bId") int bId,
            @PathVariable("qty") int qty
    ) {
        GoodsDTO goodsDTO = service.getById(gId);
        GoodsDTO goodsRequest = goodsDTO;
        if (goodsDTO.getQty() >= qty) {
            goodsDTO.setQty(goodsDTO.getQty() - qty); // for update 
            createOrder(gId, bId, qty, true);
            service.updateGoods(gId, goodsDTO);
            goodsDTO.setQty(qty); // for posting
            TCPConnection.sendMessage("Sending " + qty + " much of " + goodsDTO.getName());
        } else {
            createOrder(gId, bId, qty, false);
            TCPConnection.sendMessage("The warehouse will send them the goods as soon as they get it.");
            goodsDTO = null;
        }
        return goodsDTO;
    }

    @ApiOperation("get goods by id")
    @GetMapping("/{id}")
    public GoodsDTO getGoodsById(
            @PathVariable(name = "id") int id
    ) {
        return service.getById(id);
    }

    @ApiOperation("insert new goods")
    @PostMapping
    public void inertGoods(@RequestBody GoodsRequest goodsRequest) {
        service.insertGoods(goodsRequest);
    }

    @ApiOperation("add goods")
    @PutMapping("/{id}/{qty}")
    public void addGoods(
    @PathVariable(name = "id") int id,
    @PathVariable(name = "qty") int qty        
    ) {
        service.addGoods(id, qty);
        reOrder(id, getGoodsById(id).getQty());
    }

    @ApiOperation("update goods by id")
    @PutMapping("/{id}")
    public void updateGoods(@PathVariable("id") int id, @RequestBody GoodsDTO goodsDTO) {
        service.updateGoods(id, goodsDTO);
    }

    @ApiOperation("delete goods by id")
    @DeleteMapping("/{id}")
    public void deleteGoods(@PathVariable("id") int id) {
        service.deleteGoods(id);
    }

    private void reOrder(int goodsID,int goodsQty) {
        List<TOrder> order = oService.getAllUnsuccessOrders(goodsID);
        for (TOrder o : order) {
            if (goodsQty >= o.getQty()) {
                String url = "http://localhost:8081/buyer/orderGoods/" + o.getOGId() + "/" + o.getQty();
                sendToSpecificClient(url);
                oService.deleteOrder(o.getOId());
            }
        }
    }

    private void sendToSpecificClient(String requestUrl) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(requestUrl, null, String.class);
    }

    private TOrder createOrder(int goodsId, int buyerId, int qty, boolean isSuccess) {
        TOrder order = new TOrder();
        order.setOBId(buyerId);
        order.setOGId(goodsId);
        order.setQty(qty);
        if (isSuccess) {
            order.setOSuccess(true);
        } else {
            order.setOSuccess(false);
        }
        oService.insertOrder(order);
        return order;
    }
}
