class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0], x = bandage[1], y = bandage[2];
        int maxHealth = health;
        int cur = health;
        int streak = 0;
        int time = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            // 공격 전까지 회복
            for (int sec = time + 1; sec < attackTime; sec++) {
                streak++;
                cur = Math.min(maxHealth, cur + x);
                if (streak == t) {
                    cur = Math.min(maxHealth, cur + y);
                    streak = 0;
                }
            }
            
            // 공격 받음
            cur -= damage;
            streak = 0;
            time = attackTime;
            
            if (cur <= 0) return -1;
        }
        
        return cur;
    }
}