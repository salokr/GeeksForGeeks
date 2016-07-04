
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
public class Test_gfg 
{
    public static int getMin(int a,int b)
    {
        return a<b?a:b;
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
                jmps[i+j]=getMin(jmps[i+j], jmps[i]+1);
            }
        }
        return jmps[jmps.length-1];
    }
    
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
                    a[i]=sc.nextInt();
	        int result=byDP(a);
	        /*if(result==Integer.MAX_VALUE)
	        System.out.println("-1");
	        else */System.out.println(result);
	        t--;
	    }
	}    
}
