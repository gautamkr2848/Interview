package com.interview.tree.LCA;

import com.interview.tree.BTPath;
import com.interview.tree.Node;

import java.util.List;

public class LCAForBT {

    public int findLCA_2(Node node, int n1, int n2){
        BTPath btPath = new BTPath();
        List<Integer> path1 = btPath.nodeToRootPath(node, n1);
        List<Integer> path2 = btPath.nodeToRootPath(node, n2);

        int res = -1;
        for(int i=0; i<path1.size(); i++){
            res = path1.get(i);
            if(path1.get(i) == path2.get(i))
                continue;
            else
                break;
        }
        return res;
    }
}
