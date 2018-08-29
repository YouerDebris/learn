#include<cstdio>

class Carpet
{
    public:
        int left,right,bottom,top;
        Carpet();
        Carpet(int a,int b,int c,int d);
        bool isIn(int l,int r)
        {
            if(l>=left&&l<=right&&r>=bottom&&r<=top) return true;
            else return false;
        }
};

Carpet::Carpet(){}
Carpet::Carpet(int a,int b,int c,int d):left(a),bottom(b),right(left+c),top(bottom+d){};

int main()
{
    int len;
    scanf("%d",&len);
    Carpet car[len];
    for(int i = 0;i<len;i++){
        int x,y,xl,yl;
        scanf("%d%d%d%d",&x,&y,&xl,&yl);
        car[i] = Carpet(x,y,xl,yl);
    }
    int a,b;
    scanf("%d%d",&a,&b);
    for(int i = len-1;i>=0;i--) if(car[i].isIn(a,b))
    {
        printf("%d",i+1);
        return 0;
    }
    printf("-1");
    return 0;
}