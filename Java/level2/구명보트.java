import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int count=0;

        // 50 70 80
        while(left<right){
            int sum=people[left]+people[right]; // 2명 탑승
            if(sum<=limit){
                count++;
                left++;
                right--;
            }else{ // 작은 친구랑 같이 탈 수 없음. 혼자 타는 애는 return 시 계산
                // 여기서 count++해도 left=right가 같은 경우가 씹힘
                right--;
            }
        }
        
        // 1명이 타는 보트 수 + 2명이 타는 보트 수
        return people.length-count;
    }
}