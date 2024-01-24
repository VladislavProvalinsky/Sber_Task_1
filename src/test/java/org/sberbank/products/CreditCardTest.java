package org.sberbank.products;

import org.junit.Before;
import org.junit.Test;
import org.sberbank.currency.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CreditCardTest {

    private CreditCard creditCard;

    @Before
    public void setUp() {
        creditCard = new CreditCard("Test Card", BigDecimal.valueOf(1000), Currency.RUB, 0.1);
    }

    @Test
    public void testWithdrawPositiveValue() {
        creditCard.withdraw(BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), creditCard.checkBalance());
    }

    @Test
    public void testWithdrawPositiveValueGraterThanBalance() {
        creditCard.withdraw(BigDecimal.valueOf(1500));
        assertEquals(BigDecimal.valueOf(-500), creditCard.checkBalance());
    }

    @Test
    public void testWithdrawZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> creditCard.withdraw(BigDecimal.ZERO));
    }

    @Test
    public void testWithdrawNullValue() {
        assertThrows(IllegalArgumentException.class, () -> creditCard.withdraw(null));
    }

    @Test
    public void testWithdrawNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> creditCard.withdraw(BigDecimal.valueOf(-500)));
    }

    @Test
    public void testDebtRequest() {
        BigDecimal expectedDebt = BigDecimal.valueOf(1000.27);
        BigDecimal actualDebt = creditCard.debtRequest().setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expectedDebt, actualDebt);
    }

}