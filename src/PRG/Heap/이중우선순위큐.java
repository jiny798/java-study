package PRG.Heap;
import java.util.*;

class 이중우선순위큐 {
	public static PriorityQueue<Integer> maxHeap ;
	public static PriorityQueue<Integer> minHeap ;

	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for(String str : operations){
			if(str.substring(0,1).equals("I")){

				String[] addStr = str.split(" ");
				minHeap.add(Integer.parseInt(addStr[1]));
				maxHeap.add(Integer.parseInt(addStr[1]));

			}else if(str.substring(0,3).equals("D 1")){
				if(maxHeap.size() == 0){
					continue;
				}
				int n = maxHeap.poll();
				minHeap.remove(n);
			}else{
				if(minHeap.size() == 0){
					continue;
				}
				int n = minHeap.poll();
				maxHeap.remove(n);
			}
		}

		if(maxHeap.size() == 0){
			answer[0] = 0 ;
			answer[1] = 0;
			return answer;
		}
		answer[0] = maxHeap.poll();
		answer[1] = minHeap.poll();

		return answer;
	}
}