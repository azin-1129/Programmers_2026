import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length()==1){ // 한개의 괄호는 회전할 필요 없음
            return 0;
        }
        // s번 큐를 회전해서 스택으로 올바른 string인지 파악
        // 회전한 String 만드는 데에는 StringBuffer 사용
        StringBuffer sb=new StringBuffer(s);
        
        int count=0;
        for(int i=0;i<s.length();i++){
            boolean flag=true;
            // String 회전
            sb.insert(0, sb.charAt(sb.length()-1));
            sb.deleteCharAt(sb.length()-1);
            // 회전 완료
            String str=sb.toString();
            // System.out.println("회전된 String:"+str);
            
            // 괄호 파악
            // (, [, {인 경우 일단 add. 외에는 peek값과 대조해 pop.
            // ), ], }인 경우, 스택이 비었거나 괄호쌍이 안 맞으면 실패
            Stack<Character> stack=new Stack<>();
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                if(flag==false){
                    break;
                }
                
                switch(c){
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if(stack.empty()){
                            flag=false;
                        }else{
                             if(stack.peek()!='('){
                                flag=false;
                            }else{
                                stack.pop();
                            }   
                        }
                        break;
                    case ']':
                        if(stack.empty()){
                            flag=false;
                        }else{
                             if(stack.peek()!='['){
                                flag=false;
                            }else{
                                stack.pop();
                            }   
                        }
                        break;
                    case '}':
                        if(stack.empty()){
                            flag=false;
                        }else{
                             if(stack.peek()!='{'){
                                flag=false;
                            }else{
                                stack.pop();
                            }   
                        }
                        break;
                }           
            }
            // 처리되지 않은 문자열이 남아있을 경우 flag는 false
            if(stack.empty()){
              if(flag){
                    count++;
                }  
            }
            // System.out.println("flag 값:"+flag);
        }
        return count;
    }
}