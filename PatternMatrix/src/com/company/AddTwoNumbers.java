package com.company;

public class AddTwoNumbers {



    public AddTwoNumber.ListNode addTwoNumbers(AddTwoNumber.ListNode l1, AddTwoNumber.ListNode l2) {
        AddTwoNumber.ListNode dummyHead = new AddTwoNumber.ListNode(0);
        AddTwoNumber.ListNode result = dummyHead;
        AddTwoNumber.ListNode p = l1, q = l2;
        int carry = 0;

        while (p!=null || q!=null) {

           int val1 =  p!=null?p.data:0;
           int val2 = q!=null?q.data:0;

           if(p!=null)
               p = p.nextNode;
           if(q!=null)
               q=q.nextNode;

           int sum = val1 + val2 + carry;

           result.nextNode = new AddTwoNumber.ListNode(sum%10);
           result = result.nextNode;

           carry = sum/10;

        }

        if(carry > 0)
            result.nextNode = new AddTwoNumber.ListNode(carry);

        return dummyHead.nextNode;
    }
}
