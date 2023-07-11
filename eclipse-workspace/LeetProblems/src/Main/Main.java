package Main;

public class Main {

	public void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] indeces = twoSum(nums, target);
		int indexOne = indeces[0];
		int indexTwo = indeces[1];
		System.out.print("Output: [" + indexOne + "," + indexTwo + "]");
	}

	public int[] twoSum(int[] nums, int target) {
		int indexOne = 0;
		int indexTwo = 0;

		for (int firstNumber : nums) {

			for (indexTwo = indexOne + 1; indexOne < nums.length; indexTwo++) {
				if (target == firstNumber + nums[indexTwo]) {
					break;
				}
			}
			if (target == nums[indexOne] + nums[indexTwo]) {
				break;
			}
			indexOne++;

		}
		int[] indeces = { indexOne, indexTwo };
		return indeces;
	}
}