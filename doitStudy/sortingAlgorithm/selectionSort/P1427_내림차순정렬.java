package doitStudy.sortingAlgorithm.selectionSort;

import java.util.Scanner;

public class P1427_내림차순정렬 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int[] A = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            /*
                ▶ substring(i, i+1);
                  string.subString(시작인덱스, 마지막인덱스+1);
                  ex) "123456789" str.substring(3, 4); // 4 출력
             */
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 시간복잡도 O(n²)
        for(int i = 0; i < str.length(); i++){
            // 기본 max 인덱스를 0으로 설정 
            int max = 0;
            
            //  A[0]과 A[1]를 비교하여 A[1]크다면 max 인덱스 변경
            for(int j = 0 + i; j < str.length(); j++){
                if(A[j] > A[max]){
                    max = j;
                }
                
                // max 인덱스가 더 크다면 swap진행 : 큰 인덱스를 왼쪽에 두고 작은 인덱스를 오른쪽으로
                if(A[j] < A[max]){
                    int temp = A[j];
                    A[j] = A[max];
                    A[max] = temp;
                }
            }
        }

        // 출력
        for(int i = 0; i < A.length ; i++){
            System.out.println(A[i]);
        }
    }
}
