import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ArrayReversorNullTest {

    @Test
    public void testReverseArrayNull() {

        ArrayFlattenerService mockService =
                mock(ArrayFlattenerService.class);

        ArrayReversor reversor =
                new ArrayReversor(mockService);

        int[] result = reversor.reverseArray(null);

        assertNull(result);

        verify(mockService, never())
                .flattenArray(any());
    }
}