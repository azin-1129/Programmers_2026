
class Solution {
    public int[] solution(int n, long left, long right) {
        // arr[left/n][left%n]~arr[right/n][right%n]
        int startX=(int)(left/n);
        int startY=(int)(left%n);
        
        // x는 startX부터 시작하고, endX까지 진행.
        // y는 startY부터 시작하되, n을 넘어서면 x++, y=0.
        int[] answer=new int[(int)(right-left)+1];
        int idx=0;
        int x=startX;
        int y=startY;
        while(idx<answer.length){
            answer[idx]=Math.max(x+1, y+1);
            y++;
            if(y==n){
                x++;
                y=0;
            }
            idx++;
        }
        return answer;
    }
}