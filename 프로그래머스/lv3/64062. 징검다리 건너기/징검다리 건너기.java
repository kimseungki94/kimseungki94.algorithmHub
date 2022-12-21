import java.util.*;

class Solution {
    static int[] stones;
    static int k;

    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;

        int left = 1;
        int right = 200_000_001;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right - 1;
    }

    boolean isPossible(int num) {
        int ct = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - (num - 1) > 0) {
                ct = 0;
            } else {
                ct++;
            }

            if (ct == k) {
                return false;
            }
        }

        return true;
    }
}