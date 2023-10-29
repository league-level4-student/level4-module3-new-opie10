package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	System.out.println(me);
    	
  int trueCount= sAd(avlTree.getRoot(),0,me);
        return trueCount;

    }
    public int sAd(AVLNode<Integer>avl,int counter, int me) {
    	if (avl!=null) {
			if (me>avl.getValue()) {
				
				int c =count(avl.getLeft(),0);
				counter =counter+ c;
				
				counter = sAd(avl.getRight(),counter, me);
				
			}
			if (me<=avl.getValue()) {
				
					counter = sAd(avl.getLeft(),counter, me);
				
				
			}
		}
		return counter;
    	
    }
    public int count(AVLNode<Integer>avl,int counter) {
	if (counter==0) {
		counter =1;
	}
    	if (avl!=null) {
			
		
    	if (avl.getLeft()!=null) {
    		counter = counter+1;
		
    	counter =count(avl.getLeft(),counter);
    	}

    	if (avl.getRight()!=null) {
    		counter = counter+1;
    	counter =count(avl.getRight(),counter);
    	}
    	}
    	return counter;
    }
    

}
