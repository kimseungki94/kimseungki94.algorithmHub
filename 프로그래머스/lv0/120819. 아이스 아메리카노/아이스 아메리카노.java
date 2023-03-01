class Solution {
    public int[] solution(int money) {
        int count=money/5500;
        int restMoney = money%5500;
        int[] answer = {count,restMoney};
        return answer;
    }
}