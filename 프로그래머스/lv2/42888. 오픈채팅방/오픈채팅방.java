import java.util.*;
import java.awt.*;

class Solution {
    public static class Command {
        String command;
        String index;
        String name;

        public Command(String command, String index, String name) {
            this.command = command;
            this.index = index;
            this.name = name;
        }
    }

    public static class Recode {
        String command;
        String index;

        public Recode(String command, String index) {
            this.command = command;
            this.index = index;
        }
    }
    
    public String[] solution(String[] record) {
        ArrayList<Command> list = new ArrayList<>();
        ArrayList<Recode> save = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();

        Arrays.stream(record).forEach(recode -> {
            String[] command = recode.split(" ");
            if(command[0].equals("Leave")) list.add(new Command(command[0],command[1],null));
            else list.add(new Command(command[0],command[1],command[2]));
            if(!map.containsKey(command[1])) map.put(command[1],command[2]);
        });
        
        list.stream().forEach(command -> {
            if(command.command.equals("Enter") || command.command.equals("Leave")) {
                if(command.command.equals("Enter")) {
                    if(map.containsKey(command.index)) {
                        map.put(command.index,command.name);
                    }
                }
                save.add(new Recode(command.command, command.index));
            } else {
                map.put(command.index,command.name);
            }
        });
        
        ArrayList<String> answerTemp = new ArrayList<>();
        save.stream().forEach(recode -> {
            if(recode.command.equals("Enter")) {
                answerTemp.add(map.get(recode.index)+"님이 들어왔습니다.");
            } else {
                answerTemp.add(map.get(recode.index)+"님이 나갔습니다.");
            }
        });
        String[] answer = answerTemp.toArray(new String[answerTemp.size()]);
        return answer;
    }
}