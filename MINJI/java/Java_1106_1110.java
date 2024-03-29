// 로또의 최고 순위와 최저 순위
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;
        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }
        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }
        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;
        return new int[] {maxRank, minRank};
    }
}

// 숫자 짝꿍
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = {0,0,0,0,0,0,0,0,0,0};
        int[] y = {0,0,0,0,0,0,0,0,0,0};
        for(int i=0; i<X.length();i++){
           x[X.charAt(i)-48] += 1;
        }
        for(int i=0; i<Y.length();i++){
           y[Y.charAt(i)-48] += 1;
        }
        for(int i=9; i >= 0; i--){
            for(int j=0; j<Math.min(x[i],y[i]); j++){
                answer.append(i);
            }
        }
        if("".equals(answer.toString())){
           return "-1";
        }else if(answer.toString().charAt(0)==48){
           return "0";
        }else {
            return answer.toString();
        }
    }
}

// 체육복
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(reserve[j] == lost[i]) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        return answer;
    }
}

// 완주하지 못한 선수
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for(String player : completion) map.put(player, map.get(player) - 1);
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); 
        while(iter.hasNext()) { 
            Map.Entry<String, Integer> entry = iter.next(); 
            if(entry.getValue() != 0) { 
                answer = entry.getKey();
                break; 
            } 
        } 
        return answer;
    }
}

// 문자열 나누기
class Solution {
    public int solution(String s) {
        char first = s.charAt(0);
		int firstNum = 0;
		int diff = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (firstNum == diff) {
				result++;
				first = s.charAt(i);
			}
			if (s.charAt(i) == first) firstNum++;
			else diff++;
		}
		return result;
    }
}

// 대충 만든 자판
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                if(map.containsKey(keymap[i].charAt(j))) {
                    Integer nCurrCnt = map.get(keymap[i].charAt(j));
                    if (nCurrCnt > (j + 1)) {
                        map.put(keymap[i].charAt(j), j + 1);
                    }
                }
                else {
                    map.put(keymap[i].charAt(j), j + 1);
                }
                
            }
        }
        for(int i = 0; i < targets.length; i++) {
            int nCnt = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                char alpha = (targets[i].charAt(j));
                Integer nMinClick = map.get(alpha);
                if( nMinClick != null ) {
                    nCnt += nMinClick;
                } else {
                    nCnt = -1;
                    break;
                }
            }
            answer[i] = nCnt;
        }
        return answer;
    }
}
