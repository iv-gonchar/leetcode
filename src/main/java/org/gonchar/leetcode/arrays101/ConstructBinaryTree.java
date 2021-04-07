package org.gonchar.leetcode.arrays101;

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildSubTree(0, inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    private TreeNode buildSubTree(int lIn, int[] inorder, int rIn, int lPo, int[] postorder, int rPo) {
        if (rPo < lPo) {
            return null;
        }
        int value = postorder[rPo];
        TreeNode parent = new TreeNode(value);
        if (lPo == rPo) {
            return parent;
        }
        int parentPos = findParent(lIn, inorder, rIn, value);
        int leftLength = parentPos - lIn;

        parent.left = buildSubTree(lIn, inorder, parentPos - 1, lPo, postorder, lPo + leftLength - 1);
        parent.right = buildSubTree(parentPos + 1, inorder, rIn, lPo + leftLength, postorder, rPo - 1);
        return parent;
    }

    /**
     * Finds parent node position in inorder traversal array
     */
    private int findParent(int l, int[] inorder, int r, int parent) {
        for (int i = l; i <= r; i++) {
            if (inorder[i] == parent) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
