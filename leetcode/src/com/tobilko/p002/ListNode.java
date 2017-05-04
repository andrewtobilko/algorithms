package com.tobilko.p002;

import java.util.StringJoiner;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");

        ListNode node = this;

        while (node != null) {
            joiner.add(Integer.toString(node.val));
            node = node.next;
        }

        return joiner.toString();
    }

}
