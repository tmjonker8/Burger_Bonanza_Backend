package com.tmjonker.burgerbonanza.entities.purchase;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;

import javax.persistence.*;
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
