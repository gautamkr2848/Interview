package com.interview.systemDesign.LLD;
/*
There are several data structures that can be used to represent LRU cache. A linked list
(either singly linked or doubly linked), or an array are the most obvious choices. This algorithm
specifically needs to be able to remove items from the middle of the list and move them to the start.
So for that reason arrays are not ideal: removing an element from the middle would require
a lot of shifting.
Singly linked lists could have worked, but are harder to implement correctly, because if you
want to remove an item from the list you have to know its predecessor. So the
doubly linked list was probably the easiest efficient solution that meets all the requirements.
*/


import java.util.*;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    /*This method will delete node*/
    public void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    /*This method will make passed node as head*/
    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;
        head = node;
        if (end == null)
            end = head;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);    // update the old value
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                delete(end);    // remove last node
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }
}

class LRUCache2 {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache2(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };

        /*Used for Array Cache
        Set<Integer> set = Collections.newSetFromMap(new LinkedHashMap<Integer, Boolean>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        });*/
    }

    public int get(int key) {
        System.out.println("Going to get the value for the key : " + key);
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        System.out.println("Going to set the (key, value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }
}
