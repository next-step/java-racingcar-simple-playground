package domain;

import java.util.Random;

public class carPos {
    public static int position(int pos) {
        int n;
        Random random = new Random();
        n = random.nextInt(10);
        if (n >= 4) pos += 1;

        return pos;
    }
}
