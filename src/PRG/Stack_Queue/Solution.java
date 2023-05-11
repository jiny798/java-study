package PRG.Stack_Queue;

import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String frag = s.substring(i,i+1);
            if(frag.equals("(")){
                stack.push("(");
            }else{
                if(stack.size()==0){
                    return false;
                }
                frag = stack.pop();
            }
        }
        if(stack.size()>0){return false;}
        return answer;
    }
}
