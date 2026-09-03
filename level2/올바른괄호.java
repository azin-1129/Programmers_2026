import java.util.*;

class Solution {
    boolean solution(String s) {
        // "("가 들어오면 일단 넣어둠
        // ")"을 push하려할 때, peek값이 "("가 아니라면 올바르지 않음
        // 로직이 끝난 후, stack의 size가 0이 아니라면 올바르지 않음
        
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            // System.out.println(i);
            char c=s.charAt(i);
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.size()==0 || stack.peek()!='('){
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        
        if(stack.size()!=0){
            return false;
        }
        
        return true;
    }
}