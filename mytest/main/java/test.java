import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("d/M/yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        System.out.println("date: " + dateFormat1.parse( "12/12/2004") );
    }
}
