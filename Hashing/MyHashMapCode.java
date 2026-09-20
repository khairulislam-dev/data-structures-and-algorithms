import java.util.LinkedList;

public class MyHashMapCode {
    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1, 22);
        hm.put(3, 22);
        hm.put(4, 22);
        System.out.println(hm);
    }
}

class MyHashMap {
    private class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int n; // number of node
    private int N ; // bucket size
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.n = 0;
        this.N = 4;
        this.buckets = new LinkedList[4];

        for (int i = 0; i < 4; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // hash function
    private int hashFun(int key) {
        return (Integer.hashCode(key) & 0x7fffffff) % N;

        // int hc = Integer.hashCode(key);
        // return Math.abs(hc) % N;
    }

    // search in ll
    private int searchInLL(int key) {
        int bi = hashFun(key);
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key == key) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    // rehash
    private void rehash() {
        LinkedList<Node> oldBuckets[] = buckets;
        buckets = new LinkedList[N * 2];
        N = N * 2;
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        n = 0;

        for (int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node> ll = oldBuckets[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node = ll.get(j);
                put(node.key, node.val);
            }
        }
    }

    public void put(int key, int value) {
        int bi = hashFun(key);
        int di = searchInLL(key);

        if (di != -1) {
            buckets[bi].get(di).val = value;
        } else {
            buckets[bi].add(new Node(key, value));
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 0.75) {
            rehash();
        }
    }

    public int get(int key) {
        int bi = hashFun(key);
        int di = searchInLL(key);

        if (di != -1) {
            return buckets[bi].get(di).val;
        }
        return -1;
    }

    public void remove(int key) {
        int bi = hashFun(key);
        int di = searchInLL(key);

        if (di != -1) {
            buckets[bi].remove(di);
            n--;
        }
    }
}
