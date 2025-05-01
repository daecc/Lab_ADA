
package lab02;


import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Lab02 {

    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min + 1)) + min; // valores entre min y max
        }

        return array;
    }

    public static int maxSubsequenceSum(int[] arr) {
        int maxCurrent = 0;
        int maxGlobal = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            maxCurrent += arr[i];

            if (maxCurrent < 0) {
                maxCurrent = 0;
                tempStart = i + 1;
            }

            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
                start = tempStart;
                end = i;
            }
        }

        // Mostrar subsecuencia
        if (maxGlobal > 0) {
            System.out.print("Subsecuencia con suma máxima: ");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Todos los números son negativos. Suma máxima = 0");
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números a generar: ");
        int size = scanner.nextInt();

        // Puedes ajustar este rango si deseas otro tipo de valores
        int min = -10;
        int max = 10;

        int[] array = generateRandomArray(size, min, max);
        System.out.println("Arreglo generado: " + Arrays.toString(array));

        int maxSum = maxSubsequenceSum(array);
        System.out.println("Suma máxima de una subsecuencia contigua: " + maxSum);
        
        // Análisis de complejidad asintótica
        System.out.println("\n--- Análisis de Complejidad ---");
        System.out.println("Algoritmo utilizado: Kadane's Algorithm");
        System.out.println("Notación asintótica del tiempo: O(n)");
        System.out.println("Notación asintótica del espacio: O(1)");
    }
}
