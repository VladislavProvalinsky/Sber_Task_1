package org.sberbank.interfaces;

import java.math.BigDecimal;

public interface IBaseOperations {

    /**
     * Refill of product with needed amount
     */
    void refill(BigDecimal value);

    /**
     * Checking current balance of product
     */
    BigDecimal checkBalance();

    /**
     * Gets product name
     * @return {@link String} product name
     */
    String getName();

}