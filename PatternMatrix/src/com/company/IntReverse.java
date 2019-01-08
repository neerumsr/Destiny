package com.company;

/**
 * Created by pranavi on 1/6/19.
 */
public class IntReverse {
    public int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            if (rev > Integer.MAX_VALUE || (rev == Integer.MAX_VALUE &&
                    (n % 10 > 7))) return 0;

            if (rev < Integer.MIN_VALUE || (rev == Integer.MIN_VALUE &&
                    (n % 10 < -8))) return 0;

            rev = rev * 10 + (n % 10);
            n = n / 10;
        }

        return rev;
    }
}
