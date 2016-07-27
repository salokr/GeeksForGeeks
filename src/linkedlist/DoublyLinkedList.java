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
public class DoublyLinkedList
{
    DoublyNode head;
    void addAtLast(int data)
    {
        DoublyNode node=new DoublyNode(data);
        if(head==null)
        {
            head=node;
            return;
        }
        DoublyNode temp=head;
        while(temp.right!=null)
            temp=temp.right;
        temp.right=node;
        node.left=temp;
    }
    public void printList()
    {
        DoublyNode temp=head;
        while(temp.right!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.right;
        }
    }
}
class DoublyNode
{
    int data;
    DoublyNode left,right;
    public DoublyNode(int data)
    {
        this.data=data;
        left=right=null;
    }
}
