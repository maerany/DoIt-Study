package doitStudy.sortingAlgorithm.quickSort;


 /*
    ▶ quick sort (퀵 정렬)
     : 기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘
     : '기준값이 어떻게 선정되는가'에 따라 시간 복잡도에 많은 영향을 미침
     : 시간복잡도 O(nlogn)

    ▶ 퀵 정렬의 핵심 이론
     - pivot을 중심으로 계속 데이터를 2개의 집합으로 나누면서 정렬하는 것이 퀵 정렬의 핵심이다.

    ▶ 퀵 정렬 과정
     1. 데이터를 분할하는 pivot을 설정한다.
     2. pivot을 기준으로 다음 ①~⑤ 과정을 거쳐 데이터를 2개의 집합으로 분리함
      2-①. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start를 오른쪽으로 1칸 이동
      2-②. end가 가리키는 데이터가 pivot이 가리키는 데이터보다 크면 end를 왼쪽으로 1칸 이동
      2-③. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 크고,
           end가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start, end가 가리키는 데이터를 swap하고
           start는 오른쪽 end는 왼쪽으로 1칸씩 이동한다.
      2-④. start와 end가 만날 때까지 ①~③까지 반복한다.
      2-⑤. start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여
            pivot이 가리키는 데이터가 크면 만난 지점의 오른쪽에,
            작으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입한다.
     3. 분리 집합에서 각각 다시 pivot을 선정한다.
     4. 분리 집합이 1개 이하가 될 때까지 과정 1~3을 반복한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K);
        System.out.println(A[K-1]);
    }


    public static void quickSort(int[] A, int start, int end, int K){

        if(start < end){
            int pivot = partition(A,start, end);
            if(pivot == K){
                return;
            } else if(K < pivot) {
                quickSort(A, start, pivot-1, K);
            } else {
                quickSort(A, pivot+1, end, K);
            }
        }

    }

    private static int partition(int[] A, int start, int end) {

        // start가 1증가 했을 때 end와 같고, start위치가 end위치의 값보다 더 클 경우 swap 진행
        if(start + 1 == end){
            if(A[start] > A[end]) swap(A, start, end);
            return end;
        }

        int M = (start + end) / 2;   // 중앙값 구하기
        swap(A, start, M);           // 중앙값을 1번째 요소로 이동하기
        int pivot = A[start];        // 중앙값이 pivot값이 됨
        int i = start +1, j = end;   // i = start, j = end로 셋팅

        // start와 end가 같을 때까지
        while (i <= j){

            // pivot보다 작은 수가 나올 때까지 j--
            while (pivot < A[j] && j > 0){ // pivot보다 end 위치값이 크고, 0이 아닐 때
                j--; //end point를 왼쪽으로 옮긴다.
            }

            // pivot보다 큰 수가 나올 때까지 i++
            while (pivot > A[i] && i < A.length-1){  // pivot보다 start위치값이 크고, 배열을 벗어나지 않을 때
                i++; // start_point를 오른쪽으로 옮긴다.
            }

            if( i <= j){
                swap(A, i++, j--);
            }
        }

        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j){ // start가 end보다 클 경우 두 수를 swap 시켜준다.
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

