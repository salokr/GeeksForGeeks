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
Check if a linked list of strings forms a palindrome
Given a linked list handling string data, check to see whether data is palindrome or not?
For example,

Input  : a -> bc -> d -> dcb -> a -> NULL
Output : True
String "abcddcba" is palindrome.

Output : a -> bc -> d -> ba -> NULL
Output : False
String "abcdba" is not palindrome. 
*/
public class CheckIfALinkedListOfStringsFormsAPalindrome 
{
    public static boolean isPalindrome(String str)
    {
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length/2;i++)
        {
            if(arr[i]!=arr[str.length()-i-1])
                return false;
        }
        return true;
    }
    public static void checkList(Linked_List ll)
    {
        StringBuilder buff=new StringBuilder();
        Node temp=ll.head;
        while(temp!=null)
        {
            buff.append(temp.data);
            temp=temp.next;
        }
        if(isPalindrome(buff.toString()))
            System.out.println("Palindrome");
        else
            System.out.println("Not-Palindrome");
    }
    public static void main(String[] args)
    {
        Linked_List ll=new Linked_List();
        checkList(ll);
        ll.addAtEnd(1);
        checkList(ll);
        ll.addAtEnd(1);
        checkList(ll);
        ll.addAtEnd(0);
        checkList(ll);
        ll.addAtEnd(1);
        checkList(ll);
        ll.addAtEnd(1);
        checkList(ll);
    }
}
