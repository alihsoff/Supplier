/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supplier.repository;

import com.supplier.model.entity.TBuyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<TBuyer, Integer>{
    
}
