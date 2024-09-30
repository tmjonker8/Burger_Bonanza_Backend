package com.tmjonker.burgerbonanza.dtos;

import jakarta.persistence.Column;

public class MenuItemDTO {

    private String category;
    private String name;
    private String description;
    private double price;
    private String imgPath;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public MenuItemDTO() {
    }

    public MenuItemDTO(String category, String name, String description, double price, String imgPath) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }
}
