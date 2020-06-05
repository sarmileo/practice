package ReverseLinkedList;
    
public class LinkedList
{
    public class Node 
    {
        int val;
        Node next;
        Node() {}

        Node(int val)
        {
            this.val = val;
        }

        Node(int val, Node next) 
        { 
            this.val = val; this.next = next; 
        }
    }

    void print(Node head)
    {
        Node node = head;

        if(node == null)
        {
            System.out.println("The List is empty");
        }

        while(node != null)
        {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }    

    public Node reverseList(Node head) 
    {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null)
        {
            next      = curr.next; // save next node
            curr.next = prev;      // invert the link to next node
            prev      = curr;      // advance prev
            curr      = next;      // advance curr      
        }
        
        head = prev; // in the last iteration, prev will have the last node in the list.
        
        return head;        
    }

    public static void main(String[] args) 
    {
        LinkedList myList = new LinkedList();

        Node n5 = myList.new Node(5, null);
        Node n4 = myList.new Node(4, n5);
        Node n3 = myList.new Node(3, n4);
        Node n2 = myList.new Node(2, n3);
        Node n1 = myList.new Node(1, n2);

        Node head = n1;

        // Print head
        System.out.println("head: " + head.val);  
        
        // Print Original List
        myList.print(head);

        Node newHead = myList.reverseList(head);

        System.out.println("\nhead: " + newHead.val + ", (after reversing the List)"); 

        // Print Reversed List
        myList.print(newHead);

        // Print an empty List, The LinkedList class can be updated to include 
        // for example: Node head, AddNode(Node n), isEmpty() .
        Node nullHead = null;
        System.out.println();
        myList.print(nullHead);

    }
}
