public class QuickUnion {
    private int[] parent;

    public QuickUnion(int N) {
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    public void connect(int p, int q) {
        parent[find(q)] = find(p);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int i) {
        if(parent[i] == -1) return i;
        else return find(parent[i]);
    }
}
