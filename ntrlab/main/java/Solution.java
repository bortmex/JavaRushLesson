
public class Solution {
    //test cubePlusOne
    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < 10000000; i++) {
            int y = cubePlusOne();
            if(y==7) x++;
        }
        System.out.format("%(.7f",1.0/7);
        System.out.println();
        System.out.println(x*1.0/10000000);
    }

    public static int cube(){
        return (int) (Math.random()*6) + 1;
    }

    public static int cubePlusOne(){
        return (cube() + cube())%7 + 1;
    }
}
