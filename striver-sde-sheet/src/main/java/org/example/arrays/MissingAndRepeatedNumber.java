package org.example.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//TC: O(N)
//SC: O(1)
//Problem link: https://www.interviewbit.com/problems/repeat-and-missing-number-array/
//Level: Medium
public class MissingAndRepeatedNumber {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();

        // Calculate sum and sum of squares using BigInteger
        BigInteger s1 = BigInteger.ZERO;
        BigInteger s2 = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            BigInteger ai = BigInteger.valueOf(A.get(i));
            s1 = s1.add(ai);
            s2 = s2.add(ai.multiply(ai));
        }

        // Calculate sum and sum of squares using formulas
        BigInteger sn = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n + 1)).divide(BigInteger.valueOf(2));
        BigInteger s2n = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n + 1)).multiply(BigInteger.valueOf(2 * n + 1)).divide(BigInteger.valueOf(6));

        // Solve equations
        // eq1 => (x-y)
        BigInteger eq1 = s1.subtract(sn);
        // eq2 => (x^2-y^2)
        BigInteger eq2 = s2.subtract(s2n);
        // eq3 = x+y
        BigInteger eq3 = eq2.divide(eq1);
//        repeatedNumber => x+y+x-y => x=sum/2
        BigInteger repeatedNumber = eq3.add(eq1).divide(BigInteger.valueOf(2));
        BigInteger missingNumber = eq3.subtract(repeatedNumber);

        ans.add(repeatedNumber.intValue());
        ans.add(missingNumber.intValue());
        return ans;
    }
}
