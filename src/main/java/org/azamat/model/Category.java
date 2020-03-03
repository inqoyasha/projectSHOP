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
@SuppressWarnings("PMD.DataClass")
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

    // @checkstyle MemberNameCheck (5 lines)
    /**
     * ImageURL.
     */
    @Column(name = "imageURL")
    private String imageUrl;

    /**
     * Default constructor for Category.
     */
    @SuppressWarnings("PMD.UncommentedEmptyConstructor")
    public Category() {
    }

    // @checkstyle ParameterNameCheck (10 lines)
    // @checkstyle ParameterNumber (9 lines)
    /**
     * Constructor for Category with params.
     * @param name Name of category
     * @param description Description of category
     * @param imageUrl ImageURL of category
     */
    public Category(final String name,
        final String description,
            final String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    /**
     * Method get category id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set category id.
     * @param id Id
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set category name.
     * @param name Name
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set category description.
     * @param description Description
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

    // @checkstyle HiddenField (6 lines)
    // @checkstyle ParameterNameCheck (5 lines)
    /**
     * Method set category imageUrl.
     * @param imageUrl ImageUrl
     */
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
