package base;

public class Main {
    public static void main(String[] args) {

		removeNode mytree = new removeNode();

    mytree.addNode(8, "Bears");
                
		mytree.addNode(10, "Seahawks");
                
    mytree.addNode(15, "Giants");

		mytree.addNode(25, "Redskins");
                
    mytree.addNode(40, "Titans");

		mytree.addNode(50, "Eagles");

		mytree.addNode(52, "Vikings");

		mytree.addNode(65, "Ravens");
                
    mytree.addNode(80, "Chiefs");

		mytree.addNode(85, "Chargers");
                
    mytree.addNode(95, "Bills");

                //remove desired element
		mytree.remove(40);
                
                //yields null from searching removed element 
		System.out.println(mytree.findNode(40));
             
               //find desired element
		System.out.println(mytree.findNode(52));
               
                //creates tree
		mytree.inOrderTraverseTree(mytree.root);

		System.out.println("Maximal element: " + mytree.findMax(mytree.root));
		System.out.println("Minimum element: " + mytree.findMin(mytree.root));

		System.out.println("Tree height: " + mytree.maxHeight(mytree.root));

	}
}
