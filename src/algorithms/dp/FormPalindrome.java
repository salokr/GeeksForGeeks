/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dp;

/**
 *
 * @author ashutosh
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class FormPalindrome {
    public static int formPalindrome(String a,int begin,int end,int[] count)
    {
        if(begin==end)
            return 0;
        if(a.charAt(begin)==a.charAt(end))
        {
            if(begin==end-1)
                return 0;
            return formPalindrome(a,begin+1,end-1,count);
        }
        else
        {
            int atLeft=formPalindrome(a,begin,end-1,count);
            int atRight=formPalindrome(a,begin+1,end,count);
            return 1+(atLeft<atRight?atLeft:atRight);
        }
    }
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        String x=sc.next();
                int count[]=new int[x.length()];
                count[0]=0;count[1]=0;
	        System.out.println(formPalindrome(x,0,x.length()-1,count));
	        t--;
	    }
	    
	}
}