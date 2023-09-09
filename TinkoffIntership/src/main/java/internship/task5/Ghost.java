package internship.task5;

import java.util.*;

public class Ghost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Ghost.Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextInt();
            edges.add(new Ghost.Edge(u, v, w));
        }

        edges.sort(Comparator.comparingLong(e -> e.w));

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        long maxWeight = 0;
        int numComponents = n;

        for (int i = m - 1; i >= 0; i--) {
            if (numComponents == 1) {
                break;
            }

            Ghost.Edge edge = edges.get(i);
            int u = edge.u;
            int v = edge.v;
            long w = edge.w;

            int pu = root(parent, u);
            int pv = root(parent, v);

            if (pu != pv) {
                parent[pu] = pv;
                maxWeight = w;
                numComponents--;
            }
        }

        System.out.println(maxWeight - 1);
    }

    static int root(int[] parent, int node) {
        while (node != parent[node]){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    static class Edge {
        int u, v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}