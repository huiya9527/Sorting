package sort;

public class CountingSort implements SortMethod {
	int upBound = 0;

	public CountingSort(int upBound) {
		this.upBound = upBound;
	}

	@Override
	public void sort(int[] nums) {
		int[] record = new int[upBound];
		int[] afterSort = new int[nums.length];
		int[] order = new int[nums.length];
		for (Integer integer : nums) {
			record[integer]++;
		}
		for (int i = 1; i < upBound; i++) {
			record[i] += record[i - 1];
		}
		for(int i = nums.length-1; i >=0; i--){
			afterSort[record[nums[i]]-1] = nums[i];
			order[record[nums[i]]-1] = i;
			record[nums[i]]--;
		}
		
		for(int i = 0; i < nums.length; i++){
			nums[i] = afterSort[i];
		}
		
	}
}
