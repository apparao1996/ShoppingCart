/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author janith
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invId", fetch = FetchType.EAGER)
    private List<InvoiceItem> invoiceItemList;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    //Adds an item to cart.
    //If the cart already has the same item, increment the quantity
    public void addItem(Item item, int quantity) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            InvoiceItem invoiceItem = invoiceItemList.get(itemIndex);
            invoiceItem.setQuantity(invoiceItem.getQuantity() + quantity);
        } else {
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setInvId(this);
            invoiceItem.setItemId(item);
            invoiceItem.setPrice(item.getPrice());
            invoiceItem.setQuantity(quantity);
            invoiceItemList.add(invoiceItem);
        }
    }

    public void removeItem(Item item) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            invoiceItemList.remove(itemIndex);
        }
    }

    //Simply updates the quantity
    public void updateQuantity(Item item, int quantity) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            InvoiceItem invoiceItem = invoiceItemList.get(itemIndex);
            invoiceItem.setQuantity(invoiceItem.getQuantity() + quantity);
        }
    }

    private int hasItem(Item item) {        
        int index = -1;
        if(invoiceItemList == null){
            invoiceItemList = new ArrayList<InvoiceItem>();
            return index;
        }
        for (int i = 0; i < invoiceItemList.size(); i++) {
            if (invoiceItemList.get(i).getItemId().equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public List<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcart.pojo.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}
