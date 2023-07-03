package doitStudy.sortingAlgorithm.mergeSort;

import java.io.*;
import java.util.StringTokenizer;

/*
    ▶ 병합정렬(merge sort)
     : 분할 정복(divide and conquer) 방식을 사용해 데이터를 분할하고 분할한 집합을 정렬하며 합치는 알고리즘
     : 시간 복잡도(평균) : O(nlogn)

    ▶ 병합 정렬의 핵심 이론
       - 가장 작은 데이터 집합으로 분할
       - 병합하면서 정렬 진행 (오름차순, 내림차순 정렬)
       ex) set 8개  (병합)→  set 4개  (병합)→  set 2개  (병합)→  set 1개

    ▶ 병합 정렬은 코딩 테스트 정렬 관련 문제에서 자주 등장함
      2개의 그룹을 병합하는 원리 숙지 필요
       - 투 포인터 개념을 사용하여 왼쪽, 오른쪽 그룹을 병합함
       - 왼쪽 포인터와 오른쪽 포인터의 값을 비교하여 작은 값을 결과 배열에 추가하고
       - 포인터를 오른쪽으로 1칸 이동시킴

 */
public class P2751_수정렬하기2 {

    public static int[] A, tmp;
    //public static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받을 정수의 개수
        int N = Integer.valueOf(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);
        for(int i = 1; i <= N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void mergeSort(int start, int end) {

        // 만약에 end - start 가 1보다 작으면 정렬할 게 없다는 뜻으로 return
        if(end - start < 1){ return; }

        // 중간점 구하기
        int m = start + (end - start) / 2;

        //재귀함수 형태로 구현
        mergeSort(start, m);
        mergeSort(m+1, end);

        for(int i = start; i <= end; i++){
            tmp[i] = A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = m + 1;

        // 두 개의 그룹을 병합하는 로직
        while (index1 <= m && index2 <= end){
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택하여 배열에 저장한뒤
            // 선택된 데이터의 index값을 오른쪽 한 칸 이동

            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= end){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }


}
