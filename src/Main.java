import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //error хочу чтобы пользователь задал размеры матрицы
        int[][] matr = createMatrixOfZeroes();
        printMatr(matr);
        randomize(matr);
        printMatr(matr);
        printLineSums(matr);
        printMaxElement(matr, 1);
        printMaxElement(matr, 2);
        printMaxElement(matr, 3);
    }

    private static void printMaxElement(int[][] matr, int flags) {
        int max = 0, maxI = 0, maxJ = 0;
        int min = matr[0][0], minI = 0, minJ = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (max < matr[i][j]) {
                    max = matr[i][j];
                    maxI = i + 1;
                    maxJ = j + 1;
                }
                if (min > matr[i][j]) {
                    min = matr[i][j];
                    minI = i + 1;
                    minJ = j + 1;

                }
            }
        }
        if (flags == 1)
            IO.println(" Максимальное значение элемента [" + maxI + "][" + maxJ + "] имеет значение " + max);
        if (flags == 2) IO.println(" Максимальное значение в строке [" + maxI + "] имеет значение " + max);
        if (flags == 3) {
            for (int i = 0; i < matr.length; i++) {
                if (minI != (i + 1)) {
                    if (maxI != (i + 1)) {
                        IO.println(" Строка [" + (i + 1) + "] не имеет максимального значения " + max + " и минимального значения " + min);
                    }
                }

            }
        }
    }

    private static int[][] createMatrixOfZeroes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размеры матрицы");
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matr = new int[n][m];
        return matr;
    }

    public static void printMatr(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.printf(" %3d", matr[i][j]);
            }
            System.out.println();
        }
    }

    public static void randomize(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                Random rn = new Random();
                int randomNum = rn.nextInt(100);
                matr[i][j] = randomNum;
            }
        }
    }

    //подсчитать и вывести сумму элементов в каждой строке матрицы
    public static void printLineSums(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            int s = 0;
            for (int j = 0; j < matr[i].length; j++) {
                s += matr[i][j];
            }
            System.out.println("сумма элементов строки " + (i + 1) + " равна " + s);
        }
    }
}

//todo 1) найти максимальный элемент матрицы
//todo 2) вывести столбец, содержащий макксимаьный элемент матрицы
//todo 3) вывести строки, не содержащие минимальноно и максимального элементов