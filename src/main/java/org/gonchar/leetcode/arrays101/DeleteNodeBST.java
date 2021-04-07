package org.gonchar.leetcode.arrays101;

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return deleteRoot(root);
        }
        TreeNode node = root;

        // find key
        while (node != null) {
            if (node.val > key) {
                // left subtree
                if (node.left != null && node.left.val == key) {
                    delete(node, node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                // right subtree
                if (node.right != null && node.right.val == key) {
                    delete(node, node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    /**
     * Returns new root after deletion current root
     */
    private TreeNode deleteRoot(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // two children case
        Pair successor = findSuccessor(root);
        // swap

        TreeNode temp = new TreeNode(root.val, root.left, root.right);
        root.left = successor.child.left;
        root.right = successor.child.right;
        if (successor.parent != root) {
            replaceChild(successor.parent, successor.child, root);
            successor.child.left = temp.left;
            successor.child.right = temp.right;
            delete(successor.parent, root);
        } else {
            successor.child.left = temp.left;
            successor.child.right = root;
            delete(successor.child, root);
        }
        return successor.child;
    }

    private void delete(TreeNode parent, TreeNode node) {
        // parent should be not null here

        // no children
        if (node.left == null & node.right == null) {
            replaceChild(parent, node, null);
            return;
        }

        // one child
        if (node.left == null) {
            replaceChild(parent, node, node.right);
            return;
        }
        if (node.right == null) {
            replaceChild(parent, node, node.left);
            return;
        }

        // two children
        Pair successor = findSuccessor(node);
        // swap
        TreeNode temp = new TreeNode(node.val, node.left, node.right);
        node.left = successor.child.left;
        node.right = successor.child.right;
        if (successor.parent != node) {
            replaceChild(successor.parent, successor.child, node);
            successor.child.left = temp.left;
            successor.child.right = temp.right;
            replaceChild(parent, node, successor.child);
            // delete node on new place. Here is should not have 2 children
            delete(successor.parent, node);
        } else {
            successor.child.left = temp.left;
            successor.child.right = node;
            replaceChild(parent, node, successor.child);
            delete(successor.child, node);
        }
    }

    private Pair findSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode successor = node.right;
        while (successor.left != null) {
            parent = successor;
            successor = successor.left;
        }
        return new Pair(parent, successor);
    }

    private void replaceChild(TreeNode parent, TreeNode child, TreeNode replacement) {
        if (isLeftChild(parent, child)) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
    }

    private boolean isLeftChild(TreeNode parent, TreeNode child) {
        return parent.left == child;
    }

    static class Pair {
        TreeNode parent;
        TreeNode child;
        public Pair(TreeNode parent, TreeNode child) {
            this.parent = parent;
            this.child = child;
        }
    }

}
