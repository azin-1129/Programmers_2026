import java.util.*;

class Solution {
    static int[] arr;
    public int solution(int[] a) {
        arr=a;
        
        if(a.length==1){
            return a[0];
        }
        
        return LCM(a[0], a[1], 1);
    }
    static int LCM(int x, int y, int depth){
        // 내림차순으로 약수를 중복없이 정렬해둠
        TreeSet<Integer> divs=new TreeSet<>(Comparator.reverseOrder());
        // 최대공약수
        int maxDiv=0;
        // 두 수의 곱
        int multi=x*y;
        // 두 수의 약수 구하기
        for(int i=1;i<=Math.sqrt(x);i++){
            if(x%i==0){
                divs.add(i);
                divs.add(x/i);
            }
        }
        for(int i=1;i<=Math.sqrt(y);i++){
            if(y%i==0){
                divs.add(i);
                divs.add(y/i);
            }
        }
        
        // ts 순회하면서 두 수를 나누는 제일 큰 약수 구하기
        for(int div : divs){
            int count=0;
            
            if(x%div==0){
                count++;
            }
            if(y%div==0){
                count++;
            }
            
            if(count==2){
                maxDiv=div;
                break;
            }
        }
        
        int lcm = multi/maxDiv;
        if(depth==arr.length-1){
            return lcm;
        }
        return LCM(lcm, arr[depth+1], depth+1);
    }
}