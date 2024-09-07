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

// 前序dfs递归要+1  后序不用
// 中序则是中间要间隔rootIndex，与rootIndex + 1 
import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        // 创建一个哈希表，用来快速定位中序遍历中每个节点的位置
        Map<Integer, Integer> index = new HashMap<>(n); // 预分配空间大小
        for (int i = 0; i < n; i++) {
            // 将中序遍历的每个值和它的下标存储到哈希表中，方便后续查找根节点位置

            // val就是位置
            index.put(inorder[i], i);
        }

        // 递归函数构造二叉树，初始范围为整个数组
        return dfs(preorder, 0, n, inorder, 0, n, index); // 左闭右开区间 [preL, preR)
    }

    /**
     * @param preorder 前序遍历数组
     * @param preL 当前子树在前序遍历中的起始位置（左闭）
     * @param preR 当前子树在前序遍历中的终止位置（右开）
     *
     * @param inorder 中序遍历数组
     * @param inL 当前子树在中序遍历中的起始位置（左闭）
     * @param inR 当前子树在中序遍历中的终止位置（右开）
     *
     * @param index 存储中序遍历中节点值对应位置的哈希表，方便查找根节点的位置
     * @return 构造出的当前子树的根节点
     */
    private TreeNode dfs(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> index) {
        // Base case：如果前序遍历的区间为空，返回空节点
        if (preL == preR) {
            return null;
        }

        // 从前序遍历的起点位置获取当前子树的根节点的值
        int rootVal = preorder[preL];
        // 找到根节点在中序遍历中的位置
        int rootIndex = index.get(rootVal);

        // 计算左子树的大小，即中序遍历中左子树节点的个数
        int leftSize = rootIndex - inL;

        // 构造左子树
        TreeNode left = dfs(
                preorder,
                preL + 1,                  // 左子树的前序遍历的起始位置是根节点的下一个
                preL + 1 + leftSize,       // 左子树的前序遍历的终止位置（不包括）

                inorder,
                inL,                       // 左子树的中序遍历的起始位置
                rootIndex,                 // 左子树的中序遍历的终止位置（不包括根节点）

                index
        );

        // 构造右子树
        TreeNode right = dfs(
                preorder,
                preL + 1 + leftSize,       // 右子树的前序遍历的起始位置
                preR,                      // 右子树的前序遍历的终止位置

                inorder,
                rootIndex + 1,             // 右子树的中序遍历的起始位置（根节点的右边）
                inR,                       // 右子树的中序遍历的终止位置

                index
        );

        // 返回当前子树的根节点，并连接左右子树
        return new TreeNode(rootVal, left, right);
    }
}
