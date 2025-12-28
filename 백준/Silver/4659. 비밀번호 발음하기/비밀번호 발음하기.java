import java.io.*;
import java.util.*;

public class Main {
    static char[] momAlphas = {'a', 'e', 'i', 'o', 'u'};
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            int len = input.length();
            
            if(input.equals("end")) {
                return;
            }
            
            boolean isPossible = true;    
            
            // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            boolean flag = false;
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < 5; j++) {
                    if(input.charAt(i) == momAlphas[j]) {
                        flag = true;
                    }                    
                }
            }
            
            if(!flag) {
                isPossible = false;
            }
        
            // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if(len >= 3) {
                for(int i = 0; i < len - 2; i++) {
                    boolean prevMom = false;
                    
                    for (int j = 0; j < 5; j++) {
                        if(input.charAt(i) == momAlphas[j]) {
                            prevMom = true;
                        }
                    }

                    int count = 0;
                    
                    for(int j = i + 1; j < i + 3; j++) {
                        boolean curMom = false;
                        
                        for(int k = 0; k < 5; k++) {
                            if(input.charAt(j) == momAlphas[k]) {
                                curMom = true;
                                break;
                            }
                        }
                        
                        if(curMom && prevMom) {
                            count++;
                        } else if (!curMom && !prevMom) {
                            count++;
                        }
                    }
                    
                    if(count == 2) {
                        isPossible = false;
                    }
                }   
            }
        
            // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
            if(len >= 2) {
                 for(int i = 0; i < len - 1; i++) {
                     if(input.charAt(i) == input.charAt(i + 1)) {
                         if(input.charAt(i) != 'e' && input.charAt(i) != 'o'){
                             isPossible = false;                             
                         }
                     }
                 }   
            }
            
            if(isPossible) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }            
        }
    }
}