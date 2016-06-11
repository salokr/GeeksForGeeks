/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import sun.misc.Queue;

/**
 *
 * @author ashutosh
 */
public class TopologicalSort 
{
    public static void main(String[] args)
    {
        int a[][]={
                  {0,0,1,1,0},
                  {1,0,0,1,0},
                  {0,0,0,0,1},
                  {0,0,1,0,1},
                  {0,0,0,0,0}
                  };
        topologicalSort(a, getInDegrees(a));
    }
    public static int[] getInDegrees(int a[][])
    {
        int indegs[]=new int[a.length];
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            count=0;
            for(int j=0;j<a.length;j++)
                if(a[j][i]==1)
                    count++;
            indegs[i]=count;
        }
        /*for(int i=0;i<a.length;i++)
            System.out.print(indegs[i]+" ");*/
        return indegs;
    }
    public static void topologicalSort(int a[][],int indegrees[])
    {
        try
        {
        Queue<Integer> q=new Queue<>();
        for(int i=0;i<indegrees.length;i++)
            if(indegrees[i]==0)
                q.enqueue(i);
        while(!q.isEmpty())
        {
            int currentvertex=q.dequeue();
            System.out.print((char)('a'+currentvertex)+"\t");
            for(int col=0;col<a.length;col++)
            {
                if(a[currentvertex][col]!=0)
                {
                    indegrees[col]--;
                    if(indegrees[col]==0)
                          q.enqueue(col);
                }
            }
            
        }
        }
        catch(Exception e){System.out.println(e);}
    }
}
