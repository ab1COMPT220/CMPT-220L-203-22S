package base;
import java.util.LinkedList;
import java.util.Queue;


public class removeNode {

//This portion allows new nodes to be added to search tree 
	Node root;
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftWing;
					if (focusNode == null) {
						parent.leftWing = newNode;
						return; 
					}                           
				} else { 
					focusNode = focusNode.rightWing;
					if (focusNode == null) {
						parent.rightWing = newNode;
						return; 
					}
				}
			}
		}
	}

//this portion provides the function to remove desired node from tree
        public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		boolean leftWingCheck = true;
		while (focusNode.key != key) {
			parent = focusNode;
			if (key < focusNode.key) {
				leftWingCheck = true;
				focusNode = focusNode.leftWing;
			} else {
				leftWingCheck = false;
				focusNode = focusNode.rightWing;
			}
			if (focusNode == null)
				return false;
		}
		if (focusNode.leftWing == null && focusNode.rightWing == null) {
			if (focusNode == root)
				root = null;
			else if (leftWingCheck)
				parent.leftWing = null;
			else
				parent.rightWing = null;
		}
		else if (focusNode.rightWing == null) {
			if (focusNode == root)
				root = focusNode.leftWing;
			else if (leftWingCheck)
				parent.leftWing = focusNode.leftWing;
			else
				parent.rightWing = focusNode.leftWing;
		}
		else if (focusNode.leftWing == null) {
			if (focusNode == root)
				root = focusNode.rightWing;
			else if (leftWingCheck)
				parent.leftWing = focusNode.rightWing;
			else
				parent.rightWing = focusNode.rightWing;
		}
               return true; 
	}
//first traversing method for program to look through tree
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			
                        System.out.println(focusNode);
                        preorderTraverseTree(focusNode.leftWing);
			preorderTraverseTree(focusNode.rightWing);
		}
	}
//second traversing method for program to look through tree
	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
                        System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftWing);
			preorderTraverseTree(focusNode.rightWing);
		}
	}
//third traversing method for program to look through tree
	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {

			preorderTraverseTree(focusNode.leftWing);
			preorderTraverseTree(focusNode.rightWing);
			System.out.println(focusNode);
		}
	}
//find desired node function
	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftWing;
			} else {
				focusNode = focusNode.rightWing;
			}
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}
    
		public int findMax(Node node)
		{
			if (node == null)
				return Integer.MIN_VALUE;
	
			int res = node.key;
			int lres = findMax(node.leftWing);
			int rres = findMax(node.rightWing);
			if (lres > res)
				res = lres;
			if (rres > res)
				res = rres;
			return res;
		}
		public int findMin(Node node)
    {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.key;
        int lres = findMin(node.leftWing);
        int rres = findMin(node.rightWing);
        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }
	int maxHeight(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lHeight = maxHeight(node.leftWing);
            int rHeight = maxHeight(node.rightWing);
            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }
    //advanced tree search methods    
	static void breadthSearch(Node node){
		Queue<Node> q = new LinkedList<>();
		q.add(node);

        while (!q.isEmpty()) {
            node = q.remove();
            System.out.print(" " + node.key);

            if (node.leftWing != null){
                q.add(node.leftWing);
			}
            if (node.rightWing != null){
                q.add(node.rightWing);
			}
		}
	}
	static void depthSearch(Node node){
		if (node == null)
		{
			return;
		}
		System.out.println(node.key);
		depthSearch(node.leftWing);
		depthSearch(node.rightWing);
	}
//provides node class       
public class Node {
    int key;
	String name;
	Node leftWing;
	Node rightWing;
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

    @Override
	public String toString() {
		return name + " assigned element is " + key;

	}
}


}
