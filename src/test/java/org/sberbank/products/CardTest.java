package org.sberbank.products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sberbank.currency.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CardTest {

    private Card card;

    @Before
    public void setUp() {
        card = new Card("Test Card", new BigDecimal("100.00"), Currency.RUB);
    }

    @Test
    public void testWithdrawPositive() {
        card.withdraw(new BigDecimal("50.00"));
        Assert.assertEquals(new BigDecimal("50.00"), card.checkBalance());
    }

    @Test
    public void testWithdrawEntireBalance() {
        card.withdraw(new BigDecimal("100.00"));
        Assert.assertEquals(BigDecimal.ZERO, card.checkBalance().setScale(0, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testWithdrawNegativeValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.withdraw(new BigDecimal("-50.00")));
    }

    @Test
    public void testWithdrawZeroValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.withdraw(BigDecimal.ZERO));
    }


    @Test
    public void testWithdrawNullValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.withdraw(null));
    }

    @Test
    public void testWithdrawValueGraterThanBalance() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.withdraw(new BigDecimal("150.00")));
    }

    @Test
    public void testRefillPositive() {
        card.refill(new BigDecimal("50.00"));
        Assert.assertEquals(new BigDecimal("150.00"), card.checkBalance());
    }

    @Test
    public void testRefillNegativeValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.refill(new BigDecimal("-50.00")));
    }

    @Test
    public void testRefillZeroValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.refill(BigDecimal.ZERO));
    }

    @Test
    public void testRefillNullValue() {
        Assert.assertThrows(IllegalArgumentException.class, () -> card.refill(null));
    }

    @Test
    public void testCheckBalance() {
        Assert.assertEquals(new BigDecimal("100.00"), card.checkBalance());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test Card", card.getName());
    }

}