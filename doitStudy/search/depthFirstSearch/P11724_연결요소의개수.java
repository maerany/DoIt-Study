package doitStudy.search.depthFirstSearch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.StringTokenizer;

/*
    ▶ DFS : Depth-first Search
        - 그래프 완전 탐색 기법 중 하나
        - 그래피의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정해 최대 깊이까지 탐색을 마친 후
        - 다른 분기로 이동하여 다시 탐색을 수행하는 알고리즘
    ▶ 특징
        - 재귀 함수로 구현
        - 스택 자료구조 이용
        - 시간 복잡도 (노드 수 : V, 에지 수 : E) == O(V+E)
        - 단절점 찾기, 단절선 찾기, 사이클 찾기, 위상 정렬 등에 응용

    ▶ 핵심이론
        - DFS는 한 번 방문한 노드를 다시 방문하면 안됨, 노드 방문 여부 확인을 위한 배열 필요
        - 그래프는 인접 리스트로 표현
        - DFS는 LIFO 특성을 가지므로 stack을 사용, stack 성질을 가지는 재귀함수로 표현됨

    ▶ 적용
      1. DFS를 시작할 노드를 정한 후 사용할 자료구조 초기화
        - 인접 리스트로 그래프 표현
        - 방문 배열 초기화 (boolean)
        - 시작 노드 스택에 삽입
      2. 스택에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 다시 스택에 삽입
        - pop을 수행하여 노드 꺼냄
        - 꺼낸 노드를 탐색 순서에 기입 후 인접 리스틔 인접 노드를 스택에 삽입하며 방문 배열 체크
      3. 스택 자료구조에 값이 없을 때까지 반복
        - 2번 과정 반복하며, 다녀간 노드는 재삽입하지 않는 것이 핵심
 */
public class P11724_연결요소의개수 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++){ // 인접리스트 초기화
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){ // A인접 리스트에 그래프 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());

            // 양방향 에지이므로 양쪽에 에지 더하기
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0; // 연결요소의 개수가 count
        for(int i = 1; i < n+1; i++){ // visited false일 때, 연결되는 부분이므로 count++
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if(visited[v]) { // true면 메소드 종료, 방문했다는 뜻 (해당 조건은 재귀함수로 돌릴 때 조건 검사)
            return;
        }

        visited[v] = true;
        for(int i : A[v]){ //향상된 for문으로 A[v]번째 요소를 각각 돌면서 방문했을 때 true로 바꿔준다
            if(visited[i] == false){
                DFS(i);
            }
        }
    }
}
