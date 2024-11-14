import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var num = Integer.parseInt(args[0]);

        MyPasswordGenerator pg = new MyPasswordGenerator();
        var password = pg.getStrongPassword(num);

        System.out.println(password);
    }
}

