package com.supplier.service;

import com.supplier.mapper.OrderMapper;
import com.supplier.model.dto.OrderDTO;
import com.supplier.model.entity.TOrder;
import com.supplier.repository.OrderRepository;
import java.util.List;
import org.apache.commons.collections4.IterableUtils;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO getById(int id) {
        return orderMapper.mapEntityToDto(orderRepository.findById(id).get());
    }

    public List<OrderDTO> getAllOrders() {
        Iterable<TOrder> order = orderRepository.findAll();
        return orderMapper.mapEntityListToDtoList(IterableUtils.toList(order));
    }

    public boolean updateOrder(TOrder order) {
        orderRepository.save(order);
        return true;
    }

    public OrderDTO insertOrder(TOrder order) {
        orderRepository.save(order);
        return orderMapper.mapEntityToDto(order);
    }

    public boolean deleteOrder(int id) {
        orderRepository.deleteById(id);
        return true;
    }

    public List<TOrder> getAllUnsuccessOrders(int gId) {
        return orderRepository.getUnsuccessOrder(gId);
    }

}
