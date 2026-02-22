class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int person_length = schedules.length;
        
        int[] safe_time = new int[person_length];
        // 1. 가능 시간 구하기
        for(int x = 0; x < person_length; x++) {
            safe_time[x] = schedules[x] + 10;
            if(safe_time[x] % 100 >= 60) {
                int div = safe_time[x] % 100 - 60;
                safe_time[x] = (safe_time[x] / 100 + 1) * 100 + div;
            }
        }
        
        // 2. 가능시간에 속한건지 구하기
        for(int x = 0; x < timelogs.length; x++) {
            boolean isTrue = true;
            int person_startday = startday;
            for(int y = 0; y < 7; y++) {
                if (person_startday == 6) {
                    person_startday++;
                    continue;
                }
                else if (person_startday == 7) {
                    person_startday = 1;
                    continue;
                }
                person_startday++;
                if(timelogs[x][y] > safe_time[x]) {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) answer++;
        }
        
        return answer;
    }
}
