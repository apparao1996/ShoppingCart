/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author janith
 */
@Entity
@Table(name = "invoice_item")
@NamedQueries({
    @NamedQuery(name = "InvoiceItem.findAll", query = "SELECT i FROM InvoiceItem i"),
    @NamedQuery(name = "InvoiceItem.findById", query = "SELECT i FROM InvoiceItem i WHERE i.id = :id"),
    @NamedQuery(name = "InvoiceItem.findByQuantity", query = "SELECT i FROM InvoiceItem i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "InvoiceItem.findByPrice", query = "SELECT i FROM InvoiceItem i WHERE i.price = :price")})
public class InvoiceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    
    @JoinColumn(name = "inv_id", referencedColumnName = "invoice_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Invoice invId;
    
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Item itemId;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer id) {
        this.id = id;
    }

    public InvoiceItem(Integer id, int quantity, int price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Invoice getInvId() {
        return invId;
    }

    public void setInvId(Invoice invId) {
        this.invId = invId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItem)) {
            return false;
        }
        InvoiceItem other = (InvoiceItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcart.pojo.InvoiceItem[ id=" + id + " ]";
    }
    
}
