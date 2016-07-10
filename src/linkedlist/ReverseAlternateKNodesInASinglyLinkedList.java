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
public class ReverseAlternateKNodesInASinglyLinkedList
{
    public static Node reverse(Node head,int k)
    {
        Node start=head,end=head,next=null,prev=null;
        int num=k;
        while(start!=null&&k>0)
        {
            k--;
            next=start.next;
            start.next=prev;
            prev=start;
            start=next;
        }
        if(end!=null)
            end.next=start;
        k=num;
        while(start!=null&&k>1)
        {
            k--;
            start=start.next;
        }
       end=start;
        if(end!=null)
            end.next=reverse(end.next, num);
        
        return prev;
    }
    public static void main(String[] ags)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        Node result=reverse(ll.head,3);
        Util.printFromNode(result);
    }
}
