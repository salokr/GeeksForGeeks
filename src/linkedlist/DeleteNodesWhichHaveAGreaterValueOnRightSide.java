/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ashutosh
 */
public class DeleteNodesWhichHaveAGreaterValueOnRightSide 
{
    
    static void compute(Linked_List l)
    {
        Stack<Node> stk=new Stack<>();
        if(l.head==null)
            return;
        stk.push(l.head);
        Node start=l.head.next;
        while(start!=null)
        {
            int currentdata=start.data;
            while(!stk.isEmpty()&&currentdata>stk.peek().data)
                stk.pop();
            if(stk.isEmpty())
                l.head=start;
            else
                stk.peek().next=start;
            stk.push(start);
            start=start.next;
        }
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(30);
        compute(ll);
        ll.printNodes();
    }
}
