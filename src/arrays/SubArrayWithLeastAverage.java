/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 * Given An Array Of Size n and an Integer k, where k<=n, find Subarray of size k with least average in O(1) space and O(n) time 
 */
public class SubArrayWithLeastAverage 
{
    public static void findSubArray(int a[],int k)//Sliding Window Approach
    {
        int sum=0,minsum,startindex=0;
        for(int i=0;i<k;i++)
            sum+=a[i];
        minsum=sum;
        for(int i=k;i<a.length;i++)
        {
            sum+=a[i]-a[i-k];
            if(sum<minsum)
            {
                minsum=sum;
                startindex=i-k+1;
            }
        }
        System.out.println(startindex+" "+(startindex-1+k));
    }
    public static void main(String arsg[])
    {
        int a[]={3,7,90,20,10,50,40};
        int b[]={3,7,5,20,-10,0,12};
        findSubArray(a, 3);
        findSubArray(b, 2);
    }
}
