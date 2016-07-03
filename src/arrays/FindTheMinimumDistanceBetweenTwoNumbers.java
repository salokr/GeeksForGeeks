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
Find the minimum distance between two numbers
Given an unsorted array arr[] and two numbers x and y, 
find the minimum distance between x and y in arr[]. 
The array might also contain duplicates. 
You may assume that both x and y are different and present in arr[].
Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.
Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.
Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.
Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
*/
public class FindTheMinimumDistanceBetweenTwoNumbers
{
    public static void findMinDisce(int a[],int x,int y)
    {
        int index=-1,mindisce=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
            if(a[i]==x||a[i]==y)
            {
                index=i;
                break;
            }
        for(int i=index+1;i<a.length;i++)
        {
            if(a[i]==x||a[i]==y)
            {
                if(a[index]==a[i])
                    index=i;
                else
                {
                    int currdis=i-index;
                    if(currdis<mindisce)
                        mindisce=currdis;
                }
            }
        }
        System.out.println(mindisce);
    }
    public static void main(String[] args)
    {
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        findMinDisce(arr, 3, 6);
    }
}
