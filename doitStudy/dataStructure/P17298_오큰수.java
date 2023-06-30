package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        /*
            char[] A = br.readLine().toCharArray();

            BufferedReader에 readLine() 읽어오면 String형이기 때문에 String형을
            배열로 바꿔주는 toCharArray() 메소드를 사용하려면, 해당 배열을 담는 자료형이
            char형 배열이여야 함
         */

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.valueOf(st.nextToken());
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for(int i = 1; i < A.length; i++){

            while(!stack.isEmpty() && A[i] > A[stack.peek()]){
                int num = stack.pop();
                result[num] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        /*
            ▶ BufferedWriter 로 출력
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < N; i++){
                bw.write(ans[i] + " ");
            }

            bw.write("\n");
            bw.flush();
         */

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
