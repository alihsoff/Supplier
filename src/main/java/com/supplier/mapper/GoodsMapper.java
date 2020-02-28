package com.supplier.mapper;

import com.supplier.model.dto.GoodsDTO;
import com.supplier.model.entity.TGoods;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class GoodsMapper {
    public GoodsDTO mapEntityToDto(TGoods goodsEntity){
        return GoodsDTO.builder()
                .id(goodsEntity.getGId())
                .name(goodsEntity.getGName())
                .qty(goodsEntity.getGQty())
                .build();
                
    }
    
    public List<GoodsDTO> mapEntityListToDtoList(List<TGoods> goodsEntites){
        return goodsEntites.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
