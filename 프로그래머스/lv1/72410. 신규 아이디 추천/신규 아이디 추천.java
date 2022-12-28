import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String temp="";
        
        for(char c : new_id.toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c) || c=='-' || c=='.' || c=='_') {
                temp+=c;
            }
        }
        new_id = temp;
        
        new_id = new_id.replace("..", ".");
        
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        
        if(new_id.length()>0) {
            if(new_id.charAt(0)=='.') {
                new_id = new_id.substring(1,new_id.length());
            }
        }
        
        if(new_id.length()>0) {
            if(new_id.charAt(new_id.length()-1)=='.') {
                new_id = new_id.substring(0,new_id.length()-1);
            }    
        }
        
        if(new_id.equals("")) {
            new_id="a";
        }
        
        if(new_id.length()>=16) {
            new_id = new_id.substring(0,15);
            
            if(new_id.charAt(new_id.length()-1)=='.') {
                new_id = new_id.substring(0,new_id.length()-1);
            }
            
        }

        if(new_id.length()<=2) {
            if(new_id.length()==1) {
                while(new_id.length()<3) {
                    new_id+=new_id.charAt(0);
                }                
            } else {
                while(new_id.length()<3) {
                    new_id+=new_id.charAt(new_id.length()-1);
                }                
            }
        }
        String answer = new_id;
        
        
        return answer;
    }
}