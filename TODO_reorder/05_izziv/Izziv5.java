import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

    /*
                    [2, 3, 1, -1, 4, -5, 3]
                    /                       \
            [2, 3, 1, -1 ]                 [4, -5, 3]
            /         \                     /          \
        [2, 3]      [1, -1]              [4, -5]        [3]
        /   \         /   \               /   \            \ 
     [2]    [3]     [1]   [-1]           [4]  [-5]          \ 
      |      |       |     |              |    |              \
      2      3       1     -1             4    -5              3
    cross([2,3])=5  cross([1,-1])=1    cross([4,-5])=4   cross([3]])=3
    max(2,3,5)       max(1,-1,1)         max(4,-5,4)        max(3,3)
        \               /                      \             /
          5           1                         4           3
          cross[2,3,1,-1]=6                    cross([4,-5,3])=3
          max(5,1,6)                             max(4,3,3)
                    \                              /
                     6                            4
                        cross([2,3,1,-1,4,-5,3])=5+4 = 9
                                max(6,4,9)
                                    |
                                    9

    */

public class Izziv5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        ArrayList<Integer> arr = new ArrayList<>();

        while (sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }
        sc.close();
        maxSubArrSum(arr);
    }

    private static int maxSubArrSum(List<Integer> arr) {
        // length of 1
        if (arr.size() == 1) {
            System.out.printf("%s: %d\n", arr.toString(), arr.get(0));
            return arr.get(0);
        }

        int middle = (arr.size()+1) / 2;

        int max = max(
            maxSubArrSum(arr.subList(0, middle)),
            maxSubArrSum(arr.subList(middle, arr.size())),
            maxCrossingSum(arr, middle)
        );
        System.out.printf("%s: %d\n", arr.toString(), max);
        return max;
    }

    private static int maxCrossingSum(List<Integer> arr, int middle) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = middle-1; i >= 0; i--) {
            sum += arr.get(i);
            if (sum > left_sum) 
                left_sum = sum;
        }

        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = middle; i < arr.size(); i++) {
            sum += arr.get(i);
            if (sum > right_sum) 
                right_sum = sum;
        }

        return max(
            left_sum + right_sum,
            left_sum,
            right_sum      
        );
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a,b), c);
    }

}