package doitStudy.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        /*
            ▶ Lambda expression
             - [ex] (매개변수) -> { 식 or return ~~ ;}
             - 메서드(함수)를 하나의 식으로 표현한 것
             - 함수를 간략하고 명확하게 표현할 수 있게 해준다.
             - 메서드를 람다식으로 표현함으로써 메서드 이름과 반환형이 없어지므로 'anonymous expression'이라고도 부른다.
             - lambda식(객체)이 매개변수로 전달되거나, 메서드의 결과로 반환될 수 있다.
             - {} 안의 식이 자동적으로 반환(return)값이 된다.

             -----------------------------------------------------
             - lambda식은 익명 class의 객체와 동등하다.
             - Interface를 통해 람다식을 다루기로 결정되었으며, 람다식을 다루기 위한 인터페이스를
               '함수형 인터페이스(functional interface)'라고 부르기로 했다.
               @FunctionalInterface
             - 단, 함수형 인터페이스에는 오직 하나의 '추상 메서드'만 정의되어 있어야 한다는 제약이 있음
               그래야만 람다식과 인터페이스이 메서드가 1:1로 연결될 수 있기 때문임.
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> {

            // queue에 있는 두 개의 노드를 비교
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 두 개의 노드의 절대값이 같다면
            if(first_abs == second_abs){
                // 첫번째 노드가 두번째 노드보다 크면(T) 오름차순 / (F)내림차순
                // -붙은 절대값 노드가 우선순위 우선
                return o1 > o2 ? 1 : -1;
                // 1 : 오름차순 정렬 / -1 : 내림차순 정렬
            }
            // 두 개의 노드 절대값이 같지 않다면, 두번째 노드가
            return first_abs - second_abs;
        });

        for(int i = 0; i < N; i++){
            int num = Integer.valueOf(br.readLine());

            if(num == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            } else {
                queue.add(num);
            }
        }



    }
}
