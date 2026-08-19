import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayFlattenerNullTest {

    @Test
    public void testFlattenArrayNull() {

        ArrayFlattener flattener = new ArrayFlattener();

        assertNull(flattener.flattenArray(null));
    }
}