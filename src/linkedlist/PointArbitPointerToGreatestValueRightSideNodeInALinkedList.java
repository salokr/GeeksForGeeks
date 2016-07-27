/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;

/**
 *
 * @author ashutosh
 */
public class PointArbitPointerToGreatestValueRightSideNodeInALinkedList
{
    public static void printWithArbit(Arbit node)
    {
        if(node==null)
            return;
        System.out.print(node.data+"\t\t");
        if(node.next==null)
            System.out.print("NULL\t\t");
        else System.out.print(node.next.data+"\t\t");
        if(node.arbit==null)
            System.out.print("NULL\t\t");
        else System.out.println(node.arbit.data);
        printWithArbit(node.next);
    }
    public static Arbit pointToArbit(Arbit node)
    {
        if(node==null||node.next==null)
            return node;
        Arbit largest=pointToArbit(node.next);
        node.arbit=largest;
        if(largest!=null&&node.data<largest.data)
            return largest;
        return node;
    }
    public static void main(String[] args)
    {
        LinkedList<Arbit> list=new LinkedList();
        Arbit five=new Arbit(1);
        Arbit ten=new Arbit(2);
        Arbit two=new Arbit(3);
        Arbit three=new Arbit(4);
        five.next=ten;ten.next=two;two.next=three;
        pointToArbit(five);
        System.out.println("Node\t\tNext\t\tArbit");
        printWithArbit(five);
    }
}
class Arbit
{
    Arbit arbit,next;
    int data;
    public Arbit(int data)
    {
        this.data=data;
        next=null;
        arbit=null;
    }
}