import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("output.csv"));
        Scanner in = new Scanner(new File("Large Data Set.txt"));
        ArrayList<Double> loadFactors = new ArrayList<>();
        for (double i = .1; i <= 1; i += .1){
            loadFactors.add(i);
        }

        ArrayList<Person> input = new ArrayList<>();
        while(in.hasNext()){
            Person p = new Person(in.next(), in.next(), in.next(), in.next(), in.next());
            input.add(p);
        }

        writer.println("Load Factor,Average Probes Per Insertion,Average Insertion Time,Average Search Time (Successful),Average Probes Per Search (Successful),Average Probes to Find Absent Element,Average Search Time (Unsuccessful)");


    }
}
