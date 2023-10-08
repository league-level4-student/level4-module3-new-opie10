package _03_Intro_to_Binary_Trees;

import java.util.List;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

    public static void main(String[] args) {
    	BinaryTree<Integer> tree = new BinaryTree<Integer>();
    	tree.insert(1);
    	Node<Integer>e = new Node<Integer>(2);
    	Node<Integer>f = new Node<Integer>(3);
    	Node<Integer>g = new Node<Integer>(4);
    	Node<Integer>h = new Node<Integer>(5);
    	Node<Integer>i = new Node<Integer>(6);
    	Node<Integer>j = new Node<Integer>(7);
    	tree.getRoot().setLeft(e);
    	tree.getRoot().setRight(f);
    	f.setRight(j);
    	f.setLeft(i);
    	e.setRight(h);
    	e.setLeft(g);
    	
    	
    	System.out.println(tree.getRoot().getValue());
    	tree.printVertical();
    	operation(tree.getRoot());
    	tree.printVertical();
    }
    public static void operation(Node<Integer> n) {
    	if (n!=null) {
			
		
    		operation(n.getLeft());
    		n.setValue(n.getValue()*2);
    		operation(n.getRight());
    }
    	else {
    		return;
    	}
    }

}
