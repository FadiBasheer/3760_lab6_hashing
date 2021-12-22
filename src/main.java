//Fadi Basheer
//A01074701
//Set O
// Count the total number of collisions that occur with each hash table (do not count probes)

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.pow;

public class main {
    public static void main(String[] args) throws IOException {

        //String fn = "37_names.txt";
        //String fn = "333_names.txt";
        String fn = "5163_names.txt";


        String[] number_of_strings = fn.split("_", 0);
        // Call helper function to read the input file
        int n = Integer.parseInt(number_of_strings[0]);
        String[] data = read_array(fn, n);


        //
        //---------------------------------------------------------------
        // MAIN PROGRAM LOGIC HERE
        H1(data, n);
        H2(data, n);
        H3(data, n);

        H1(data, 2 * n);
        H2(data, 2 * n);
        H3(data, 2 * n);

        H1(data, 5 * n);
        H2(data, 5 * n);
        H3(data, 5 * n);

        H1(data, 10 * n);
        H2(data, 10 * n);
        H3(data, 10 * n);
        //---------------------------------------------------------------

    }

    public static void H1(String[] data, int n) {
        String[] hash = new String[n];
        int colision = 0;

        for (int i = 0; i < data.length; i++) {
            int location = 0;
            for (int j = 0; j < data[i].length(); j++) {
                location += (((int) data[i].charAt(j)) - 64);
            }
            location %= n;

            if (hash[location] != null) {
                colision++;
            }

            for (; location < hash.length; location++) {
                if (hash[location] == null) {
                    hash[location] = data[i];
                    break;
                }
                if (location == (hash.length - 1)) {
                    location = -1;
                }
            }
        }
        System.out.print("colision: " + colision);
    }

    public static void H2(String[] data, int n) {
        String[] hash = new String[n];
        int colision = 0;

        for (int i = 0; i < data.length; i++) {
            long location = 0;
            for (int j = 0; j < data[i].length(); j++) {
                location += (((data[i].charAt(j)) - 64) * (pow(26, j)));
            }
            location %= n;

            if (hash[(int) location] != null) {
                colision++;
            }

            for (; location < hash.length; location++) {
                if (hash[(int) location] == null) {
                    hash[(int) location] = data[i];
                    break;
                }
                if (location == (hash.length - 1)) {
                    location = -1;
                }
            }
        }
        System.out.print("  colision: " + colision);
    }

    public static void H3(String[] data, int n) {
        String[] hash = new String[n];
        int colision = 0;

        for (int i = 0; i < data.length; i++) {
            long location = 0;
            for (int j = 0; j < data[i].length(); j++) {
                location += (location * 31) + (((int) data[i].charAt(j)) - 64);
            }
            location %= n;

            if (hash[(int) location] != null) {
                colision++;
            }

            for (; location < hash.length; location++) {
                if (hash[(int) location] == null) {
                    hash[(int) location] = data[i];
                    break;
                }
                if (location == (hash.length - 1)) {
                    location = -1;
                }
            }
        }
        System.out.println("    colision: " + colision);
    }

    public static String[] read_array(String filename, int number_of_strings) throws IOException {
        //
        // Reads the input file given by "filename", assumed to contain a list of
        // integer numbers. Stores the numbers into an array and returns the
        // array.
        //
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String str = sc.next();

        String[] arr_Of_Str = str.split(",", number_of_strings);

        return arr_Of_Str;
    }
}
