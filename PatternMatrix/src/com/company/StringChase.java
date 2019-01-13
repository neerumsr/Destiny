package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pranavi on 1/13/19.
 */
public class StringChase {

    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email: emails) {
            int i = email.indexOf('@');
            String id = email.substring(0, i);
            String domain = email.substring(i);

            if (id.contains("+")) {
                id = id.substring(0, id.indexOf('+'));
            }

            if (id.contains(".")) {
                id = id.replaceAll(".", "");
            }
            unique.add(id + domain);
        }
        return unique.size();
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i]-minPrice > maxProfit)
                    maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
