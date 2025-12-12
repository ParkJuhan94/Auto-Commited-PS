import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        ArrayList<Goverment> goverments = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            goverments.add(new Goverment(idx, g, s, c));
        }
        
        Collections.sort(goverments);
        
        int prevG = goverments.get(0).g;
        int prevS = goverments.get(0).s;
        int prevC = goverments.get(0).c;
        int rank = 1;
        
        for(int i = 1; i < N; i++) {
            Goverment cur = goverments.get(i);
            
            // 같은 등수인지 처리
            if(prevG != cur.g || prevS != cur.s || prevC != cur.c) {                
                rank++;
                prevG = cur.g;
                prevS = cur.s;
                prevC = cur.c;
            }
            
            if(cur.idx == K) {
                System.out.print(rank);
            }
        }
    }
}

class Goverment implements Comparable<Goverment> {
    int idx, g, s, c;
    
    Goverment(int idx, int g, int s, int c) {
        this.idx = idx;
        this.g = g;
        this.s = s;
        this.c = c;        
    }
    
    @Override
    public int compareTo(Goverment o) {
        if(this.g != o.g) return this.g - o.g;
        if(this.s != o.s) return this.s - o.s;
        return this.c - o.c;
    }
}