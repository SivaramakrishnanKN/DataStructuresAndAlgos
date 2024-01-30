public class DSU {
    int[] parent;
    int n;
    public DSU() {

    }

    public DSU(int n) {
        this.n = n;
        this.parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX != parentY) {
            for(int i=0; i<parent.length; i++) {
                if(parent[i] == parentY) {
                    parent[i] = parentX;
                }
            }   
        }
    }

    private int find(int x) {
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    private boolean connected(int x, int y) {
        return (find(x) == find(y));
            
    }

    private void print() {
        for(int i=0; i<n; i++) {
            System.out.println("i: "+i + " parent: "+parent[i]);
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        // dsu.union(1, 2);
        dsu.union(0, 3);
        // dsu.union(4, 2);

        dsu.print();
        System.out.println("Connected: "+dsu.connected(1, 3));
    }
    
}
