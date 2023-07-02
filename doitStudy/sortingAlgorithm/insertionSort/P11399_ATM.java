package doitStudy.sortingAlgorithm.insertionSort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    ▶ 삽입정렬(insertion sort)
      : 이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식
      : 시간복잡도 O(n²)

    ▶ 삽입 정렬의 핵심 이론
     - 선택 데이터를 현재 정렬된 데이터 범위 내에서 적절한 위치에 삽입하는 것이 핵심

    ▶ 삽입 정렬 수행 방식
     1. 현재 index에 있는 데이터 값을 선택한다.
     2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다.
     3. 삽입 위치부터 index에 있는 위치까지 shift(쉬프트)연산을 수행한다.
     4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행한다.
     5. 전체 데이터의 크기만큼 index가 커질 때까지, wmr 선택할 데이터가 없을 때까지 반복한다.

     ! 적절한 삽입 위치를 탐색하는 부분에서 binary search등과 같은 탐색 알고리즘을 사용하여 시간복잡도를 줄일 수 있다.
 */
public class P11399_ATM {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        // 합정렬 배열
        int[] S = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // index[1] ~ 마지막까지 순회하면서 insertion sort 진행
        for(int i = 1; i < A.length; i++){
            // 삽입이 될 index번호와 value를 담을 변수 선언
            int insert_point = i;
            int insert_value = A[i];

            // i보다 작은 인덱스부터 index 0번까지 순회하면서 비교함
            for(int j = i - 1; j >= 0; j--){
                // 만약에 i번째가 j보다 더 크다면 i번째 +1이 insert될 지점으로 변경
                // 1 3 4 5 2가 있고, A[4] = 2 일때,  j로 5 -> 4 -> 3 -> 1 순으로 순회하다가
                // 1번과 비교할 시 A[j]가 더 크므로 그 앞번째가 insert 지점이 되는 것
                if(A[i] > A[j]){
                    insert_point = j+1;
                    break;
                }
                // 만약에 j가 0번째까지 가게 되면 가장 작은 값이라는 의미이므로 insert_point가 0이 된다
                if(j == 0){
                    insert_point = 0;
                }
            }

            // shift 진행
            // j = i번째부터, j가 insert_point보다 클때까지 한칸씩 앞으로 땡겨준다.
            for(int j = i; j > insert_point; j--){
                A[j] = A[j-1];
            }

            // insert_point지점에는 insert_value를 넣어주므로써 배열에 값을 업데이트시킨다.
            A[insert_point] = insert_value;
        }

        /* 버블정렬..
        for(int i = 0; i < A.length; i++){
            for(int j = 1; j <A.length; j++){
                if(A[j-1] > A[j]){
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                }
            }
        }
        */

        S[0] = A[0];
        int result = S[0];
        for(int i = 1; i < S.length; i++){
            S[i] = S[i-1] + A[i];
            result = result + S[i];
        }

        System.out.println(result);

    }

}
