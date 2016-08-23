package sort;

public class InsertionSort implements SortMethod {
	@Override
	public void sort(int[] nums) {
		for(int i = 1; i < nums.length; i++){
			if(nums[i] < nums[i-1]){
				int temp = nums[i];
				int j = i-1;
				for(; j >= 0; j--){
					if(nums[j] > temp){
						nums[j+1] = nums[j];
					} else{
						break;
					}
				}
				nums[j+1] = temp;
			}
		}
	}

}
