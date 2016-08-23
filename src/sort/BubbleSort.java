package sort;

public class BubbleSort implements SortMethod {

	@Override
	public void sort(int[] nums) {
		int n = nums.length;
		for(int i = 0; i < n-1; i++){
			boolean swap = false;
			for(int j = n-1; j >i; j--){
				if(nums[j-1] > nums[j]){
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
					swap = true;
				}
			}
			if(!swap){
				break;
			}
		}
	}

}
