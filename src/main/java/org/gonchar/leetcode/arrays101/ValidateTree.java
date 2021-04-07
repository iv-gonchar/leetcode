package org.gonchar.leetcode.arrays101;

import java.util.Stack;

public class ValidateTree {
    public boolean isValidBST(TreeNode root) {
        Stack<SearchNode> stack = new Stack<>();
        SearchNode sNode = null;
        if (root != null) {
            sNode = new SearchNode(root);
        }
        SearchNode lastVisited = null;
        while (!stack.empty() || sNode != null) {
            if (sNode != null) {
                stack.push(sNode);
                if (sNode.node.left != null) {
                    sNode.left = new SearchNode(sNode.node.left);
                }
                if (sNode.node.right != null) {
                    sNode.right = new SearchNode(sNode.node.right);
                }
                sNode = sNode.left;
            } else {
                SearchNode parent = stack.peek();
                if (parent.right != null && parent.right != lastVisited) {
                    sNode = parent.right;
                } else {
                    visitNode(parent);
                    if (!parent.isValid) {
                        return false;
                    }
                    lastVisited = parent;
                    stack.pop();
                }
            }
        }
        return true;
    }

    private void visitNode(SearchNode s) {

        if (s.left != null) {
            s.isValid = s.left.isValid && s.node.val > s.left.max;
            s.min = s.left.min;
        } else {
            s.isValid = true;
            s.min = s.node.val;
        }

        if (s.right != null) {
            s.isValid = s.isValid && s.right.isValid && s.node.val < s.right.min;
            s.max = s.right.max;
        } else {
            s.max = s.node.val;
        }

    }

    static class SearchNode {
        TreeNode node = null;
        SearchNode left = null;
        SearchNode right = null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isValid = false;

        SearchNode(TreeNode node) {
            this.node = node;
        }
    }
}
