package doitStudy.dataStructure;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // N = 입력받을 숫자의 개수, L = 최솟값을 구하는 범위 == 슬라이딩 윈도우 크기
        int N = Integer.valueOf(st.nextToken());
        int L = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        /*
            ▶ Deque (Double Ended Queue)
             : 큐의 양쪽에 데이터를 넣고 뺄 수 있는 형태의 자료구조를 뜻함
         */
        Deque<Node> mydeque = new LinkedList<>();

        for(int i = 0; i < N; i++){
            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄인다.
            int now = Integer.valueOf(st.nextToken());

            // deque이 비어있지 않고, 덱의 마지막 요소의 값이 현재(now) 들어온 값보다 클 때
            // deque의 첫번째 요소를 제거한다.
            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                // deque의 left쪽에 있는 첫번째 값을 제거, 없을 시 Exception발생
                mydeque.removeFirst();
            }

            // 덱의 right쪽에 현재 입력된 숫자와 index를 넣는다.
            mydeque.addLast(new Node(now, i));

            // L범위에 벗어난 값은 덱에서 제거
            if(mydeque.getFirst().index <= i-L){
                mydeque.removeFirst();
            }

            // 첫 번째 값 확인해서 bw에 넣어준다.
            bw.write(mydeque.getFirst().value+" ");

        }

        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

}
