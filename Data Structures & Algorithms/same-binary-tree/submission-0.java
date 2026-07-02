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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        dfs(p, pList);
        dfs(q, qList);
        if (pList.size() != qList.size()) {
            return false;
        }
        for (int i = 0; i < pList.size(); i++) {
            TreeNode pChild = pList.get(i);
            TreeNode qChild = qList.get(i);
            if (pChild == null && qChild != null) {
                return false;
            }
            if (qChild == null && pChild != null) {
                return false;
            }
            if (pChild == null && qChild == null) {
                continue;
            }
            if (pChild.val != qChild.val) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        list.add(node);
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
