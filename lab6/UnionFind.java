public class UnionFind {
    private int[] parent;

    public UnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    public void validate(int v1) throws IllegalArgumentException {
        if(v1 < 0 || v1 >= parent.length)
            throw new IllegalArgumentException("v1 out of bound");
    }

    public int sizeOf(int v1) {
        validate(v1);
        return 0-parent[find(v1)];
    }

    public int parent(int v1) {
        validate(v1);
        return parent[v1];
    }
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if(parent[root1] < parent[root2]) {
            // size of root1 > size of root2
            parent[root1] += parent[root2];
            parent[root2] = root1;
        } else {
            parent[root2] += parent[root1];
            parent[root1] = root2;
        }
    }

    public int find(int v1) {
        validate(v1);
        return findRoot(v1);
    }
    private int findRoot(int v1) {
        if(parent[v1] < 0) return v1;
        else return findRoot(parent[v1]);
    }

}
