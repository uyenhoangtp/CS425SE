public class ArrayFlattener {

    public int[] flattenArray(int[][] input) {

        if (input == null) {
            return null;
        }

        int size = 0;

        for (int[] row : input) {
            size += row.length;
        }

        int[] result = new int[size];

        int index = 0;

        for (int[] row : input) {
            for (int value : row) {
                result[index++] = value;
            }
        }

        return result;
    }
}