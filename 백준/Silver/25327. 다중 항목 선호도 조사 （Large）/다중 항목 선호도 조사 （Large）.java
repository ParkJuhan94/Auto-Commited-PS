//package BOJ.Section11.P25327;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static Map<String, Integer> preferenceCountMap;
    static String[] originQuery;
    static String[] subjects = {"kor", "eng", "math"};
    static String[] fruits = {"apple", "pear", "orange"};
    static String[] colors = {"red", "blue", "green"};

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P25327/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preferenceCountMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            preferenceCountMap.put(key, preferenceCountMap.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            originQuery = br.readLine().split(" ");
            count = 0;
            dfs(0, new String[3]);
            System.out.println(count);
        }
    }

    static void dfs(int depth, String[] nextQuery) {
        if (depth == 3) {
            String key = String.join(" ", nextQuery);
            count += preferenceCountMap.getOrDefault(key, 0);
            return;
        }

        String[] options;
        if (depth == 0) options = subjects;
        else if (depth == 1) options = fruits;
        else options = colors;

        if(originQuery[depth].equals("-")) {
            for(String option : options) {
                nextQuery[depth] = option;
                dfs(depth + 1, nextQuery);
            }
        } else {
            nextQuery[depth] = originQuery[depth];
            dfs(depth + 1, nextQuery);
        }
    }


}

