import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Long, Integer> hm=new HashMap<>();
        for(long tgr : tangerine){
            if(hm.containsKey(tgr)){
                int val=hm.get(tgr);
                hm.put(tgr, val+1);
            }else{
                hm.put(tgr, 1);
            }
            
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer i1, Integer i2){
                    return Integer.compare(i2, i1);
                }
            }
        );
        
        for(Long key : hm.keySet()){
            pq.offer(hm.get(key));
        }

        long sum=0L; // 귤 개수
        int count=0; // 귤 종류
        while(!pq.isEmpty()){
            sum+=pq.poll();
            count++;   
            if(sum>=k){
                break;
            }
        }
        return count;
    }
}