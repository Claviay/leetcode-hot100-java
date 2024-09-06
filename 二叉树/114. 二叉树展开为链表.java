class Solution {
    public void flatten(TreeNode root) {
        // 定义一个指针指向当前处理的节点
        TreeNode curr = root;
        
        while (curr != null) {
            // 如果当前节点有左子树
            if (curr.left != null) {
                // 找到左子树的最右节点
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // 将当前节点的右子树接到左子树的最右节点的右边
                rightmost.right = curr.right;
                
                // 将当前节点的左子树移动到右子树的位置
                curr.right = curr.left;
                curr.left = null; // 左子树置空
            }
            // 继续处理右子树
            curr = curr.right;
        }
    }
}

/*
class Solution {
    /**
     * 将给定的二叉树展开为一个右斜的链表，顺序按照先序遍历的顺序（根节点，左子树，右子树）
     * @param root 二叉树的根节点
     *
    public void flatten(TreeNode root) {
        // Base case 1: 如果节点为 null，直接返回。无需处理。
        if (root == null) {
            return;
        }

        // Base case 2: 如果当前节点没有左子树和右子树，也不需要进一步展开，直接返回。
        if (root.left == null && root.right == null) {
            return;
        }

        // 如果没有左子树，只需递归处理右子树，使其变为线性结构
        if (root.left == null) {
            flatten(root.right); // 递归处理右子树
            return; // 返回，因为右子树已经处理完毕，当前节点不需要其他操作
        } else {
            // 如果存在左子树，必须将左右子树分别压平成链表

            // 1. 递归处理左子树，将左子树展开为链表
            flatten(root.left);

            // 2. 递归处理右子树，将右子树展开为链表
            flatten(root.right);

            // 3. 找到左子树展开后，最右边的节点（也就是左子树链表的最后一个节点）
            TreeNode temp = root.left;
            while (temp.right != null) { // 一直向右走，直到找到左子树的最右节点
                temp = temp.right;
            }

            // 4. 将右子树接到左子树的最右节点的右子树位置上
            temp.right = root.right;

            // 5. 将左子树移动到右子树的位置，使得左子树成为当前节点的右子树
            root.right = root.left;

            // 6. 将左子树设为 null，因为已经将左子树挂载到右边
            root.left = null;
        }
    }
}
*/
