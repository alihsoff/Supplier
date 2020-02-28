/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supplier.repository;

import com.supplier.model.entity.TOrder;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TOrder, Integer>{
    @Query("select o from TOrder o where o.oGId = ?1 and o.oSuccess = false")
    public List<TOrder> getUnsuccessOrder(int gId);
    
}
