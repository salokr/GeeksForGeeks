/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 */

/*                                                                      TASK DESCRIPTION
Online algorithm for checking palindrome in a stream
Given a stream of characters (characters are received one by one), write a function that prints ‘Yes’ if a character makes the complete string palindrome, else prints ‘No’.

Examples:

Input: str[] = "abcba"
Output: a Yes   // "a" is palindrome
        b No    // "ab" is not palindrome
        c No    // "abc" is not palindrome
        b No    // "abcb" is not palindrome
        a Yes   // "abcba" is palindrome

Input: str[] = "aabaacaabaa"
Output:  a Yes   // "a" is palindrome
         a Yes   // "aa" is palindrome
         b No    // "aab" is not palindrome 
         a No    // "aaba" is not palindrome  
         a Yes   // "aabaa" is palindrome  
         c No    // "aabaac" is not palindrome  
         a No    // "aabaaca" is not palindrome  
         a No    // "aabaacaa" is not palindrome  
         b No    // "aabaacaab" is not palindrome  
         a No    // "aabaacaaba" is not palindrome  
         a Yes   // "aabaacaabaa" is palindrome  
*/
public class OnlineAlgorithmForCheckingPalindromeInaStream 
{
    public static void checkPalindrome(String a)
    {
        System.out.println("Yeas");
        if(a.length()==1)
            return;
        int first=a.charAt(0);
        int second=a.charAt(1);
        for(int i=1;i<a.length();i++)
        {
            if(first==second)
            {
                boolean flag=true;
                for(int j=0;j<i/2;j++)
                {
                    if(a.charAt(j)!=a.charAt(i-j))
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag)System.out.println("Yeas");
            }
             else System.out.println("No");
            if(i<a.length()-1)
            {
                if(i%2==1)
                {
                    second+=a.charAt((i+1))-a.charAt((i+1)/2);
                }
                else
                {
                    first+=a.charAt(i/2);
                    second+=a.charAt(i+1);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        checkPalindrome("aabaacaabaa");
    }
}
