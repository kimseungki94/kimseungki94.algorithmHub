class Solution {
    public int[] solution(int brown, int yellow) {
        int row=1;
        int[] answer = new int[2];
        while(true) {
            if(yellow%row==0) {
                int temp =  yellow/row;
                int value = (temp+2)*2+row*2;
                if(value==brown) {
                    answer[0]=temp+2;
                    answer[1]=row+2;
                    break;
                }
            }
            row++;
        }
        return answer;
    }
}

//1열
// (x+2)*2+row(1)*2
// (x+2)*2+row(2)*2

//1열
// (24+2)*2+1*2 = 54
// (12+2)*2+2*2 = 32
// (8+2)*2+3*2 = 26
// (6+2)*2+4*2 = 24