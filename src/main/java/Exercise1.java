

public class Exercise1 {

	public static void main(String[] args) {

		int[] nums = { 2, 5, 3, 9, 15, 20, 1, 17 };
		int max = Integer.MIN_VALUE;

		if (nums.length == 1) {
			System.out.println(nums[0]);
		} else {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length - 1; j++) {
					int diff = nums[j] - nums[i];
					if (diff > max) {
						max = diff;
					}
				}
			}
			System.out.println(max);
		}
	}
}
