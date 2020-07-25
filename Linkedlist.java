 
import java.io.*;

public class LinkedList {

    Node head;
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    //Finding element in linked list
    public static void searchNode(LinkedList list, int data) {
        Node current = list.head;
        int i = 1;
        boolean flag = false;
        //Checks whether list is empty
        if(list.head == null) {
            System.out.println("List is empty");
        }
        else {
            while(current != null) {
                //Compares node to be found with each node present in the list
                if(current.data == data) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if(flag)
            System.out.println("Element is present in the list at the position : " +i);
        else
            System.out.println("Element is not present in the list");
    }


    // Inserting elements

    public static LinkedList insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }
    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    // Method to delete a node in the LinkedList by KEY
    public static LinkedList deleteByKey(LinkedList list, int key)
    {
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }

    // Method to delete a node in the LinkedList by POSITION
    public static LinkedList deleteAtPosition(LinkedList list, int index)
    {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");

            return list;
        }
        int counter = 0;

        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                System.out.println(index + " position element deleted");
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }


    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        printList(list);
        deleteByKey(list, 2);
        printList(list);
        deleteByKey(list, 3);
        printList(list);
        deleteByKey(list, 1);
        printList(list);
        deleteAtPosition(list, 1);
        printList(list);
        deleteAtPosition(list, 0);
        printList(list);
        deleteAtPosition(list, 0);
        printList(list);
        searchNode(list,3);
        printList(list);
        searchNode(list,5);
        printList(list);
        searchNode(list,2);
        printList(list);
    }
}
