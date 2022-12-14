import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answer;
    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();

        DFS(new LinkedHashSet<>(), user_id, banned_id);

        return answer.size();
    }


    private static void DFS(HashSet<String> set, String[] user_id, String[] banned_id) {
        if (set.size() == banned_id.length) {
            if (isBanList(set, banned_id)) {
                answer.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : user_id) {
            if (set.add(userId)) {
                DFS(set, user_id, banned_id);
                set.remove(userId);
            }
        }
    }


    private static boolean isBanList(HashSet<String> set, String[] banned_id) {
        int index = 0;
        for (String userID : set) {
            String banID = banned_id[index++];
            if (userID.length() != banID.length()) {
                return false;
            }
            for (int i = 0; i < banID.length(); i++) {
                if (banID.charAt(i) == '*') {
                    continue;
                }
                if (userID.charAt(i) != banID.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}