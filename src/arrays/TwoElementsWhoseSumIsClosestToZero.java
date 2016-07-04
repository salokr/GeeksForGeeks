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
Two elements whose sum is closest to zero
Question: An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
*/

/*IDEA IS TO SORT ARRAY AND CALCULATE THE CURRENT SUM OF LEFT AND RIGHT INDICES
ACCORDING TO CURRENT VALUE OF SUM WE NEED TO MOVE LEFT AND RIGHT INDICES
FOR EXP IF WE HAVE SITUATION LIKE (SUM)   0   I.E. SUM IS LESS THAN 0 THEN OBVIOUSLY TO MOVE CLOSER TO ZERO WE NEED TO MOVE LEFT INDEX
OTHERWISE IF WE HAVE SITUATIO LIKE 0    (SUM) I.E. SUM IS GT 0 THEN NEED TO DECREASE RIGHT INDEX 
*/
public class TwoElementsWhoseSumIsClosestToZero
{
    public static void findElements(int a[])
    {
        Arrays.sort(a);
        int l=0,r=a.length-1;
        int mindis=Integer.MAX_VALUE,left=-1,right=-1;
        while(l<r)
        {
            int currsum=(a[l]+a[r]);
            if(Math.abs(currsum)<mindis)
            {
                mindis=Math.abs(currsum);
                left=l;right=r;
            }
            if(currsum>=0)
                r--;
            else l++;
        }
        System.out.println(mindis+" "+a[left]+" "+a[right]);
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 60, -10, 70, -80, 85};
        findElements(arr);
    }
}
