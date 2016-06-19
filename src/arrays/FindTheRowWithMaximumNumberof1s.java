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
Find the row with maximum number of 1s
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example
Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0
Output: 2
*/
public class FindTheRowWithMaximumNumberof1s 
{
public static int getIndexOfFirstOne(int a[],int start,int end)//do Binary Search to find the index
{
    if(a[start]==1)
        return start;
    if(a[end]==0)
        return Integer.MAX_VALUE;
    int mid=(start+end)/2;
    if(a[mid]==1&&a[mid-1]==0)
        return mid;
    else if(a[mid]==0)
        return getIndexOfFirstOne(a, mid+1, end);
    else return getIndexOfFirstOne(a, start, mid-1);
}
public static int findRow(int a[][])
{
    int rowsize=a[0].length-1;
    int row=0;
    int left=getIndexOfFirstOne(a[0], 0, rowsize);
    for(int i=1;i<a.length;i++)
    {
        int firstone=getIndexOfFirstOne(a[i],0,rowsize);//GEEKS IDEA : instead of doing binary search what we can do is to set left as left most one
        //and then if next row is having less left most index then start decreementing left till zero occur else continue to next row
        // this way complexity will be O(m+n) imlemented method is less efficient by the way.
        //System.out.println(firstone);
        if(firstone>left)
            continue;
        left=firstone;
        row=i;
    }
    return row;
}
public static void main(String[] args)
{
    int mat[][] = { {0, 0, 0, 1},
                    {0, 1, 1, 1},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0}
                  };
    System.out.println(findRow(mat));
}
}
