package com.taoufix.commons.math;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalUtilsTest {

    @Test
    public void sum() {

        Assert.assertEquals(BigDecimal.ONE, BigDecimalUtils.sum(BigDecimal.ONE));

        Assert.assertEquals(BigDecimal.ZERO, BigDecimalUtils.sum(null));

        Assert.assertEquals(BigDecimal.TEN, BigDecimalUtils.sum(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));

        Assert.assertNotSame(BigDecimal.ONE, BigDecimalUtils.sum(BigDecimal.ZERO));

        Assert.assertEquals(BigDecimal.ONE, BigDecimalUtils.sum(BigDecimal.ONE, null));

    }

}