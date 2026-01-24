// number : 1463
// description : 1로 만들기
// date : 2024.04.30

#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int n;
    int dp[1000001];

    cin >> n;

    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    for(int i = 4; i <= n; i++){
        dp[i] = dp[i-1] + 1;
        if(i % 2 == 0) dp[i] = min(dp[i], dp[i/2] + 1);
        if(i % 3 == 0) dp[i] = min(dp[i], dp[i/3] + 1);
    }

    cout << dp[n] << '\n';

    return 0;
}