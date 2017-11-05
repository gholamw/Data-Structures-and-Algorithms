package BST;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
	private String treeInOrder = "";


    /**
     * Private node class.
     */
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

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: TODO
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() {
      //TODO fill in the correct implementation.
      int n = height(this.root,0);	
      return n;
    }
    
    private int height(Node x,int height){
    	int count = height;
    	if(x==null)return count;
    	
    	int leftCount = size(x.left);
    	int rightCount = size(x.right);
    	if(leftCount >= rightCount) return height(x.left,count+1);
    	else if (leftCount <= rightCount) return height(x.right,count+1);
    	else if (leftCount == 0 || rightCount == 0) return count;
    	else
    		return count;
    		
    }

    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */
    public Key median() {
      if (isEmpty()) return null;
      //TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.
      return null;
    }


    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
	public String printKeysInOrder() {
		if (isEmpty())
			return "()";

		String tree = printKeysInOrder(root);
		treeInOrder = "";
		return tree;

	}

	// TODO fill in the correct implementation

	private String printKeysInOrder(Node x) {
		if (x != null) {
			treeInOrder = treeInOrder +"(";
			printKeysInOrder(x.left);
			treeInOrder = treeInOrder + x.key;
			printKeysInOrder(x.right);
			treeInOrder = treeInOrder +")";

		} else {
			treeInOrder = treeInOrder +"()";
		}

		return treeInOrder;
	}
    
    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys() {
      //TODO fill in the correct implementation.
      return null;
    }
    
    public Node predecessor(Node x){
    	Node pre = predecessor(root);
    	return pre;
    }
    
    private Node predecessor(Node x, Key key){
    	if(x == null) return x;
    	return null;
    }

    /**
     * Deteles a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) {
      delete(this.root, key);
    }
    
    private Node delete(Node x , Key key){
    	if(x == null) return null;
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0) x.left = delete(x.left, key);
    	else if (cmp >0 ) x.right = delete(x.right, key);
    	else
    		
    		if(x.right == null) return x.left;
    		if(x.left == null) return x.right;
    	
    	return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
						// -7
						// |-3
						// | |-1
						// | | |-null
		bst.put(140, 140);  // | | -2
		bst.put(123, 123);  // | | |-null
		bst.put(150, 150);  // | | -null
		bst.put(120, 120);  // | -6
		bst.put(125, 125);  // | |-4
		bst.put(141, 141);  // | | |-null
		bst.put(155, 155);  // | | -5
		bst.put(110, 110);
		bst.put(121, 121);// | | |-null
						// | | -null
						// | -null
						// -8
						// |-null
					    // -null
		System.out.println(bst.printKeysInOrder());
		bst.delete(125);
		System.out.println(bst.printKeysInOrder());

    }

}