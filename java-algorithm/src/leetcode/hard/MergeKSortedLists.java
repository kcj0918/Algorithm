package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    /**
     * https://leetcode.com/problems/merge-k-sorted-lists/
     *
     * 12 ms, faster than 29.87% of Java online submissions for Merge k Sorted Lists.
     */
    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        if (lists.length == 0) {
            return null;
        }

        for (ListNode head : lists) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(list);

        if(list.size() == 0) {
            return null;
        }

        ListNode result = new ListNode(list.get(0));
        ListNode tmp = result;
        for (int i = 1; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
