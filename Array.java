package ru.geekbrains;

public class Array {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public void oneMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();//старт отчета времени выполнения
        calculate(arr);
        long finishTime = System.currentTimeMillis();// финиш отчета выполнения
        long elapsedTime = finishTime - startTime;
        System.out.printf("Первый метод->\nВремя работы составило %d мс\n\n", elapsedTime);
    }

    public void twoMethod() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        calculate(arr1);
        calculate(arr2);

        /*new Thread() {
            public void run() {
                float[] a1 = calculate(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = calculate(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();*/

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        long finishTime = System.currentTimeMillis();// финиш отчета выполнения
        long elapsedTime = finishTime - startTime;
        System.out.printf("Второй метод->\nВремя работы составило %d мс\n", elapsedTime);


    }

    /**
     * Метод проходит по всему массиву и для каждой ячейки считает новое значение
     * @param arr массив
     * @return массив
     */
    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }
}
