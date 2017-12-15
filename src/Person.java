/**
 * Created by 216430 on 12/7/2017.
 */
public class Person {
    public Name name;
    String tele;
    String email;
    String creditCard;
    public Person(){
        name = null;
        tele = "";
        email = "";
        creditCard = "";
    }

    public Person(String firstName, String lastName, String t, String e, String c){
        name = new Name(firstName, lastName);
        tele = t;
        email = e;
        creditCard = c;
    }
}
