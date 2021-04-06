package org.gonchar.leetcode.tree;

public class TreeFactory {

    BinaryTreeNode<Character> generate() {
        BinaryTreeNode<Character> b = new BinaryTreeNode<>('B');
        BinaryTreeNode<Character> l = new BinaryTreeNode<>('L');
        BinaryTreeNode<Character> o = new BinaryTreeNode<>('O');
        BinaryTreeNode<Character> p = new BinaryTreeNode<>('P');
        BinaryTreeNode<Character> e = new BinaryTreeNode<>('E');
        BinaryTreeNode<Character> t = new BinaryTreeNode<>('T');
        BinaryTreeNode<Character> s = new BinaryTreeNode<>('S');
        BinaryTreeNode<Character> q = new BinaryTreeNode<>('Q');
        BinaryTreeNode<Character> c = new BinaryTreeNode<>('C');
        BinaryTreeNode<Character> r = new BinaryTreeNode<>('R');
        BinaryTreeNode<Character> u = new BinaryTreeNode<>('U');

        b.setLeft(l);
        b.setRigth(o);

        l.setLeft(p);
        l.setRigth(e);

        o.setLeft(t);
        o.setRigth(s);

        p.setLeft(q);
        p.setRigth(c);

        e.setLeft(r);

        s.setLeft(u);

        return b;
    }
}
