package sort;

public class BucketSort implements SortMethod {
	
	int upBound = 0;

	public BucketSort(int upBound) {
		this.upBound = upBound;
	}

	@Override
	public void sort(int[] nums) {
		int[] record = new int[upBound];
		for(Integer integer: nums){
			record[integer]++;
		}
		int index=0;
		for(int i = 0; i < upBound; i++){
			while(record[i] > 0){
				nums[index++] = i;
				record[i]--;
			}
		}
	}
}
