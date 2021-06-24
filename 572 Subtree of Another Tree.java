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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        return confirmSubtree(root, subRoot) || isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot);
    }
    
    public boolean confirmSubtree(TreeNode big, TreeNode small) {        
        if (big == null && small == null) {
            return true;
        }
        
        if (big == null || small == null) {
            return false;
        }        
        
        return (big.val == small.val) && confirmSubtree(big.left, small.left) 
            && confirmSubtree(big.right, small.right);
    }
}