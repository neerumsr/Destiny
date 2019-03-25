package com.company;
import com.company.AddTwoNumber.ListNode;

/**
 * Created by pranavi on 1/8/19.
 */
public class KMergeLists {
    public ListNode mergeSortedLists(ListNode leftList, ListNode rightList) {

        if (leftList == null) return rightList;
        if (rightList == null) return leftList;

        if (leftList.data < rightList.data) {
            leftList.nextNode = mergeSortedLists(leftList.nextNode, rightList);
            return leftList;
        }  else {
            rightList.nextNode = mergeSortedLists(leftList, rightList.nextNode);
            return rightList;
        }
    }
    public ListNode mergeKLists(ListNode[] lists, int start, int end) {

        // Some base cases
        if (start > end) return null;
        if (start == end) return lists[start];

        // Core divide and conquer

        int middle = (start + end)/2;

        ListNode leftList = mergeKLists(lists, start, middle);
        ListNode rightList = mergeKLists(lists, middle+1, end);

        return mergeSortedLists(leftList, rightList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }

}
