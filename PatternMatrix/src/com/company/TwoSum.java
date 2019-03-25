package com.company;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int compliment = target - nums[i];

            if(map.containsKey(compliment) && map.get(compliment)!=i) {
                return new int[] {i, map.get(compliment)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int compliment = target - nums[i];

            if(map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int compliment = 0;

        for (int i = 0; i < nums.length; i++) {
            compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
