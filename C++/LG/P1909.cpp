#include<iostream>
#include<cstdio>
using namespace std;

int main()
{
    int need;
    scanf("%d",&need);
    int result = 10000000;
    for(int i=0;i<3;i++)
    {
        int a,b;
        scanf("%d%d",&a,&b);
        int c = need/a;
        if(c*a<need) c++;
        int ans = c*b;
        if(ans<result) result = ans;
    }
    printf("%d\n",result);
    return 0;
}