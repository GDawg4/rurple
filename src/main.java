import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class main {
    public static void main (String[] args) {
        try{
            Stream<String> lines = Files.lines(
                    Paths.get("C:\\Users\\garoz\\Desktop\\2018 2\\rurple"),
                    StandardCharsets.UTF_8);
                    System.out.println(lines);
        }catch (IOException exception){
            System.out.println("Error");
        }
    }
}
