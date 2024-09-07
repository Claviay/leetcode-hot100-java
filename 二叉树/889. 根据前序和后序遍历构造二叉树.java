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
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;

        // 创建一个哈希表，用于存储后序遍历中每个值的位置，方便查找子树
        Map<Integer, Integer> postIndex = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            postIndex.put(postorder[i], i);
        }

        // 调用递归函数来构建二叉树，初始范围是整个数组
        return dfs(preorder, 0, n, postorder, 0, n, postIndex);
    }

    /**
     * 递归构建二叉树的辅助函数
     *
     * @param preorder 前序遍历数组
     * @param preL 前序遍历的左边界（左闭）
     * @param preR 前序遍历的右边界（右开）
     *
     * @param postorder 后序遍历数组
     * @param postL 后序遍历的左边界（左闭）
     * @param postR 后序遍历的右边界（右开）
     *
     * @param postIndex 哈希表，存储后序遍历中元素的位置
     * @return 构造的当前子树的根节点
     */
    private TreeNode dfs(int[] preorder, int preL, int preR, 
                         int[] postorder, int postL, int postR, 
                         Map<Integer, Integer> postIndex) {

        // 如果前序遍历的区间为空，返回空节点
        if (preL == preR) {
            return null;
        }

        // 创建根节点，前序遍历的第一个元素即为根节点
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);

        // 当只剩下一个节点时，直接返回根节点
        if (preR - preL == 1) {
            return root;
        }

        // 获取前序遍历的下一个元素（左子树的根节点），在后序遍历中找到它的位置
        int leftRootVal = preorder[preL + 1];
        int leftRootIndex = postIndex.get(leftRootVal);

        // 根据左子树根节点的位置，计算左子树的大小
        int leftSize = leftRootIndex - postL + 1;

        // 递归构建左子树
        root.left = dfs(
                preorder, 
                preL + 1,                  // 左子树在前序遍历中的起始位置
                preL + 1 + leftSize,       // 左子树在前序遍历中的终止位置（不包含）

                postorder, 
                postL,                     // 左子树在后序遍历中的起始位置
                leftRootIndex + 1,         // 左子树在后序遍历中的终止位置（不包含）

                postIndex
        );

        // 递归构建右子树
        root.right = dfs(
                preorder, 
                preL + 1 + leftSize,       // 右子树在前序遍历中的起始位置
                preR,                      // 右子树在前序遍历中的终止位置

                postorder, 
                leftRootIndex + 1,         // 右子树在后序遍历中的起始位置
                postR - 1,                 // 右子树在后序遍历中的终止位置（不包含根节点）

                postIndex
        );

        // 返回构造好的根节点
        return root;
    }
}
