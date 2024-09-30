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

中序
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





后序
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                res.addFirst(root.val);
                stk.push(root);
                root = root.right;
            }
            if (!stk.isEmpty()) {
            root = stk.pop();
            root = root.left;
            }
        }
        return res;
    }
}




前序
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val); // 访问当前节点
            
            // 先压入右子节点，再压入左子节点
            // 因为栈是 LIFO（后进先出），所以左子节点会先处理
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return res;
    }
}
