/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author ashutosh
 */
public class Linked_List
{
    Node head;
    public int lengthOfLinkedList()
    {
        Node start=head;
        int count=0;
        while(start!=null)
        {
            start=start.next;
            count++;
        }
        return count;
    }
    public int recursiveLength(Node current)
    {
        if(current==null)
            return 0;
        return 1+recursiveLength(current.next);
    }
    public boolean isPresent(int key)
    {
        Node start=head;
        while(start!=null)
        {
            if(start.data==key)
                return true;
            start=start.next;
        }
        return false;
    }
    public boolean recursiveIsPresent(Node current,int key)
    {
        if(current==null)
            return false;
        if(current.data==key)
            return true;
        return recursiveIsPresent(current.next, key);
    }
    public void addAtEnd(int x)
    {
        Node n=new Node(x);
        if(head==null)
        {
            head=n;
            return;
        }
        Node start=head;
        while(start.next!=null)
            start=start.next;
        start.next=n;
    }
    public void addAtFront(int x)
    {
        Node n=new Node(x);
        if(head==null)
        {
            head=n;
            return;
        }
        n.next=head;
        head=n;
    }
    public void addAfterNode(int x,Node n)
    {
        Node newnode=new Node(x);
        newnode.next=n.next;
        n.next=newnode;
    }
    public void deleteKey(int key)
    {
        Node start=head,parent=null;
        while(start!=null&&start.data!=key)
        {
            parent=start;
            start=start.next;
        }
        if(start==null)
        {
            System.out.println("Key Not Found");
            return;
        }
        if(parent==null)
        {
            head=null;
            return;
        }
        parent.next=start.next;
    }
    public void delAtPosition(int pos)
    {
        Node parent=null,start=head;
        while(start!=null&&pos>1)
        {
            parent=start;
            start=start.next;
            pos--;
        }
        //either pos is at zero and we are at aur destination or pos is non-zero reflecting the fact that linked list was too
        //small or the parent is null i.e. we have to delete head of node
    if(pos!=1)
    {
        System.out.println("Linked List Is too Small ");
        return;
    }
    if(parent==null)//we are deleting head node
    {
        head=head.next;
        return;
    }
    parent.next=start.next;
    }
    public Node getHead()
    {
        return head;
    }
    public void printNodes()
    {
        Node current=head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public void addRandomN(int n)
    {
        for(int i=1;i<=n;i++)
            addAtEnd((int)(Math.random()*100));
        printNodes();
    }
    public void addSortedN(int n)
    {
        int start=(int)(Math.random()*100);
        for(int i=1;i<=n;i++)
            addAtEnd(start+i);
        printNodes();
    }
    public void addRandomN(int n,int range)//if range is too low it will add too much repetitions otherwise same as above
    {
        for(int i=1;i<=n;i++)
            addAtEnd((int)(Math.random()*range));
        printNodes();
    }
    public void addRepeatNSortedN(int n)//may add sorted calues too
    {
        int start=(int)(Math.random()*100);
        for(int i=1;i<=n;i++)
        {
            int repeat=(int)(Math.random()*2);
            addAtEnd(start+i*repeat);
            start+=i*repeat;
        }
        printNodes();
    }
    public void mergeNode(Node listhead)
    {
        Node start=head;
        while(start.next!=null)
            start=start.next;
        start.next=listhead;
    }
    public int getCountOfX(int x)
    {
        Node start=head;
        int count=0;
        while(start!=null)
        {
            if(start.data==x)
                count++;
            start=start.next;
        }
        return count;
    }
}

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
        next=null;
    }
}
