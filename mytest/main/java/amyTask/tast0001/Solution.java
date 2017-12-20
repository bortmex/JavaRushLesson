package amyTask.tast0001;
/*строка aabcccccaaa должна превратиться в а2b1с5аЗ. Если «сжатая» строка оказывается длиннее исходной, метод должен вернуть исходную строку.*/
public class Solution{
    public static void main(String[] args) {
        System.out.println(compressionOfStr("acrsdaaasats"));
    }

    public static String compressionOfStr(String text) {
        StringBuilder exit = new StringBuilder();
        int indexfortest=0;
        for (int i = 0; i <text.length(); i++) {
            indexfortest++;
            if((i + 1)>=text.length() || text.charAt(i)!=text.charAt(i+1)){
                exit.append("").append(text.charAt(i)).append(indexfortest);
                indexfortest = 0;
            }
        }

        return exit.length()== text.length()*2 ? text : exit.toString();
    }
}
