import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;


public class main {
    public static void main (String[] args) {
        ArrayList<String> map = new ArrayList<>();
        ArrayList<String> commands = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto que contiene el mapa");
        String mapPath = input.nextLine();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get(mapPath),
                    StandardCharsets.UTF_8);
                    lines.forEach(s -> map.add(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        Maps mapToSolve = new Maps();
        mapToSolve.createMap(map);
        mapToSolve.setBareText(map);

        input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto que contiene las instrucciones");
        String directionsPath = input.nextLine();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get(directionsPath),
                    StandardCharsets.UTF_8);
            lines.forEach(s -> commands.add(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        mapToSolve.executeInstructions(commands);
    }
}
