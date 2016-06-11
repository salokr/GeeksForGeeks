/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.*;
/**
 *
 * @author ashutosh
 */

/*
                                                        TASK DECRIPTION
Check if a given array contains duplicate elements within k distance from each other
Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
*/
public class CheckIfaGivenArrayContainsDuplicateElementsWithinkDistanceFromEachOther 
{
    public static void checkWhateverGiven/*:p :p :D*/(int a[],int k)
    {
        System.out.println(Arrays.toString(a));
        HashSet<Integer> donek=new HashSet<>();
        for(int i=0;i<k;i++)
        {
            if(donek.contains(a[i]))
            {
                System.out.println(a[i]+" Repeated");
                return;
            }
            else
            donek.add(a[i]);
        }
        for(int i=k;i<a.length;i++)
        {
            if(donek.contains(a[i]))
            {
                System.out.println(a[i]+" Repeated");
                return;
            }
            donek.remove(a[i-k]);
            donek.add(a[i]);
        }
        System.out.println("Everything's Safe");
    }
    public static void main(String[] args)
    {
        int k = 3, arr[] = {1, 2, 3, 4, 4};
        checkWhateverGiven(arr, k);
        int k1 = 3, arr1[] = {1, 2, 3, 4, 5};
        checkWhateverGiven(arr1, k1);
        int k2 = 3, arr2[] = {1, 2, 3, 1, 4, 5};
        checkWhateverGiven(arr2, k2);
        int k3 = 3, arr3[] = {1, 2, 3, 4, 1, 2, 3, 4};
        checkWhateverGiven(arr3, k3);
    }
}
