class Solution {
    static int N;
    static int count;
    public long solution(int n) {
        N=n;
        // 1로 시작
        // 2로 시작
        func(1);
        func(2);
        
        // 반복마다 1, 2를 고르면서, 합산값이 n이라면 count++ 하고 종료
        return count;
    }
    static void func(int x){
        if(x>N){
            return;
        }
        
        if(x==N){
            count++;
            return;
        }
        
        func(x+1);
        func(x+2);
    }
}