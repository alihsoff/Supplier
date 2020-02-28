/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supplier.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_order")
@XmlRootElement
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TOrder implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "O_G_ID")
    private int oGId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "O_B_ID")
    private int oBId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "O_SUCCESS")
    private boolean oSuccess;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "O_ID")
    private Integer oId;

    public int getOGId() {
        return oGId;
    }

    public void setOGId(int oGId) {
        this.oGId = oGId;
    }

    public int getOBId() {
        return oBId;
    }

    public void setOBId(int oBId) {
        this.oBId = oBId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean getOSuccess() {
        return oSuccess;
    }

    public void setOSuccess(boolean oSuccess) {
        this.oSuccess = oSuccess;
    }

}
