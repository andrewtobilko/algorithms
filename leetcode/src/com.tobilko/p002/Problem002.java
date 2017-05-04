package com.tobilko.p002;

import java.math.BigInteger;

public class Problem002 {

    public static void main(String[] args) {
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        n11.next = n12;
        n12.next = new ListNode(3);

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        n21.next = n22;
        n22.next = new ListNode(4);

        ListNode result = new Problem002().addTwoNumbers(n11, n21);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getListNodeFromValue(getValueFromListNode(l1).add(getValueFromListNode(l2)));
    }

    private ListNode getListNodeFromValue(BigInteger value) {
        String stringValue = reverseStringBuilderToString(new StringBuilder(String.valueOf(value)));

        ListNode node = new ListNode((int) Long.parseLong(stringValue.substring(0, 1)));
        ListNode previous = node;

        for (int i = 1; i < stringValue.length(); ++i) {
            ListNode n = new ListNode((int) Long.parseLong(stringValue.substring(i, i + 1)));
            previous.next = n;
            previous = n;
        }

        return node;
    }

    private BigInteger getValueFromListNode(ListNode node) {
        StringBuilder builder = new StringBuilder();

        do {
            builder.append(node.val);
            node = node.next;
        } while (node != null);

        return new BigInteger(reverseStringBuilderToString(builder));
    }

    private String reverseStringBuilderToString(StringBuilder builder) {
        return builder.reverse().toString();
    }

}
