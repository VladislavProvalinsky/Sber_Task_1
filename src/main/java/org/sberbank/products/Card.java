package org.sberbank.products;

import org.sberbank.currency.Currency;
import org.sberbank.interfaces.IBaseOperations;

import java.math.BigDecimal;
import java.util.Objects;

public class Card implements IBaseOperations {

    protected BankProduct bankProduct;

    public Card(String name, BigDecimal balance, Currency currency) {
        this.bankProduct = new BankProduct(name, balance, currency);
    }

    /**
     * Method that withdraw money from card
     * @param value {@link BigDecimal} value to withdraw from card balance
     */
    public void withdraw(BigDecimal value) {
        if (Objects.isNull(value) || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value to withdraw should be positive!");
        }
        if (checkBalance().compareTo(value) < 0) {
            throw new IllegalArgumentException("You cannot withdraw more money than you have on balance!");
        }
        bankProduct.setBalance(bankProduct.getBalance().subtract(value));
    }

    @Override
    public void refill(BigDecimal value) {
        if (Objects.isNull(value) || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value to refill should be positive!");
        }
        bankProduct.setBalance(bankProduct.getBalance().add(value));
    }

    @Override
    public BigDecimal checkBalance() {
        return bankProduct.getBalance();
    }

    @Override
    public String getName() {
        return bankProduct.getName();
    }

}