package org.sberbank.products;

import org.sberbank.currency.Currency;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard extends Card {

    private final Double percentageRate;

    public CreditCard(String name, BigDecimal balance, Currency currency, Double percentageRate) {
        super(name, balance, currency);
        this.percentageRate = percentageRate;
    }

    @Override
    public void withdraw(BigDecimal value) {
        if (Objects.isNull(value) || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value to withdraw should be positive!");
        }
        bankProduct.setBalance(bankProduct.getBalance().subtract(value));
    }

    /**
     * Method for request credit card debt according current card balance and card percentage rate
     * @return {@link BigDecimal} current credit card debt
     */
    public BigDecimal debtRequest() {
        return BigDecimal.valueOf(bankProduct.getBalance().doubleValue() * percentageRate / 365)
                .add(bankProduct.getBalance()).abs();
    }

}