package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 입력 받을 배열의 크기
    int arr_Size = Integer.valueOf(st.nextToken());
    // 입력 받을 질의의 횟수
    int quiz_Size = Integer.valueOf(st.nextToken());

    // 원본 배열 선언
    int[][] origin_Arr = new int[arr_Size+1][arr_Size+1];

    // 원본 배열에 입력된 값 넣기
    for(int i = 1; i <= arr_Size; i++){
        st = new StringTokenizer(br.readLine());

        for(int j = 1; j <= arr_Size; j++){
            origin_Arr[i][j] = Integer.valueOf(st.nextToken());
        }
    }

    // 구간 합 배열 선언
    int[][] sum_Arr = new int[arr_Size+1][arr_Size+1];

    // 구간 합 배열에 값 넣기
    for(int i = 1; i <= arr_Size; i++){
        for(int j = 1; j <= arr_Size; j++){
            // 구갑 합 배열에 값 넣을 때 식 설명
            /*
              - 원본 배열의 (0,0)부터 (x,y)까지의 사각형 영역 안에 있는 수의 합

              합배열[x][y] =   합배열[x축-1][y축]   -> y축 기준으로 y축 길이 만큼의 영역 구간합 크기
                           +  합배열[x축][y축-1]   -> x축 기준으로 x축 길이 만큼의 영역 구간합 크기
                           -  합배열[x축-1][y축-1] -> 중복되는 구간 합 구간을 빼줌
                           +  원본배열[x][y]       -> 원본배열의 x,y축의 숫자를 더함으로써 해당크기까지의 구간합을 구할 수 있음
             */
            sum_Arr[i][j] = sum_Arr[i-1][j] + sum_Arr[i][j-1] - sum_Arr[i-1][j-1] + origin_Arr[i][j];
        }
    }

    for(int i = 0; i < quiz_Size; i++){
        st = new StringTokenizer(br.readLine());

        int x1 = Integer.valueOf(st.nextToken());
        int y1 = Integer.valueOf(st.nextToken());
        int x2 = Integer.valueOf(st.nextToken());
        int y2 = Integer.valueOf(st.nextToken());

        /*
            구간합 배열에서 입력된 축(x1, y1)에서 축(x2, y2)까지의 크기 구하기
            결과 = 축(x2,y2)       -> 해당하는 구간합 크기에서
                 - 축(x1-1, y2)   -> x1-1축 기준 y2축까지 해당 하지 않는 영역의 구간합 크기 제거
                 - 축(x2, y1-1)   -> y1-1축 기준으로 x2축까지 해당 하지 않는 영역 구간합 크기 제거
                 + 축(x1-1, y1-1) -> 중복으로 제거된 구간합 영역 추가
         */
        int result = sum_Arr[x2][y2] - sum_Arr[x1-1][y2] - sum_Arr[x2][y1-1] + sum_Arr[x1-1][y1-1];

        System.out.println(result);

    }



    }
}
