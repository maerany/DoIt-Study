package doitStudy.dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class P1940_주몽 {
    public static void main(String[] args){

        /*
            ▶ 슈도코드 작성하기

            int N(재료의 개수) = sc.nextInt;
            int M(번호의 합)   = sc.nextInt;
            int[] 재료배열;

            for(N만큼)(
                재료들 = sc.nextint;
            )

            Arrays.sort(재료배열);

            while(i > j){
                if(sum = M){
                    count++;
                    i++, j--;
                    sum = 재료배열[i] + 재료배열[j]
                } else if (sum > M){
                    j--;
                    sum = 재료배열[i] + 재료배열[j]
                } else if (sum < M) {
                    i++;
                    sum = 재료배열[i] + 재료배열[j]
                }
            }

         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int i = 0, j = N-1, sum = arr[i] + arr[j], count = 0 ;

        while(i < j){
            if(sum == M){
                count++;
                i++;
                j--;
                sum = arr[i] + arr[j];
            } else if (sum > M){
                j--;
                sum = arr[i] + arr[j];
            } else if (sum < M){
                i++;
                sum = arr[i] + arr[j];
            }
        }

        System.out.println(count);
    }
}
