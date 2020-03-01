/*
 * Copyright (c) 2019-2020, Aamat.org
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *
 * modification, are permitted provided that the following conditions
 *
 * are met: no conditions.
 */

package org.azamat.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This is class entity of Product.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "products")
public class Product {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ProductName.
     */
    private String productName;

    /**
     * Description.
     */
    private String description;

    /**
     * Manufacturer.
     */
    private String manufacturer;

    /**
     * PictureUrl.
     */
    @Column(name = "pictureURL")
    private String pictureUrl;

    /**
     * Price.
     */
    private int price;

    /**
     * Quantity.
     */
    private int quantity;

    /**
     * Status.
     */
    private boolean active = true;

    /**
     * Category.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Default constructor for Product.
     */
    public Product() {
    }

    /**
     * Constructor for Product with params.
     * @param id Id
     * @param productName ProductName
     * @param description Description
     * @param manufacturer Manufacturer
     * @param pictureUrl PictureUrl
     * @param price Price
     * @param quantity Quantity
     * @param active Status
     * @param category Category
     * @checkstyle ParameterNumber (7 lines)
     */
    public Product(final Integer id,
        final String productName,
            final String description,
                final String manufacturer,
                    final String pictureUrl,
                        final int price,
                            final int quantity,
                                final boolean active,
                                    final Category category) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.category = category;
    }

    /**
     * Constructor for Product with params.
     * @param productName ProductName
     * @param description Description
     * @param manufacturer Manufacturer
     * @param pictureUrl PictureUrl
     * @param price Price
     * @param quantity Quantity
     * @param active Status
     * @param category Category
     * @checkstyle ParameterNumber (7 lines)
     */
    public Product(final String productName,
        final String description,
            final String manufacturer,
                final String pictureUrl,
                    final int price,
                        final int quantity,
                            final boolean active,
                                final Category category) {
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.category = category;
    }

    /**
     * Method get Product id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set Product id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get ProductName.
     * @return Id
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Method set ProductName.
     * @param productName ProductName
     * @checkstyle HiddenField (2 lines)
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Method get Product pictureUrl.
     * @return PictureUrl
     */
    public String getPictureUrl() {
        return this.pictureUrl;
    }

    /**
     * Method set Product pictureUrl.
     * @param pictureUrl PictureUrl
     * @checkstyle HiddenField (2 lines)
     */
    public void setPictureUrl(final String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * Method get Product price.
     * @return Price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Method set Product price.
     * @param price Price
     * @checkstyle HiddenField (2 lines)
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * Method get Product description.
     * @return Description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Method set Product description.
     * @param description Description
     * @checkstyle HiddenField (2 lines)
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Method get Product manufacturer.
     * @return Manufacturer
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Method set Product manufacturer.
     * @param manufacturer Manufacturer
     * @checkstyle HiddenField (2 lines)
     */
    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Method get Product quantity.
     * @return Quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Method set Product quantity.
     * @param quantity Quantity
     * @checkstyle HiddenField (2 lines)
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method get Product status.
     * @return Status
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Method set Product status.
     * @param active Status
     * @checkstyle HiddenField (2 lines)
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * Method get Product category.
     * @return Category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Method set Product category.
     * @param category Category
     * @checkstyle HiddenField (2 lines)
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
}
