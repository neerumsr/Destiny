package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pranavi on 1/21/19.
 */
public class Utils {

    public static String sort(String src) {
        char[] ret = src.toCharArray();
        Arrays.sort(ret);
        return new String(ret);
    }

    public static int fibonacci(int n) {
        return fibonacci(n, new int[n + 1]);
    }

    public static int fibonacci(int n, int[] memo) {

        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        }
        return memo[n];
    }

    public static int binarySearch(int[] arr, int val) {
        return binarySearch(arr, val, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int val, int lo, int hi) {

        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;

        if (arr[mid] > val)
            return binarySearch(arr, val, lo, mid - 1);
        else if (arr[mid] < val)
            return binarySearch(arr, val, mid + 1, hi);
        else
            return mid + 1;

    }

    public static int binarySearchIterative(int[] arr, int target) {

        if (arr.length <= 0) return  -1;
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi  - lo) / 2;

            if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else
                return mid + 1;
        }

        return -1;
    }

    public static int waterTrap(int[] height) {
        if (height.length < 2) return 0;

        int total  = 0;

        int[] lmem = new int[height.length];
        int[] rmem = new int[height.length];

        int len = height.length;

        lmem[0] = height[0];
        for (int i = 1; i < len; i++)
            lmem[i] = Math.max(height[i], lmem[i-1]);

        rmem[len - 1] = height[len - 1];

        for (int i = len - 2; i >= 0; i--)
            rmem[i] = Math.max(height[i], rmem[i + 1]);


        for (int i = 1; i < len - 1; i++) {
            total += Math.min(lmem[i], rmem[i]) - height[i];
        }
        return total;

    }

    public static int romantoInt(String roman) {
        if (roman.length() <= 0) return 0;

        HashMap<Character, Integer> maps = new HashMap<>();

        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);

        int add = 0;

        for (int i = 0; i < roman.length() - 1; i++) {
            if (maps.get(roman.charAt(i)) < maps.get(roman.charAt(i + 1))) {
                add -= maps.get(roman.charAt(i));
            } else {
                add += maps.get(roman.charAt(i));
            }
        }
        add += maps.get(roman.charAt(roman.length() - 1));
        return add;
    }

    public static String intToRoma(int val) {

        String M[] = {"", "M", "MM", "MMM","MMMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[val/1000] + C[(val % 1000) / 100] + X[(val % 100) / 10] + I[(val % 10)];
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            new IllegalStateException("Must not instantiate an element of this class");
            return false;
        }

        if (matrix.length == 1 || matrix[0].length == 1) return true;

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (r > 0 && c > 0 && matrix[r][c] != matrix[r -1][c - 1])
                    return false;
            }
        }
        return true;
    }

    public boolean validWordSquare(List<String> words) {

        if (words.size() <= 0) return true;

        int index = 0;
        int len = words.get(0).length();

        for (String s : words) {
            if (s.length() != len)
                return false;
            len = s.length();
            if (!s.equals(colRead(words, index++)))
                return false;
        }

        return true;
    }

        public String colRead(List<String> words, int i) {

        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            if (i < s.length())
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void gameOfLife(int[][] board) {

        int R = board.length;
        int C = board[0].length;

        printMatrix(board);

        System.out.println();


        int[][] temp = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                temp[r][c] = nextLifeChk(board, r, c);
            }
        }

        for (int r = 0; r < R; r++) {
            System.out.println();
            for (int c = 0; c < C; c++) {
                board[r][c] = temp[r][c];
                System.out.print(board[r][c] + " ");
            }
        }

    }

    public static int nextLifeChk(int[][] board, int r, int c) {
        int counter = 0;
        for (int ro = r - 1; ro <= r + 1; ro++) {
            for(int co = c - 1; co <= c + 1; co++) {
                if (ro == r && co == c)
                    continue;
                if (ro < 0 || ro > board.length - 1
                        | co < 0 || co > board[0].length - 1)
                    continue;
                if (board[ro][co] == 1) counter++;
            }
        }

        if ( counter < 2 && board[r][c] == 1)
            return 0;
        else if (counter >= 2 && counter <= 3 && board[r][c] == 1)
            return 1;
        else if (counter > 3 && board[r][c] == 1)
            return 0;
        else if (counter == 3 && board[r][c] == 0)
            return 1;

        return 0;
    }


    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println();
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);


        int n = nums1.length;
        int m = nums2.length;

        System.out.println(n + "  " + m);

        if (n <= 0) {
            if (m <= 0) {
                return 0;
            } else {
                return m % 2 == 0 ? (nums2[m / 2] + nums2[(m - 1) / 2]) / 2 : nums2[m / 2];
            }
        }

        int low = 0;
        int high = n;

        while (low <= high) {
            int pN = low + (high - low) / 2;   // Partition element for first array
            int pM = (n + m + 1) / 2 - pN;   // Partition element for second array

            int maxLeftN = pN == 0 ? Integer.MIN_VALUE : nums1[pN - 1];
            int minRightN = pN == n ? Integer.MAX_VALUE : nums1[pN];

            int maxLeftM = pM == 0 ? Integer.MIN_VALUE : nums2[pM - 1];
            int minRightM = pM == m ? Integer.MAX_VALUE : nums2[pM];

            if (maxLeftN <= minRightM && maxLeftM <= minRightN) {

                if ((n + m) % 2 == 0)
                    return ((double) Math.max(maxLeftN, maxLeftM) + Math.min(minRightN, minRightM)) / 2;
                else
                    return Math.max(maxLeftN, maxLeftM);
            } else if (maxLeftN > minRightM) {
                high = pN - 1;
            } else if (maxLeftM > maxLeftN){
                low = pN + 1;
            }
        }
        throw new IllegalArgumentException();
    }





}
