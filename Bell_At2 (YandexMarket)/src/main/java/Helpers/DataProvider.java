package Helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * ����� ���������� ��� �����
 */
public class DataProvider {
    public static Stream<Arguments> provideCheckingArguments(){
        return Stream.of(
                Arguments.of("������", "����������", "��������", "10000", "90000", "HP", "Lenovo")
        );
    }
}
