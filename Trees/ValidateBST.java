package Trees;

import java.util.ArrayList;

public class ValidateBST {

	/**
	 * Anshul Jain
	 * ajain89@asu.edu
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {3,2,5,1,4};
		/*
		 * 	       	    3
		 *                 / \
		 *                /   \
		 *               2     5
		 *              / \       
		 *             1   4 
		 * 
		 * */
		int[] array = {4,2,5,1,6};
		/*
		 * 		    4
		 *                 / \
		 *                /   \
		 *               2     5
		 *              / \       
		 *             1   6 
		 * 
		 * */
		//int[] array = {-2147483648};
		//int[] array = {0,-1};
		//int[] array = {-2147483647,-2147483648,2147483647};
		BinaryTree bt=null;
		bt=BinaryTree.buildATree(bt, array);
		System.out.println(isValidBST(bt));
	}
	/*************************************************************************/	
	public static boolean checkBST(BinaryTree root){
		return checkBSTMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean checkBSTMinMax(BinaryTree root, int min, int max){
		if(root==null)
			return true;
		if (root.data < min || root.data > max) 
		     return false; 
		return checkBSTMinMax(root.left, min, root.data) &&  
				checkBSTMinMax(root.right, root.data, max);
	}
	/*************************************************************************/	
	public static boolean isValidBST(BinaryTree root){
		if(root == null)
			return true;
		if(root.left == null && root.right==null)
			return true;
		validateBST(root);
		for(int i=1;i<a.size();i++)
			if(a.get(i)<=a.get(i-1))
				return false;
		return true;
	}
	public static ArrayList<Integer> a = new ArrayList<>();
	public static void validateBST(BinaryTree root){
		if(root == null)
			return;
		validateBST(root.left);
		a.add(root.data);
		validateBST(root.right);
	}
}
