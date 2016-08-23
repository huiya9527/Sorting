package sort;

import java.util.PriorityQueue;

public class HeapSortTwo implements SortMethod {
	@Override
	public void sort(int[] nums) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(Integer integer: nums){
			queue.add(integer);
		}
		int length = nums.length;
		for(int i = 0; i < length; i++){
			nums[i] = queue.poll();
		}

	}

}
