package sort;

public class SelectSort implements SortMethod {

	@Override
	public void sort(int[] nums) {
		int n = nums.length;
		for(int i = 0; i < n-1; i++){
			int minIndex = i;
			for(int j = i+1; j < n; j++){
				if(nums[j] < nums[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}
	}

}
