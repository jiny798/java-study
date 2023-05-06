package PRG.hash;

import java.util.*;

public class Solution5 {
    public int[] solution(String[] genres, int[] plays) {
        Map<Integer,Integer> playMap = new HashMap<>(); // 고유번호 , 플레이 횟수 (0,500)
        Map<String,Integer> sumMap = new HashMap<>(); // 장르 , 플레이 총합  (classic, 1450)
        Map<String,List<Map.Entry<Integer,Integer>> > genMap = new HashMap<>(); // 장르 , 장르별 고유번호,재생횟수 리스트 (classic 1,500 2,150 3,800)
        List<Integer> answer = new ArrayList<>();

        for(int i=0;i<plays.length;i++){
            playMap.put(i,plays[i]);
            if (sumMap.get(genres[i]) == null){  // genres[] = classic , pop ...
                sumMap.put(genres[i],plays[i]);

                List<Map.Entry<Integer,Integer>> list = new ArrayList<>(); // 새로 생성해서 재생횟수 삽입
                Map.Entry<Integer,Integer> entry = new AbstractMap.SimpleEntry<>(i,plays[i]);
                list.add(entry);
                genMap.put(genres[i],list);
            }else{
                sumMap.put(genres[i], sumMap.get(genres[i])+plays[i]);

                List<Map.Entry<Integer,Integer>> list = genMap.get(genres[i]); //기존 리스트 갱신
                Map.Entry<Integer,Integer> entry = new AbstractMap.SimpleEntry<>(i,plays[i]);
                list.add(entry);
                genMap.put(genres[i],list);
            }
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : sumMap.entrySet()){ 
            entryList.add(entry);
        }

        Collections.sort(entryList,((o1, o2) -> { //  o1 -> [장르 , 총재생횟수]
            return o2.getValue().compareTo(o1.getValue());
        })); // 클래식 2000 , 팝 1300 등 내림차순

        for(Map.Entry<String,Integer> entry : entryList){
            String genre = entry.getKey(); //재생횟수 높은 순서대로 가져오기

            List<Map.Entry<Integer,Integer>> playList = genMap.get(genre); // 클래식 고유번호,재생횟수 가져오기 -> [0,500 1,150 2,800]

            if(playList.size()>=2) {
                Collections.sort(playList, (o1, o2) -> {
                    if (o1.getValue() != o2.getValue()) {
                        return o2.getValue() - o1.getValue();
                    } else {
                        return o1.getKey() - o2.getKey();
                    }
                });
            }
            playList.stream().limit(2).forEach( e -> {
                answer.add(e.getKey());
            });
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
