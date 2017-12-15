import java.lang.reflect.Array;
import java.util.*;

public class HashTable {
    LinkedList<Node>[] table;
    int size;
    int putCollisions;
    @SuppressWarnings("unchecked")

    public HashTable(int maxSize){
        table = (LinkedList<Node>[]) Array.newInstance(LinkedList.class, maxSize);
        size = 0;
        putCollisions = 0;
    }

    public Object put(Object key, Object value){
        Node put = new Node(key, value);
        int code = key.hashCode();
        if (table[code] == null){
            table[code] = new LinkedList<Node>;
            table[code].add(put);
            size++;
            return null;
        }

        for (int i = 0; i < table[code].size(); i++){
            if (table[code].get(i).key.equals(key)){
                Node output = table[code].get(i);
                table[code].set(i, put);
                return output;
            }
        }
        table[code].add(put);
        putCollisions++;
        size++;
        return null;
    }

    public Object get(Object key){
        int code = key.hashCode();
        if (table[code] == null){
            return false;
        }

        if (table[code].size() == 1){
            return table[code].get(0).value;
        }

        for (int i = 0; i < table[code].size(); i++){
            if (table[code].get(i).key.equals(key)){
                return table[code].get(i).value;
            }
        }

        return false;
    }

    public class Node {
        Object key;
        Object value;
        boolean removed;

        public Node(){
            key = null;
            value = null;
            removed = false;
        }

        public Node(Object k, Object v){
            key = k;
            value = v;
            removed = false;
        }

        public String toString(){
            return removed ? "DUMMY" : "<" + key + ", " + value + ">";
        }
    }

}