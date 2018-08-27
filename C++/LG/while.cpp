#include <iostream>
#include <set>

using namespace std;

bool isTrue(int a[]){
    //use set's feature determine if the number is repeated
    set<int> s;
    for(int i = 0;i<3;i++){
        for(int c = 0;c<3;c++)
        {
        int d = a[c]%10;
        if(d == 0) return false;
        s.insert(d);
        a[c]/=10;
        }
    }
    return s.size() == 9;
}

int main()
{
    for(int h = 1;h<4;h++)
        for(int t = 1;t<10;t++)
            for(int s = 2;s<10;s++)
            {
                int a = h*100+t*10+s;
                int list[] = {a,a*2,a*3};
                if(isTrue(list)){
                    cout<<a<<" "<<a*2<<" "<<a*3<<endl;
                }
            }
    return 0;
}