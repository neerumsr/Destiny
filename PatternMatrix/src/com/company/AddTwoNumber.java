package com.company;



import com.sun.tools.javac.comp.Infer;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.decrementExact;
import static java.lang.Math.pow;

public class AddTwoNumber {


    static class ListNode {
        int data;
        ListNode nextNode;
        ListNode (int val) { data = val; }
    }



    public static void main(String arg[]) throws Exception {

        //System.out.println(List2Num(AddTwoLists(Num2List(342) , Num2List(465))));
        TwoSum twoSum = new TwoSum();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        IntReverse intReverse = new IntReverse();
        KMergeLists kMergeLists = new KMergeLists();
        StringChase stringChase = new StringChase();

        int[] nums = new int[] {2,7,11,15};
        String longPalindrone = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int target = 9;
/*        System.out.println(Arrays.toString(twoSum.twoSumTwoPass(nums,target)));
        System.out.println(Arrays.toString(twoSum.twoSumOnePass(nums,target)));
        int sum = List2Num(addTwoNumbers.addTwoNumbers(Num2List(342), Num2List(465)));
        System.out.println(sum);
        System.out.print(intReverse.reverse(-1234));*/
        ListNode[] lists = new ListNode[3];
        lists[0] = Num2List(4321);
        lists[1] = Num2List(98);
        lists[2] = Num2List(876);
        long sortedlist = List2Num(kMergeLists.mergeKLists(lists));
        System.out.println(sortedlist);
        System.out.println(reverseString("hello"));
        ListNode list = Num2List(1);
      //  System.out.println(reverseList(list));
        appendToTail(list, 6);
        printList(list);
        System.out.println();
        list = deleteNode(list, 6);
        printList(list);
        System.out.println();
        System.out.println(maxSubArray(new int[]{1,2,-3,4,5,-9,1,2,3}));
        System.out.print(stringChase.numUniqueEmails(new String[]{"nk@g.com","n.k@g.com","n+k@gmail.com","nk@yahoo.com"}));
        System.out.println(stringChase.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("\n" + stringChase.convert("PAYPALISHIRING", 3));

        System.out.println(stringChase.uniqueLetterString("ABC"));
        System.out.println(stringChase.uniqueLetterString2("ABCD"));
        //stringChase.SubString("ABCD", 4);
        System.out.println(stringChase.isUniqueChars("ABCDEF"));
        System.out.println(stringChase.isUniqueChars("ABCDEFF"));

        System.out.println(stringChase.isAnagram("DOD", "GOD"));
        System.out.println(stringChase.isAnagramNoSort("DOD", "GOD"));

        System.out.println("Tiny URL implementation :  ");
        String longURL = "https://leetcode.com/problems/design-tinyurl";
        String tinyURL = stringChase.encodeTinyURL(longURL);
        String tinyURLrand = stringChase.encodeTinyURLrand(longURL);
        System.out.println("Encode " + longURL + " = " + tinyURL);
        System.out.println("Decode " + tinyURL + " = " + stringChase.decodeTinyURL(tinyURL));
        System.out.println("Encode Rand " + longURL + " = " + tinyURLrand);
        System.out.println("Decode Rand " + tinyURLrand + " = " + stringChase.decodeTinyURLrand(tinyURLrand));
        System.out.println(stringChase.URLify("Mr John Smith"));
        System.out.println("Longest palindrome = " + stringChase.longestPalindrome("babad"));
        System.out.println("Longest palindrome = " + stringChase.longestPalindrome("bb"));
        System.out.println("Longest palindrome = " + stringChase.longestPalindrome("a"));

        // System.out.println("Longest palindrome = " + stringChase.longestPalindrome(longPalindrone));

        System.out.println("Longest palindrome = " + stringChase.longestPalindromeCenter(longPalindrone));
        System.out.println(stringChase.isRotation("waterbottle", "erbottlewat"));

        System.out.println(Arrays.toString(stringChase.searchRange(new int[]{5,7,8,8,8,10}, 8)));

        System.out.println(Arrays.toString(stringChase.searchRangeOptimized(new int[]{5,7,8,8,8,10,11}, 8)));


        System.out.println(Utils.fibonacci(5));

        System.out.println(Utils.binarySearch(new int[]{10,20,30,40,50,60,70,80,90,100}, 20));

        System.out.println(Utils.binarySearchIterative(new int[]{10,20,30,40,50,60,70,80,90,100}, 20));

        System.out.println(stringChase.totalFruit(new int[] {3,1,3,1,3,2,1,1,2,1,2,3,3,4}));

        System.out.println(Utils.waterTrap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(Utils.romantoInt("MCMXCIV"));

        System.out.println(Utils.intToRoma(4999));

        System.out.println(Utils.isToeplitzMatrix(new int[][] {{}}));

        Utils.gameOfLife(new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}});

        Utils.findMedianSortedArrays(new int[] {2, 8, 12, 15}, new int[]{1, 5, 6, 7, 10});

        TwoSigma.RandomWeights randomWeights = new TwoSigma.RandomWeights(new int[] {1, 3});

        TwoSigma twoSigma = new TwoSigma();
        double median = twoSigma.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});
        System.out.println("Median : " + median);

        for (int i = 0; i < 4; i++) {
            System.out.println(" Index : " + randomWeights.picIndex());
        }

    }

    private static ListNode deleteNode(ListNode head, int d) {
        ListNode cur = head;

        if (cur == null) return null;

        if (d == cur.data)
            cur = cur.nextNode;

        while (cur.nextNode != null) {
            if (cur.nextNode.data == d) {
                cur.nextNode = cur.nextNode.nextNode;
                return head;
            }
            cur = cur.nextNode;
        }
        return head;
    }

    public static ListNode AddTwoLists( ListNode valOne, ListNode valTwo) {
        ListNode addVal = null;

        int sum = List2Num(valOne) + List2Num(valTwo);
        addVal = Num2List(sum);
        return addVal;
    }

    private static ListNode Num2List(int sum) {
        ListNode dummyHead = new ListNode(0);
        ListNode valNode = dummyHead;
        int rem;
        do {
            rem = sum%10;
            sum = sum/10;
            valNode.nextNode = new ListNode(rem);
            valNode = valNode.nextNode;
        } while (sum !=0);
        return dummyHead.nextNode;
    }

    static int List2Num(ListNode valNode) {
        int val = 0, i=0;
        while (valNode != null) {
            val = (int) (pow(10, i)*valNode.data + val);
            if (valNode != null)
                valNode = valNode.nextNode;
            i++;
        }
        System.out.println("Valus of List2Num = " + val);
        return val;
    }

    static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode tempNext = cur.nextNode;
            cur.nextNode = prev;
            prev = cur;
            cur = tempNext;
        }
        return  prev;
    }

    static void appendToTail(ListNode head, int d) {
        ListNode cur = head;

        ListNode end = new ListNode(d);
        while (cur.nextNode != null) {
            cur = cur.nextNode;
        }
        cur.nextNode = end;
    }

    static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.nextNode != null) {
            System.out.print(cur.data + "->");
            cur = cur.nextNode;
        }
        if (cur != null)
            System.out.print(cur.data);
        else
            System.out.println("Empty LinkedList");
    }

    static int maxSubArrayOld(int[] nums) {
        int sum = nums[0], curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];
            curSum = Math.max(curSum, nums[i]);
            sum = Math.max(sum, curSum);
        }
        return sum;
    }

    static int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;

        int sum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];
            curSum = Math.max(curSum, nums[i]);
            sum = Math.max(sum, curSum);
        }

        return sum;
    }

    static boolean hasCycle(ListNode head) {

        Set<ListNode> nodesSeen = new HashSet<>();

        while (head != null) {
            if (nodesSeen.contains(head))
                return false;
            else
                nodesSeen.add(head);

            head = head.nextNode;
        }
        return false;
    }

    static boolean hasCycleOptimized(ListNode head) {

        if (head == null || head.nextNode == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.nextNode;

        while (slow != fast) {
            if (fast == null || fast.nextNode == null)
                return false;
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return true;
    }

    public static String reverseString(String s) {
        int len = s.length();
        char[] word = s.toCharArray();

        for (int i = 0, j = len-1; i < len/2; i++, j--) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }
        return new String(word);
    }
}
