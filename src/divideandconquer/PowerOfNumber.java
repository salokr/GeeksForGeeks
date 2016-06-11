/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divideandconquer;

/**
 *
 * @author ashutosh
 */
public class PowerOfNumber 
{
    double getPower(double x,int y)
    {
        if(y==0)
            return 1;
        double temp=getPower(x,y/2);
        if(y%2==0)
        {
            return temp*temp;
        }
        else
        {
            if(y>0)
            return x*temp*temp;
            else
                return (temp*temp)/x;
        }
        
    }
    public static void main(String[] args)
    {
        System.out.println(new PowerOfNumber().getPower(2,-2));
    }
}
