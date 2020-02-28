package com.supplier.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private int gId;    
    private int bId;    
    private int qty;
    private short success;    
}
