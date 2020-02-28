/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supplier.mapper;

import com.supplier.model.dto.OrderDTO;
import com.supplier.model.entity.TOrder;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO mapEntityToDto(TOrder orderEntity){
        return OrderDTO.builder()
                .bId(orderEntity.getOBId())
                .gId(orderEntity.getOGId())
                .qty(orderEntity.getQty())
                .build();
    }
    
    public List<OrderDTO> mapEntityListToDtoList(List<TOrder> orderEntites){
        return orderEntites.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
