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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(res,root);
		return res;
	}

	void dfs(List<Integer> res, TreeNode root) {
		if(root==null) {
			return;
		}

		//按照 左-打印-右的方式遍历
		dfs(res,root.left);
		res.add(root.val);
		dfs(res,root.right);

	}

}

// 迭代

/*

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();  // 存储遍历结果的列表
        Deque<TreeNode> stk = new LinkedList<TreeNode>();  // 用于模拟递归的栈

        while (root != null || !stk.isEmpty()) {  // 当根节点非空或栈不为空时
            // 访问左子树
            while (root != null) {
                stk.push(root);  // 将当前节点压入栈中
                root = root.left;  // 移动到左子节点
            }
            // 处理当前节点
            root = stk.pop();  // 从栈中弹出节点（此节点为中序遍历中的当前节点）
            res.add(root.val);  // 将节点值加入结果列表
            root = root.right;  // 移动到右子节点
        }
        return res;  // 返回结果列表
    }
}



*/
