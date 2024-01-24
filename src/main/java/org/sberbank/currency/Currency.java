package org.sberbank.currency;

/**
 * Record for holding currency of bank products
 */
public record Currency(long code, String name) {

    public static final Currency RUB = new Currency(643L, "RUB");
    public static final Currency USD = new Currency(840L, "USD");
    public static final Currency EUR = new Currency(978L, "EUR");
    public static final Currency BYN = new Currency(933L, "BYN");

}