package by.itacademy.practice.array;

public class Array {

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public static class Test {

        public void run() {
            int arrMathRandom[];
            int arrKeypad[] = new int[]{1, 35, 234, 5614, 0};
            int arrTwo[][];

            arrTwo = new int[2][3];

            for (int q = 0; q < arrTwo.length; q++) {
                for (int u = 0; u < arrTwo[q].length; u++) {
                    arrTwo[q][u] = (int) (Math.random() * 100);
                }
            }
            //1,2
            arrMathRandom = new int[4];
            System.out.print("Массив, проинициализированный Math.random(): ");
            for (int i = 0; i < arrMathRandom.length; i++) {
                arrMathRandom[i] = (int) (Math.random() * 100);
            }
            this.printArrMathRandom(arrMathRandom);

            System.out.print("Массив, проинициализированный с клавиатуры: ");
            this.printArrKeyPad(arrKeypad);
            //3
            System.out.print("Max значение массива Math.random: ");
            System.out.println(this.maxValue(arrMathRandom));
            System.out.print("Max значение массива с клавиатуры: ");
            System.out.println(this.maxValue(arrKeypad));
            System.out.print("Min значение массива Math.random: ");
            System.out.println(this.minValue(arrMathRandom));
            System.out.print("Min значение массива с клавиатуры: ");
            System.out.println(this.minValue(arrKeypad));
            System.out.print("Среднее значение элементов массива Math.random: ");
            System.out.println(this.averageValue(arrMathRandom));
            System.out.print("Среднее значение элементов массива с клавиатуры: ");
            System.out.println(this.averageValue(arrKeypad));
            //4
            System.out.print("Элементы массива с количеством цифр = 2 (способ 1) массив Math.random: ");
            arrayElementsTwoDigitsMyWay(arrMathRandom);
            System.out.print("Элементы массива с количеством цифр = 2 (способ 1) массив с клавиатуры: ");
            arrayElementsTwoDigitsMyWay(arrKeypad);
            System.out.print("Элементы массива с количеством цифр = 2 (способ подсмотренный в примере) массив Math.random: ");
            arrayElementsTwoDigitsByExample(arrMathRandom);
            System.out.print("Элементы массива с количеством цифр = 2 (способ подсмотренный в примере) массив с клавиатуры: ");
            arrayElementsTwoDigitsByExample(arrKeypad);
            //5
            System.out.print("Элемент массива, цифры в котором идут в строгом порядке возрастания массив Math.random: ");
            findNumberWithIncreasingDigits(arrMathRandom);
            System.out.print("Элемент массива, цифры в котором идут в строгом порядке возрастания массив массив с клавиатуры: ");
            findNumberWithIncreasingDigits(arrKeypad);
            //6
            System.out.print("Массив Math.random в обатном порядке: ");
            this.printArrMathRandom(this.reverse(arrMathRandom));
            System.out.print("Массив с клавиатуры в обатном порядке: ");
            this.printArrKeyPad((this.reverse(arrKeypad)));
            //7
            System.out.print("Сортировка элементов массива Math.random в убывающем порядке: ");
            this.printArrMathRandom(((this.sort(arrMathRandom))));
            System.out.print("Сортировка элементов массива с клавиатуры в убывающем порядке: ");
            this.printArrKeyPad(((this.sort(arrKeypad))));
            //8
            System.out.println("Многомерный массив в виде треугольника: ");
            this.printTwoDimArray((this.triangleArray()));
            //9
            System.out.println("Многомерный массив в виде X: ");
            this.printTwoDimArray((this.xArray()));
            //10
            System.out.println("Исходный массив: ");
            this.printTwoDimArray((arrTwo));
            System.out.println("Повернуть матрицу на 90 градусов против часовой стрелки: ");
            arrTwo = this.toRotateArray(arrTwo);
            this.printTwoDimArray((arrTwo));
            System.out.println("Повернуть матрицу на 180 градусов против часовой стрелки: ");
            arrTwo = this.toRotateArray(arrTwo);
            this.printTwoDimArray((arrTwo));
            System.out.println("Повернуть матрицу на 270 градусов против часовой стрелки: ");
            arrTwo = this.toRotateArray(arrTwo);
            this.printTwoDimArray((arrTwo));
        }

        private void printArrKeyPad(int[] arrKeypad) {
            for (int i = 0; i < arrKeypad.length; i++) {
                System.out.print(arrKeypad[i] + " ");
            }
            System.out.println();
        }

        public void printArrMathRandom(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public int maxValue(int arr[]) {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

        public int minValue(int arr[]) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        public double averageValue(int arr[]) {
            double sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
            }
            double avrValue = (sum / arr.length);
            return avrValue;
        }

        public void arrayElementsTwoDigitsMyWay(int arr[]) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] >= 10 && arr[k] <= 99) {
                    System.out.print(arr[k] + " ");
                }
            }
            System.out.println();
        }

        public void arrayElementsTwoDigitsByExample(int arr[]) {
            boolean isTwoDigitNumber = false; //предположим, что таких чисел нет
            for (int i = 0; i < arr.length; i++) { //проверяем по очереди все элементы массива на количество разрядов 2
                int count = 0; //счетчик - учитывает сколько раз выполнилось условие
                int twoDigitNumber = arr[i];
                while (twoDigitNumber != 0) { //пока цифра не равна 0
                    twoDigitNumber = twoDigitNumber / 10;
                    count++;
                    if (count > 2) { //если счетчик пошел по третьему кругу - break
                        break;
                    }
                }
                if (count == 2) {
                    isTwoDigitNumber = true;
                    System.out.print(arr[i] + " ");
                }
            }
            if (isTwoDigitNumber == false) {
                System.out.print(" таких элементов нет.");
            }
            System.out.println();
        }

        public void findNumberWithIncreasingDigits(int arr[]) {
            boolean isIcreasingDigit = false;
            for (int i = 0; i < arr.length; i++) {
                int count = 0;
                int arrayElement = arr[i];
                if (arrayElement == 0) {
                    count = 1;
                } else {
                    while (arrayElement != 0) {
                        arrayElement /= 10;
                        count++;
                    }
                }

                int element = arr[i];
                for (int j = count; j >= count; j--) {
                    if (count != 1) {
                        int tenInDegree = (int) (Math.pow(10, (count - 1)));
                        int a = (int) (element / tenInDegree);
                        int b = (int) ((element - (element / (tenInDegree) * tenInDegree)) / (Math.pow(10, (count - 2))));
                        if ((a + 1) == b) {
                            element = (int) (element - (element / tenInDegree) * tenInDegree);
                            count--;
                            if (count == 1) {
                                System.out.println(arr[i]);
                                isIcreasingDigit = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (isIcreasingDigit == false) {
                System.out.println(" такого элемента нет.");
            }
        }

        public int[] reverse(int[] arr) {
            int newIndex = arr.length - 1;
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length / 2) {
                    int additionalVariable = arr[i];
                    arr[i] = arr[newIndex];
                    arr[newIndex] = additionalVariable;
                    newIndex--;
                } else if (i == arr.length / 2) {
                    if (i < arr.length) {
                        while (i < arr.length) {
                            i++;
                        }
                    }
                }
            }
            return arr;
        }

        public int[] sort(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int additionalVariable = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = additionalVariable;
                    }
                }

            }
            return arr;
        }

        public void printTwoDimArray(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                this.printArrMathRandom(arr[i]);
            }
        }

        public int[][] triangleArray() {
            int[][] triaArray = new int[5][5];
            for (int i = 0; i < triaArray.length; i++) {
                triaArray[i] = new int[i + 1];
                for (int j = 0; j < triaArray[i].length; j++) {
                    triaArray[i][j] = 1;
                }
            }
            return triaArray;
        }

        public int[][] xArray() {
            int[][] xArray = new int[5][5];
            int i, j;
            for (i = 0; i < xArray.length / 2 + 1; i++) {
                for (j = 0; j < xArray.length; j++) {
                    if ((j < i) || (j >= (xArray[i].length - i))) {
                        xArray[i][j] = 0;
                    } else {
                        xArray[i][j] = 1;
                    }
                }
            }
            for (i = xArray.length - 1; i >= xArray.length / 2; i--) {
                for (j = 0; j < xArray[i].length; j++) {
                    if ((j < (xArray[i].length - 1 - i)) || (j > i)) {
                        xArray[i][j] = 0;
                    } else {
                        xArray[i][j] = 1;
                    }
                }
            }
            for (i = 0; i < xArray.length; i++) {
                for (j = 0; j < xArray[i].length; j++) {
                }
            }
            return xArray;
        }

        public int[][] toRotateArray(int[][] arr) {
            int[][] buf = new int[arr[0].length][arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr[i].length - 1, k = 0; j >= 0; j--, k++) {
                    buf[k][i] = arr[i][j];
                }
            }
            return buf;
        }
    }
}








