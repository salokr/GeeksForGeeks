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
import java.util.*;
import java.lang.*;
import java.io.*;
/*
Sort an array according to the order defined by another array
Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.

Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
The code should handle all cases like number of elements in A2[] may be more or less compared to A1[]. A2[] may have some elements which may not be there in A1[] and vice versa is also possible.

Source: Amazon Interview | Set 110 (On-Campus)

Method 1 (Using Sorting and Binary Search)
Let size of A1[] be m and size of A2[] be n.
1) Create a temporary array temp of size m and copy contents of A1[] to it.
2) Create another array visited[] and initialize all entries in it as false. visited[] is used to mark those elements in temp[] which are copied to A1[].
3) Sort temp[]
4) Initialize the output index ind as 0.
5) Do following for every element of A2[i] in A2[]
…..a) Binary search for all occurrences of A2[i] in temp[], if present then copy all occurrences to A1[ind] and increment ind. Also mark the copied elements visited[]
6) Copy all unvisited elements from temp[] to A1[].

Time complexity: The steps 1 and 2 require O(m) time. Step 3 requires O(mLogm) time. Step 5 requires O(nLogm) time. Therefore overall time complexity is O(m + nLogm).

Thanks to vivek for suggesting this method. Following is C++ implementation of above algorithm.


Method 2 (Using Self-Balancing Binary Search Tree)
We can also use a self balancing BST like AVL Tree, Red Black Tree, etc. Following are detailed steps.
1) Create a self balancing BST of all elements in A1[]. In every node of BST, also keep track of count of occurrences of the key and a bool field visited which is initialized as false for all nodes.
2) Initialize the output index ind as 0.
3) Do following for every element of A2[i] in A2[]
…..a) Search for A2[i] in the BST, if present then copy all occurrences to A1[ind] and increment ind. Also mark the copied elements visited in the BST node.
4) Do an inorder traversal of BST and copy all unvisited keys to A1[].

Time Complexity of this method is same as the previous method. Note that in a self balancing Binary Search Tree, all operations require logm time.

Method 3 (Use Hashing)
1. Loop through A1[], store the count of every number in a HashMap (key: number, value: count of number) .
2. Loop through A2[], check if it is present in HashMap, if so, put in output array that many times and remove the number from HashMap.
3. Sort the rest of the numbers present in HashMap and put in output array.

Thanks to Anurag Sigh for suggesting this method.

The steps 1 and 2 on average take O(m+n) time under the assumption that we have a good hashing function that takes O(1) time for insertion and search on average. The third step takes O(pLogp) time where p is the number of elements remained after considering elements of A2[].

Method 4 (By Writing a Customized Compare Method)
We can also customize compare method of a sorting algorithm to solve the above problem. For example qsort() in C allows us to pass our own customized compare method.
1. If num1 and num2 both are in A2 then number with lower index in A2 will be treated smaller than other.
2. If only one of num1 or num2 present in A2, then that number will be treated smaller than the other which doesn’t present in A2.
3. If both are not in A2, then natural ordering will be taken.

Time complexity of this method is O(mnLogm) if we use a O(nLogn) time complexity sorting algorithm. We can improve time complexity to O(mLogm) by using a Hashing instead of doing linear search.

*/
class RelativeSorting {
    public static void doRelativeSorting(int a[],int b[])
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
        {
            if(!map.containsKey(a[i]))
                map.put(a[i],0);
            int frequency=map.get(a[i]);
            map.remove(a[i]);
            map.put(a[i],frequency+1);
        }
        /*for(int i=0;i<a.length;i++)
            System.out.println(a[i]+" "+map.get(a[i]));*/
        int count=0;
        for(int i=0;i<b.length;i++)
        {
            int current=b[i];
            if(map.containsKey(current))
            {
                int frequency=map.get(current);
                for(int j=0;j<frequency;j++)
                    a[count++]=current;
                map.remove(current);
            }
        }
        //System.out.println(Arrays.toString(a));
        //copy remaining elements
        Object[] remains=map.keySet().toArray();
        for(int i=0;i<remains.length;i++)
        {
            //System.out.println(map.get((int)remains[i])+"< >"+(int)remains[i]);
            int frequency=Integer.parseInt(map.get((int)remains[i])+"");
            for(int j=0;j<frequency;j++)
                a[count++]=(int)remains[i];
            map.remove((int)remains[i]);
        }
        for(int i:a)
            System.out.print(i+" ");
    }
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        int a[]=new int[n];
	        int b[]=new int[m];
	        for(int i=0;i<n;i++)
                    a[i]=sc.nextInt();
	        for(int i=0;i<m;i++)
                    b[i]=sc.nextInt();
                doRelativeSorting(a, b);
                System.out.println();
                t--;
	    }
	    
	}
}