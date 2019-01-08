package com.company;



import java.util.Arrays;

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
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum.twoSumTwoPass(nums,target)));
        System.out.println(Arrays.toString(twoSum.twoSumOnePass(nums,target)));
        int sum = List2Num(addTwoNumbers.addTwoNumbers(Num2List(342), Num2List(465)));
        System.out.println(sum);
        System.out.print(intReverse.reverse(-1234));
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
}
