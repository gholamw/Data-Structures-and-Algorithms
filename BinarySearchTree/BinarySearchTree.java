package BinarySearchTree;

import java.util.Queue;

public class BinarySearchTree< Key extends Comparable<Key>, Value> {
	
	Node root;
	String printTreeInOrder = " ";
	
	public class Node{
		Key nodeKey;
		Value nodeValue;
		Node right,left;
		Node(Key key, Value val){
			nodeKey = key;
			nodeValue = val;
		}
	}
	
	
	public boolean isEmpty(){
		if(this.root == null) return true;
		return false;
	}
	
	
	
    public void put(Key key, Value val) {
      //  if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.nodeKey);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.nodeValue   = val;
       // x.N = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    
    public void delete(Key key){
    	delete(this.root, key);
    }
    
    private Node delete(Node x, Key key){
    	if(x == null ) return null;
    	int cmp = key.compareTo(x.nodeKey);
    	if(cmp < 0 ) x.left = delete(x.left, key);
    	else if(cmp > 0 ) x.right = delete(x.right, key);
    	else {
    		if(x.left != null && x.right != null)
    		{
    			Node y = predecessor(x.left,1);
    			System.out.println("Content is " + x.nodeKey);
    			x.nodeKey = y.nodeKey;
    			x.nodeValue = y.nodeValue;
    			return delete(y,y.nodeKey); 
    			} // case 3, Node has 2 childern
    		else if(x.right == null && x.left == null) return null;
    		else if (x.left == null) return x.right;
    		else if(x.right == null) return x.left;
    		
    	}
    	
    	return x;
    }
    
    
    public Node predecessor(Node x, int num){
    	Node predecessorNode = predecessor(x);
    	return predecessorNode;
    }
    
    private Node predecessor(Node x){
    	if(x.right == null) return x;
    	x = predecessor(x.right);
    	return x;
    }
    
    
//    private Node delete(Node x, Key key){
//    	if(x == null ) return null;
//    	int cmp = key.compareTo(x.nodeKey);
//    	if(cmp < 0 ) x.left = delete(x.left, key);
//    	else if(cmp > 0 ) x.right = delete(x.right, key);
//    	else if ( cmp == 0 ) return null;
//    	
//    	return x;
//    }
    	
	
	public String printInOrder(){
		printTreeInOrder = " ";
		printInOrder(this.root );
		return printTreeInOrder;
	}
	
	private Node printInOrder(Node x){
		if(x == null) return null;
		printInOrder(x.left);
		printTreeInOrder = printTreeInOrder + x.nodeKey + " - ";
		printInOrder(x.right);
		
		return null;
	}
	
	
	public Key floor(Key key){
		Node wantedKey = floor(this.root, key);
		return wantedKey.nodeKey;
	}
	
	private Node floor(Node x, Key key){
		if(x == null ) return null; 
		
		int cmp = key.compareTo(x.nodeKey);
		if(cmp < 0 )return floor(x.left, key);
		if (cmp > 0) return floor(x.right, key);
		
		Node t = floor(x.right, key);
		if(t != null)return t;
		else return x;
		
		
		
	}
	
    
 
    
    private Node Cieling(Node x, Key key)
    {
     if (x == null) return null;
     int cmp = key.compareTo(x.nodeKey);
     if (cmp == 0) return x;
     if (cmp < 0) return Cieling(x.left, key);
     Node t = Cieling(x.right, key);
     if (t != null) return t;
     else return x;
    } 
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<Integer,Integer>();
		tree.put(25, 25);
		tree.put(22, 22);
		tree.put(30, 30);
		tree.put(21, 21);
		tree.put(23, 23);
		tree.put(29, 29);
		tree.put(40, 40);
		tree.put(20, 20);
		System.out.println(tree.printInOrder());
		//tree.delete(40);
		System.out.println(tree.printInOrder());
		//tree.delete(25);
		System.out.println(tree.printInOrder());
		//tree.delete(21);
		System.out.println(tree.printInOrder());
		//tree.delete(24);
		//System.out.println(tree.printInOrder());
		//System.out.println("The Key is :  "  +  tree.floor(60));
		System.out.print(tree.Cieling(tree.root, 28).nodeKey);
		
		





		//System.out.println(tree.print());



	}
	
	
	
	
	
	
	
	
	
	
}
