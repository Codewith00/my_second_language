import java.util.Scanner;

public class JavaVersionHW5 {
    public static void main(String[] Arg) {

        int number = -1;
        int a = 0;
        int b = 1;
        int sum;

        while (number < 0) {
            try {
                System.out.print("Введите порядковый номер числа Фибаначи: ");
                Scanner in = new Scanner(System.in);
                number = in.nextInt();
                if (number < 0) System.out.println("Введено отрицательное значение! Повторите попытку");
            } catch (Exception e) {
                System.out.println("Введено некорректное значение! Повторите попытку");
                number = -1;

            }
        }
        for (int i = 0; i < number; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println("Число Фибаначи: " + a + " под номером: " + number);
    }
}
