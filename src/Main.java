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


    }
}
