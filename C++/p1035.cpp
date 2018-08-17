#include<cstdio>
int main(){
    int d,a=3;
    scanf("%d",&d);
    for(double s=1.5;s<=d;++a)
        s+=1.0/a;
    printf("%d",a-1);
    return 0;
}