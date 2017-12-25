package amyTask.tast002;

//если элемент матрицы NXN равен 0 то вся строка и весь столбец обнуляется
public class Solution {

    private static int[][] testarr = {{1, 23, 34}, {123, 0, 423}, {123, 123, 0}, {23, 23, 12}};

    private static void showMyTestArray() {
        for (int i = 0; i < testarr.length; i++) {
            StringBuilder text = new StringBuilder();
            for (int j = 0; j < testarr[0].length; j++) {
                text.append(Integer.toString(testarr[i][j])).append(" ");
            }
            System.out.println(text.toString().trim());
        }
    }

    public static void main(String[] args) {
        showMyTestArray();
        System.out.println("---------------------------");
        nmx();
        showMyTestArray();
        System.out.println("---------------------------");

        System.out.println(testarr.length);
    }

    private static void nmx() {
        int[] intermediateArr = new int[testarr.length];
        for (int i = 0; i < testarr.length; i++) {
            for (int j = 0; j < testarr[0].length; j++) {
                if (testarr[i][j] == 0) intermediateArr[i] = 1;
            }
        }


        for (int i = 0; i < testarr.length; i++) {
            for (int j = 0; j < testarr[0].length; j++) {
                if (testarr[i][j] == 0) {
                    testarr[i] = new int[testarr.length];
                    break;
                }
            }
        }

        for (int i = 0; i < intermediateArr.length; i++) {
            if (intermediateArr[i] == 1) {
                for (int j = 0; j < testarr.length; j++) {
                    testarr[j][i] = 0;
                }
            }
        }

    }

}
