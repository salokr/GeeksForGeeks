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
Construct an array from its pair-sum array
Given a pair-sum array and size of the original array (n), construct the original array.
A pair-sum array for an array is the array that contains sum of all pairs in ordered form. For example pair-sum array 
for arr[] = {6, 8, 3, 4} is {14, 9, 10, 11, 12, 7}.
In general, pair-sum array for arr[0..n-1] is 
{arr[0]+arr[1], arr[0]+arr[2], ……., arr[1]+arr[2], arr[1]+arr[3], ……., arr[2]+arr[3], arr[2]+arr[4], …., arr[n-2]+arr[n-1}.
“Given a pair-sum array, construct the original array.”
*/
public class ConstructAnArrayFromItsPairSumArray 
{
    public static void createArray(int pairs[],int n)
    {
        int a[]=new int[n];
        a[0]=(pairs[0]+pairs[1]-pairs[n-1])/2;
        for(int i=1;i<n;i++)
            a[i]=pairs[i-1]-a[0];
        Util.printArray(a);
    }
    public static void main(String[] arhs)
    {
        int pair[] = {15, 13, 11, 10, 12, 10, 9, 8, 7, 5};
        int n = 5;
        createArray(pair, n);
    }
}
