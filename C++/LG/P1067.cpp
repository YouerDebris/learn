#include<cstdio>
#include<string>
#include<iostream>
using namespace std;

string dig(int coe,int ind){
  if(coe == 0) return "";
  string s;
  if(coe==1);
  else if(coe==-1) s = "-";
  else s = to_string(coe);
  if(ind<=0) s = to_string(coe);
  else if(ind==1) s+="x";
  else s+="x^"+to_string(ind);
  if(coe>0) return "+"+s;
  else return s;
}

int main()
{
  int lim;
  scanf("%d",&lim);
  string s = "";
  for(;lim>=0;lim--)
  {
    int a;
    scanf("%d",&a);
    s+=dig(a,lim);
  }
  if(s[0]=='+') cout<<string(s,1);
  else cout<<s;
  return 0;
}