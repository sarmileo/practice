package ImplementStackUsingQueue;

import java.util.*;

/** Simple Stack implementation using One Queue */

public class QueueStack 
{
    int top;
    int size;
    Queue<Integer> q1;    

    /** Initialize your data structure here. */
    public QueueStack() {
        q1 = new LinkedList<>();
        top = 0;
        size = q1.size();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(empty())
        {
            q1.add(x);
        }
        else
        {
            // moves elements in the queue until x is the head of the queue
            q1.add(x);
            int moves = q1.size() - 1;
        
            while (moves >= 1)
            {
                int head = q1.poll();
                q1.add(head);

                moves--;
            }
        }    
        
        top = q1.peek();
        size = q1.size();
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int head = 0;
        
        if(!empty())
        {
            head = q1.poll();
            size = q1.size();
            
            if (!empty())
                top = q1.peek();  
        }
        
        return head;
    }
    
    /** Get the top element. */
    public int top() {
        return top;        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;       
    }

    /** Print Stack. */
    public void print()
    {
        System.out.println("QueueStack : " + q1);
    }

    public static void main(String[] args) 
    {
        QueueStack stack = new QueueStack();
        stack.push(1);
        stack.push(2);

        stack.print();

        int x = stack.pop();
        System.out.println("pop() : " + x);

        int y = stack.top();
        System.out.println("top() : " + y);

        boolean check = stack.empty();
        System.out.println("empty() : " + check);

        stack.print();      
        
        System.out.println("pop() : " + stack.pop());
        System.out.println("empty() : " + stack.empty());
        stack.print();  
    }
}