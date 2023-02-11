package DZ3;

import java.time.temporal.ValueRange;
import java.util.InputMismatchException;
import java.util.Scanner;

public class navigator {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Integer max = 25;

        int m = getNumberByUser("Введите размерность карты M от 1 до " + max, max);
        int n = getNumberByUser("Введите размерность карты N от 1 до " + max, max);

        int x = getcoordByUser("Введите координату X фигуры ", m);
        int y = getcoordByUser("Введите координату Y фигуры ", n);
        //новая размерность сетки
        m=m-x;
        n=n-y;
        //вывод количества путей
        System.out.println(numberOfPaths(m, n));
    }

    public static int getNumberByUser(String text, int max) {
        
        Integer num = 0;
        boolean flag=false;
        while (!flag) {
                System.out.println(text);
        try {
            num = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("ошибка формата входных данных");
            System.exit(1);
        }
        
        // System.out.println(text);
        if (ValueRange.of(1, max).isValidIntValue(num)) {
            // System.out.println("В5веденное в диапазоне");
            flag=true;
        } else {
            System.out.println("Введенное значение вне диапазона");
            // System.exit(1);

        }
    }
        return num;
    }

    public static int getcoordByUser(String text, int m) {
        System.out.println(text);
        Integer num = 0;
        boolean flag=false;
            while (!flag) {
        
        
        try {
            num = input.nextInt();


        } catch (InputMismatchException e) {
            
            System.out.println("ошибка формата входных данных");
            System.exit(1);
        }

        if (ValueRange.of(1, m).isValidIntValue(num)) {
           
            flag=true;
        } else {
            
            System.out.println("Введенное значение превышает размерность карты");
            
        }
        if (num==1) {
           
            num=0;
        }
    }
            return num;
    }

        //количество путей
        static long numberOfPaths(int m, int n)
        {
            int count[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                count[i][0] = 1;
            for (int j = 0; j < n; j++)
                count[0][j] = 1;
     
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++)
     
                    count[i][j]
                        = count[i - 1][j]
                          + count[i]
                                 [j - 1]; 
            }
            return count[m - 1][n - 1];
        }
    
}
