package arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
/*
Minimum number of jumps to reach end
Given an array of integers where each element represents the max number of steps that can be made forward from that element.
Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then cannot move through that element.
Example:
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
*/
public class MinimumNumberOfJumpsToReachEnd 
{
    //SIMPLE RECURSIVE APPROACH
    public static int getMinSteps(int a[],int current)
    {
        if(a[current]==0)
            return Integer.MAX_VALUE;// not possible to go further
        if(current==a.length-1)
            return 0;//reached solution from here no need to go anywhere
        int ai=a[current];
        int minsteps=Integer.MAX_VALUE;
        for(int i=1;i<=ai&&i+current<a.length;i++)
        {
            int newcurr=current+i;
            int jumps=getMinSteps(a,newcurr);
            if(jumps!=Integer.MAX_VALUE)
            {
                if(jumps+1<minsteps)//1 is used because wherever you jump, jump cost is one
                    minsteps=jumps+1;//since jump is costs ONE only
            }
        }
        return minsteps;//REMEMBER: JUMP COST IS ONLY ONE
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        //System.out.println(getMinSteps(arr,0));
        int arr2[] = {1, 3, 6, 1, 0, 9};
        //System.out.println(getMinSteps(arr2,0));
        //System.out.println(byDP(arr));
        //System.out.println(byDP(arr2));
        int arr3[]={1 ,3 ,5 ,8 ,9 ,2 ,6 ,7 ,6 ,8, 9};
        //System.out.println(getMinSteps(arr3, 0));
        System.out.println(byDP(arr3));
    }
    public static int byDP(int a[])
    {
        if(a[0]==0||a.length==0)
            return Integer.MAX_VALUE;
        int jmps[]=new int[a.length];
        for(int i=0;i<jmps.length;i++)
            jmps[i]=Integer.MAX_VALUE;
        jmps[0]=0;
        /*Easy Solution is to first reach at current i, then see each jump costs only one
          and  let a[i]=3,then till 3 steps this value can have its effect so at jmps[i+1] jmps[i+2] jmps[i+3] put min of (old values
          at those indices AND entry at jmps[i]+1 jmps[i+2] jmps[i+3] respectively)
        */
        for(int i=0;i<a.length;i++)
        {
            int currentjmps=a[i];
            if(currentjmps==0)
                continue;
            for(int j=1;j<=currentjmps&&j+i<a.length;j++)
            {
                jmps[i+j]=Integer.min(jmps[i+j], jmps[i]+1);
            }
        }
        return jmps[jmps.length-1];
    }
}
