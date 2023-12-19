import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {
  private Map<Integer, List<Integer>> adjList;
  // Number of vertices
  private int n;
  public BFS(int n) {
    this.n = n;
    adjList = new HashMap<>();
    for(int i=0; i<n; i++) {
      adjList.put(i, new ArrayList<>());
    }
  }
  // Initialize Directed Graph with edges.
  public BFS(int n, int[][] edges) {
    this.n = n;
    adjList = new HashMap<>();
    for(int i=0; i<n; i++) {
      adjList.put(i, new ArrayList<>());
    }
    for(int[] edge:edges) {
      adjList.get(edge[0]).add(edge[1]);
    }
  }

  public void bfs(int start, Queue<Integer> queue, boolean[] visited) {
    queue.offer(start);
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      // Perform Action
      System.out.println(curr);
      visited[curr] = true;
      for(int neigh:adjList.get(curr)) {
        if(!visited[neigh])
          queue.offer(neigh);
      }
    }
  }
  public int[] topologicalSortBFS(Queue<Integer> queue, boolean[] visited, int[] inDegree) {
    int count=0;
    int[] res = new int[n];
    for(int i=0; i<n; i++) {
      if(inDegree[i]==0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();
//      System.out.println(curr);
      res[count++]=curr;
      for(int neigh:adjList.get(curr)) {
        if (--inDegree[neigh] == 0)
          queue.offer(neigh);
      }
    }
    if(count==n) {
      return res;
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {0, 4}, {4, 2}};
    int[][] cycle = new int[][]{{0, 1}, {1, 2}, {1, 3}, {0, 4}, {4, 2}, {4, 0}};
    int n = 5;
    boolean[] visited = new boolean[n];
    boolean[] path = new boolean[n];
    int[] inDegree = new int[n];
    Queue<Integer> queue = new LinkedList<>();

    BFS bfs = new BFS(n, edges);

    System.out.println("--- BFS ---");
    for (int i=0; i<n; i++){
      if(!visited[i]) {
        bfs.bfs(i, queue,visited);
      }
    }

    System.out.println("--- Topological Sort ---");
    for(int[] edge:edges) {
      inDegree[edge[1]]++;
    }
    int[] res = bfs.topologicalSortBFS(queue, visited, inDegree);
    for(int x:res) {
      System.out.println(x);
    }
  }
}
