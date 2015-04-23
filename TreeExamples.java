package hardik.code;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeExamples {
	
	public static int getDepthOfNode(BinaryTreeNode root, int data)
	{
		int left, right;
		if(root == null)
			return 0;
		else
		{
			if(root.getData() == data)
				return 1;
			else
			{
				left =getDepthOfNode(root.getLeft(), data);
				if(left >= 1)
					return left +1;
				right = getDepthOfNode(root.getRight(), data);
				if(right >= 1)
					return right +1;
				
				return 0;
			}
		}
	}
	
	private static int getMaxSum(BinaryTreeNode root, int sum)
	{
		int left, right;
		if(root == null)
			return sum;
		
		if(root.getData() + sum > sum)
			sum = root.getData() +sum;
		
		left = getMaxSum(root.getLeft(), sum);
		right = getMaxSum(root.getRight(), sum);
		
		
		return left>right?left:right;
	}
	
	public static void preOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true) {
			while (root != null) {
				System.out.println(root.getData());
				s.push(root);
				root = root.getLeft();
			}
			if (s.isEmpty())
				break;
			root = s.pop();
			root = root.getRight();
		}
		return;
	}
	
	public static void inOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true) {
			while (root != null) {
				s.push(root);
				root = root.getLeft();
			}
			if (s.isEmpty())
				break;
			root = s.pop();
			System.out.print(root.getData() + " ");
			root = root.getRight();
		}
	}
	
	public static void postOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true) {
			while (root != null) {
				if (root.getRight() != null)
					s.push(root.getRight());
				s.push(root);
				root = root.getLeft();
			}
			if (s.isEmpty())
				return;
			else {
				root = s.pop();
				if (root.getRight() != null && !s.isEmpty() && s.peek().equals(root.getRight())) {
					s.pop();
					s.push(root);
					root = root.getRight();
				} else {
					System.out.println(root.getData());
					root = null;
				}
			}
		}
	}
	
	public static void levelOrder(BinaryTreeNode root) {
		if (root == null) 
			return;
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.poll();
			System.out.print(root.getData() + " ");
			if (root.getLeft() != null) {
				q.add(root.getLeft());
			}
			if (root.getRight() != null)
				q.add(root.getRight());
		}
	}
	
	public static boolean findElement(BinaryTreeNode root, int data) {
		boolean temp; 
		if (root == null) 
			return false;
		if (root.getData() == data) {
			System.out.println("Data Found");
			return true;
		} else {
			temp = findElement(root.getLeft(), data);
			if (temp) {
				return true;
			} else {
				return findElement(root.getRight(), data);
			}
		}
	}
	
	public static int sizeofTree(BinaryTreeNode root) {
		if(root == null)
			return 0;
		else
			return (sizeofTree(root.getLeft()) + 1 + sizeofTree(root.getRight())); 
	}
	
	
	public static int hightofTreeRecursive(BinaryTreeNode root) {
		int left, right;
		if(root == null)
			return 0;
		else {
			left = hightofTreeRecursive(root.getLeft());
			right = hightofTreeRecursive(root.getRight());
			if (left >= right) 
				return (left + 1);
			else 
				return (right + 1);
		}
	}
	
	public static int hightofTreeIterative(BinaryTreeNode root) {
		int level =0;
		if(root == null)
			return 0;
		else {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(root);
			q.add(null);
			while (!q.isEmpty()) {
				root = q.poll();
				if (root == null) {
					if (!q.isEmpty()) {
						q.add(null);
					}
					level++;
				} else {
					if (root.getLeft() != null)
						q.add(root.getLeft());
					if (root.getRight() != null)
						q.add(root.getRight());
				}
			}
		}
		return level;
	}
	public static void levelOrderReverse(BinaryTreeNode root) {
		if (root == null) 
			return;
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.poll();
			s.push(root);
			if (root.getRight() != null)
				q.add(root.getRight());
			if (root.getLeft() != null) {
				q.add(root.getLeft());
			}
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop().getData());
		}
	}
	
	public static BinaryTreeNode  deleteElementFromTree(BinaryTreeNode root, int data) {
		if (root == null)
			return root;
		if (root.getData() == data) {
			root = null;
			return root;
		}
			
		BinaryTreeNode lastNode = null, temp;
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		q.add(root);
		lastNode = findDeepestNode(root);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.getData() == data) {
				System.out.println("Deepest node is :" + lastNode.getData());
				temp.setData(lastNode.getData());
				//find parent node
			}
			//System.out.println(temp.getData());
			if (temp.getLeft() != null && !temp.getLeft().equals(lastNode)) {
				q.add(temp.getLeft());
			} else if(temp.getLeft() != null && temp.getLeft().equals(lastNode)) {
				temp.setLeft(null);
			}
			if (temp.getRight() != null && !temp.getRight().equals(lastNode)) {
				q.add(temp.getRight());
			} else if(temp.getRight() != null && temp.getRight().equals(lastNode)) {
				temp.setRight(null);
			}
		}
		return root;
	}
	
	
	public static BinaryTreeNode findDeepestNode(BinaryTreeNode root) {
		if (root == null) 
			return null;
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root.getLeft() != null) {
				q.add(root.getLeft());
			}
			if (root.getRight() != null)
				q.add(root.getRight());
		}
		return root;
		
	}
	 
	public static int findDiameter(BinaryTreeNode root, int diameter) {
		int left, right;
		if(root == null) 
			return 0;
		left = findDiameter(root.getLeft(), diameter);
		right = findDiameter(root, diameter);
		if (left + right + 1 > diameter)
			diameter = left + right;
		return (Math.max(left, right) + 1);
		
	}
	public static long getDiameter(BinaryTreeNode root) {
        if (root != null) {
            long leftDiameter = getDiameter(root.getLeft());
            long rightDiameter = getDiameter(root.getRight());
            long leftHeight = getHeight(root.getLeft());
            long rightHeight = getHeight(root.getRight());
            return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
        }
        return 0;
    }

    public static long getHeight(BinaryTreeNode root) {
        if (root != null) {
            long leftHeight = getHeight(root.getLeft());
            long rightHeight = getHeight(root.getRight());
            return  1 + Math.max(leftHeight, rightHeight);
        }
        return 0;
    }
    
    public static void printAllPaths(BinaryTreeNode root, int[] path, int pathLen) {
    	if (root == null) return;
    	path[pathLen++] = root.getData();
    	if (root.getLeft() == null && root.getRight() == null) {
    		for (int i = 0 ; i < pathLen; i++)
    			System.out.print(path[i]);
    		System.out.println();
    	} else {
    		printAllPaths(root.getLeft(), path, pathLen);
    		printAllPaths(root.getRight(), path, pathLen);
    	}
    	
    }
    
    static void printnPathToNode(BinaryTreeNode root, BinaryTreeNode node, int[] path, int len) {
    	if (root == null || node == null) {
    		return;
    	}
    	path[len++] = root.getData();
    	if (root == node) {
    		for (int i= 0; i < len; i++) {
    			System.out.print(path[i] + " ");
    		}
    	}
    	printnPathToNode(root.getLeft(), node, path, len);
    	printnPathToNode(root.getRight(), node, path, len);
    }
    
    public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
    	BinaryTreeNode left, right;
    	if (root == null)
    		return root;
    	if (root.equals(node1) || root.equals(node2)) {
    		return root;
    	}
    	left = findLCA(root.getLeft(), node1, node2);
    	right = findLCA(root.getRight(), node1, node2);
    	if (left != null && right != null)
    		return root;
    	else 
    		return (left != null ? left : right);
    }
    
    
    public static BinaryTreeNode preOrderChar(char[] ch, int i) {
    	if (ch == null) return null;
    	BinaryTreeNode node = new BinaryTreeNode();
    	node.setData(ch[i]);
    	if (ch[i] == 'L')
    		return node;
    	node.setLeft(preOrderChar(ch, ++i));
    	node.setRight(preOrderChar(ch, ++i));
    	return node;
    	
    }
    public static void zigZagTraversal(BinaryTreeNode root) {
    	if (root == null)
    		return;
    	Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
    	s.push(root);
    	boolean b = true;
    	while (!s.isEmpty()) {
    		Stack<BinaryTreeNode> t = new Stack<BinaryTreeNode>();
    		while (!s.isEmpty()) {
    			BinaryTreeNode temp = s.pop();
        		System.out.print(temp.getData() + "\t");
    			if (b) {
    				if (temp.getLeft() != null)
    					t.push(temp.getLeft());
    				if (temp.getRight() != null)
    					t.push(temp.getRight());
    			} else {
    				if (temp.getRight() != null)
    					t.push(temp.getRight());
    				if (temp.getLeft() != null)
    					t.push(temp.getLeft());
    			}
    		}
    		b = !b;
    		s = t;
    	}
    }
    
    public static boolean isBST(BinaryTreeNode root, int min, int max) {
    	if (root == null) return true;
    	if (root.getData() <= min || root.getData() >= max)
    		return false;
    	return (isBST(root.getLeft(), min, root.getData()) && isBST(root.getRight(), root.getData(), max));
    }
    
    public static BinaryTreeNode convertListToBST(Iterator<Integer> it, int start, int end) {
    	
    	if (start > end)
    		return null;
    	int mid = start + (end-start)/2;
    	BinaryTreeNode node = new BinaryTreeNode();
    	node.setLeft(convertListToBST(it, start, mid-1));
    	node.setData(it.next());
    	node.setRight(convertListToBST(it, mid + 1, end));
    	return node;
    	
    }
    
    public static BinaryTreeNode convertArrayToBST(int[] array, int start, int end) {
    	if (start > end) return null;
    	BinaryTreeNode node = new BinaryTreeNode();
   		int mid = start + (end - start)/2;
   		node.setLeft(convertArrayToBST(array, start, mid-1));
   		node.setData(array[mid]);
   		node.setRight(convertArrayToBST(array, mid + 1, end));
    	return node;
    }
    
    public static BinaryTreeNode convertToLL(BinaryTreeNode root, BinaryTreeNode currentNode)
    {
 	   if(root == null)
 		   return currentNode;
 	   else
 	   {
 		   currentNode = convertToLL(root.getLeft(), currentNode);
 		   if(currentNode != root)
 		   {
 			   currentNode.setRight(root);
 			   root.setLeft(currentNode);
 			   currentNode = root;
 		   }
 		   return convertToLL(root.getRight(), currentNode);
 	   }
    }
    
    public static BinaryTreeNode findPredecessor(BinaryTreeNode node)
    {
    	return null;
    	/*
        if (node == null)
            return null;
        
        if (node.getLeft() != null)
            return findMaximum(node.getLeft());
                
        TreeNode parent = node.getParent();
    
        TreeNode y = parent;
        TreeNode x = node;
        while (y != null && x == y.getLeft())
        {
            x = y;
            y = y.getParent();
        }
        
        return y;
        */
    }
    
    public static BinaryTreeNode findSuccessor(BinaryTreeNode node)
    {
    	return null;
    	/*
        if (node == null)
            return null;
        
        if (node.getRight() != null)
            return findMinimum(node.getRight());
        
        BinaryTreeNode y = node.getParent();
        BinaryTreeNode x = node;
        while (y != null && x == y.getRight())
        {
            x = y;
            y = y.getParent();
        }
        // Intuition: as we traverse left up the tree we traverse smaller values
        // The first node on the right is the next larger number
        return y;
        */
    }
    
    public static int isTreeBalanced (BinaryTreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftHeight = isTreeBalanced(root.getLeft());
    	if (leftHeight == -1)
    		return -1;
    	int rightHeight = isTreeBalanced(root.getRight());
    	if (rightHeight == -1)
    		return -1;
    	if (Math.abs(leftHeight - rightHeight) > 1)
    		return -1;
    	else
    		return (Math.max(leftHeight, leftHeight) + 1);
    }
    
    public static void levelOrderLinkedList(BinaryTreeNode root, LinkedList<LinkedList<BinaryTreeNode>> list) {
		LinkedList<BinaryTreeNode> levelList = new LinkedList<BinaryTreeNode>(); 
		if (root != null)
			levelList.add(root);
		while (levelList.size() > 0) {
			list.add(levelList);
			LinkedList<BinaryTreeNode> parentLevel = levelList;
			levelList = new LinkedList<BinaryTreeNode>();
			for (BinaryTreeNode node : parentLevel) {
				if(node.getLeft() != null)
					levelList.add(node.getLeft());
				if(node.getRight() != null)
					levelList.add(node.getRight());
			}
		}
    }
    
    public static BinaryTreeNode findCommonAnsector(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
    	if (root == null)
    		return root;
    	if (root == a || root == b)
    		return root;
    	BinaryTreeNode left = findCommonAnsector(root.getLeft(), a, b);
    	BinaryTreeNode right = findCommonAnsector(root.getRight(), a, b);
    	if (left!= null && right != null) 
    		return root;
    	else 
    		return (left != null?left : right);
    }
    
    public static boolean isSubTree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
    	if (tree1 == null)
    		return false;
    	if (tree2 == null)
    		return true;
    	if (tree1.getData() == tree2.getData()) {
    		return (isSubTreeHelper(tree1, tree2));
    	} else {
    		return (isSubTree(tree1.getLeft(), tree2) || isSubTree(tree1.getRight(), tree2));
    	}
    }
	private static boolean isSubTreeHelper(BinaryTreeNode tree1,
			BinaryTreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		if (tree1 == null || tree2 == null)
			return false;
		return (tree1.getData() == tree2.getData() && isSubTreeHelper(tree1.getLeft(), tree2.getLeft()) && isSubTreeHelper(tree1.getRight(), tree2.getRight()));
	}
	
	static void kThSmallest(BinaryTreeNode root, int count, int k) {
		if (root == null || k < 0) {
			return;
		}
		kThSmallest(root.getLeft(),count,k);
		--k;
		if(k == 0) {
			System.out.println("Kth smallest element is :" + root.getData());
			return;
		}
		kThSmallest(root.getRight(), count, k);
	}

	static void isCousine(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null || node2 == null)
			System.out.println("Not cousine");
		if (findLevel(root, node1, 1) == findLevel(root, node2, 1)
				&& !isSiblings(root, node1, node2))
			System.out.println("Cousines of eachother");
		else 
			System.out.println("Not cousines");
	}
	
	static int findLevel(BinaryTreeNode root, BinaryTreeNode node, int level) {
		if (root == null) {
			return -1;
		}
		if (root == node)
			return level;
		int leftLevel = findLevel(root.getLeft(), node, level + 1);
		if (leftLevel != -1)
			return leftLevel;
		
		return findLevel(root.getRight(), node , level + 1);
	}
	
	static boolean isSiblings(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		if (root == null)
			return false;
		return ((root.getLeft() == node1 && root.getRight() == node2)
				||(root.getRight() == node1 && root.getLeft() == node2)
				|| isSiblings(root.getLeft(), node1, node2)
				|| isSiblings(root.getRight(), node1, node2));
	}
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode();
		root1.setData(18);
		BinaryTreeNode root2 = new BinaryTreeNode();
		root2.setData(22);
		BinaryTreeNode root3 = new BinaryTreeNode();
		root3.setData(16);
		BinaryTreeNode root4 = new BinaryTreeNode();
		root4.setData(19);
		BinaryTreeNode root5 = new BinaryTreeNode();
		root5.setData(21);
		BinaryTreeNode root6 = new BinaryTreeNode();
		root6.setData(23);
		BinaryTreeNode root7 = new BinaryTreeNode();
		root7.setData(15);
		BinaryTreeNode root8 = new BinaryTreeNode();
		root8.setData(25);
		BinaryTreeNode root9 = new BinaryTreeNode();
		root9.setData(17);
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(20);
		root.setLeft(root1);
		root.setRight(root2);
		root1.setLeft(root3);
		root1.setRight(root4);
		root2.setLeft(root5);
		root2.setRight(root6);
		root3.setLeft(root7);
		root3.setRight(root9);
		root6.setRight(root8);
		System.out.println("-----------Get max sum-------------");
		System.out.println(getMaxSum(root, 0));
		System.out.println("-----------Cousines-------------");
		isCousine(root, root9, root6);
		System.out.println("-----------Kth Smallest-------------");
		kThSmallest(root, 0, 1);
		System.out.println("-----------PreOrder-------------");
		preOrder(root);
		System.out.println("--------------------------------");
		System.out.println("-----------InOrder-------------");
		inOrder(root);
		System.out.println("--------------------------------");
		System.out.println("-----------PostOrder-------------");
		postOrder(root);
		System.out.println("--------------------------------");
		System.out.println("-----------LevelOrder-------------");
		levelOrder(root);
		System.out.println("--------------------------------");
		System.out.println("----------Find Element Recursive-----------");
		findElement(root, 40);
		System.out.println("--------------------------------");
		System.out.println("----------Size of tree Recursive-------------");
		System.out.println("Size of tree is " + sizeofTree(root));
		System.out.println("--------------------------------");
		System.out.println("-----------LevelOrderReverse-------------");
		levelOrderReverse(root);
		System.out.println("--------------------------------");
		System.out.println("----------Height of tree Recursive-------------");
		System.out.println("Height of tree is " + hightofTreeRecursive(root));
		System.out.println("--------------------------------");
		System.out.println("----------Height of tree Iterative-------------");
		System.out.println("Height of tree is " + hightofTreeIterative(root));
		System.out.println("--------------------------------");
		if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("It is binary search tree");
		else 
			System.out.println("Not a binary serarch tree");
		LinkedList<LinkedList<BinaryTreeNode>> result = new LinkedList<LinkedList<BinaryTreeNode>>();
		levelOrderLinkedList(root, result);
		for (LinkedList<BinaryTreeNode> l : result) {
			for (BinaryTreeNode btn : l) {
				System.out.print(btn.getData());
			}
			System.out.println();
		}
		BinaryTreeNode nd = findCommonAnsector(root, root5, root7);
		root = deleteElementFromTree(root, 17);
		levelOrder(root);
		BinaryTreeNode temp = new BinaryTreeNode();
		temp.setData(18);
		
		temp = deleteElementFromTree(temp, 18);
		levelOrder(temp);
		
		System.out.println("Diameter is " + getDiameter(root));
		printAllPaths(root, new int[256], 0);
		System.out.println("Path to node is ");
		printnPathToNode(root, root3, new int[256], 0);
		System.out.println();
		System.out.println("LCA is :" + findLCA(root, root3, root4).getData());
		System.out.println("-----------Zigzag-------------");
		zigZagTraversal(root);
		System.out.println();
		System.out.println("------------------------------");
		temp = preOrderChar(new char[] {'I', 'L', 'I', 'L', 'L'}, 0);
		levelOrder(temp);
		root7.setRight(root8);
		if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("It is binary search tree");
		else 
			System.out.println("Not a binary serarch tree");
		int[] array = new int[]{2,3,4,5,6,7,8,9,10};
		List<Integer> list = Arrays.asList(new Integer[]{2,3,4,5,6,7,8,9,10});
		BinaryTreeNode node1 = convertListToBST(list.iterator(), 0, list.size() - 1);
		levelOrder(node1);
		BinaryTreeNode node2 = convertArrayToBST(array, 0, array.length - 1);
		levelOrder(node2);
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.setLeft(root1);
		//node.setRight(root2);
		root1.setLeft(root3);
		root3.setRight(root4);
		root4.setRight(root5);
		if(isTreeBalanced(node) != -1) {
			System.out.println("The Tree is balanced");
		} else {
			System.out.println("The tree is not balanced");
		}
		if (nd != null) {
			System.out.println("common ansector is : " + nd.getData());
		}
		if (isSubTree(root, node2)){
			System.out.println("Subtree of a given tree");
		} else {
			System.out.println("Not a subtree");
		}
		int[] array1 = new int[(int) getHeight(node1)];
		printPathWithSum(node1, 21 , array1, 0);
	}
	
	static void printPathWithSum(BinaryTreeNode root, int sum, int[] array, int len) {
		if (root == null) {
			return;
		} else {
			array[len] = root.getData();
			int pathSum = 0;
			for (int i = len ; i >=0 ; i--) {
				pathSum += array[i];
				if (pathSum == sum) {
					printPath(array, i, len);
				}
			}
			printPathWithSum(root.getLeft(), sum, array, len + 1);
			printPathWithSum(root.getRight(), sum, array, len + 1);
			array[len] = Integer.MIN_VALUE;
		}
		
	}
	

	private static void printPath(int[] array, int i, int len) {
		for (int j = i ; j <= len ; j++) {
			System.out.print(array[j] + " ");
		}
		System.out.println();
		
	}
	

}
