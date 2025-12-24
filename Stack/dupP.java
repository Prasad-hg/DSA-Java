import java.util.*;
public class dupP{
    public static boolean validD(String str){
        Stack<Character>s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                int count = 0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
            
        }
        return false;
    }
    public static void main(String args[]){
        String str1 = "((a+b)+(a-b))";
        String str = "(((a+b)+(a-b)))";
        System.out.println(validD(str));
    }
  
}