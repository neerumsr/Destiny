package com.company;



import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
       // System.out.println(sortedlist);
        System.out.print(reverseString("hello"));
      /*  ListNode list = Num2List(12345);
        System.out.println(reverseList(list));
        System.out.println(maxSubArray(new int[]{1,2,-3,4,5,-9,1,2,3}));*/
      System.out.print(stringChase.numUniqueEmails(new String[]{"nk@g.com","n.k@g.com","n+k@gmail.com","nk@yahoo.com"}));
      System.out.println(stringChase.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
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

    static int maxSubArray(int[] nums) {
        int sum = nums[0], curSum = nums[0];

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
