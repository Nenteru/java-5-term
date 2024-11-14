import java.util.Random;

public class MyPasswordGenerator {

    Random rand = new Random();
    String[] buffer = new String[] {
            "!@#$%&*()_+-=[]|,./?><+-=[",
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "01234567890123456789012345"};

    public String getStrongPassword(int num) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; ++i) {
            var idx_i = (int) (Math.abs(Math.random()) * 3);
            var idx_j = (int) (Math.abs(Math.random()) * 26);
            sb.append(buffer[idx_i].toCharArray()[idx_j]);
        }

        return sb.toString();
    }
}