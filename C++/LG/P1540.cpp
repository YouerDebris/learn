#include<cstdio>
int m;
bool find(int a[],int need){
  for(int i=0;i<m;i++) if(a[i]==need) return true;
  return false;
}

int main(){
  int n;
  scanf("%d%d",&m,&n);
  int a[m];
  for(int i = 0;i<m;i++) a[i] = -1;
  if(m==0){
    printf("%d",n);
    return 0;
  }
  int r=0,c=0;
  for(int i = 0;i<n;i++){
    int d;
    scanf("%d",&d);
    if(find(a,d)) continue;
    if(c>m-1) c = 0;
    a[c] = d;
    c++;
    r++;
  }
  printf("%d",r);
  return 0;
}