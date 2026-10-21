import java.util.*;

class Solution {
    static int count=50000*240;
    static int peopleLength;
    static int limit;
    static int[] people;
    static boolean[] visited;

    public int solution(int[] p, int l) {
        peopleLength=p.length;
        people=p; // 몸무게 배열
        limit=l; // 무게 제한
        visited=new boolean[peopleLength];
        perm(0, 0, 0);
        return count;
    }
    
    static void perm(int depth, int weight, int boatCount){
        if(depth>=peopleLength){
            count=Math.min(count, depth);
            return;
        }
        
        for(int i=0;i<peopleLength;i++){
            if(!visited[i]){
                visited[i]=true;
                if((weight+people[i])>=limit){
                    perm(depth+1, 0, boatCount+1);
                }else{
                    perm(depth+1, weight+people[i], boatCount);
                }
                visited[i]=false;
            }
        }
    }
}