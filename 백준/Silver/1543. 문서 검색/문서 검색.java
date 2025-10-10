import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String document = br.readLine();
        String word = br.readLine();
        
        int count = 0;
        int index = 0;
        
        // 문서를 순회하면서 단어 찾기
        while ((index = document.indexOf(word, index)) != -1) {
            count++;
            index += word.length();  // 찾은 단어 길이만큼 건너뛰기
        }
        
        System.out.println(count);
    }
}