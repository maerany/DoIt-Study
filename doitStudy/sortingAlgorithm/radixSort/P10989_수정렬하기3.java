package doitStudy.sortingAlgorithm.radixSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
/*
    ▶ 기수 정렬(radix sort)
     : 값을 비교하지 않는 특이한 정렬
     : 값을 놓고 비교할 자릿수를 정한 다음 해당 자릿수만 비교한다.
     : 시간 복잡도 O(kn) --> k == 데이터 자릿수

    ▶ 핵심 이론
      1. 10개의 큐를 이용하며, 각 큐는 값의 자릿수를 대표한다.
      2. 일의 자리 수를 기준으로 (0~9까지의 큐에)데이터 저장
      3. 십의 자릿수를 기준으로 데이터 저장
         -> data를 담는 자료구조는 Queue로 First In First Out

      참고 사이트
      https://www.geeksforgeeks.org/radix-sort/

 */
public class P10989_수정렬하기3 {

    public static int A[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        radixSort(A, 5);

        for(int i = 0; i < N; i++){
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static void radixSort(int[] A, int max_size){
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 1;

        while(count != max_size){
            int[] bucket = new int[10];
            for(int i = 0; i <A.length; i++){
                bucket[(A[i] / jarisu) % 10]++;
            }
            // 합 배열을 이용한 index 계산
            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i-1];
            }
            // 현재 자릿수를 기준으로 output[]담기
            for(int i = A.length-1; i >= 0; i--){
                output[bucket[(A[i] / jarisu % 10)] -1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            for(int i = 0; i <A.length; i++){
                A[i] = output[i];
            }

            jarisu = jarisu * 10;
            count++;

        }

    }




}
