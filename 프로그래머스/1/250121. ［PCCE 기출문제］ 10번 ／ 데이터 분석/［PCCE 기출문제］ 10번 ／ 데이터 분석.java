import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Data[] datas = new Data[data.length];
        for(int i = 0; i < data.length; i++) {
            datas[i] = new Data(data[i][0], data[i][1], data[i][2], data[i][3]);
        }
        
        ArrayList<Data> answers = new ArrayList<>();
        for(Data data_ : datas) {
            int val = -1;
            
            if(ext.equals("code")) {                
                val = data_.code;
            }
            if(ext.equals("date")) {
                val = data_.date;
            }
            if(ext.equals("maximum")) {
                val = data_.maximum;
            }
            if(ext.equals("remain")) {
                val = data_.remain;
            }
            
            if(val < val_ext) {
                answers.add(data_);
            }
        }
        
        Collections.sort(answers, (a, b) -> {
            if (sort_by.equals("code")) {
                return a.code - b.code;
            } else if (sort_by.equals("date")) {
                return a.date - b.date;
            } else if (sort_by.equals("maximum")) {
                return a.maximum - b.maximum;
            } else if (sort_by.equals("remain")) {
                return a.remain - b.remain;
            }
            return 0; // 기본값
        });

        
        int[][] answer = new int[answers.size()][];
        for(int i = 0; i < answer.length; i++) {
            Data data_ = answers.get(i);
            answer[i] = new int[]{data_.code, data_.date, data_.maximum, data_.remain};   
        }
        
        return answer;
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    
    public Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}