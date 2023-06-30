package doitStudy.dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            // 사용자가 입력한 정수 N까지 차례대로 queue에 오른쪽에서 부터 담는다
            queue.add(i);
        }

        while (queue.size() > 1){
            // queue left쪽에 있는 원소 하나 삭제
            queue.remove();
            // queue left쪽에 있는 원소 하나를 queue right쪽으로 넣음
            queue.add(queue.poll());
        }

        // 마지막 남은 원소 하나를 출력
        System.out.println(queue.peek());

    }
}
