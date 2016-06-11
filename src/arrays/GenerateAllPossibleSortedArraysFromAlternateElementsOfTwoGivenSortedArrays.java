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
public class GenerateAllPossibleSortedArraysFromAlternateElementsOfTwoGivenSortedArrays 
{
    public static void generateArrays(int a[],int b[],int currB,int currA,boolean fromA,int op[],int currop)
    {
        
    }
    public static void main(String[] args)
    {
        int a[]={10,15,25};
        int b[]={1,5,20,30};
        int c[]=new int[a.length+b.length];
        generateArrays(a, b, 0, 0, true, c, 0);
    }
}
