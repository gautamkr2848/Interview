package com.interview.tree.bfs.horizontalDistance;
/*
                1                               4
       2                3               ==>     2
   4       5        6       7                   1 5 6
                        8       9               3 8
                                                7
                                                9
*/

import java.util.*;

public class d_VerticalTreeTraversal {

    public void printVertical(){

        a_NodeView root = new a_NodeView(20);
        root.left = new a_NodeView(8);
        root.right = new a_NodeView(22);
        root.left.left = new a_NodeView(5);
        root.left.right = new a_NodeView(3);
        root.right.left = new a_NodeView(4);
        root.right.right = new a_NodeView(25);
        root.left.right.left = new a_NodeView(10);
        root.left.right.right = new a_NodeView(14);

        if (root == null)
            return;

        int hd = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<a_NodeView> queue = new LinkedList<>();

        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()){
            a_NodeView temp = queue.remove();
            hd = temp.hd;

            if(map.containsKey(hd)){
                List<Integer> list = map.get(hd);
                list.add(temp.data);
                map.put(hd, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(temp.data);
                map.put(hd, list);
            }

            // If the dequeued node has a left child, add it to the queue with a horizontal distance hd-1.
            if (temp.left != null){
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a right child, add it to the queue with a horizontal distance hd+1.
            if (temp.right != null){
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        /*Map<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));*/

        for(Integer i : map.keySet()){
            List<Integer> list = map.get(i);
            System.out.print(i+" => ");
            for(int j=0; j<list.size(); j++)
                System.out.print(list.get(j)+" ");
            System.out.println();
        }

    }

}
