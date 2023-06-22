package dataStructure.arrayAndList;

import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 시험을 본 과목의 개수
        int N = sc.nextInt();
        // 입력된 점수를 받을 배열 선언 후 차례로 넣음
        // ** scanner nextInt는 공백 기준으로 줄 바꿈이 됨.
        int[] score = new int[N];

        for(int i = 0; i < N; i++){
            score[i] = sc.nextInt();
        }

        long max = 0;
        long sum = 0;

        for(int i = 0; i < score.length; i++){
            if(max < score[i]){
                max = score[i];
            }
            sum = sum + score[i];
        }


        /*
            원래점수 / 최고점수(max) * 100 으로 전체 점수를 변환하고
            변환된 점수의 합 / 입력된 과목의 갯수

            위의 계산식 단순화 → ( sum ) * 100 / 최대점수 / 과목수

         */
        System.out.println(sum * 100.0 / max / N);



    }
}
