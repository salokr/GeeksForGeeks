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
/*
    Find the element that appears once
Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.
Example:
Input:  ar[] = {7, 3, 5, 4, 5, 3, 4};
Output: 7 
*/
public class FindtheElementThatAppearsOnce 
{
    //Can use hashing too
    public static void findPoint(int a[])
    {
        int xor=a[0];
        for(int i=1;i<a.length;i++)
            xor^=a[i];
        System.out.println(xor);
    }
    public static void main(String[] args)
    {
        int ar[] = {7, 3, 5, 4, 5, 3, 4};
        findPoint(ar);
    }
}
