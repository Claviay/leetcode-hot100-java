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


// 定义一个类 Solution，解决验证二叉搜索树问题
class Solution {

    // 定义一个公共方法 isValidBST，用于判断整个树是否为二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 调用私有的递归方法进行验证，从根节点开始，初始的合法范围是整个 Long 类型的取值范围
        // 即根节点的值必须在 [Long.MIN_VALUE, Long.MAX_VALUE] 之间
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 定义一个私有的递归方法 isValidBST，该方法用于递归判断当前节点及其子树是否满足二叉搜索树的性质
    // 参数说明：
    // node：当前节点
    // left：当前节点允许的最小值（不包括在内）
    // right：当前节点允许的最大值（不包括在内）
    private boolean isValidBST(TreeNode node, long left, long right) {
        // 递归的终止条件，如果当前节点为空，返回 true，表示到达叶子节点的子节点（空节点），依然满足 BST 的条件
        if (node == null) {
            return true;
        }

        // 获取当前节点的值
        long x = node.val;

        // 检查当前节点的值是否在合法的范围内，即是否满足 left < x < right
        // 如果不满足，直接返回 false
        if (!(left < x && x < right)) {
            return false;
        }

        // 递归检查左子树和右子树是否满足 BST 的性质：
        // - 对于左子树，所有节点的值必须小于当前节点的值，因此递归调用时，更新右边界为当前节点的值
        // - 对于右子树，所有节点的值必须大于当前节点的值，因此递归调用时，更新左边界为当前节点的值
        return isValidBST(node.left, left, x) && // 检查左子树，右边界更新为当前节点的值
               isValidBST(node.right, x, right); // 检查右子树，左边界更新为当前节点的值
    }
}

/* 中序
class Solution {

    private long pre = Long.MIN_VALUE;



    public boolean isValidBST(TreeNode root) {

        if (root == null) {

            return true;

        }

        if (!isValidBST(root.left) || root.val <= pre) {

            return false;

        }

        pre = root.val;

        return isValidBST(root.right);

    }

}


后序
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def dfs(node: Optional[TreeNode]) -> Tuple:

            if node is None:

                return inf, -inf

            l_min, l_max = dfs(node.left)

            r_min, r_max = dfs(node.right)

            x = node.val

            # 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了

            if x <= l_max or x >= r_min:

                return -inf, inf

            return min(l_min, x), max(r_max, x)

        return dfs(root)[1] != inf


*/
