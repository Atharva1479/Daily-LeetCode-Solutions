/* 94. Binary Tree Inorder Traversal - Easy

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();        
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {

                stack.push(root);
                root = root.left;
            }

            root = stack.pop();   
            res.add(root.val);
            root = root.right;
        }
        return res;        
    }
}
//Time complexity: O(n)
//Space complexity: O(n)