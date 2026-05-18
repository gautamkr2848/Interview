package com.interview.list;

import java.util.HashSet;

public class InsertionPoint {

    public void insertionPoint(Node n1, Node n2){
        HashSet<Node> set = new HashSet<>();
        while (n1 != null) {
            set.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (set.contains(n2))
                System.out.println(n2);
            n2 = n2.next;
        }
        System.out.println("null");
    }

    public int insertionPoint2(Node n1, Node n2){
        Node curr1 = n1, curr2 = n2;
        while(curr1 != curr2){
            if(curr1 != null)
                curr1 = curr1.next;
            else
                curr1 = n2;

            if(curr2 != null)
                curr2 = curr2.next;
            else
                curr2 = n1;
        }

        if(curr1 == null)
            return -1;
        else
            return curr1.data;
    }
}