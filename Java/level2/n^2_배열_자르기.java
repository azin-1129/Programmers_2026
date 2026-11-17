import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // n * n 배열 생성
        int[][] arr=new int[n][n];
        // for i=1; i<=n; i++
        // 1행1열~i행i열에 i
        for(int k=n-1;k>=0;k--){
            for(int i=k;i>=0;i--){
                for(int j=k;j>=0;j--){
                    arr[i][j]=k+1; 
                }
            }   
        }
        // i가 3일때 j가 3 2 1
        // for(int[] a:arr){
        //     System.out.println(Arrays.toString(a));
        // }
        // 걍 배열에서 인덱싱하면안됨?
        // arr[left/n][left%n]~arr[right/n][right%n]
        int startX=(int)(left/n);
        int startY=(int)(left%n);
        int endX=(int)(right/n);
        int endY=(int)(right%n);
        
        // System.out.printf("시작점: %d %d, 끝점: %d %d \n",startX,startY,endX,endY);
        
        // [sX][sY]부터 [eX][eY]까지 추려야 하는데..
        // x는 startX부터 시작하고, endX까지 진행.
        // y는 startY부터 시작하되, n을 넘어서면 x++, y=0.
        int[] answer=new int[(int)(right-left)+1];
        int idx=0;
        int x=startX;
        int y=startY;
        while(idx<answer.length){
            // System.out.println("x:"+x+", y:"+y);
            // System.out.println(((endX-x)+(endY-y))+"번 인덱스에 값을 부여한다.");
            answer[idx]=arr[x][y];
            y++;
            if(y==n){
                x++;
                y=0;
            }
            idx++;
        }

        // 배열 붙이는 데 StringBuilder나 Array를 사용할 경우, 최대 길이가 Integer.MAX_VALUE라서 사용 불가능
        
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}