package org.sberbank.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sberbank.currency.Currency;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BankProduct {

    private String name;
    private BigDecimal balance;
    private Currency currency;

}