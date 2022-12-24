package com.heatwave.template.math;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    /**
     * 判断 n 是否是质数 (素数)
     * check if n is prime
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 质因数分解
     * Prime factorization
     */
    private static int[] primeDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                for (n /= i; n % i == 0; n /= i) ;
                list.add(i);
            }
        }
        if (n > 1) {
            list.add(n);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 欧几里得算法 (辗转相除法) 求最大公约数
     * Euclidean Algorithm for Greatest Common Divisor
     */
    private static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    /**
     * 最小公倍数 Least Common Multiple
     */
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
