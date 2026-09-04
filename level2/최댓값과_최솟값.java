import java.util.*;

class Solution {
    public String solution(String s) {
        List<Integer> list=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        String min=Integer.toString(list.get(0));
        String max=Integer.toString(list.get(list.size()-1));
        
        String answer = min+" "+max;
        return answer;
    }
}