import junit.framework.TestCase;
import org.junit.Test;
import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

public class SimpleFileDBTest {

    @Test
    public void testSize() {
        FileDB fileDB = new SimpleFileDB();
        fileDB.add("blab");
        fileDB.add("dupa");
        TestCase.assertEquals(fileDB.size(), 2);
    }

}



