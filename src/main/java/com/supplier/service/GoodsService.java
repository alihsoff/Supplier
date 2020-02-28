package com.supplier.service;

import com.supplier.mapper.GoodsMapper;
import com.supplier.model.GoodsRequest;
import com.supplier.model.dto.GoodsDTO;
import com.supplier.model.entity.TGoods;
import com.supplier.repository.GoodsRepository;
import java.util.List;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;

    public GoodsService(GoodsRepository goodsRepository, GoodsMapper goodsMapper) {
        this.goodsRepository = goodsRepository;
        this.goodsMapper = goodsMapper;
    }

    public GoodsDTO getById(int id) {
        return goodsMapper.mapEntityToDto(goodsRepository.findById(id).get());
    }

    public List<GoodsDTO> getAllGoodss() {
        Iterable<TGoods> goods = goodsRepository.findAll();
        return goodsMapper.mapEntityListToDtoList(IterableUtils.toList(goods));
    }

    public void updateGoods(int id, GoodsDTO goodsDTO) {
        TGoods goods = goodsRepository.findById(id).get();
        goods.setGName(goodsDTO.getName());
        goods.setGQty(goodsDTO.getQty());
        goodsRepository.save(goods);
    }

    public void insertGoods(GoodsRequest goodsRequest) {
        TGoods goods = new TGoods();
        goods.setGName(goodsRequest.getName());
        goods.setGCost(goodsRequest.getCost());
        goods.setGQty(goodsRequest.getQty());
        goodsRepository.save(goods);
    }

    public void deleteGoods(int id) {
        goodsRepository.deleteById(id);
    }
    
    public void addGoods(int id,int qty){
    TGoods goods = goodsRepository.findById(id).get();
    goods.setGQty(goods.getGQty()+qty);
    goodsRepository.save(goods);
    }

}
