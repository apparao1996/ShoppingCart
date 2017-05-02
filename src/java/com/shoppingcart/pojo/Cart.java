/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author janith
 */
@Entity
@Table(name = "invoice")
public class Cart {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<CartItem> itemList = new ArrayList<CartItem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addItem(Item item, int quantity) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            CartItem cartItem = itemList.get(itemIndex);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            itemList.add(new CartItem(item, quantity));
        }
    }

    public void removeItem(Item item) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            itemList.remove(itemIndex);
        }
    }

    public void updateQuantity(Item item, int quantity) {
        int itemIndex = hasItem(item);
        if (itemIndex != -1) {
            CartItem cartItem = itemList.get(itemIndex);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
    }

    public void setItemList(List<CartItem> itemList) {
        this.itemList = itemList;
    }

    public List<CartItem> getItemList() {
        return itemList;
    }

    /*
	 * Checks whether an item is already is in the cart.
	 * If exists, return it's index, else return -1. 
     */
    private int hasItem(Item item) {
        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItem().equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
