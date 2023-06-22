package dataStructure.arrayAndList;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력받을 숫자의 자리 수가 몇인지 입력 받는다.
        int N = sc.nextInt();
        // 1 <= N <= 100 이므로 int, long으로 입력받을 시 범위를 벗어나므로 String으로 받는다.
        String sNum = sc.next();
        // 입력받은 String 정수를 자리수에 따라 배열에 담는다.
        char[] cNum = sNum.toCharArray();
        // 각 자릿수의 정수 하나하나를 담을 변수 지정
        int sum = 0;

        /*
            * 아스키코드
            1. 0~9 (48~57)
            2. a~z (65~90)
            3. A~Z (97~122)
         */

        for(int i=0; i < cNum.length; i++){
            sum += cNum[i] - '0';
            // '0' 으로 해도 되고, 48로 빼도 됨.
        }
            System.out.println(sum);

    }
}
