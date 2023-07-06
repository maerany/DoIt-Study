package doitStudy.search.depthFirstSearch;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/?ref=gcse
// Java program to print connected components in
// an undirected graph

public class DFS_Exam {
    // Driver code
    public static void main(String[] args) {
        // Create a graph given in the above diagram
        DFS_Exam g = new DFS_Exam(7);

        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 6);
        System.out.println(
                "Following are connected components");
        g.connectedComponents();
    }

    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices in graph)
    int V; //정점의 수
    ArrayList<ArrayList<Integer> > adjListArray; //인접 리스트

    DFS_Exam(int V) {  // constructor
        this.V = V;
        // define the size of array as number of vertices
        adjListArray = new ArrayList<>();

        // 각각의 정점 노드마다 새로운 리스트 생성
        // 인접 노드가 저장될 수 있도록
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }

    void addEdge(int src, int dest) { // 무방향 그래프에 간선 추가
        // src로부터 dest 에지 추가
        adjListArray.get(src).add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }

    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited);
        }
    }
    void connectedComponents() {
        // Mark all the vertices as not visited

        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

}

