public class App {
    // metodo sort
    public static void sort(int[] array) {
        int aux;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // crear un array de 10 elementos y rellena con numeros aleatorios
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        // mostrar el array en una linea
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // ordenar el array
        sort(array);

        // mostrar el array en una linea
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
