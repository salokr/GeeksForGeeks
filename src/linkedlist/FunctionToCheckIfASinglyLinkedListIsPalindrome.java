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
public class FunctionToCheckIfASinglyLinkedListIsPalindrome
{
    static Node left;
    public static boolean isPalindrome(Node right)
    {
        if(right==null)
            return true;
        boolean result=isPalindrome(right.next);
        if(!result)
            return false;//if at any point we get mismatch return FALSE
        result=right.data==left.data;
        left=left.next;
        return result;
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        char [] str={'a','b','a','c','c','a','b','a'};
        for(char c:str)
            ll.addAtEnd(c);
        left=ll.head;
        System.out.println("Is Linked List Palindrome: "+isPalindrome(ll.head));
    }
}
