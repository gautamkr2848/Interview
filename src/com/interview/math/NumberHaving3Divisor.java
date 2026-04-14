package com.interview.math;

// Start a loop for integer i from 2 to N.
// Check if i is prime or not, which can be done easily using the isPrime(n) method.

// If i is prime, check if its square is less than or equal to the given number. This will be reviewed only for squares
// of prime numbers, therefore reducing the number of checks.

// If the above condition is satisfied, the number will be printed and the loop will continue till i <= n.

public class NumberHaving3Divisor {

    public void numbersWith3Divisors(int n) {
        System.out.println("Numbers with 3 divisors : ");

        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i * i + " ");
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
