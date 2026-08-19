import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayFlattenerTest {

    @Test
    public void testFlattenArray() {

        ArrayFlattener flattener = new ArrayFlattener();

        int[][] input = {
                {1, 3},
                {0},
                {4, 5, 9}
        };

        int[] expected = {1, 3, 0, 4, 5, 9};

        assertArrayEquals(expected,
                flattener.flattenArray(input));
    }
}