import java.io.*;
import java.util.*;

class BFS{
    public static void main(String args[]) throws IOException{
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        for(int i=0; i<=v; i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0; i<e; i++){
            String inp[]=br.readLine().split(" ");
            int u=Integer.parseInt(inp[0]);
            int w=Integer.parseInt(inp[1]);
            addEdge(adj,u,w);
        }
        System.out.println("Printing BFS:"+printBfs(adj, v));

    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);

    }
    public static ArrayList<Integer> printBfs(ArrayList<ArrayList<Integer>> adj, int V){
        int[] visited = new int[V+1];
        ArrayList<Integer> bfs = new ArrayList<>();
        for(int i=0; i<=V; i++)
            visited[i]=0;
        for(int i=1;i<=V; i++){
            if(visited[i]==0)
                bfsCall(adj, V, i, bfs, visited);
        }

        return bfs;
    }
    public static void bfsCall(ArrayList<ArrayList<Integer>> adj, int V, int i, ArrayList<Integer> bfs, int[] visited){
        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        visited[i]=1;
        while(q.size()>0){
            int popped = q.poll();
            for(Integer it:adj.get(popped)){
                if(visited[it]!=1){
                    q.add(it);
                    visited[it]=1;
                }
            }
            bfs.add(popped);
        }
    }
}