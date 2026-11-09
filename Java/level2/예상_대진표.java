class Solution
{
    public int solution(int n, int a, int b)
    {
        int count=0;
        while(a!=b){ // 동일하면, 같은 라운드
            a=(a/2)+(a%2);
            b=(b/2)+(b%2);
            // System.out.printf("%d %d\n", A,B);
            count++;
        }
        // 순서 정하는 식: 몫/2+몫%2

        return count;
    }
}