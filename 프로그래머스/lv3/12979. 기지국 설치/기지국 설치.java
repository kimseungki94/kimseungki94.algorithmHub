import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer=0;
        int start=1;
        int index=0;
        int size=stations.length;
        while(start<=n) {
            if(index<size && stations[index]-w<=start && start<=stations[index]+w) {
                start=stations[index]+w+1;
                index++;
            } else {
                answer++;
                start+=(2*w)+1;
            }
        }
        return answer;
    }
}
/**
그리디
1부터 시작
현재 위치가 n보다 클경우 끝
만약 전파가 안되는 구역에 있다면
 지금위치에서 w만큼 간 위치에 가서 기지국 설치
 이후 기지국에서 +w+1한 위치로 가기
만약 전파가 되는 구역에 있다면
 인덱스 카운트
 전파 인덱스 +w+1한 위치로 가기

1보다 크면
*/