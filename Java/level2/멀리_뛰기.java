class Solution {
    public long solution(int N) {
        int[] dp=new int[2001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        
        return dp[N];
    }
}