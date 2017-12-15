import java.lang.reflect.Array;
import java.util.*;

public class HashTable {
    LinkedList<Node>[] table;
    int size;
    int putCollisions;
    int searchCollisions;
    @SuppressWarnings("unchecked")

    public HashTable(int maxSize){
        table = (LinkedList<Node>[]) Array.newInstance(LinkedList.class, maxSize);
        size = 0;
        putCollisions = 0;
        searchCollisions = 0;
    }

    public Object put(Object key, Object value){
        Node put = new Node(key, value);
        int code = key.hashCode();
        if (table[code] == null){
            table[code] = new LinkedList<Node>();
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
            searchCollisions++;
        }

        return false;
    }

    public String toString(){
        String output = "[";
        for(int i = 0; i < table.length-1; i++){
            output += "[";
            for (int j = 0; j < table[i].size()-1; j++){
                output += table[i].get(i).toString() + ", ";
            }
            output += table[i].getLast().toString() + "]\n";
        }
        output += "[";
        for (int j = 0; j < table[table.length-1].size()-1; j++){
            output += table[table.length-1].get(j).toString() + ", ";
        }
        output += table[table.length-1].getLast().toString() + "]]";
        return output;

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