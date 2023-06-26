package dataStructure.arrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986_나머지합 {
    public static void main(String[] args) throws IOException {
        /*
            - 나머지 합 문제 풀이의 핵심 아이디어
            ▶ 나머지 연산의 (A+B) % C은 ((A % C) + (B % C)) % C 와 같다
              다시 말해 특정 구간 수들의 나머지 연산을 더해 나머지 연산을 한 값과 이 구간 합의 나머지 연산을 한 값은 동일하다

            ▶ 구간 합 배열의 원소를 M으로 나눈 나머지로 update s[i], s[j]가 같은 (i,j)쌍을 찾으면
              원본 배열에서 j+1부터 i까지의 구간 합이 M으로 나누어 떨어진다는 것
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두 번째 행에서 받을 숫자의 갯수 == sum_arr배열의 크기
        int num_size = Integer.valueOf(st.nextToken());
        // 구간합 배열에서 나눠줄 정수값
        int M = Integer.valueOf(st.nextToken());

        // 두 번째 행에서 받은 값으로 구간합을 담을 배열
        long[] sum_arr = new long[num_size];
        /*
            - diff_arr[]의 용도
            1. 0번째 인덱스는 구간합배열에서 M값을 나눴을 때 0으로 떨어지는 횟수를 담는다
            2. 1번째 인덱스는 구간합배열에서 M으로 나누어 떨어지지는 않으나 나머지가 같은 인덱스의 개수를 담는다.
         */
        long[] diff_arr = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        sum_arr[0] = Integer.valueOf(st.nextToken());

        for(int i = 1; i < num_size; i++){
            sum_arr[i] = sum_arr[i-1] + Integer.valueOf(st.nextToken());
        }

        for(int i = 0; i < num_size; i++){
            int remainder = (int)(sum_arr[i] % M);
            // 0~i까지 구간 합 자체가 0일 때 정답에 더하기
            if( remainder == 0) answer++;
            // 나머지가 같은 인덱스의 개수 카운팅하기
            diff_arr[remainder]++;
        }

        for(int i = 0; i < M; i++){
            if(diff_arr[i] > 1){
                // 기존의 구간합 / M = 0인 갯수와 나머지가 같은 인덱스의 경우의 수를 더해준다
                answer = answer + (diff_arr[i] * (diff_arr[i]-1) / 2);
            }
        }

        System.out.println(answer);
    }
}
