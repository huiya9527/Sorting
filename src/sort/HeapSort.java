package sort;

public class HeapSort implements SortMethod {

	@Override
	public void sort(int[] nums) {
		buildMaxHeap(nums);
		for (int i = nums.length - 1; i > 0; i--) {
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			adjustDown(nums, 0, i);
		}
	}

	private void buildMaxHeap(int[] nums) {
		int len = nums.length;
		for (int i = len % 2 == 0 ? len / 2 - 1 : len / 2; i >= 0; i--) {
			adjustDown(nums, i, len);
		}
	}

	private void adjustDown(int[] nums, int k, int len) {
		int temp = nums[k];
		for (int i = 2 * k + 1; i < len; i = 2 * i + 1) {
			if (i < len - 1 && nums[i] < nums[i + 1]) {
				i++;
			}
			if (temp >= nums[i])
				break;
			else {
				nums[k] = nums[i];
				k = i;
			}
		}
		nums[k] = temp;
	}

}
