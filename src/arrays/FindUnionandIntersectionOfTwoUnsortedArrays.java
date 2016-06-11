/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
/*
Find Union and Intersection of two unsorted arrays
Given two unsorted arrays that represent two sets (elements in every array are distinct), find union and intersection of two arrays.

For example, if the input arrays are:
arr1[] = {7, 1, 5, 2, 3, 6}
arr2[] = {3, 8, 6, 20, 7}
Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20} and Intersection as {3, 6}. Note that the elements of union and intersection can be printed in any order.

Method 1 (Naive)
Union: 
1) Initialize union U as empty.
2) Copy all elements of first array to U.
3) Do following for every element x of second array:
…..a) If x is not present in first array, then copy x to U.
4) Return U.
*/


/*
APPROACHES ARE SORT FIRST BOTH ARRAYS O(NLOGN + MLOGM)
1)MERGE ALGORITHM O(M+N)
2)HASHING 0(M+N)

*/

public class FindUnionandIntersectionOfTwoUnsortedArrays 
{    
/*
third approach sort the smaller array O(nlogn) for each x in larger array do binary search in smaller one O(mlogn) (assuming m>n)    
*/
    public static void findIntersection(int a[],int b[])
    {
        ArrayList<Integer> intersection=new ArrayList<>();
        int n1=a.length,n2=b.length,smaller[],larger[];
        if(n1>n2)
        {
            smaller=b;
            larger=a;
        }
        else
        {
            smaller=a;
            larger=b;
        }
        Arrays.sort(smaller);
        //System.out.println(Arrays.toString(smaller));
        //System.out.println(Arrays.toString(larger));
        for(int i=0;i<larger.length;i++)
        {
            if(doBinarySearch(smaller, 0, smaller.length-1, larger[i]))
                intersection.add(larger[i]);
        }
        System.out.print(intersection);
    }
    public static boolean doBinarySearch(int a[],int begin,int end,int key)
    {
        //System.out.println(Arrays.toString(a)+key);
        if(begin>end)
            return false;
        int mid=(begin+end)/2;
        if(a[mid]==key)
            return true;
        else if(a[mid]>key)
            return doBinarySearch(a, begin, mid-1, key);
        else return doBinarySearch(a, mid+1, end, key);
    }
    public static void main(String[] args)
    {
        int arr1[] = { 7,1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        System.out.println("intersection Of Two Arrays Is : ");
        findIntersection(arr1, arr2);
    }
}
