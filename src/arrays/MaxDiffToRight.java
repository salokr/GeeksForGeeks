/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
public class MaxDiffToRight 
{
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
	        int min=a[0];int diff=Integer.MIN_VALUE,maxsofar=Integer.MIN_VALUE;
                for(int i=1;i<n;i++)
                {
                    if(a[i]<min)
                    {
                        min=a[i];
                        maxsofar=Integer.MIN_VALUE;
                        continue;
                    }
                    if(a[i]>maxsofar)
                        maxsofar=a[i];
                    int currdiff=maxsofar-min;
                    if(currdiff>diff)
                        diff=currdiff;
                }
                System.out.println(diff);
                bruteForce(a);
	        t--;
	    }
	}
    //49 130 124 85 455 257 341 467 377 432 309 445 440 127 324 38 39 119 83 430 42 334 116 140 159 205 431 478 307 174 387 22 246 425 73 271 330 278 74 98 13 487 291 162 137 356 268 156 75 32 53 351 151 442 225 467 431 108 192 8 338 458 288 254 384 446 410 210 259 222 89 423 447 7 31 414 169 401 92 263 156 411 360 125 38 49 484 96 42 103 351 292 337 375  
//13 487 291 162 137 356 268 156 75 32 53 351 151 442 225 467 431 108 192 8 338 458 288 254 384 446 410 210 259 222 89 423 447 7 31 414 169 401 92 263 156 411 360 125 38 49 484 96 42 103 351 292 337 375
    public static void bruteForce(int a[])
    {
        int max=Integer.MIN_VALUE;
        int pos1=-1,pos2=-1;
        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                int diff=a[j]-a[i];
                if(diff>max)
                {
                    max=diff;
                    pos1=i;
                    pos2=j;
                }
            }
        }
        //System.out.println(a[pos1]+" "+a[pos2]);
    }
}
