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
Equilibrium index of an array
Equilibrium index of an array is an index such that the sum of elements at lower indexes 
is equal to the sum of elements at higher indexes. For example, in an array A:

A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0

3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

6 is also an equilibrium index, because sum of zero elements is zero, i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0

7 is not an equilibrium index, because it is not a valid index of array A.

Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n, 
returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.
*/
public class EquilibriumIndexOfAnArray
{
    public static void findEquillibriumIndex(int a[])
    {
        boolean found=false;
        int sum=0;
        for(int i:a)
            sum+=i;
        int prefixsum=0;
        for(int i=0;i<a.length;i++)
        {
            sum-=a[i];
            if(sum==prefixsum)
            {
                System.out.println("Found Eqb Index At : "+i);
                found=true;
            }
            prefixsum+=a[i];
        }
        if(!found)
            System.out.println("-1");
    }
    public static void main(String[] args)
    {
        int a[]={-7,1,5,2,-4,3,0};
        findEquillibriumIndex(a);
    }
}
