import java.util.LinkedList;

public class HashMapCode {
    // Custom HashMap
    public static class HashMap<K, V> {
        class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of node
        private int N; // number of bucket size
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        // HashMap Constructor
        public HashMap() {
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // hash Functions
        private int hashFunction(K key) {
            int hc = key.hashCode(); // hashCode return any (-number, +number)
            return Math.abs(hc) % N; // bucket index < bucket size
        }

        // find bucket index in LinkedList
        private int findDataInx(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int idx = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return idx;
                }
                idx++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        // rehash bucket
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // put oldBuckets to original buckets
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // put function
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = findDataInx(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            // check
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = findDataInx(key, bi);

            if (di != -1) {
                return true;
            }
            return false;
        }

        // get key to vale
        public V get(K key) {
            int bi = hashFunction(key);
            int di = findDataInx(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        // remove node
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = findDataInx(key, bi);

            if (di != -1) {
                n--;
                return buckets[bi].remove(di).value;
            } else {
                return null;
            }
        }

        public LinkedList<K> setKeys() {
            LinkedList<K> keys = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
        }

        // isEmpty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("khokon", 724083);
        hm.put("Imran", 499239);
        LinkedList<String> ll = hm.setKeys();
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        
        System.out.println("remove: " + hm.remove("khokon"));
    }

}
