package dynamicprogramming.helper;

public class Matrix {

    public static void print(int[][] arr) {

        System.out.println("{");

        for (int i = 0; i < arr.length; i++) {

            System.out.print("\t{ ");

            for (int j = 0; j < arr[i].length; j++) {

                System.out.printf("%02d ", arr[i][j]);
            }

            System.out.println("}");
        }

        System.out.println("}");
    }
}
