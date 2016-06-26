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
Find the smallest positive number missing from an unsorted array
You are given an unsorted array with both positive and negative elements. You have to find the smallest positive number missing from the array in O(n) time using constant extra space. You can modify the original array.

Examples

 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2 
Source: To find the smallest positive no missing from an unsorted array

A naive method to solve this problem is to search all positive integers, starting from 1 in the given array. We may have to search at most n+1 numbers in the given array. So this solution takes O(n^2) in worst case.

We can use sorting to solve it in lesser time complexity. We can sort the array in O(nLogn) time. Once the array is sorted, then all we need to do is a linear scan of the array. So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table of all positive elements in the given array. 
Once the hash table is built. We can look in the hash table for all positive integers, starting from 1. 
As soon as we find a number which is not there in hash table, 
we return it. This approach may take O(n) time on average, but it requires O(n) extra space.
*/
public class FindTheSmallestPositiveNumberMissingFromAnUnsortedArray 
{
    public static void findSmallestMissingPositive(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            int curr=a[i];
            if(curr>0&&curr<a.length)
                a[curr]=Integer.MIN_VALUE;//more intuitive will be to just replace with i only , isn't it
        }
        for(int i=1;i<a.length;i++)
        {
            if(a[i]!=Integer.MIN_VALUE)
            {
                System.out.println("Smallest Missing is  "+i);
                return;
            }
        }
        System.out.println("Smallest Missing is + "+(a.length+1));
    }
    public static void main(String[] args)
    {
        int a[]={2, 3, 7, 6, 8, -1, -10, 15};
        int b[]={ 2, 3, -7, 6, 8, 1, -10, 15 };
        int c[]={1, 1, 0, -1, -2};
        int d[] = {0, 10, 2, -10, -20};
        findSmallestMissingPositive(a);
        findSmallestMissingPositive(b);
        findSmallestMissingPositive(c);
        findSmallestMissingPositive(d);
    }
}
