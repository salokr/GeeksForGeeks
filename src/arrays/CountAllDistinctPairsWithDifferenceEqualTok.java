/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
/*
Count all distinct pairs with difference equal to k
Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.

Examples:

Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
Output: 5
There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, 
{8, 12}, {12, 16} and {16, 20} 
*/

/*
Count all distinct pairs with difference equal to k
Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.

Examples:

Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
Output: 5
There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, 
{8, 12}, {12, 16} and {16, 20} 
Method 1 (Simple) 
A simple solution is to consider all pairs one by one and check difference between every pair. Following program implements the simple solution. We run two loops: the outer loop picks the first element of pair, the inner loop looks for the other element. This solution doesn’t work if there are duplicates in array as the requirement is to count only distinct pairs.


Method 2 (Use Sorting)
We can find the count in O(nLogn) time using a O(nLogn) sorting algorithm like Merge Sort, Heap Sort, etc. Following are the detailed steps.

1) Initialize count as 0
2) Sort all numbers in increasing order.
3) Remove duplicates from array.
4) Do following for each element arr[i]
   a) Binary Search for arr[i] + k in subarray from i+1 to n-1.
   b) If arr[i] + k found, increment count. 
5) Return count. 



Method 3 (Use Self-balancing BST)
We can also a self-balancing BST like AVL tree or Red Black tree to solve this problem. Following is detailed algorithm.

1) Initialize count as 0.
2) Insert all elements of arr[] in an AVL tree. While inserting, 
   ignore an element if already present in AVL tree.
3) Do following for each element arr[i].
   a) Search for arr[i] + k in AVL tree, if found then increment count.
   b) Search for arr[i] - k in AVL tree, if found then increment count.
   c) Remove arr[i] from AVL tree. 
Time complexity of above solution is also O(nLogn) as search and delete operations take O(Logn) time for a self-balancing binary search tree.

Method 5 (Use Sorting)

Sort the array arr
Take two pointers, l and r, both pointing to 1st element
Take the difference arr[r] – arr[l]
If value diff is K, increment count and move both pointers to next element
if value diff > k, move l to next element
if value diff < k, move r to next element
return count



*/
public class CountAllDistinctPairsWithDifferenceEqualTok 
{
    public static void countPairs(int[] a,int k)
    {
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:a)
                set.add(i);
        Object keys[]=set.toArray();
        for(Object o:keys)
            System.out.print((int)o+" ");
        System.out.println();
        for(int i=0;i<keys.length;i++)
        {
            int current=(int)keys[i];
            if(set.contains(current+k))//MERGE BOTH CONDITIONS TO ONE IF ONLY COUNT REQUIRED
            {
                //System.out.print(current+" "+(current+k)+" ");
                count++;
            }
            if(set.contains(current-k))//MERGE BOTH CONDITIONS TO ONE IF ONLY COUNT REQUIRED
                //System.out.print((current-k)+" "+current+" ");
                count++;
            set.remove(current);
        }
        System.out.println(count);
    }

        public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        repeatAllowed(a,k);
                //bruteForce(a, k);
	        t--;
	    }
	    
	
    }
    public static void repeatAllowed(int a[],int k)
    {
        int count=0;
        Hashtable<Integer,Integer> table=new Hashtable<>();
        for(int i:a)
        {
            if(!table.containsKey(i))
                table.put(i,0);
            int freq=table.get(i);
            table.remove(i);
            table.put(i, freq+1);
        }
        Object keys[]=table.keySet().toArray();
        for(int i=0;i<keys.length;i++)
        {
            //System.out.println(keys[i]+" "+table.get(keys[i]));
            int current=(int)keys[i];
            if(table.containsKey(current+k))//MERGE BOTH CONDITIONS TO ONE IF ONLY COUNT REQUIRED
            {
                //System.out.print(current+" "+(current+k)+" ");
                int freq1=table.get(current);
                int freq2=table.get(current+k);
                count+=freq1*freq2;
            }
            if(table.containsKey(current-k)){
                //System.out.print((current-k)+" "+current+" ");
                int freq1=table.get(current);
                int freq2=table.get(current-k);
                count+=freq1*freq2;}
            table.remove(current);
        }
        System.out.println(count);
    }
}
/*

 int count = 0;
     
    // Pick all elements one by one
    for (int i = 0; i < n; i++)
    {       
        // See if there is a pair of this picked element
        for (int j = i+1; j < n; j++)
            if (arr[i] - arr[j] == k || arr[j] - arr[i] == k )
                  count++;
    }
*/