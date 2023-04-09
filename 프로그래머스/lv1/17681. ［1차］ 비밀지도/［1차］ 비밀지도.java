class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] map1 = parseDataToBinary(n,arr1);
        String[] map2 = parseDataToBinary(n,arr2);
        String[] answer=new String[n];
        for(int i=0;i<n;i++) {
            String map1Data = map1[i];
            String map2Data = map2[i];
            
            for(int j=0;j<n;j++) {
                int map1Character = map1Data.charAt(j)-'0';
                int map2Character = map2Data.charAt(j)-'0';
                if(map1Character==0 && map1Character==map2Character) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i]=sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
    
    private String[] parseDataToBinary(int n, int[] arr) {
        String[] data = new String[n];
        for(int i=0;i<n;i++) {
            data[i]=Integer.toBinaryString(arr[i]);
            while(data[i].length()<n) {
                data[i]="0"+data[i];
            }
        }
        return data;
    }
}
/**
프로도가 비상금 숨긴 비밀지도
암호해독


n

지도 1
지도 2

1,2 하나라도 벽이면 전체지도 벽
1,2 모두 공백이면 공백

*/