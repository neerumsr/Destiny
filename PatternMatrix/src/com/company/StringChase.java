package com.company;

import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 * Created by pranavi on 1/13/19.
 */
public class StringChase {

    HashMap<Character, List<Integer>> index;
    HashMap<Integer, String> urlMap = new HashMap<>();
    HashMap<String, String> urlstrMap = new HashMap<>();
    String alphabet = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    String key = getRandom();

    private int lo, maxLen;


    public String getRandom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    int[] peek;
    int N;

    public int uniqueLetterString(String S) {
        index = new HashMap();
        peek = new int[26];
        N = S.length();

        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long cur = 0, ans = 0;
        for (char c: index.keySet()) {
            index.get(c).add(N);
            index.get(c).add(N);
            cur += get(c);
        }

        for (char c: S.toCharArray()) {
            ans += cur;
            long oldv = get(c);
            peek[c - 'A']++;
            cur += get(c) - oldv;
        }
        return (int) ans % 1_000_000_007;
    }

    public int uniqueLetterString2(String S) {
        char[] s = S.toCharArray();
        long res = 0;

        for (int n = S.length(), i = 0, l = 0, r = 0; i < n; i++) {
            for (l = i - 1; l >= 0 && s[l] != s[i]; l--);
            for (r = i + 1; r < n && s[r] != s[i]; r++);
            res += (r - i) * (i - l);
        }

        return (int)(res % 1000000007);
    }

    /* Implement Algo to determine if a string has all unique characters.
     What if you can not use additional data structure.

    * */
    // Using HashMap
    public boolean isUniqueChars(String str) {
        HashMap<Character, Integer> maps = new HashMap<>();
        if (str == null || str.length() == 0) return false;

        for (int i = 0; i < str.length(); i++) {
            if (maps.containsKey(str.charAt(i)))
                maps.put(str.charAt(i), maps.get(str.charAt(i)) + 1);
            else
                maps.put(str.charAt(i), 1);
        }

        for (Character ch: maps.keySet()) {
            if (maps.get(ch) > 1)
                return false;
        }
        return true;
    }

    // Using ASCII set
    public boolean isUniqueCharsFixed(String str) {
        if (str == null || str.length() == 0) return false;
        boolean[] char_set = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val])
                return false;

            char_set[val] = true;
        }
        return true;
    }

    /* Anagram
    * Using sort O(n log n )*/
    public boolean isAnagram(String src, String tgt) {
        if (src.length() != tgt.length()) return false;

        return Utils.sort(src).equals(Utils.sort(tgt));
    }


    /* Is Anagram without sort O(n)*/
    public boolean isAnagramNoSort(String src, String tgt) {
        if (src.length() != tgt.length()) return false;

        int[] letters = new int[256];

        for (int i = 0; i < src.length(); i++)
            letters[src.charAt(i)]++;
        for (int i = 0; i < tgt.length(); i++) {
            letters[tgt.charAt(i)]--;
            if (letters[tgt.charAt(i)] < 0 )
                return false;
        }
        return true;
    }

    /* Tiny URL implementation */

    public String encodeTinyURL(String longURL) {
        int hashCode = longURL.hashCode();
        urlMap.put(hashCode, longURL);
        return "http://tinyurl.com/"+hashCode;
    }

    public String decodeTinyURL(String tinyURL) {
       return urlMap.get(Integer.parseInt(tinyURL.replace("http://tinyurl.com/","")));
    }

    /* TinyURL different implemetation */

    public String encodeTinyURLrand(String longURL) {
        while (urlstrMap.containsKey(key)) {
            key = getRandom();
        }
        urlstrMap.put(key, longURL);
        return "http://tinyurl.com/"+key;
    }

    public String decodeTinyURLrand(String tinyURL) {
        return urlstrMap.get(tinyURL.replace("http://tinyurl.com/", ""));
    }

    /* URLify i.e. replace spaces with %20 */
    public String URLify(String src) {
        int length = 0;
        for (int i = 0; i < src.length(); i++) {
            if (' ' == src.charAt(i))
                length++;
        }

        length = src.length() + length * 2;
        char[] dest = new char[length];

        for (int i = src.length()-1; i >= 0; i--) {
            if (' ' == src.charAt(i)) {
                dest[length-1] = '0';
                dest[length-2] = '2';
                dest[length-3] = '%';
                length -= 3;
            } else {
                dest[length-1] = src.charAt(i);
                length -= 1;
            }
        }
        return new String(dest);
    }
