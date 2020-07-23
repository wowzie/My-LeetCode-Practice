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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length);
    }
    
    public TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) {
        	return null;
        }

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = createBST(nums, left, mid-1);
        root.right = createBST(nums, mid+1, right);

        return root;
    }
}

/**
Key Insights

There are two sub-problems here, one is to make sure the tree is a BST, and the second one is to make 
sure we have a height balanced tree. Since the array is sorted, we do not need to worry about our tree 
not being a BST. The values will auto-magically fall into place using my algorithm.

Algorithm:
	--> Find the middle value in the array and use it to create the root element.
	--> Recursively find the middle values in the left and right sub-halves of the root element.
	--> For every recursion, find the middle value and treat it as the root element for the subtree below it.
	--> Stop when the range doesn't make sense anymore, i.e. left is more than right.
*/