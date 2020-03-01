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

package org.azamat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is ProductNotFoundException class.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends RuntimeException {

    /**
     * Constructor for ProductNotFoundException.
     * @param productId Product id
     * @param quantity Quantity
     */
    public ProductNotFoundException(final Integer productId, final Integer quantity) {
        super(new StringBuilder("Product with id: ")
            .append(productId)
                .append(" is not available.")
                    .append(" Available only: ")
                        .append(quantity)
                            .append(" products.").toString());
    }
}
