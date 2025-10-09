//package WEEK0.P90;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK0/P90/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        //M = Integer.parseInt(st.nextToken());
        ArrayList<String>[] arr = new ArrayList[51];

        for(int i = 0; i <= 50; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            String input = br.readLine();

            if(!arr[input.length()].contains(input)){
                arr[input.length()].add(input);
            }
        }

        for(int i = 1; i <= 50; i++){
            Collections.sort(arr[i]);
        }

        for(int i = 1; i <= 50; i++){
            for(int j = 0; j < arr[i].size(); j++){
                System.out.println(arr[i].get(j));
            }
        }



//        int ans = 0;
//        System.out.println(ans);
    }
}
