class Solution {
    int[] arr=new int[100001];
    public int solution(int n) {
        if(n==0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        
        if(arr[n]!=0){
            return arr[n]%1234567;
        }
        arr[n]=solution(n-1)+solution(n-2);
        return arr[n]%1234567;
    }
}