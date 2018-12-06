package com.company;

import java.util.Scanner;

class Recursion {

    static long factorial(int num)
    {
        if (num == 0)
        {
            return 1;
        }
        else
        {
            return num * factorial(num - 1);
        }
    }


    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case)
        {
            int num = sc.nextInt();

            long value = factorial(num);

            System.out.println("#" + test_case + " " + num + "! = " + value);
        }

        sc.close();
    }
}
