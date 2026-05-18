package com.interview.tree;

/*Input:
        Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
        Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

        Output:
        Postorder traversal is {4, 5, 2, 6, 3, 1}*/

public class Postorder_Pre_In {

    static int preIndex = 0;
    public static void postorder_Pre_In(int[] inorder, int[] preorder, int start, int end){
        if (start > end)
            return;

        int index = search(inorder, start, end, preorder[preIndex++]);       // Find index of next item in preorder traversal in inorder
        postorder_Pre_In(inorder, preorder, start, index - 1);     // traverse left tree
        postorder_Pre_In(inorder, preorder, index + 1, end);      // traverse right tree

        System.out.print(inorder[index] + " ");
    }

    private static int search(int[] inorder, int start, int end, int data) {
        int i = 0;
        for (i = start; i < end; i++)
            if (inorder[i] == data)
                return i;
        return i;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 3, 6};
        int[] preorder = {1, 2, 4, 5, 3, 6};
        postorder_Pre_In(inorder, preorder, 0, inorder.length - 1);
        preIndex = 0;
        Node node = buildTree(inorder, preorder, 0, inorder.length - 1);
        System.out.println();
        System.out.println(node.key);
    }

    private static Node buildTree(int[] inorder, int[] preorder, int start, int end) {
        if (start > end)
            return null;

        Node tNode = new Node(preorder[preIndex++]);

        if (start == end)
            return tNode;

        int inIndex = search(inorder, start, end, tNode.key);

        tNode.left = buildTree(inorder, preorder, start, inIndex - 1);
        tNode.right = buildTree(inorder, preorder, inIndex + 1, end);

        return tNode;
    }
}
