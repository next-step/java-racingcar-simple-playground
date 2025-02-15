package view;

import scanner.ScannerPool;

import java.util.Scanner;

public class RacingGameInputView implements RacingGameView {

    private final Scanner scanner = ScannerPool.getSystemInScanner();

    public String getCarNames() {
        System.out.println("������ �ڵ��� �̸��� �Է��ϼ���(�̸��� ��ǥ(,)�� �������� ����).");

        return scanner.nextLine();
    }

    public int getGameCount() {
        System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");

        return scanner.nextInt();
    }

}
