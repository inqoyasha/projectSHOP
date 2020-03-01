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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is class entity of Category.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
public class Category {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name.
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * ImageURL.
     */
    @Column(name = "imageURL")
    private String imageUrl;

    /**
     * Category status.
     */
    private boolean active = true;

    /**
     * Default constructor for Category.
     */
    public Category() {
    }

    /**
     * Constructor for Category with params.
     * @param name Name of category
     * @param description Description of category
     * @param imageUrl ImageURL of category
     * @param active Status of category
     * @checkstyle ParameterNumber (5 lines)
     */
    public Category(final String name,
        final String description,
            final String imageUrl,
                final boolean active) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.active = active;
    }

    /**
     * Method get category id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set category id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get category name.
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method set category name.
     * @param name Name
     * @checkstyle HiddenField (2 lines)
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method get category description.
     * @return Description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Method set category description.
     * @param description Description
     * @checkstyle HiddenField (2 lines)
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Method get category imageUrl.
     * @return ImageUrl
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * Method set category imageUrl.
     * @param imageUrl ImageUrl
     * @checkstyle HiddenField (2 lines)
     */
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Method get category status.
     * @return Status
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Method set category status.
     * @param active Status
     * @checkstyle HiddenField (2 lines)
     */
    public void setActive(final boolean active) {
        this.active = active;
    }
}
