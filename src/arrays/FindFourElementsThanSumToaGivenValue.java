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
/*
Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)
Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5 7 8″ (3 + 5 + 7 + 8 = 23).

Sources: Find Specific Sum and Amazon Interview Question
*/
public class FindFourElementsThanSumToaGivenValue
{
    public static boolean isDifferent(My_Data d1,My_Data d2)
    {
        int i1=d1.first,i2=d2.first,j1=d1.second,j2=d2.second;
        return !(i1==j1||i1==j2||i2==j1||i2==j2);
    }
    public static void findQuadruple(int a[],int k)
    {
        int n=a.length;
        My_Data pairsum[]=new arrays.My_Data[(n*(n-1))/2];
        Arrays.sort(a);
        int index=0;
        for(int i=0;i<a.length;i++)
            for(int j=i+1;j<a.length;j++)
                pairsum[index++]=new My_Data(i, j, a[i]+a[j]);
        int l=0,r=pairsum.length-1;    
        while(l<r)
        {
            //System.out.println(l+" "+r);
            if(pairsum[l].sum+pairsum[r].sum==k&&isDifferent(pairsum[l],pairsum[r]))
            {
                System.out.println("Quadruples Are At Index: "+a[pairsum[l].first]+" "+a[pairsum[l].second]+" "+a[pairsum[r].first]+" "+a[pairsum[r].second]);
                return;
            }
            else if(pairsum[l].sum+pairsum[r].sum<=k)
                l++;
            else 
                r--;
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 20, 30, 40, 1, 2};
        findQuadruple(arr, 91);
    }
}
class My_Data
{
    int first;
    int second;
    int sum;
    public My_Data(int first,int second,int sum)
    {
        this.first=first;
        this.second=second;
        this.sum=sum;
    }
    public String toString()
    {
        return first+" "+second;
    }
    
}