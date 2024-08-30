package com.tmjonker.burgerbonanza.entities.shoppingcart;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.entities.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "num_items", nullable = false)
    private int numItems;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "cart_items",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<MenuItem> menuItems;

    @OneToOne(mappedBy = "shoppingCart")
    private User user;

    public ShoppingCart(int numItems, List<MenuItem> menuItems) {
        this.numItems = numItems;
        this.menuItems = menuItems;
    }

    public ShoppingCart() {

    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumItems() {
        return numItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public User getUser() {
        return user;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addMenuItem(MenuItem menuItem) {

        menuItems.add(menuItem);
    }

    public void addMenuItems(List<MenuItem> menuItems) {

        this.menuItems.addAll(menuItems);
    }
}
