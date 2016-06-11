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
public class SpiralMatrix 
{
    public static void printSpiral(int a[][])
    {
        int n=a.length;
        for(int layer=0;layer<n/2;layer++)
        {
            for(int i=layer;i<n-layer-1;i++)
                System.out.print(a[layer][i]+" ");
            for(int j=layer;j<n-layer-1;j++)
                System.out.print(a[j][n-layer-1]+" ");
            for(int k=n-layer-1;k>0;k--)
                System.out.print(a[(n-layer-1)][k]+" ");
            for(int l=n-layer-1;l>0;l--)
                System.out.print(a[l][layer]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=4;
            int a[][]=new int[n][n]; 
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=sc.nextInt();
            printSpiral(a);
            t--;
        }
    }
}
