#include<iostream>
using namespace std;
int main()
{
    double far;
    cin>>far;
    int step = 0;
    for(double f = 2,a=0;a<far;step++){
        a+=f;
        f*=0.98;
    }
    cout<<step;
    return 0;
}