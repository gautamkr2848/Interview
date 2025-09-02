package com.interview.tree;

public class TreeBSTDS {

    public static void main(String[] args) {
        TreeBSTDS bst = new TreeBSTDS();

        // Stream of integers (simulate input)
        int[] stream = { 50, 30, 70, 20, 40, 60, 80 };
        for (int num : stream) bst.insert(num);

        bst.inOrder(); // 20 30 40 50 60 70 80

        System.out.println(bst.search(40)); // true
        bst.update(40, 45);
        bst.inOrder(); // 20 30 45 50 60 70 80

        bst.delete(30);
        bst.inOrder(); // 20 45 50 60 70 80
    }

    private Node root;

    // CREATE: Insert a key
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key)
            node.left = insertRecursive(node.left, key);
        else if (key > node.key)
            node.right = insertRecursive(node.right, key);
        return node;
    }

    // READ: Search for a key
    public boolean search(int key) {
        return searchRecursive(root, key) != null;
    }

    private Node searchRecursive(Node node, int key) {
        if (node == null || node.key == key)
            return node;
        if (key < node.key)
            return searchRecursive(node.left, key);
        else
            return searchRecursive(node.right, key);
    }

    // UPDATE: Replace oldKey with newKey
    public void update(int oldKey, int newKey) {
        if (search(oldKey)) {
            delete(oldKey);
            insert(newKey);
        }
    }

    // DELETE: Remove a key
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Node with two children: get the inorder successor (min in right subtree)
            node.key = minValue(node.right);
            node.right = deleteRecursive(node.right, node.key);
        }

        return node;
    }

    private int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            node = node.left;
            min = node.key;
        }
        return min;
    }

    // Utility: In-order traversal
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.key + " ");
            inOrderRecursive(node.right);
        }
    }

}
