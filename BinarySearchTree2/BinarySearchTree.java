package BinarySearchTree2;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import BinarySearchTree.BinarySearchTree.Node;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	Node root;
	String tree = " ";
	String printTreeInOrder = " " ;
	String printTreeOrder = " " ;
	Queue <Node>q = new LinkedList<Node>();

	ArrayList<Key> list = new ArrayList<Key>();


	
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    
    
    public boolean isEmpty(){
    	if(this.root == null)
    		return true;
    	return false;
    }
    
    
    
    public void put(Key key,Value val){
    	put(this.root, key,val);
    }
    
    
    private Node put(Node x, Key key, Value val){
    	if(isEmpty())
    		this.root = new Node(key,val,1);
    	if(x == null){
    		x = new Node(key,val,1);
    		return x;
    	}
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0)  x.left = put(x.left, key,val);
    	else if (cmp > 0)  x.right = put(x.right,key,val);
		return x;
    	
    	    	
    }
    
    
    public int height(Node n, int b){
    	int x = height(n);
    	return x;
    }
    
    private int height(Node x){
    	if(x == null)
    		return 0;
    	return 1 + Math.max(height(x.right), height(x.left));
    }
    
    
    public Node predecessor(Node x){
    	return predecessor(x.left, 1);
    }
    
    private Node predecessor(Node x, int num){
    	if(x == null ) return x;
    	x.right = predecessor(x.right, 1);
    	
    	return x;
    }
    
    
    public Node successor(Node x){
    	Node y = successor(x.right, 1);
    	return y;
    }
    
    private Node successor(Node x, int num){
    	if(x == null ) return x;
    	x.left = successor(x.left, 1);
    	
    	return x;
    }
    
    
    public Key floor(Key key){
    	Node x = floor(this.root, key, this.root);
    	return x.key;
    }
    
    private Node floor(Node x, Key key, Node node){
    	if(x == null) return null;
    	
    	int cmp = x.key.compareTo(key);
    	if(cmp == 0) return floor(x.left, key, x);
    	else if(cmp < 0) return floor(x.right, key, x);
    	else{
    		Node temp = floor(x.left , key, x);
    		if(temp == null) return x; 
    		else return temp;
    	}    	
    	
    }
    
    
    
    public Key ceiling(Key key , Value val){
    	Node x = ceiling(this.root, key,val, this.root);
    	return x.key;
    	
    }
    
    private Node ceiling(Node x, Key key, Value val, Node node){
    	if(x == null) return node;
    	
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp == 0) return x;
    	else if(cmp > 0 ) return ceiling(x.right, key,val, x);
    	else{
    		Node child = x.left;
    		
    		if(child == null) return x;
    		int cmp1 = key.compareTo(child.left.key);
    		if(cmp1 > 0) return child;
    		return ceiling(child.left, key,val, x);
    	}
    	
    	
    	
    }
    
    
    public int rank(Key key){
    	return rank(this.root, key);
    }
    
    private int rank(Node x, Key key){
    	if(x == null ) return 0;
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp == 0) return height(x);
    	if(cmp < 0 ) return rank(x.left, key);
    	
    	return 1+ height(x.left) + rank(x.right ,key);
    	
    }
    
    
    public int leftHeight(){
    	return leftHeight(this.root);
    	
    }
    
    private int leftHeight(Node x){
    	
    	if(x == null) return 0;
    	int rightSubtree = height(x.right);
    	int leftSubtree = height(x.left);
    	if(rightSubtree > leftSubtree){
    		return leftHeight(x);
    	}else{
    		 return 1 + leftHeight(x.left); 
    	}
    	
    }
    
    
    
    public void delete(Key key, Value val){
    	delete(this.root, key,this.root);
    }
    
    private Node delete(Node x, Key key, Node node){
    	if(x == null) return null;
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0) delete(x.left, key, x);
    	else if(cmp > 0) delete(x.right, key, x);
    	else if(x.left == null || x.right == null){
    		int cmp1 = key.compareTo(node.key);
    		if(cmp1 < 0) node.left = null;
    		if(cmp1 > 0) node.right = null;
    	}else{
    		Node pre = successor(x);
    		System.out.println("The sucssesor node is : "  + pre.key);
    		System.out.println("The current node is : "  + node.key);
    		System.out.println("The prevoius node is : "  + x.key);
    		//System.out.println(pre.left.key);
    		System.out.println(x.left.key);
    		System.out.println(node.right.key);
    		System.out.println(pre.key);
    		System.out.println(" ");




    		pre.left = x.left;
    		node.right = pre;
    		return null;
    		}

    
		return null;
    	
  }
    
    
    public Key floor1(Key key, Value val){
    	Node x = floor1(this.root, key,val,this.root);
    	return x.key;
    }
    
    private Node floor1(Node x , Key key, Value val, Node node){
    	if(x == null) return node;
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0 ) return floor1(x.left,key ,val,x);
    	else if(cmp == 0) return x;
    	else{
    		if(x.right == null) return x;
    		Node child = x.right;
    		int cmp1 = key.compareTo(child.key);
    		if(cmp1 > 0) 
    			return floor1(x.right , key, val, x);
    		if(cmp1 == 0)
    			return child;
			return floor1(child.left , key, val, x);
    	}
    }
    
    
    
    
    
    
    public String prettyPrintKeys() {
		// TODO fill in the correct implementation.
		String tree = prettyPrint(root, "");
		return tree;
	}

	private String prettyPrint(Node node, String prefix) {
		String output = "";
		if (node != null) {
			// System.out.println(node.key);
			output = prefix + "-" + node.key + "\n";
			// prefix = prefix + "|";
			String left = prettyPrint(node.left, prefix + " |");
			String right = prettyPrint(node.right, prefix + "  ");
			output = output + left + right;
			// System.out.print(prefix);
		} else {
			output = prefix + "-null\n";
		}
		return output;

	}
	
	
	public String printInOrder(){
		printTreeInOrder = " ";
		printInOrder(this.root);
		return printTreeInOrder;
	}
	
	private Node printInOrder(Node x){
		if(x == null) return null;
		printInOrder(x.left);
		printTreeInOrder += x.key + " - ";
		list.add(x.key);
		printInOrder(x.right);
		
		return null;

		
	}
	
	public int rank1 (Key key){
		int rankNumber =0;
		for(int i=0; i<list.size(); i++){
			int cmp = key.compareTo(list.get(i));
			if(cmp == 0){
				rankNumber = i;
				return rankNumber;
			}
		}
		return rankNumber;	
	}
	
	public int rank2 (Key key){
		return rank2(this.root, key);
	}
	
	public int rank2(Node x, Key key){
		if(x == null) return 0;
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank2(x.left, key);
		if(cmp == 0) return 1 + height(x.left);
		
		return 1 + height(x.left) + rank(x.right, key);
		}
	
	
	public Key select (int num){
		Key rankNumber =null;
		for(int i=0; i<list.size(); i++){
			if(i == num){
				rankNumber = list.get(i);
				return rankNumber;
			}
		}
		return rankNumber;	
	}
	
	public String treeOrder(){
		printTreeOrder = " ";
		treeOrder(this.root, printTreeOrder);
		return printTreeOrder;
		
		
	}
	
	private void treeOrder(Node x, String tree){
		q.add(x);
		do{	
		if(x == null) return;	
		Node pervious = q.remove();
		printTreeOrder = printTreeOrder + pervious.key + " - ";
		q.add(x.left);
		q.add(x.right);
		x = q.element();
		
		}while(q.isEmpty() == false);
	}
	
	public int fullHeight(){
		return fulHeight(this.root);
	}
	
	private int fulHeight(Node x){
		if(x == null) return 0;
		
		int leftsub = height(x.left);
		int rightsub = height(x.right);
		if(leftsub != rightsub) return -1;
		
		return height(x);
		
	}
    
    
    public static void main(String[] args){
    	
    	BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
    	bst.put(10,10);
    	bst.put(5,5);
    	bst.put(15,15);
    	System.out.println("The height of the tree is : "  + bst.height(bst.root));

    	System.out.println(bst.prettyPrintKeys());
    	
    	bst.delete(15, 15);
    	System.out.println(bst.prettyPrintKeys());
    	bst.put(15,15);
    	bst.put(20,20);
    	bst.put(11,11);
    	bst.put(6,6);
    	bst.put(4,4);

    	
    	System.out.println(bst.prettyPrintKeys());




    	System.out.println("The floor is : " + bst.floor(11));
    	//System.out.println("The ceiling is : " + bst.ceiling(12));
    	System.out.println("The height of the tree is : "  + bst.height(bst.root.right));
    	System.out.println("The rank of node 15 is : " + bst.rank(11));
    	System.out.println("The left Height is  : " + bst.leftHeight());


    	
    	//bst.delete(15, 15);
    	System.out.println(bst.prettyPrintKeys());
    	
    	
    	
    	BinarySearchTree<Integer,Integer> bst1 = new BinarySearchTree<Integer,Integer>();
    	bst1.put(8,8);
    	bst1.put(6,6);
    	bst1.put(10,10);
    	bst1.put(4,4);
    	bst1.put(7,7);
    	bst1.put(9,9);
    	bst1.put(15,15);
    	System.out.println(bst1.prettyPrintKeys());
    	System.out.println(bst1.floor1(5, 5));
    	System.out.println(bst1.floor1(9, 9));
    	System.out.println(bst1.floor1(11, 11));
    	System.out.println(bst1.floor1(15, 15));
    	System.out.println(bst1.floor1(10, 10));
    	System.out.println("The ceiling of 5 is " + bst1.ceiling(5, 5));
    	System.out.println("The ceiling of 6 is " + bst1.ceiling(6, 6));
    	System.out.println("The ceiling of 11 is " + bst1.ceiling(11, 11));
    	System.out.println("The ceiling of 10 is " + bst1.ceiling(10,10));
    	System.out.println("The ceiling of 8 is " + bst1.ceiling(8, 8));
    	System.out.println("The ceiling of 20 is " + bst1.ceiling(20, 20));

    	System.out.println("The height of the tree is : "  + bst1.height(bst.root.left));
    	
    	System.out.println(bst1.printInOrder());
    	System.out.println("Rank of key 10 is :  " + bst1.rank1(10));
    	System.out.println("Rank of key 8 is :  " + bst1.rank1(8));
    	
    	System.out.println("Rank of key 10 is :  " + bst1.rank2(10));
    	System.out.println("Rank of key 8 is :  " + bst1.rank2(8));
    	
    	System.out.println("The key has rank 5 is : " + bst1.select(5));
    	System.out.println("The key has rank 3 is : " + bst1.select(3));


    	System.out.println(bst1.treeOrder());
    	System.out.println("The left height before deletion is  " + bst1.leftHeight());
    	System.out.println("Exam question : " + bst1.fullHeight());
    	bst1.put(1000,1000);
    	System.out.println("Exam question : " + bst1.fullHeight());


    	//bst1.delete(6, 6);
    	//bst1.delete(12, 12);
    	//System.out.println("The left height after deletion is  " + bst1.leftHeight());














    	
    	
    	
    }

}
