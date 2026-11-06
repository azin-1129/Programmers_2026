import java.util.*;

class Solution {
    static int N, extendedLength;
    static int[] arr;
    static HashSet<Integer> hs;
    public static void main(String[] args) throws Exception{
        solution(new int[]{7, 9, 1, 1, 4});
    }
    public static int solution(int[] elements) {
        hs=new HashSet<>();
        N=elements.length;
        // 슬라이딩 너비-1만큼 끝에 0, 1, 2 ... 순으로 붙여주고 슬라이딩 윈도우나 투포인터 하면될듯
        for(int i=1;i<=N;i++){
            extendedLength=N+(i-1);
            arr=new int[extendedLength];
            for(int j=0;j<N;j++){
                arr[j]=elements[j];
            }
            for(int k=N;k<extendedLength;k++){
                arr[k]=elements[k-N];
            }
            
            // System.out.println("덧붙인 배열:"+Arrays.toString(arr));
            slide(i);
        }
        
        // left와 right 간격을 size만큼 두고, right가 N 미만일 때까지만 진행

        // for(int h : hs){
        //     System.out.print(h+" ");
        // }
        return hs.size();
    }
    static void slide(int size){
        // System.out.println("size:"+size);
        int left=0;
        int right=(left+size)-1;
        
        while(right<extendedLength){
            // System.out.println("L:"+left+", R:"+right);
            int sum=0;
            for(int i=left;i<=right;i++){
                sum+=arr[i];
            }
            hs.add(sum);
            left++;
            right++;
        }
    }
}