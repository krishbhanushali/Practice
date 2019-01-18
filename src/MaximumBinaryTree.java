import java.util.Scanner;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { this.val = x;}
}
public class MaximumBinaryTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for(int i = 0 ; i < n ; i++) {
			nums[i] = scanner.nextInt();
		}
		TreeNode node = constructMaximumBinaryTree(nums);
		System.out.println(node.val);
		scanner.close();
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		
		return construct(0,nums.length,nums);
	}
	
	private static TreeNode construct(int start, int end, int[] nums) {
		if (start==end) return null;
		int maxIndex = findMax(start, end, nums);
		TreeNode node = new TreeNode(nums[maxIndex]);
		
		node.left = construct(start,maxIndex,nums);
		node.right = construct(maxIndex+1, end, nums);
		
		return node;
	}
	private static int findMax(int start, int end, int[] nums) {
		int max = Integer.MIN_VALUE;
		int maxIndex = start;
		for(int i=start;i<end;i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
