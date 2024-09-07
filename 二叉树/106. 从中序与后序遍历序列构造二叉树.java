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
import java.util.*;

// 前序dfs递归 一开始要+1  然后再加leftSize  
// 后序不用，直接+leftSize，  结尾需要 -1
// 中序则是中间要间隔rootIndex，与rootIndex + 1 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        // 创建一个哈希表，用来存储中序遍历数组中元素的位置
        Map<Integer, Integer> index = new HashMap<>(n); // 预分配空间大小
        for (int i = 0; i < n; i++) {
            // 将中序遍历的值和它的索引位置存入哈希表
            index.put(inorder[i], i);
        }

        // 递归函数来构造二叉树，初始范围是整个数组
        return dfs(inorder, 0, n, postorder, 0, n, index); // 左闭右开区间 [inL, inR)
    }

    /**
     * @param inorder 中序遍历数组
     * @param inL 当前子树在中序遍历中的左边界（左闭）
     * @param inR 当前子树在中序遍历中的右边界（右开）
     *
     * @param postorder 后序遍历数组
     * @param postL 当前子树在后序遍历中的左边界（左闭）
     * @param postR 当前子树在后序遍历中的右边界（右开）
     *
     * @param index 存储中序遍历中元素位置的哈希表
     * @return 构建的当前子树的根节点
     */
    private TreeNode dfs(int[] inorder, int inL, int inR, 
                         int[] postorder, int postL, int postR, 
                         Map<Integer, Integer> index) {

        // 如果后序遍历的区间为空，表示没有节点，返回空
        if (postL == postR) {
            return null;
        }

        // 获取当前子树的根节点值，即后序遍历的最后一个元素
        int rootVal = postorder[postR - 1];

        // 在中序遍历中找到根节点的位置
        int rootIndex = index.get(rootVal);

        // 计算左子树的节点数量
        int leftSize = rootIndex - inL;

        // 递归构建左子树
        TreeNode left = dfs(
                inorder, 
                inL,                    // 左子树在中序遍历中的起始位置
                rootIndex,              // 左子树在中序遍历中的结束位置（不包含根节点）

                postorder, 
                postL,                  // 左子树在后序遍历中的起始位置
                postL + leftSize,       // 左子树在后序遍历中的结束位置（不包含）

                index
        );

        // 递归构建右子树
        TreeNode right = dfs(
                inorder, 
                rootIndex + 1,          // 右子树在中序遍历中的起始位置
                inR,                    // 右子树在中序遍历中的结束位置

                postorder, 
                postL + leftSize,       // 右子树在后序遍历中的起始位置
                postR - 1,              // 右子树在后序遍历中的结束位置（不包含根节点）

                index
        );

        // 返回当前根节点，并连接左右子树
        return new TreeNode(rootVal, left, right);
    }
}
