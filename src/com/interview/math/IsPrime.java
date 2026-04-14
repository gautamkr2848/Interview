package com.interview.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Why did we choose sqrt(N)?
//The reason is that the smallest and greater than one factor of a number cannot be more than the sqrt of N. And we
// stop as soon as we find a factor. For example, if N is 49, the smallest factor is 7. For 15, smallest factor is 3.

public class IsPrime {

    public boolean isPrime(int N) {
        if (N <= 1) return false;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    //Find all factors
    //36 => {1, 2, 3, 4, 6, 9, 12, 18, 36}
    //if a < b, a < Math.sqrt(n)
    //          b > Math.sqrt(n)
    //if a > b, a > Math.sqrt(n)
    //          b < Math.sqrt(n)
    public void findAllFactors(int n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(n);

        for(int i=0; i<=Math.sqrt(new Double(n)); i++){
            if(n % i == 0){
                list.add(i);
                if(1 != Math.sqrt(new Double(n)))
                    list.add(n / i);
            }
        }

        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }


    //Prime Factorization
    //44 => 2 * 2 * 11
    public void primeFactorization(int n){
        for(int i=0; i<=Math.sqrt(new Double(n)); i++){
            if(n % i == 0){
                int count = 0;
                while(n % i == 0){
                    n = n / i;
                    count++;
                }
                System.out.println(i + " " + count);
            }
        }

        if(n != 1)
            System.out.println(n + " " + 1);
    }
}
