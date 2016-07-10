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
public class ReverseALinkedListInGroupsOfGivenSize
{
    public static Node reverseKNodes(Node head,int k)
    {
        if(head==null)
            return null;
        int num=k;
        Node end=head,start=head,prev=null,next=start.next;
        while(start!=null&&k>0)
        {
            k--;
            start.next=prev;
            prev=start;
            start=next;
            if(start!=null)
            next=start.next;
        }
        end.next=reverseKNodes(start, num);
        return prev;
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        ll.addRandomN(10);
        Node result=reverseKNodes(ll.head, 3);
        Util.printFromNode(result);
    }
}
