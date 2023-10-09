package Study.Map;

import java.util.HashSet;
import java.util.Set;

class SetSolution {
	public int solution(int[] nums) {
		int answer = 0;
		int MAX_PICK_COUNT = nums.length / 2;
		Set<Integer> set = new HashSet<>();

		for (int num : nums){
			set.add(num);
		}

		if(set.size() < MAX_PICK_COUNT){
			return set.size();
		}
		return MAX_PICK_COUNT;
	}

	public static void main(String[] args) {
		SetSolution s = new SetSolution();
		int[] nums = {3,1,2,3};

		System.out.println(s.solution(nums));

	}
}