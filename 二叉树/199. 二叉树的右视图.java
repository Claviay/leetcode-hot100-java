/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
层序遍历

的变种
 */
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();
        dfs(1,root,levels);

        for (List<Integer> level : levels) {
            res.add(level.getLast());
        }
        return res;
    }

    void dfs(int level, TreeNode root, List<List<Integer>> levels){

        if (levels.size() < level) {
            levels.add(new ArrayList<Integer>());
        }


        levels.get(level - 1).add(root.val);

        if (root.left != null) {
            dfs(level + 1,root.left,levels);
        }

        if (root.right != null) {
            dfs(level + 1,root.right,levels);
        }


    }
}
