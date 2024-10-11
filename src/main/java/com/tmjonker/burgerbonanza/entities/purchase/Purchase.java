package com.tmjonker.burgerbonanza.entities.purchase;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "purchase_menu_items",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<MenuItem> menuItems;

    private double totalPrice;

    public Purchase(List<MenuItem> menuItems, double totalPrice, Date date) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @CreationTimestamp
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date date;

    public Purchase(List<MenuItem> menuItems, double totalPrice) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
    }

    public Purchase() {

    }

    public Long getId() {
        return id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {

        menuItems.add(menuItem);
    }

    public void addMenuItems(List<MenuItem> menuItems) {

        this.menuItems.addAll(menuItems);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
