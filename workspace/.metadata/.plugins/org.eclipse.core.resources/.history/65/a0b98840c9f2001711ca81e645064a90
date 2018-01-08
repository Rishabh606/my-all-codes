#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <vector>
#include <list>
#include <utility>
#include <iterator>
#include <map>
#include <stack>
#include <queue>
#include <set>
#include <deque>
#include <bitset>
#include <complex>
#include <iomanip>
#include <random>

using namespace std;

#define pb push_back
#define f first
#define s second
#define mp make_pair
#define SZ(x) ((int)(x.size()))
#define FOI(i, a, n) for(int i = int(a); i <= int(n); i++)
#define FOD(i, a, n) for(int i = int(a); i >= int(n); i--)
#define IN(x, y) ((y).find(x) != (y).end())
#define sync ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);

typedef long long ll;
typedef long double lf;
typedef pair < ll, ll > ii;

const int NMAX = 1e6+4;
const int MOD = 1e9 + 7;

int a[1005];
ll ways[NMAX];

int main()
{
   sync
   int t;
   cin>>t;
   while(t--)
   {
       int m;
       cin>>m;
       FOI(i,1,m)
       cin>>a[i];
       sort(a+1,a+m+1);
       memset(ways, 0, sizeof(ways));
       int n;
       cin>>n;
       ways[0]=1;
       FOI(i,1,m)
       FOI(j,0,n-a[i])
       {
           ways[j+a[i]]=(ways[j+a[i]]+ways[j])%MOD;
       }
       cout<<ways[n]<<endl;
   }

}
