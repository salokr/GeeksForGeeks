/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
//                                  COUNT TRIPLETS WITH SUM SMALLER THAN GIVEN VALUE 'K'

/*
Count triplets with sum smaller than a given value
Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 4
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)


*/

public class TripletsWithSumSmallerThanK 
{
    //Approach One: Sort the Array use Two Pointers (modified) with one fixed point, O(n^2) approach
    //Approach Two: Use Brute Force O(n^3) approach
    public static void findContinuosTriplets(int a[],int k)
    {
        //sort and increase right index till sum is less than k for triplets once we reach a point crossing k we are done
        Arrays.sort(a);
        int sum=a[0]+a[1]+a[2],count=0;
        for(int i=3;sum<k&&i<a.length;i++)
        {
            if(sum<k)
                count++;
            sum+=a[i]-a[i-3];
        }
        System.out.println("Continuos Count: "+count);
    }
    public static void findTriplets(int a[],int k)
    {
        /*                                                           (GEEKS SOLUTION)
        Idea is to pick up an index(current) , iterate all index next to it (call it l) and then putting a third index( call it r) at last position
        in array, then till the sum is greater than k we should decrease r, once the point is reached where we have sum less than k , just subtract index values
        since the array is sorted all previous will give the desired result 
        */
        int n=a.length,count=0;
        for(int i=0;i<n-2;i++)
        {
            int current=a[i];
            int l=i+1,r=n-1;
            while(l<r)
            {
                if(current+a[l]+a[r]>=k)
                {
                    //if current configuration gives us more or equal value than k, then we need to decrease r, since r has larger values
                    //can do binary search also as optimization but not good.
                    r--;
                }
                else
                {
                    //else if we have found correct values of l and r then surely any thing in between l and r gives us the sum less than k
                    count+=r-l;//not plus onee since we are considering only third element
                    //since we are done for this index of l time to increase l value
                    l++;//r will not get updated? because for previous configuration only r was increasing so now l++, will result in bigger l...
                    //only so we need to decrese r instead which will be taken care by if condition of this loop
                }
            }
        }
        System.out.println("Count: "+count);
    }
    public static void main(String[] aregs)
    {
        int a[]={5,1,3,4,7};
        findContinuosTriplets(a, 12);
        findTriplets(a, 12);
    }
}
