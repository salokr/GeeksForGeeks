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
/*
Add two numbers represented by linked lists | Set 1
Given two numbers represented by two lists, write a function that returns sum list. 
The sum list is list representation of addition of two input numbers.
Example 1
Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613
*/
public class AddTwoNumbersRepresentedByLinkedLists
{
    public static void add(Linked_List num1,Linked_List num2)
    {
        Linked_List answer=new Linked_List();
        int carry=0;
        Node digit1=num1.head,digit2=num2.head;
        while(digit1!=null&&digit2!=null)
        {
            int sum=digit1.data+digit2.data+carry;
            carry=sum/10;
            answer.addAtEnd(sum%10);
            digit1=digit1.next;
            digit2=digit2.next;
        }
        while(digit1!=null)
        {
            int sum=digit1.data+carry;
            answer.addAtEnd(sum%10);
            carry=sum/10;
            digit1=digit1.next;
        }
        while(digit2!=null)
        {
            int sum=digit2.data+carry;
            answer.addAtEnd(sum%10);
            carry=sum/10;
            digit2=digit2.next;
        }
        if(carry!=0)
            answer.addAtEnd(carry);
        Util.printReverse(num1.head);
        System.out.println();
        Util.printReverse(num2.head);
        System.out.println();
        Util.printReverse(answer.head);
        System.out.println();
    }
    public static void main(String[] arhs)
    {
        Linked_List num1=new Linked_List();
        Linked_List num2=new Linked_List();
        num1.addAtEnd(5);num1.addAtEnd(6);num1.addAtEnd(3);
        num2.addAtEnd(8);num2.addAtEnd(4);num2.addAtEnd(2);
        add(num1,num2);
        num1.addAtEnd(9);num1.addAtEnd(7);
        add(num1,num2);
        num2.addAtEnd(9);num2.addAtEnd(7);num2.addAtEnd(9);num2.addAtEnd(7);
        add(num1,num2);
    }
}
