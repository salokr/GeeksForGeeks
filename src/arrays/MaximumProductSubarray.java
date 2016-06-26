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
Maximum Product Subarray
Given an array that contains both positive and negative integers, find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.

Examples:

Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
*/

/*                                                GEEKS SOLUTION
whole solution is based upon the fact that you have to keep track of max positive and max negative product
at last the answer would be obviously max positive product.
if you are currently visiting a positive element then maxpositive would be last max positive * current
and max negative till now will be min  of 1 and current*mintillnow
if currently negative element is visited then max positive will be last maxof  (max-ve * current and 1)
and max negaive will be updated to last max positive * current.
remmeber if negative is mulitiplied negative we will get positive at that time and thus maxpositive will change
and maxnegative should be only current, this is done as 
when current product becomes negtive the maxpositive will be 1, now when again you see negative the temp is maxpositive (which is one)and 
maxpositive is last negative * curreent negative and thus current negative value.

*/
public class MaximumProductSubarray 
{
    public static int getMax(int a,int b)
    {
        return a>b?a:b;
    }
    public static int getMin(int a,int b)
    {
        return a>b?b:a;
    }
    public static void findMaxProduct(int a[])
    {
        int maxproduct=Integer.MIN_VALUE;
        int maxpositive=1,maxnegative=1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                maxpositive=maxnegative=1;
            }
            else if(a[i]>0)
            {
                maxpositive*=a[i];
                maxnegative=getMin(1,maxnegative*a[i]);
            }
            else
            {
                //decide max negative here till now and maxpositive here till now
                int temp=maxpositive;
                maxpositive=getMax(maxnegative*a[i],1);
                maxnegative=temp*a[i];
            }
            maxproduct=getMax(maxpositive,getMax(maxnegative,maxproduct));
        } 
        System.out.println(maxproduct);
    }
    public static void main(String[] args)
    {
        int a[]={6,-3,-10,0,2};
        int b[]={-1,-3,-10,0,60};
        int c[]={-2,-3,0,-2,-40};
        int d[]={-8,5,3,1,6};
        int e[]={3 ,-7 ,-9, 2, -7, 5 ,-4 ,-8};
        findMaxProduct(a);
        findMaxProduct(b);
        findMaxProduct(c);
        findMaxProduct(d);
        findMaxProduct(e);
    }
    
}
