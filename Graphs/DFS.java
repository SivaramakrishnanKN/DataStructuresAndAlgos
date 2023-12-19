import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
  private Map<Integer, List<Integer>> adjList;
  // Number of vertices
  private int n;
  public void dfs(int curr, boolean[] visited) {
    visited[curr] = true;
    // Perform action
    System.out.println(curr);
    for(int neigh:adjList.get(curr)) {
      if(!visited[neigh]) {
        dfs(neigh, visited);
      }
    }
  }
  public boolean checkCycle(int curr, boolean[] visited, boolean[] path) {
    if(path[curr])
      return true;
    if(visited[curr])
      return false;
    visited[curr] = true;
    path[curr] = true;
    for(int neigh:adjList.get(curr)) {
      if(checkCycle(neigh, visited, path))
        return true;
    }
    path[curr] = false;

    return false;
  }
  public boolean checkCycleWithColor(int curr, int[] visited) {
    visited[curr] = 1;

    for(int neigh:adjList.get(curr)) {
      if(visited[neigh]==1)
        return true;
      if(visited[neigh]==0 && checkCycleWithColor(neigh, visited)==true)
        return true;
      visited[neigh] = 2;
    }
    return false;
  }
  public boolean topologicalSortDFS(int curr, boolean[] visited, boolean[] path) {
    if(path[curr])
      return true;
    if(visited[curr])
      return false;
    visited[curr] = true;
    path[curr] = true;
    for(int neigh:adjList.get(curr)) {
      if(topologicalSortDFS(neigh, visited, path))
        return true;
    }
    System.out.println(curr);
    path[curr] = false;

    return false;
  }
  public DFS(int n) {
    this.n = n;
    adjList = new HashMap<>();
    for(int i=0; i<n; i++) {
      adjList.put(i, new ArrayList<>());
    }
  }
  // Initialize Directed Graph with edges.
  public DFS(int n, int[][] edges) {
    this.n = n;
    adjList = new HashMap<>();
    for(int i=0; i<n; i++) {
      adjList.put(i, new ArrayList<>());
    }
    for(int[] edge:edges) {
      adjList.get(edge[0]).add(edge[1]);
    }
  }

  public static void main(String[] args) {
    int[][] edges = new int[][] {{0,1}, {1,2}, {1,3}, {0,4}, {4,2}};
    int[][] cycle = new int[][] {{0,1}, {1,2}, {1,3}, {0,4}, {4,2}, {4,0}};
    int n=5;
    boolean[] visited = new boolean[n];
    boolean[] path = new boolean[n];
    DFS dfs = new DFS(n, edges);

    System.out.println("--- DFS ---");
    dfs.dfs(0, visited);

    System.out.println("--- Topological Sort ---");
    Arrays.fill(visited, false);
    for(int i=0; i<n; i++) {
      if(!visited[i]) {
        if(dfs.topologicalSortDFS(0, visited, path)) {
          System.out.println("Cycle detected!");
          break;
        }
      }
    }

    DFS cycleGraph = new DFS(n, cycle);

    System.out.println("--- Detect Cycle ---");
    Arrays.fill(visited, false);
//    cycleGraph.checkCycle(0, visited, path);
    for(int i=0; i<n; i++) {
        if(cycleGraph.checkCycle(0, visited, path)) {
          System.out.println("Cycle detected!");
          break;
        }
    }
    System.out.println("--- Detect Cycle With Color ---");
    int[] color = new int[n];
    for(int i=0; i<n; i++) {
      if(cycleGraph.checkCycleWithColor(0, color)) {
        System.out.println("Cycle detected!");
        break;
      }
    }
  }
}