/*

    public boolean validParen(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<String> stack = new Stack<>();

    }
*/

    public String longestPalindrome(String s) {

        int len = 0;
        String lonPali = "";

        if (s.length() == 1) return s;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // System.out.println(lonPali);
                if (isPalindrom(s.substring(i, j))) {
                    if (s.substring(i, j).length() > len) {
                        len = s.substring(i, j).length();
                        lonPali = s.substring(i, j);
                       // System.out.println(lonPali + len);
                    }
                }
            }
        }
        return lonPali;
    }

    public boolean isPalindrom(String s) {
       // System.out.println(s);
        String revString = "";
        for (int i = s.length() - 1; i >=0; i--)
            revString = revString + s.charAt(i);
        return (s.equals(revString));
    }


    /* long Palindrome around the center solution */


    public String longestPalindromeCenter(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }



    public long get(char c) {
        List<Integer> indexes = index.get(c);
        int i = peek[c - 'A'];
        return indexes.get(i+1) - indexes.get(i);
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email: emails) {
            int i = email.indexOf('@');
            String id = email.substring(0, i);
            String domain = email.substring(i);domain.toUpperCase();

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

    public String convertSB(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert(String s, int numRows) {


        int len = s.length();
        char[] string = new char[len];
        if (numRows == 1) return s;
        int cycLen =  2 * numRows - 2;
        int k = 0;

        String[] strings = new String[]{"hello","world"};

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            for (int j = 0; j + i < len; j += cycLen) {
                string[k++] = s.charAt(j+i);
                if (i != 0 && i != numRows - 1 && j + cycLen - i < len )
                    string[k++] = s.charAt(j+cycLen-i);
            }
        }
        return new String(string);

    }

    public void SubString(String str, int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)

                // Please refer below article for details
                // of substr in Java
                // https://www.geeksforgeeks.org/java-lang-string-substring-java/
                System.out.println(str.substring(i, j));
    }
    
    public boolean isRotation(String s1, String s2) {
        
        if (s1.length() != s2.length() || s1.length() < 0) 
            return false;
        
        String s1s2 = s1 + s2;

        HashMap<Character, Integer> map = new HashMap<>();
/*

        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }

            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) + 1);
            } else {
                map.put(s2.charAt(i), 1);
            }
        }
*/

       /* for (Character c : map.keySet()) {
            if (map.get(c) % 2 != 0)
                return false;
        }*/
        return isSubstring(s1s2, s2);
    }

    private boolean isSubstring(String s1s2, String s2) {

        for (int i = 0; i <= s1s2.length() - s2.length(); i++) {
            int j;

            for (j = 0; j < s2.length(); j++){
                if (s1s2.charAt(i + j) != s2.charAt(j))
                    break;;
            }

            if (j == s2.length())
                return true;
        }
        return false;
    }

/* 34. Find First and Last Position of Element in Sorted Array
*     O(log n )  */
    public int[] searchRangeOptimized(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIndex = findIndices(nums, target, true);

        if (leftIndex == nums.length || target != nums[leftIndex])
            return targetRange;

        targetRange[0] = leftIndex;
        targetRange[1] = findIndices(nums, target, false) - 1;

        return targetRange;
    }

    public int findIndices(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

/* 34. Find First and Last Position of Element in Sorted Array
            Example 1:

            Input: nums = [5,7,7,8,8,10], target = 8
            Output: [3,4]
*     O( n )  */

    public int[] searchRange(int[] nums, int target) {
        int[] tgtRange = {-1, -1};

        int left = 0, right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                tgtRange[0] = i;
                break;
            }
        }

        if (tgtRange[0] == -1 ) {
            return tgtRange;
        }

        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] == target) {
                tgtRange[1] = i;
                break;
            }
        }

        return tgtRange;

    }

    public int totalFruit(int[] tree) {
        if (tree.length <= 0) return 0;

        if (tree.length == 1) return 1;

        MapCount mapCount = new MapCount();
        int total = 0, i = 0;

        for (int j = 0; j < tree.length; j++) {
            mapCount.add(tree[j], 1);

            while (mapCount.size() >= 3) {
                mapCount.add(tree[i], -1);

                if (mapCount.get(tree[i]) == 0)
                    mapCount.remove(tree[i]);

                i++;
            }
            total = Math.max(total, j - i + 1);
        }

        return total;

    }

    public class MapCount extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }

    public int numIslands(char[][] grids) {
       if (grids.length <= 0 || grids == null)
           return 0;

       int islands = 0;

       for (int r = 0; r < grids.length; r++) {
           for (int c = 0; c < grids[0].length; c++) {
               if (grids[r][c] == '1') {
                   islands++;
                   findIsland(grids, r, c);
               }
           }
       }
        return islands;
    }

    public void findIsland(char[][] grids, int r, int c) {

        if (r < 0 || c < 0 || r >= grids.length || c >= grids[0].length || grids[r][c] == '0')
            return;

        grids[r][c] = '0';

        findIsland(grids, r - 1, c);
        findIsland(grids, r + 1, c);
        findIsland(grids, r, c - 1);
        findIsland(grids, r, c + 1);
    }


    public int searchRotatedArray(int[] nums, int target) {
        if (nums.length <= 0) return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        
        int n = findRotatedIndex(nums);

        if (n == -1) return -1;

        if (nums[n] == target) return n;

        int l = 0, r = nums.length -1;

        if (n == 0) {
            l = 0;
            r = nums.length - 1;
        } else if (nums[l] <= target) {
            r = n - 1;
        } else
            l = n + 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else
                return m;
        }
        return -1;
    }

    private int findRotatedIndex(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }


}
