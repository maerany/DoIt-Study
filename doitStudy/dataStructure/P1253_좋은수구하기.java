package doitStudy.dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class P1253_좋은수구하기 {
    public static void main(String[] args){

        /*
            int N(수의개수) = sc.nextInt();
            int[] arr = new int[N];

            for(N의 크기만큼){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);  //정렬
            int count = 0;

            for(K를 0~N까지 반복){
                i = 0, j = 1 초기화
                while(i < j){
                    if(arr[i] + arr[j] = arr[k]){
                        if( i != k, j != k){
                            count++;
                            break;
                        } else if( i == k){
                            i++;
                        } else if( j == k){
                            j++;
                        }
                    } else if(arr[i] + arr[j] > arr[k]){
                        j--;
                    } else if(arr[i] + arr[j] < arr[k]){
                        i++;
                    }
                }
            }
        */


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        long[] arr = new long[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        for(int k = 0; k < N; k++){
            int i = 0, j = N-1;

            while(i < j){
                if(arr[i] + arr[j] == arr[k]){
                    // arr[k] 자기 자신의 수는 처리하지 않아야 함
                    if(i != k && j != k){
                        count++;
                        break;
                    } else if(i == k){
                        i++;
                    } else if(j == k){
                        j--;
                    }
                } else if(arr[i] + arr[j] > arr[k]){
                    j--;
                } else if(arr[i] + arr[j] < arr[k]){
                    i++;
                }
            }
        }

        System.out.println(count);
    }
}
