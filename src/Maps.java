import java.util.ArrayList;

public class Maps {
    private int[] mapSize = new int[2];
    ArrayList<Wall> listOfWalls = new ArrayList<Wall>();
    ArrayList<PileOfCoins> listOfPiles = new ArrayList<>();
    ArrayList<BlankSpaces> listOfBlankSpaces = new ArrayList<>();

    public boolean hasCoins(String stringToCheck){
        try{
            int number = Integer.valueOf(stringToCheck);
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

    public void createCoins(String numberOfCoins, int x, int y){
        int newCoins = Integer.valueOf(numberOfCoins);
        PileOfCoins newPile = new PileOfCoins();
        newPile.setQuantity(newCoins);
        newPile.setCoordinates(x,y);
        listOfPiles.add(newPile);
    }

    public boolean hasRobot(String stringToCheck){
        if (stringToCheck.equals("^") || stringToCheck.equals("<") || stringToCheck.equals(">") || stringToCheck.equals("v")){
            return true;
        }
        return false;
    }

    public void createRobot(String robotLetter, int x, int y){
        Robot newRobot = new Robot();
        newRobot.setCoordinates(x,y);
        switch (robotLetter){
            case "^":
                newRobot.setDirection(0);
            case ">":
                newRobot.setDirection(1);
            case "v":
                newRobot.setDirection(2);
            case "<":
                newRobot.setDirection(3);
        }
    }

    public void createMap(ArrayList<String> mapText) {
        int[] mapSize = this.getMapSize(mapText);
        String oneRow;
        char letra;
        for (int i = 0; i < mapSize[0]; i++) {
            oneRow = mapText.get(i);
            for (int s = 0; s < mapSize[1]; s++) {
                letra = oneRow.charAt(s);
                String letter = String.valueOf(letra);
                System.out.println(letter);
                if (letter.equals("*")){
                    Wall wall = new Wall();
                    wall.setCoordinates(i,s);
                    listOfWalls.add(wall);
                }
                else if(hasCoins(letter)){
                    createCoins(letter, i, s);
                }
                else if(hasRobot(letter)){
                    createRobot(letter, i ,s);
                }
            }
        }
    }

    public int[] getMapSize(ArrayList<String> mapText){
       int[] size = new int[2];
       size[0] = mapText.size();
       size[1] = mapText.get(1).length();
       return size;
    }

    public String getMap(){
            for(int i = 0; i<4; i++){
                for (int s = 0; s<6;s++){
                }
            }
    }
    @Override
    public String toString() {
        return "Maps{" +
                "listOfWalls=" + listOfWalls +
                ", listOfPiles=" + listOfPiles +
                ", listOfBlankSpaces=" + listOfBlankSpaces +
                '}';
    }
}
