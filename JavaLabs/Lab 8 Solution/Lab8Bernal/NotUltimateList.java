package base;

import java.util.ArrayList;

public class NotUltimateList {
    ArrayList<Node> list = new ArrayList<>();
    Node root;

    public NotUltimateList() {
        this.root = null;
    }

    public void add(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            System.out.println("Value " + value + " has been added.");
        } else {
            Node tempNode = this.root;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = new Node(value);
            System.out.println("Value " + value + " has been added.");
        }
    }


  
    public void delete(int value) {
        if (this.root == null) {
            System.out.println("The root hasn't been set yet. The value isn't in the list.");
        } else {
            Node tempNode = this.root;
            while (tempNode.nextNode.value != value || tempNode.nextNode == null) {
                tempNode = tempNode.nextNode;
            }
            if (tempNode.nextNode.nextNode != null) {
                tempNode.nextNode = tempNode.nextNode.nextNode;
            } else {
                tempNode.nextNode = null;
            }
            System.out.println("The value " + value + " has been deleted successfully.");
        }
    }

    public void sort() {
        boolean notSwapped = false;
        Node tempNode;

        while (!notSwapped) {
            Integer listLen = this.length();
            notSwapped = true;
            tempNode = this.root;
            Node lastNode = null;

            for (int index = 0; index < listLen; index++){
                if (tempNode.nextNode != null && tempNode.value > tempNode.nextNode.value) {
                    tempNode = swap(tempNode);
                    if (index == 0) {
                        this.root = tempNode;
                    } else {
                        lastNode.nextNode = tempNode;
                    }
                    lastNode = tempNode;
                    tempNode = tempNode.nextNode;
                    notSwapped = false;
                }
            }
        }
    }

    public Integer length() {
        Integer length = 0;
        if (this.root != null) {
            Node tempNode = this.root;
            length++;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                length++;
            }
        }
        return length;
    }

    public Node swap(Node root) {
        Node temp = root;
        Node tempNextNode = root.nextNode.nextNode;
        root = root.nextNode;
        root.nextNode = temp;
        if (tempNextNode != null) {
            root.nextNode.nextNode = tempNextNode;
        } else {
            root.nextNode.nextNode = null;
        }
        return root;

    }

    public void printList() {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        if (this.root != null) {
            Node tempNode = this.root;
            while (tempNode.nextNode != null) {
                tempArr.add(tempNode.value);
                tempNode = tempNode.nextNode;
            }
            tempArr.add(tempNode.value);
        }
        System.out.println(tempArr);
    }

}
