package com.taoufix.commons.math;

import java.math.BigDecimal;

/**
 * BigDecimal utilities.
 *
 * @author taoufix
 * @since 1.0.0
 */
public class BigDecimalUtils {

    /**
     * Sum of numbers. Null values are evaluated to zeros.
     *
     * @param nbrs the numbers to sum.
     * @return the sum.
     */
    public static BigDecimal sum(BigDecimal... nbrs) {
        BigDecimal sum = BigDecimal.ZERO;
        if (nbrs != null) {
            for (BigDecimal nbr : nbrs) {
                if (nbr != null) {
                    sum = sum.add(nbr);
                }
            }
        }
        return sum;
    }

}
