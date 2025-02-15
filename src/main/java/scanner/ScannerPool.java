package scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerPool {

    private static final List<Scanner> scanners = new ArrayList<>();

    public static Scanner getSystemInScanner() {
        Scanner scanner = new Scanner(System.in);
        scanners.add(scanner);

        return scanner;
    }

    public static void closeAll() {
        for (Scanner scanner : scanners) {
            scanner.close();
        }
    }

}
