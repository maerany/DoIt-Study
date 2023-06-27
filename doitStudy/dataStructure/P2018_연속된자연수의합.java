package doitStudy.dataStructure;

import java.io.IOException;
import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) throws IOException {

        // 투 포인트 사용
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // start / end 포인터를 이동시키면서 연속된 수의 합이 같은지 판별함
        int count = 1, start_index = 1, end_index = 1, sum = 1;

        // end_index가 입력된 수가 아닐 때 동안 반복함
        while(end_index != num){
            if(sum == num){
            // 합이 num과 같다면, end_point 증가 후 sum값 업데이트, count 증가
                end_index++;
                sum = sum + end_index;
                count++;
            } else if(sum > num){
            // 합이 더 크다면 합계에서 start_point 값 빼고, start_point 증가
                sum = sum - start_index;
                start_index++;
            } else if(sum < num){
            // num이 더 크다면 end_point 증가 시키고 sum값 업데이트
                end_index++;
                sum = sum + end_index;
            }
        }

        System.out.println(count);

    }
}
