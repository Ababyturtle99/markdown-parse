import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarkdownParseTest {
    @Test
    public void test1() throws IOException {
        Path filename = Path.of("test-file.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://something.com", "some-page.html");
        assertEquals(links, expected);
    }

    @Test
    public void test2() throws IOException {
        Path filename = Path.of("test2.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of();
        assertEquals(links, expected);
    }

    @Test
    public void test3() throws IOException {
        Path filename = Path.of("test3.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("space in url");
        assertEquals(expected, links);
    }


    @Test
    public void  testLabTest1() throws IOException{
        Path filename = Path.of("labTest1.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, links);
    }

    @Test
    public void  testLabTest2() throws IOException{
        Path filename = Path.of("labTest2.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("a.com(())", "example.com");
        assertEquals(expected, links);
    }

    @Test
    public void  testLabTest3() throws IOException{
        Path filename = Path.of("labTest3.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, links);
    }
}