package org.example;

import java.math.BigInteger;

class FactorialDigitSum {
    public static int calculateFactorialDigitSum(int n) {
        // Calculate n! using BigInteger
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        // Convert to string and sum digits
        String numStr = factorial.toString();
        int sum = 0;
        for (char digit : numStr.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        
        return sum;
    }
}
