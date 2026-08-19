public class ArrayReversor {

    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] input) {

        if (input == null) {
            return null;
        }

        int[] flattened = arrayFlattenerService.flattenArray(input);

        int[] reversed = new int[flattened.length];

        for (int i = 0; i < flattened.length; i++) {
            reversed[i] = flattened[flattened.length - 1 - i];
        }

        return reversed;
    }
}