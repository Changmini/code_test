package baekjoon.level1753;

import java.io.*;
import java.util.*;

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[V+1];
        int[] weight = new int[V+1];    
        ArrayList<Node>[] list = new ArrayList[V+1];
		
        for(int i = 1; i<=V; i++) {
            list[i] = new ArrayList<>();
            weight[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        weight[K] = 0;
        queue.add(new Node(K, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(!visit[now.vertex]) 
            	visit[now.vertex] = true;
            int size = list[now.vertex].size();
            for(int i = 0; i<size; i++) {
                Node next = list[now.vertex].get(i);
                int sumW = now.weight + next.weight;
                if(!visit[next.vertex] && sumW < weight[next.vertex]) {
                	weight[next.vertex] = sumW;
                    queue.add(new Node(next.vertex, weight[next.vertex]));
                }
            }
        }
		
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++) {
            if(weight[i] == Integer.MAX_VALUE) 
            	sb.append("INF").append("\n");
            else sb.append(weight[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}