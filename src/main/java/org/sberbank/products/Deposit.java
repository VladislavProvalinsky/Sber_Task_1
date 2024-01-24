package org.sberbank.products;

import lombok.Getter;
import org.sberbank.currency.Currency;
import org.sberbank.interfaces.IBaseOperations;

import java.math.BigDecimal;
import java.util.Objects;

public class Deposit implements IBaseOperations {

    public static final int CLOSED = 0;
    public static final int OPENED = 1;
    @Getter
    private int status;
    private BankProduct bankProduct;

    public Deposit(String name, BigDecimal balance, Currency currency) {
        this.bankProduct = new BankProduct(name, balance, currency);
        this.status = OPENED;
    }

    /**
     * Method to close current deposit
     */
    public void close() {
        status = CLOSED;
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