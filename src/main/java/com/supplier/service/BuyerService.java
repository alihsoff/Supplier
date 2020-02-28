package com.supplier.service;

import com.supplier.mapper.BuyerMapper;
import com.supplier.model.dto.BuyerDTO;
import com.supplier.model.entity.TBuyer;
import com.supplier.repository.BuyerRepository;
import java.util.List;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerMapper buyerMapper;

    public BuyerService(BuyerRepository buyerRepository,BuyerMapper buyerMapper) {
        this.buyerRepository = buyerRepository;
        this.buyerMapper = buyerMapper;
    }

    public BuyerDTO getById(int id) {
        return buyerMapper.mapEntityToDto(buyerRepository.findById(id).get());
    }

    public List<BuyerDTO> getAllBuyers() {
        Iterable<TBuyer> buyer = buyerRepository.findAll();
        return buyerMapper.mapEntityListToDtoList(IterableUtils.toList(buyer));
    }
    
    public void updateBuyer(int id,BuyerDTO buyerDTO) {
        TBuyer buyer = buyerRepository.findById(id).get();
        buyer.builder()
                .bName(buyerDTO.getName())
                .build();
        buyerRepository.save(buyer);
    }
    public void insertBuyer(BuyerDTO buyerDTO) {
        TBuyer buyer = new TBuyer();
        buyer.builder()
                .bName(buyerDTO.getName());
        buyerRepository.save(buyer);
        buyerMapper.mapEntityToDto(buyer);
    }
    
    public void deleteBuyer(int id) {
        buyerRepository.deleteById(id);
    }
    
}
