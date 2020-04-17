/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    List<Integer> res = new ArrayList<>();
	
	//迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()) {
            while(cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    /*
    //莫里斯遍历 就是一个节点如果左子树存在，就把这个节点挪到左子树的最右节点的右子节点
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre;
        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                TreeNode temp = cur.left;
                cur.left = null;
                pre.right = cur;
                cur = temp;
            }
        }
        return res;
    }
    */
    
    /*
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        backtrack(root);
        return res;
    }

    public void backtrack(TreeNode cur) {
        if(cur == null) return;
        backtrack(cur.left);
        res.add(cur.val);
        backtrack(cur.right);
    }*/
}