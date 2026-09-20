import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class BasicsHashMap {
    public static void main(String[] args) {
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("khokon", 724083);
        // hm.put("imran", 499239);
        // hm.put("rayhan", 121220);
        // hm.put("rakib", 724083);
        // System.out.println(hm);
        // System.out.println("Roll: " + hm.get("khokon"));
        // System.out.println("key exists: " + hm.containsKey("khokon"));
        // System.out.println("value exists: " +hm.containsValue(724083));
        // System.out.println("isEmpty: " + hm.isEmpty());
        // System.out.println("size: " + hm.size());
        // System.out.println("all hashMap keys: " + hm.keySet());
        // System.out.println("all hashMap values: " + hm.values());
        // System.out.println("remove: " + hm.remove("khokon"));
        // System.out.println(hm);
        // hm.replace("rakib", 123456);
        // System.out.println("---------");
        // // hm.clear();
        // // System.out.println(hm);

        // // loop in hashMap
        // Set<String> keys = hm.keySet();
        // for(String k: keys){
        // System.out.println("key: " + k + ", value: " + hm.get(k));
        // }

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("khokon", 724083);
        hm.put("imran", 499239);
        System.out.println(hm);

        // insertion maintains
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("khokon", 724083);
        lhm.put("imran", 499239);
        System.out.println(lhm);

        // key character sorted
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Khokon", 724083);
        tm.put("imran", 499239);
        System.out.println(tm);

    }
}
