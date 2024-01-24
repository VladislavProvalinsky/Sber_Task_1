package org.sberbank.products;

import org.junit.Before;
import org.junit.Test;
import org.sberbank.currency.Currency;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DepositTest {

    private Deposit deposit;

    @Before
    public void setUp() {
        deposit = new Deposit("Test Deposit", BigDecimal.ZERO, Currency.RUB);
    }

    @Test
    public void testRefillPositiveValue() {
        BigDecimal refillAmount = new BigDecimal("1000");
        deposit.refill(refillAmount);
        assertEquals(refillAmount, deposit.checkBalance());
    }

    @Test
    public void testRefillNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> deposit.refill(BigDecimal.valueOf(-500)));
    }

    @Test
    public void testRefillZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> deposit.refill(BigDecimal.ZERO));
    }

    @Test
    public void testRefillNullValue() {
        assertThrows(IllegalArgumentException.class, () -> deposit.refill(null));
    }

    @Test
    public void testCheckBalance() {
        BigDecimal initialBalance = new BigDecimal("5000");
        deposit.refill(initialBalance);
        assertEquals(initialBalance, deposit.checkBalance());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Deposit", deposit.getName());
    }

    @Test
    public void testClose() {
        deposit.close();
        assertEquals(Deposit.CLOSED, deposit.getStatus());
    }

}