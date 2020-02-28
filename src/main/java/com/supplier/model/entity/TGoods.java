package com.supplier.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_goods")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TGoods implements Serializable {

    @Size(max = 255)
    @Column(name = "G_NAME")
    private String gName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "G_COST")
    private BigDecimal gCost;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "G_ID")
    private Integer gId;
    @Column(name = "G_QTY")
    private Integer gQty;

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public BigDecimal getGCost() {
        return gCost;
    }

    public void setGCost(BigDecimal gCost) {
        this.gCost = gCost;
    }

    
}
