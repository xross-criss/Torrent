import junit.framework.TestCase;
import org.junit.Test;
import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

public class SimpleFileDBTest {

    @Test
    public void testSize() {
        FileDB fileDB = new SimpleFileDB();
        TestCase.assertEquals(fileDB.size(), 2);
    }

}



