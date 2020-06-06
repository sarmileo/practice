package ImplementStackUsingQueue;

// Simple stack implementation using Deque

import java.util.*;

public class MyStack 
{
    int size;
    Deque<Integer> dq;

    /** Initialize your data structure here. */
    public MyStack() 
    {
        dq = new ArrayDeque<>();
        size = dq.size();
    }
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
        dq.offerFirst(x);
        size = dq.size();
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        int x = 0;
        
        if(!empty())
        {
            x = dq.pollFirst();
            size = dq.size();
        }
        
        return x;
    }
    
    /** Get the top element. */
    public int top() 
    {
        int x = 0;
        
        if(!empty())
        {
            x = dq.peekFirst();
        }
        
        return x;        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return size == 0;        
    }

    public void print()
    {
        System.out.println("MyStack : " + dq);
    }

    public static void main(String[] args) 
    {
        MyStack stack = new MyStack();
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
