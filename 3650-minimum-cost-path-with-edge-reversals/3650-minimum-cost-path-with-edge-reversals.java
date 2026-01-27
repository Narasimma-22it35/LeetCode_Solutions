import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    static class State {
        int node;
        long dist;

        State(int n, long d) {
            node = n;
            dist = d;
        }
    }

    public int minCost(int n, int[][] edges) {

        int N = 2 * n; // two layers
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            // Normal edges (no switch usage)
            graph.get(u).add(new Edge(v, w));
            graph.get(u + n).add(new Edge(v + n, w));

            // Reverse edge using switch at v
            // Allow reversal from BOTH layers
            graph.get(v).add(new Edge(u + n, 2 * w));
            graph.get(v + n).add(new Edge(u + n, 2 * w));
        }

        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.dist, b.dist)
        );

        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist > dist[cur.node]) continue;

            for (Edge e : graph.get(cur.node)) {
                long nd = cur.dist + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new State(e.to, nd));
                }
            }
        }

        long ans = Math.min(dist[n - 1], dist[2 * n - 1]);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
