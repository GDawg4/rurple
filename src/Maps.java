import java.util.ArrayList;

public class Maps {
    private int[] mapSize = new int[2];
    private ArrayList<Wall> listOfWalls = new ArrayList<>();
    private ArrayList<PileOfCoins> listOfPiles = new ArrayList<>();
    private Robot newRobot;

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
        newRobot = new Robot();
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
        int mapSize = getMapSize(mapText);
        String oneRow;
        char letra;
        for (int i = 0; i < mapSize; i++) {
            oneRow = mapText.get(i);
            for (int s = 0; s < getRowSize(oneRow); s++) {
                letra = oneRow.charAt(s);
                String letter = String.valueOf(letra);
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

    public int getMapSize(ArrayList<String> mapText){
       int size = mapText.size();
       return size;
    }

    public int getRowSize(String row){
        return row.length();
    }

    public String getMap() {
        String finalString = "";
        for(int i = 0; i<15;i++){
            finalString += "\n";
            for (int s = 0; s<15;s++){
                boolean isEmptySpace = true;
                for (Wall searchWall : listOfWalls) {
                    if (searchWall.getCoordinates()[0] == i && searchWall.getCoordinates()[1] == s) {
                        finalString += searchWall;
                        isEmptySpace = false;
                        break;
                    }
                }
                if (newRobot.getCoordinates()[0] == i && newRobot.getCoordinates()[1] == s){
                    finalString += newRobot;
                    isEmptySpace = false;
                }
                for (PileOfCoins searchPiles : listOfPiles){
                    if(searchPiles.getCoordinates()[0] == i && searchPiles.getCoordinates()[1] == s){
                        finalString += searchPiles;
                        isEmptySpace = false;
                        break;
                    }
                }
                if (isEmptySpace){
                    finalString += " ";
                }
            }
        }
        return finalString;
    }

    public void searchForWalls(int direccion){
        //list
        if(direccion == 0){

        }
    }

    public void makeInstructions(){

    }
    @Override
    public String toString() {
        return "Maps{" +
                "listOfWalls=" + listOfWalls +
                ", listOfPiles=" + listOfPiles+ "}";
    }
}
