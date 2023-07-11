package javaCrashCourse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		leetProblems();
	}

	public static void leetProblems() {

		int[] nums = { 2, 7, 11, 15 };
		int target = 26;
		int[] indeces = twoSumTwo(nums, target);
		int indexOne = indeces[0];
		int indexTwo = indeces[1];
		System.out.print("Output: [" + indexOne + "," + indexTwo + "]");
	}

	public static int[] twoSum(int[] nums, int target) {
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

	public static int[] twoSumTwo(int[] nums, int target) {
		int[] indeces = new int[2];
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (seen.containsKey(target - nums[i])) {
				indeces[0] = seen.get(target - nums[i]);
				indeces[1] = i;
			}
			seen.put(nums[i], i);
		}
		return indeces;
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> uniques = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (uniques.contains(nums[i])) {
				return true;
			}
			uniques.add(nums[i]);
		}
		return false;
	}

	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> anagram = new HashMap<>();
		
		if (s.length()!=t.length())
			return false;
		
		for (char x:s.toCharArray()) {
			anagram.put(x, anagram.getOrDefault(x, 0) + 1);
		}
		
		for (char x:t.toCharArray()) {
			anagram.put(x, anagram.getOrDefault(x, 0) - 1);
		}
		
		for (int val:anagram.values())
			if (val!= 0)
				return false;
		
		return true;

	}

}
