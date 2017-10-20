public class Solution {
    //test cubePlusOne
    public static void main(String[] args) {
        int[] arrx = new int[8];
        for (int i = 0; i < 1000000; i++) {
           arrx[cubePlusOne()]++;
        }
        System.out.print("Нужная вероятность: ");
        System.out.format("%(.2f%%",(1.0/7)*100);
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Мой результат: ");
        for (int i = 0; i < 7; i++) {
            System.out.format("%(.2f%%",arrx[i+1]*1.0/1000000*100);
            System.out.println();
        }
    }

    public static int cube(){
        return (int) (Math.random()*6) + 1;
    }  //1-6

    public static int cubePlusOne(){
        int[][] arr = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 1, 2, 3, 4, 5 },
                { 6, 7, 1, 2, 3, 4 },
                { 5, 6, 7, 1, 2, 3 },
                { 4, 5, 6, 7, 1, 2 },
                { 3, 4, 5, 6, 7, 0 }
        };

        int result = 0;
        while (result == 0){
            int i = cube();
            int j = cube();
            result = arr[i-1][j-1];
        }
        return result;
    }

}
