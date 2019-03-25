package com.company;

import apple.laf.JRSUIUtils;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by pranavi on 3/4/19.
 */
public class TwoSigma {

    // Easy
    public int[] intersection(int[] num1, int[] num2) {
        HashMap<Integer, Integer> inter = new HashMap<>();

        int k = 0;

        for (int i = 0; i < num1.length; i++) {
            if (!inter.containsKey(num1[i]))
                inter.put(num1[i], 1);
        }

        for (int i = 0; i < num2.length; i++) {
            if (inter.containsKey(num2[i])) {
                if (inter.get(num2[i]) < 2 ) {
                    k++;
                    inter.put(num2[i], 2);
                }
            }
        }

        int[] ret = new int[k];
        int n = 0;

        for (int i : inter.keySet()) {
            if (inter.get(i) > 1)
                ret[n++] = i;
        }

        return ret;
    }

    // Easy

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int compliment;

        for (int i = 0; i < nums.length; i++) {
            compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum avaialble");
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<String>();

        queue.offer(beginWord);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                String s = queue.poll();
                if (s.equals(endWord))
                    return depth;

                for (char c = 'a'; c <= 'z'; c++) {
                    for (int i = 0; i < beginWord.length(); i++) {
                        if (s.charAt(i) == c) continue;

                        String newWord = s.substring(0, i) + c + s.substring(i + 1);

                        if (!wordList.contains(newWord)) continue;

                        wordList.remove(newWord);
                        queue.offer(newWord);
                    }
                }
            }
            depth++;
        }
        return 0;
    }


    public static class RandomWeights {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int cnt = 0;
        Random rand = new Random();

        public RandomWeights(int[] weights) {
            for (int i = 0; i < weights.length; i++) {
                cnt += weights[i];
                treeMap.put(cnt, i);
            }
        }

        public int picIndex() {
            int key = treeMap.higherKey(rand.nextInt(cnt));
            return treeMap.get(key);
        }
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int pX = low + (high - low) / 2;
            int pY = (nums1.length + nums2.length + 1) / 2 - pX;

            int maxLX = (pX == 0) ? Integer.MIN_VALUE : nums1[pX - 1];
            int minRX = (pX == nums1.length) ? Integer.MAX_VALUE : nums1[pX];

            int maxLY = (pY == 0) ? Integer.MIN_VALUE : nums2[pY - 1];
            int minRY = (pY == nums2.length) ? Integer.MAX_VALUE : nums2[pY];

            if (maxLX <= minRY && maxLY <= minRX) {
                if ( (nums1.length + nums2.length) % 2 == 0) {
                    return ((double) Math.max(maxLX, maxLY) + Math.min(minRX, minRY)) / 2;
                } else {
                    return Math.max(minRX, minRY);
                }
            } else if (maxLX > minRY) {
                high = pX - 1;
            } if (maxLY > minRX) {
                low = pX + 1;
            }

        }
        throw new IllegalArgumentException();


    }

    public class OrderNode {
        int orderId;
        String ticker;
        String side;
        int quantity;
        boolean isLimitOrder;
        float limitPrice;
    };

    OrderNode orderNode = new OrderNode();

    // Tree maps for ask ad bid prices where comparator is based on the price. This helps in getting the best price in O(logn) time.
// We could also use other data structures like Max-Min Heap/PriorityQueue where getting the best price is O(1) time.
/*    class TickerData {
        TreeMap<orderNode> askPrices;
        TreeMap<orderNode> bidPrices;
    }*/

    HashMap<Integer, OrderNode> orderMap;

    HashMap<String, TreeMap<Float, OrderNode>> mapOfTickerData;


/*




    // HashMap to delete order by id in O(1) time. Key is orderId and Value is the orderNode in the tree maps
    HashMap<int, OrderNode> orderMap;

    // Maintain a hash map of <ticker, TickerData>
    HashMap<string, TickerData> mapOfTickerData;

    // O(logn) time - Optimizing this method assuming this is more frequently called compared to delete method
    getBidPrice(ticker) {
        return mapOfTickerData[ticker].bidPrices.getMax();
    }

    // O(logn) time - Optimizing this method assuming this is more frequently called compared to delete method
    getAskPrice(ticker) {
        return mapOfTickerData[ticker].askPrices.getMax();  // Is this max or min?
    }

    // O(logn) time - deleting from tree map takes O(logn) time
    delete(orderId) {
        OrderNode orderNode = orderMap[orderId];

        // delete from tree maps
        string ticker = orderNode.ticker;
        if (orderNode.side == 'buy') {
            mapOfTickerData[ticker].bidPrices.delete(orderNode);
        } else {
            mapOfTickerData[ticker].askPrices.delete(orderNode);
        }

        // delete from orderMap
        orderMap.delete(orderId);
    }


    // O(logn) time
    add(orderData) {
        OrderNode orderNode = new OrderNode(orderData);

        // add to tree maps
        string ticker = orderNode.ticker;
        // TODO: null check
        if (orderNode.side == 'buy') {
            mapOfTickerData[ticker].bidPrices.insert(orderNode);
        } else {
            mapOfTickerData[ticker].askPrices.insert(orderNode);
        }

        // add to orderMap
        orderMap[orderId] = orderNode;
    } /*



}
