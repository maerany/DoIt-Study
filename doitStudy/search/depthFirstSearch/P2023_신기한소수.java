package doitStudy.search.depthFirstSearch;

import java.util.Scanner;

public class P2023_신기한소수 {
    /*
        ▶ 소수 구하기
         : 소수 == 1과 자기 자신만을 약수로 가지는 수
     */

    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2, 3, 5, 7는 일의 자리에서 소수인 숫자들이며, 처음 시작은 1의 자리 수로 시작
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int num, int s) {

        if (s == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if( i % 2 == 0){
                continue;
            }
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, s + 1 );
            }
        }
    }
    static boolean isPrime(int num){
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}
