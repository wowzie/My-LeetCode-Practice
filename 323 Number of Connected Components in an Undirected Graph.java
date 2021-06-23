class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(n)) {
                dfs(edges, edges[i][0], visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] graph, int start, Set<Integer> visited) {
        visited.add(start);

        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == start && !visited.contains(graph[i][1])) {
                dfs(graph, graph[i][1], visited);
            }
        }
    }
}