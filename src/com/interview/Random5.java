package com.interview;

// Given a function foo() that returns integers from 1 to 5 with equal probability, write a function that returns
// integers from 1 to 7 with equal probability using foo() only.

public class Random5 {

    public void random7() {
        // you can use random5() for generating 0 - 4 with equal probability.
        //int i = 5 * random5() + random5();
        //while (i >= 21) {
        //    i = 5 * random5() + random5();
        //}
        //return i % 7;
    }

    public void random7_2() {
        // you can use random2()
        //int random7 = rand2() + rand2() * 2 + rand2() * 4;
        //while (random7 == 7) {
        //    random7 = rand2() + rand2() * 2 + rand2() * 4;
        //}
        //return random7;
    }


/*
You are given a function foo() that represents a biased coin. When foo() is called, it returns 0 with 60% probability,
and 1 with 40% probability. Write a new function that returns 0 and 1 with a 50% probability each. Your function should
use only foo().

Solution:
If we can somehow get two cases with equal probability, then we are done. We call foo() two times. Both calls will
return 0 with a 60% probability. So the two pairs (0, 1) and (1, 0) will be generated with equal probability from two
calls of foo(). Let us see how.

(0, 1): The probability to get 0 followed by 1 from two calls of foo() = 0.6 * 0.4 = 0.24
(1, 0): The probability to get 1 followed by 0 from two calls of foo() = 0.4 * 0.6 = 0.24

So the two cases appear with equal probability. The idea is to return consider only the above two cases, return 0 in
one case, return 1 in other case. For other cases [(0, 0) and (1, 1)], recur until you end up in any of the above two
cases.
*/
    public int my_fun() {
        int val1 = 0;//foo();
        int val2 = 0;//foo();
        if (val1 == 0 && val2 == 1)
            return 0; // Will reach here with 0.24 probability

        if (val1 == 1 && val2 == 0)
            return 1; // Will reach here with 0.24 probability

        return my_fun(); // will reach here with (1 - 0.24 - 0.24) probability
    }

/*
random10_using_random7

ref - https://leetcode.com/problems/implement-rand10-using-rand7/solution/

This solution is based upon Rejection Sampling. The main idea is when you generate a number in the desired range,
output that number immediately. If the number is out of the desired range, reject it and re-sample again. As each number
in the desired range has the same probability of being chosen, a uniform distribution is produced.

Obviously, we have to run rand7() function at least twice, as there are not enough numbers in the range of 1 to 10. By
running rand7() twice, we can get integers from 1 to 49 uniformly. Why?

image - https://leetcode.com/problems/implement-rand10-using-rand7/Figures/470/rejectionSamplingTable.png

A table is used to illustrate the concept of rejection sampling. Calling rand7() twice will get us row and column index
that corresponds to a unique position in the table above. Imagine that you are choosing a number randomly from the table
above. If you hit a number, you return that number immediately. If you hit a * , you repeat the process again until you
hit a number.

Since 49 is not a multiple of 10, we have to use rejection sampling. Our desired range is integers from 1 to 40, which
we can return the answer immediately. If not (the integer falls between 41 to 49), we reject it and repeat the whole
process again.
*/

    public void random10_using_random7() {
        //rand7() that generates a uniform random integer in the range [1, 7]
        //int row, col, idx;
        //do {
        //    row = rand7();
        //    col = rand7();
        //    idx = col + (row - 1) * 7;
        //} while (idx > 40);
        //return 1 + (idx - 1) % 10;
    }
}
