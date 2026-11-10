import java.util.*;

class Solution {
    // 원하는 템 want, 원하는 수량 number, 할인제품목록 discount
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품과 수량이 할인 날짜와 10일 연속으로 일치할 경우 회원가입
        // 원하는 제품: 바나나3, 사과2, 쌀2, 돼지2, 냄1
        // 세일 순서: 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지, 바나나, 돼지, 쌀, 냄비 바나나, 사과, 바나나
        // 첫째날에 회원가입하면 냄비없어서 안함
        // 둘째날은 바나나가 충분하지 않아서 안함
        // 3,4,5 셋중 하나 회원가입함.
        
        // 원하는 제품을 모두 할인받을 수 있는 가입날짜 총 일수 return
        
        // 슬라이딩 윈도우 아님?
        // idx 이동에 따라 제품 수량 갱신하면서, 원하는 조건과 부합하는지 확인
        // 일단 생겨먹은 게 HashMap 써야될 듯(카운트 전용)
        
        HashMap<String, Integer> wants=new HashMap<>(); // 일단 원하는 정보 매핑
        HashMap<String, Integer> discounts=new HashMap<>(); // 할인 status
        int count=0;
        
        for(int i=0;i<want.length;i++){
            wants.put(want[i], number[i]);
        }

        int left=0;
        int right=9; // 10-1
        
        // 처음 정보 초기화
        for(int i=left;i<=right;i++){
            // containsKey() : 내용물 갱신, 이외 새로 삽입.
            if(discounts.containsKey(discount[i])){
                discounts.put(discount[i], discounts.get(discount[i])+1);
            }else{
                discounts.put(discount[i], 1);
            }
        }
        
        // 가입해도 좋은지 체크(첫째날)
        boolean flag=true;
        for(String key : wants.keySet()){
            if(!discounts.containsKey(key)){
                flag=false;
                break;
            }
            if(wants.get(key)>discounts.get(key)){
                flag=false;
                break;
            }
        }
        if(flag){
            count++;
        }
        
        // 슬라이딩
        while(right<discount.length-1){
            // 이전 정보 제거(왼쪽)
            discounts.put(discount[left], discounts.get(discount[left])-1);
            left++;
            // 새로운 정보 추가(오른쪽)
            right++;
            if(discounts.containsKey(discount[right])){
                discounts.put(discount[right], discounts.get(discount[right])+1);
            }else{
                discounts.put(discount[right], 1);
            }
            
            // 가입해도 좋은 날짜인지 체크
            // wants key 순회하면서, discounts의 값이 wants 원소의 이상인지 판단
            flag=true;
            for(String key : wants.keySet()){
                if(!discounts.containsKey(key)){
                    flag=false;
                    break;
                }
                if(wants.get(key)>discounts.get(key)){
                    flag=false;
                    break;
                }
            }
            
            if(flag){
                count++;
            }
        }
        return count;
    }
}