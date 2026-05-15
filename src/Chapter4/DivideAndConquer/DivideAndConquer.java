package Chapter4.DivideAndConquer;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sum(nums, 0));
        System.out.println(count(nums, 0));
        System.out.println(max(nums, 0, nums[0]));
    }

    public static int sum(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        } else {
            return numbers[index] + sum(numbers, index + 1);
        }
    }

    public static int count(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return 1;
        } else {
            return 1 + count(numbers, index + 1);
        }
    }

    public static int max(int[] numbers, int index, int maxValue) {
        if (index == numbers.length) {
            return maxValue;
        } else {
            if (numbers[index] > maxValue) {
                maxValue = numbers[index];
            }
            return max(numbers, index + 1, maxValue);
        }
    }
}
