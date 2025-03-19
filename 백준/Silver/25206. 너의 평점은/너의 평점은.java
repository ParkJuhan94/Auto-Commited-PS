//package BOJ.Section11.P25206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P25206/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int sumScore = 0;
        double sumGrade = 0;
        Map<String, Double> grades = new HashMap<>();
        grades.put("A+", 4.5);
        grades.put("A0", 4.0);
        grades.put("B+", 3.5);
        grades.put("B0", 3.0);
        grades.put("C+", 2.5);
        grades.put("C0", 2.0);
        grades.put("D+", 1.5);
        grades.put("D0", 1.0);
        grades.put("F", 0.0);

        while ((input = br.readLine()) != null) {
            {
                StringTokenizer st = new StringTokenizer(input);
                st.nextToken();
                double score = Double.parseDouble(st.nextToken());
                String grade = st.nextToken();

                if(grade.equals("P")) {
                    continue;
                }
                sumScore += score;
                sumGrade += score * grades.get(grade);
            }
        }

        System.out.printf("%.6f", sumGrade / sumScore);
    }

}
