import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Person> people = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            people.add(new Person(name, day, month, year));
        }
        
        Collections.sort(people);
        
        System.out.println(people.get(n - 1).name);  // 가장 나이 적음
        System.out.println(people.get(0).name);      // 가장 나이 많음
    }
}

class Person implements Comparable<Person> {
    String name;
    int day, month, year;
    
    Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public int compareTo(Person o) {
        if(this.year != o.year) return this.year - o.year;
        if(this.month != o.month) return this.month - o.month;
        return this.day - o.day;
    }
}