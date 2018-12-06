package com.company;

import java.util.Scanner;

class BSearch {

    static final int MAX_M = 100;

    static int T;    // # of test case
    static int M;    // # of element in array
    static int N;    // # of numbers to search
    static int arr[];

    static void binarySearch(int[] arr, int low, int high, int target)
    {
        int mid;
        if (low > high)
        {
            System.out.print("-1 ");
            return;
        }

        mid = (low + high) / 2;

        if (target < arr[mid])
        {
            binarySearch(arr, low, mid - 1, target);
        }
        else if (arr[mid] < target)
        {
            binarySearch(arr, mid + 1, high, target);
        }
        else
        {
            System.out.print(mid + " ");
            return;
        }
    }

    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#" + test_case + " ");

            M = sc.nextInt();
            N = sc.nextInt();

            arr = new int[M];
            for (int i = 0; i < M; i++)
            {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++)
            {
                int targetValue = sc.nextInt();
                binarySearch(arr, 0, M-1, targetValue);
            }

            System.out.println();
        }

        sc.close();
    }
}