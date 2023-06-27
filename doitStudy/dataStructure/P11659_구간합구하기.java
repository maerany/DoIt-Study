package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
            - BufferedReader : 버퍼에 쌓인 문자열을 읽어들이는 class
            - BufferedWriter : 버퍼를 이용한 출력 class
         */

        // br.readLine() : BufferedReader로 읽어들인 버퍼의 문자열 중 하나의 라인을 읽어들인다.
        // StringTokenizer st = new StringTokenizer() : StringTokenizer에 공백 기준으로 문자열을 토큰화 시켜서 담는다.
        StringTokenizer st = new StringTokenizer(br.readLine() );

        /* st에 담긴 토큰화된 문자들을 빼서 각각 변수에 담아준다.
            - 첫번째 토큰 = 데이터의 개수
            - 두번째 토큰 = 질의 개수
        */
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        long[] arr = new long[suNo+1];

        // BufferedReader의 다음 라인을 읽어들인 후 토큰화 시킨다.
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for(int i = 0; i < quizNo; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());

            System.out.println(arr[end] - arr[start -1]);

        }


    }
}
