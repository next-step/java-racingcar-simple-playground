package domain;

import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final int NAME_MAX_LENGTH = 5;

    public static String validateName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있을 수 없습니다.");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5자를 넘을 수 없습니다.");
        }
        return name;
    }

    public static <T> void checkRedundancy(final T[] array) {
        if (Arrays.stream(array).distinct().count() != array.length) {
            throw new IllegalArgumentException("중복 값이 존재합니다.");
        }
    }

    public static <T> void conditionalAdd(final List<T> list, final boolean condition, final T value) {
        if (condition) {
            list.add(value);
        }
    }

    public static void checkSizeOfArray(final int[] array, final int length) {
        if (array.length != length) {
            throw new IllegalArgumentException("배열의 크기가 올바르지 않습니다.");
        }
    }

    public static void checkSizeOf2DArray(final int[][] array, final int length1, final int length2) {
        if (array.length != length1) {
            throw new IllegalArgumentException("배열의 크기가 올바르지 않습니다.");
        }
        if (length1 == 0 && length2 != 0) {
            throw new IllegalArgumentException("배열의 크기가 올바르지 않습니다.");
        }
        for (int[] subArray : array) {
            checkSizeOfArray(subArray, length2);
        }
    }
}
