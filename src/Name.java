/**
 * Created by 216430 on 12/7/2017.
 */

public class Name {
    String first;
    String last;
    int hash;

    public Name(){
        first = "";
        last = "";
    }

    public Name(String f, String l){
        first = f;
        last = l;
        computeHash();
    }

    public void computeHash(){
        int output = 1;
        for (int i = 0; i < first.length(); i++){
            if (first.charAt(i) != 0){
                output *= (i % 2 == 0 ? first.charAt(i) : -first.charAt(i));
            }
        }

        int factor = 0;
        for (int i = 0; i < last.length(); i++){
            factor += last.charAt(i);
        }

        hash = output * factor;
    }

    public int hashCode(){
        return hash;
    }

    public boolean equals(Name n){
        return (first.equals(n.first) && last.equals(n.last));
    }
}
