class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++) {
            String text1 = Integer.toBinaryString(arr1[i]);
            String text2 = Integer.toBinaryString(arr2[i]);
            while(text1.length()<n) {
                text1="0"+text1;
            }
            while(text2.length()<n) {
                text2="0"+text2;
            }
            String text3="";
            for(int j=0;j<n;j++) {
                if(text1.charAt(j)=='1' || text2.charAt(j)=='1') {
                    text3+="#";
                } else {
                    text3+=" ";
                }
            }
            answer[i]=text3;           
        }
        return answer;
    }
}