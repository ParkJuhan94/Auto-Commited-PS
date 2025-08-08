import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Genre> genresQ = new PriorityQueue<>();
        ArrayList<Song> songs = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);            
            songs.add(new Song(genres[i], plays[i], i));
        }                   
        
        // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.        
        for(String key : map.keySet()) {
            genresQ.add(new Genre(key, map.get(key)));
        }
        
        // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 장르 별로 가장 많이 재생된 노래를 최대 두 개까지
        ArrayList<Integer> answerList = new ArrayList<>();
        Collections.sort(songs);
        
        while(!genresQ.isEmpty()) {
            String curGenre = genresQ.poll().genre;            
            int count = 0;
            
            for(int i = 0; i < songs.size(); i++) {                
                Song curSong = songs.get(i);
                
                if(curSong.genre.equals(curGenre)) {
                    System.out.println("song: " + curSong.genre + ", " + curSong.plays + ", " + curSong.idx);
                    answerList.add(curSong.idx);                
                    count++;
                    if(count == 2) break;        
                }
            }
        }

        int[] answer = new int[answerList.size()];        
        for(int i = 0 ; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

class Song implements Comparable<Song>{
    String genre;
    int plays;
    int idx;
    
    public Song(String genre, int plays, int idx) {
        this.genre = genre;
        this.plays = plays;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Song o) {
        if(o.plays != this.plays) {
            return o.plays - this.plays;
        } else {
            return this.idx - o.idx;
        }
    }
}

class Genre implements Comparable<Genre>{
    String genre;
    int plays;
    
    public Genre(String genre, int plays) {
        this.genre = genre;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Genre o) {
        return o.plays - this.plays;
    }
}