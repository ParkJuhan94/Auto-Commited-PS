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
        
        Goverment firstGov = goverments.get(0);
        int prevG = firstGov.g;
        int prevS = firstGov.s;
        int prevC = firstGov.c;
        int rank = 1;
        
        if(firstGov.idx == K) {
            System.out.print(rank);
            return;
        }
        
        for(int i = 1; i < N; i++) {
            Goverment cur = goverments.get(i);
            
            // 전부 같으면 랭킹 그대로 = 하나라도 다르면 랭킹 증가
            if(prevG != cur.g || prevS != cur.s || prevC != cur.c) {                
                rank++;
                prevG = cur.g;
                prevS = cur.s;
                prevC = cur.c;
            }
            
            if(cur.idx == K) {
                System.out.print(rank);
                return;
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
        if(this.g != o.g) return o.g - this.g;
        if(this.s != o.s) return o.s - this.s;
        return o.c - this.c;
    }
}