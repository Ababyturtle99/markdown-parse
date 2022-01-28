import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FailTestFile {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./FailFile3.md"));
        List<String> expect = List.of("SomeLink");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./FailFile2.md"));
        List<String> expect = List.of("");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./FailFile1.md"));
        List<String> expect = List.of("");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
}
