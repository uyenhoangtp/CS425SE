import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ArrayReversorTest {

    @Test
    public void testReverseArray() {

        ArrayFlattenerService mockService =
                mock(ArrayFlattenerService.class);

        int[][] input = {
                {1,3},
                {0},
                {4,5,9}
        };

        when(mockService.flattenArray(input))
                .thenReturn(new int[]{1,3,0,4,5,9});

        ArrayReversor reversor =
                new ArrayReversor(mockService);

        int[] expected = {9,5,4,0,3,1};

        int[] actual = reversor.reverseArray(input);

        assertArrayEquals(expected, actual);

        verify(mockService, times(1))
                .flattenArray(input);
    }
}