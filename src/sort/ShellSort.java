package sort;

public class ShellSort implements SortMethod {

	@Override
	public void sort(int[] nums) {
		for (int step = nums.length / 2; step >= 1; step/=2) {
			for(int i = step; i < nums.length; i++){
				if(nums[i] < nums[i-step]){
					int temp = nums[i];
					int j = i - step;
					for(; j >= 0; j -= step){
						if(nums[j] > temp){
							nums[j+step] = nums[j];
						} else{
							break;
						}
					}
					nums[j+step] = temp;
				}
			}
		}
	}

}
