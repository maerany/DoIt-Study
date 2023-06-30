package doitStudy.sortingAlgorithm.bubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2750_수정렬하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for(int i = 0; i < A.length; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-1-i; j++){
                int temp = 0;

                if(A[j] > A[j+1]){
                    temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }

            }
        }

        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }

    }
}
