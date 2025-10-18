import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> mapIntKey = new HashMap<>();
        HashMap<String, Integer> mapStringKey = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            mapIntKey.put(i, pokemon);
            mapStringKey.put(pokemon, i);
        }
        
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(isNumeric(input)) {
                System.out.println(mapIntKey.get(Integer.parseInt(input)));
            } else {
                System.out.println(mapStringKey.get(input));
            }            
        }
    }

    public static boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
}
}