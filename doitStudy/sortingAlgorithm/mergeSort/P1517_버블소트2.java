package doitStudy.sortingAlgorithm.mergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_버블소트2 {
    /*
        버블소트 -> 인접해 있는 두 수를 바꾸면서 정렬하는 방법
        해당 문제는 N의 최대 범위가 5,000,000이므로 bubbleSort사용시 제한 시간을 초과함
        O(nlogn) 시간복잡도를 가진 병합 정렬을 사용해야 함.
     */
    static int[] A, tmp;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력될 수열의 길이
        int N = Integer.valueOf(br.readLine());

        // 입력받은 숫자 배열 만들고, 정렬에 필요한 임시 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        result = 0;

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);
        System.out.println(result);

    }

    public static void mergeSort(int s, int e){

        if(e - s < 1){
            return;
        }

        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        for(int i = s; i <= e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;

        while (index1 <= m && index2 <= e){

            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                result = result + index2 - k;
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
        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
