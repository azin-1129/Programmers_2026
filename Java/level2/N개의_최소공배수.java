import java.util.*;

class Solution {
    public int solution(int[] arr) {
        TreeSet<Integer> divs=new TreeSet<>(Comparator.reverseOrder());
        // 최대공약수
        int maxDiv=0;
        // 모든 수의 곱
        int multi=1;
        // 각 arr 원소의 약수 구하기
        for(int num : arr){
            multi*=num;
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    divs.add(i);
                    divs.add(num/i);
                }
            }
        }

        // ts 순회하면서 모든 수를 나누는 제일 큰 약수 구하기
        for(int div : divs){
            int count=0;
            for(int num : arr){
                if(num%div==0){
                    count++;
                }
            }
            if(count==arr.length){
                maxDiv=div;
                break;
            }
        }
        
        // arr의 모든 원소 곱한 후, 최대 공약수로 나누기
        System.out.println(multi+" "+maxDiv);
        int answer = multi/maxDiv;
        return answer;
    }
}