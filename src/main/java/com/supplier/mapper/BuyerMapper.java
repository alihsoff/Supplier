/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supplier.mapper;

import com.supplier.model.dto.BuyerDTO;
import com.supplier.model.entity.TBuyer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BuyerMapper {
    public BuyerDTO mapEntityToDto(TBuyer buyerEntity){
        return BuyerDTO.builder()
                .name(buyerEntity.getBName())
                .build();
    }
    
    public List<BuyerDTO> mapEntityListToDtoList(List<TBuyer> buyerEntites){
        return buyerEntites.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
