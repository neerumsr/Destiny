package com.company;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *

 // Given an array of words, print all anagrams together.
// For example, if the given array is {"lion", "cat", "cow", "dog", "tac", "dragon", "god", "act"},
// then output should be “cat tac act dog god”.
 * If you need more classes, simply define them inline.
 */

class Anagram {
    public static void main(String[] args) {
        String arr[] = {"lion", "cat", "cow", "dog", "tac", "dragon", "god", "act"};

        HashMap<Integer, List<String>> aMap = new HashMap<>();

        for ( int n = 0; n < arr.length; n++) {
            String iWord = arr[n];
            char[] wordLetters = iWord.toCharArray();
            Arrays.sort(wordLetters);

            String nWord = new String(wordLetters);

            int key = nWord.hashCode();

            if ( aMap.containsKey(key)) {
                List<String> aWords = aMap.get(key);
                aWords.add(iWord);
                aMap.put(key, aWords);
            } else {
                List<String> aWords = new ArrayList();
                aWords.add(iWord);
                aMap.put(key, aWords);
            }
        }

        for ( Integer i:aMap.keySet()) {
            List<String> sValues = aMap.get(i);
            if (sValues.size() > 1)
                System.out.print(sValues);
        }
    }
}
