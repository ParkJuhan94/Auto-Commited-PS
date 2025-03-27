//package BOJ.Section11.P11656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P11656/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            arr.add(str.substring(i));
        }

        Collections.sort(arr);
        for(String s : arr) {
            System.out.println(s);
        }
    }

}
