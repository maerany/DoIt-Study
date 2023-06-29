package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 입력 받을 수열의 개수
        int N = sc.nextInt();
        // 입력 받을 수열을 저장할 배열
        int[] arr = new int[N];

        // 사용자한테 수열을 하나씩 입력받을 때마다 배열에 저장함
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        // int 수열을 담을 stack을 만들고
        Stack<Integer> stack = new Stack<>();
        // pop (-), push (+) 상태에 따라 저장할 문자열 담을 StringBuffer만들고
        StringBuffer sb = new StringBuffer();

        // 조건 비교를 위한 숫자, 스택에 담을 숫자가 됨 ( 0보다 큰 수만 들어와야함)
        int num = 1;
        // T/F에 따라서 sb에 담긴 문자열을 출력할 것
        boolean result = true;

        //arr배열의 요소 하나씩 확인해야 하므로 arr배열의 길이 만큼 반복한다.
        for(int i = 0; i < arr.length; i++){
            // arr요소 하나를 담고
            int arrValue = arr[i];
            // 해당 요소가 1보다 크다면
            if(arrValue >= num){
                // arrValue의 숫자의 크기만큼 반복하며, stack에 담고, sb(push -> "+")에 추가한다.
                while(arrValue >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                // 예를 들어 위에 arrValue가 4면 4까지 반복해서
                // stack에 넣고 마지막에 들어간 숫자 4를 pop()해준다.
                // pop() 했으므로 sb에 "-"를 추가한다.
                stack.pop();
                sb.append("-\n");
            } else {
                // 사용자가 입력한 숫자가 현재 stack에 마지막에 들어간 숫자보다 작다면
                // stack에서 가장 마지막에 들어간 요소를 빼서 변수에 담고
                int n = stack.pop();

                if(n > arrValue){ // stack에 마지막 요소의 수가 비교하려는 수열의 수보다 더 크다면
                    System.out.println("NO");
                    result = false;
                    break;
                } else { //비교하려는 숫자가 더 크다면 이미 pop했기에 sb에 "-"를 넣는다.
                    sb.append("-\n");
                }
            }
        }


        if(result) System.out.println(sb.toString());

    }
}
