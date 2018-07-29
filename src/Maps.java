import java.awt.*;
import java.sql.Types;
import java.util.ArrayList;

public class Maps {
    ArrayList<Wall> listOfWalls = new ArrayList<Wall>();
    ArrayList<PileOfCoins> listOfPiles = new ArrayList<>();
    ArrayList<BlankSpaces> listOfBlankSpaces = new ArrayList<>();

    public boolean checkNumber(char charToCheck){
        try{
            int number = charToCheck;
            if (1<=number && number<=9){
                return true;
            }
            else {
                return false;
            }
        }catch (NumberFormatException exception){
            return false;
        }
    }


    public void getMap(ArrayList<String> mapText) {
        String oneRow;
        char letra;
        int positionX;
        int positionY;
        ArrayList<String> listOfTiles = new ArrayList<>();
        System.out.println(mapText);
        for (int i = 0; i < mapText.size(); i++) {
            oneRow = mapText.get(i);
            for (int s = 0; s < mapText.get(i).length(); s++) {
                letra = oneRow.charAt(s);
                String letter = String.valueOf(letra);
                if (letter.equals("*")){
                    Wall wall = new Wall();
                    wall.setCoordinates(i,s);
                }
            }
        }
    }
}
