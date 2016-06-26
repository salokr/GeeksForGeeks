/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Hashtable;

/**
 *
 * @author ashutosh
 */
/*
Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. 
Expected time complexity is O(n).
Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4
*/
public class LargestSubarrayWithEqualNumberof0sAnd1s 
{
    public static void findSubArray(int a[])
    {
        Hashtable<Integer,Integer> table=new Hashtable<>();
        int sum=0,maxsubaray=Integer.MIN_VALUE,currsize=0;
        int val;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
                val=-1;
            else val=1;
            sum+=val;
            if(sum==0)
                currsize=i+1;
            else if(table.containsKey(sum))
            {
                currsize=i-table.get(sum);
            }
            else table.put(sum,i);
            if(currsize>maxsubaray)
                maxsubaray=currsize;
        }
        if(maxsubaray!=0)
        System.out.println("Max Sub-Array Size Found: "+maxsubaray);
        else
            System.out.println("No Such Sub-Array");
    }
    public static void main(String[] args)
    {
        int arr[] =  {1, 0, 0, 1, 0, 1, 1};
        int arr1[] = {1, 0, 1, 1, 1, 0, 0};
        int arr2[] = {1, 1, 1, 1};
        int arr3[] = {0, 0, 1, 1, 0};
        findSubArray(arr);
        findSubArray(arr1);
        findSubArray(arr2);
        findSubArray(arr3);
    }
}
/*
                                                            GEEKS SOLUTION(Different Approach)
Method 2 (Tricky)
Following is a solution that uses O(n) extra space and solves the problem in O(n) time complexity.
Let input array be arr[] of size n and maxsize be the size of output subarray.
1) Consider all 0 values as -1. The problem now reduces to find out the maximum length subarray with sum = 0.
2) Create a temporary array sumleft[] of size n. Store the sum of all elements from arr[0] to arr[i] in sumleft[i]. This can be done in O(n) time.
3) There are two cases, the output subarray may start from 0th index or may start from some other index. We will return the max of the values obtained by two cases.
4) To find the maximum length subarray starting from 0th index, scan the sumleft[] and find the maximum i where sumleft[i] = 0.
5) Now, we need to find the subarray where subarray sum is 0 and start index is not 0. This problem is equivalent to finding two indexes i & j in sumleft[] such that sumleft[i] = sumleft[j] and j-i is maximum. To solve this, we can create a hash table with size = max-min+1 where min is the minimum value in the sumleft[] and max is the maximum value in the sumleft[]. The idea is to hash the leftmost occurrences of all different values in sumleft[]. The size of hash is chosen as max-min+1 because there can be these many different possible values in sumleft[]. Initialize all values in hash as -1
6) To fill and use hash[], traverse sumleft[] from 0 to n-1. If a value is not present in hash[], then store its index in hash. If the value is present, then calculate the difference of current index of sumleft[] and previously stored value in hash[]. If this difference is more than maxsize, then update the maxsize.
7) To handle corner cases (all 1s and all 0s), we initialize maxsize as -1. If the maxsize remains -1, then print there is no such subarray.


*/