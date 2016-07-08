/* 
 * File:   newmain.cpp
 * Author: ashutosh
 *
 * Created on July 6, 2016, 2:28 PM
 */

#include <iostream>
#include<set>
using namespace std;

/*
 * 
 */
int main__() {
	std::set<int> s;
    int t,i,n,m,x;
    cin>>t;
    while(t>0)
    {
        cin>>n;cin>>m;
        for(i=0;i<n;i++)
        {
            cin>>x;
            s.insert(x);
        }
        
        for(i=0;i<m;i++)
        {
            cin>>x;
            s.insert(x);
        }
        while(!s.empty())
        {
            std::cout<< *s.begin()<<' ';
            s.erase(s.begin());
        }
        cout<<"\n";
            t--;
    }
    return 0;
}