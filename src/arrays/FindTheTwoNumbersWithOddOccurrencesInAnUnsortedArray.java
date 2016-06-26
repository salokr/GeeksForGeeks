/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
/*
Find the two numbers with odd occurrences in an unsorted array
Given an unsorted array that contains even number of occurrences for all numbers except two numbers. 
Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.

Examples:

Input: {12, 23, 34, 12, 12, 23, 12, 45}
Output: 34 and 45

Input: {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100}
Output: 100 and 5000

Input: {10, 20}
Output: 10 and 20
A naive method to solve this problem is to run two nested loops. 
The outer loop picks an element and the inner loop counts the number of occurrences of the picked element. 
If the count of occurrences is odd then print the number. The time complexity of this method is O(n^2).

We can use sorting to get the odd occurring numbers in O(nLogn) time. First sort the numbers using an O(nLogn) sorting algorithm like Merge Sort, Heap Sort.. etc. Once the array is sorted, all we need to do is a linear scan of the array and print the odd occurring number.
*/
public class FindTheTwoNumbersWithOddOccurrencesInAnUnsortedArray 
{
/*
    Besides above methods we can use hashing to store all elements and delete each element if they are present else add them to 
    hash table by this way even occuring will get deleted from hashtable what remains will be the odd occuring element
    this approach solves the problem in O(n) time and space
*/    
    public static void byHashing(int a[])
    {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            if(set.contains(a[i]))
                set.remove(a[i]);
            else
                set.add(a[i]);
        }
        for(Object o:set.toArray())
            System.out.print(o+" ");
        System.out.println();
    }
    /*
                                                            GEEKS SOLUTION
    Do XoR of all elements let variable is xor, the variable at last will contain odd1^odd2, we have to get back both of 'em from this value
    Note: these two elements must be different. Hence they must differ at least at one place in their decimal representation
    Note that position as 'k', now divide the array in two parts one having 0 at k and one having 1 at k
    again do XoR of these two sets with xor at last you will get your results ?
    Why?
    See, set one will have our element odd times and all other elements even times for sure
    Now when we XoR , all even will cancel out and also since var contains one odd, exoring again will make total even times xoring of that our
    one of element
    and at last var will contain only that element which isn't present in this set, same logic will be applied to set 2.
    */
    public static void main(String[] args)
    {
        int a1[]= {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        int a2[]={12, 23, 34, 12, 12, 23, 12, 45};
        byHashing(a2);
        withXoR(a2);
        byHashing(a1);
        withXoR(a1);
    }
    public static void withXoR(int a[])
    {
        int xor=a[0],k;
        for(int i=1;i<a.length;i++)
            xor^=a[i];
        /*Main Task is to get a set bit in xor variable because that will help us divide into two sets*/
        /*
        See the trick here is as following :-
        Take any number say 20->10100, now if we wil take its 2's complement what will happen ? we will have first set bit from right
        as it is and remaining values complemented (simple binary algebra), now when we do "AND" with original element we will get our position.
        In above example 2's complement-> 01100 and thus ,  01100 & 10100 = 00100 thus first set bit is at third position.
        the best way to find 2's complement is to do 1's complement and add 1 to result.
        */
        //xor=20;
        //System.out.println(Integer.toBinaryString(xor)+" "+Integer.toBinaryString(xor&(~(xor)+1))+" "+Integer.toBinaryString((~(xor)+1))+" "+(xor&(~(xor)+1)));
        int x=0,y=0;//since 0 acts as buffer
        int setbit =(xor&(~(xor)+1));
        for(int i=0;i<a.length;i++)
        {
            if((setbit&a[i])==0)
                x=x^a[i];
            else 
                y=y^a[i];
        }
        System.out.println("Odd Ocuuring Elelents Are : "+x+" "+y);
    }
}
