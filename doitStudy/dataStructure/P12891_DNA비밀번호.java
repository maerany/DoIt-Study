package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {

    static int checkArr[]; //비밀번호 체크를 위한 배열
    static int myArr[];    //현재 상태 배열
    static int checkSecret;//4개의 문자열 중에 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //문자열의 길이
        int S = Integer.parseInt(st.nextToken());
        //부분문자열의 길이
        int P = Integer.parseInt(st.nextToken());
        // (정답변수)유효한 DNA비밀번호 문자열 개수 담을 변수
        int result = 0;
        // 문자열 데이터를 담는 배열
        char[] A;
        // static변수로 선언한 class변수 초기화
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        // 입력된 문자열을 담는다.
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            // A, C, G, T의 숫자를 차례로 담는다
            checkArr[i] = Integer.parseInt(st.nextToken());

            // 만약에 비밀번호 체크 배열에 0이 있다면, 해당 문자열은 개수를 충족했다는 의미
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        for(int i = 0; i < P; i++){
            Add(A[i]);
        }

        // 문자열 검사 끝나고 checkSecret값이 4면 결과값 증가
        if(checkSecret == 4) result++;

        //★★★★★ 슬라이딩 윈도우
        /*
            문자열의 0번부터 ~ P까지 검사를 한 뒤 1 ~ P+1 까지 다시 재검사 하는 것이 아니라,
            앞의 0번은 삭제하고 뒤에 추가되는 1개만 다시 검사를 하는 로직임.
            그렇기 때문에 아래의 로직으로 진행됨.
         */
        for(int i = P; i < S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) { // 제거되는 문자를 처리하는 함수
        switch(c){
            case 'A':
                if(checkArr[0] == myArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(checkArr[1] == myArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(checkArr[2] == myArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(checkArr[3] == myArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) { //새로 들어온 문자를 처리하는 함수
        switch(c){
            case 'A':
                myArr[0]++;
                /* 만약, 체크하려는 배열의 A갯구와 나의 배열의 A갯수가 같다면 checkSecret 증가
                   즉, checkSecret이 4가 되면 모든 조건이 만족한다는 의미가 되므로
                   해당 배열은 유효한 DNA비밀번호라는 뜻이 된다.
                 */
                if(checkArr[0] == myArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(checkArr[1] == myArr[0]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(checkArr[2] == myArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(checkArr[3] == myArr[3]) checkSecret++;
                break;
        }
    }


}
