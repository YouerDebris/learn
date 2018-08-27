#include<iostream>
using namespace std;
int main()
{
    long day,result=0;
    int week;
    cin>>week>>day;
    int s = day-(8-week);
    if((s+1)/7==s/7+1) s++;
    result+=(s-s/7*2)*250;
    if(week!=6&&week!=7)
    {
        if(6-week<day) result+=(6-week)*250;
        else result = day*250;
    }
    if(result<0) result = 0;
    cout<<result;
    return 0;
}
