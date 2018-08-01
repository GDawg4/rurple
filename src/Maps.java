import java.util.ArrayList;

public class Maps {
    private int[] mapSize = new int[2];
    public ArrayList<Wall> listOfWalls = new ArrayList<>();
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
                break;
            case ">":
                newRobot.setDirection(1);
                break;
            case "v":
                newRobot.setDirection(2);
                break;
            case "<":
                newRobot.setDirection(3);
                break;
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
                    Wall wall = new Wall(i, s);
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
        for(int i = 0; i<6;i++){
            finalString += "\n";
            for (int s = 0; s<7;s++){
                boolean isEmptySpace = true;
                boolean robotHere = false;
                for (Wall searchWall : listOfWalls) {
                    if (searchWall.getCoordinates()[0] == i && searchWall.getCoordinates()[1] == s) {
                        finalString += searchWall;
                        isEmptySpace = false;
                        break;
                    }
                }
                if (newRobot.getCoordinates()[0] == i && newRobot.getCoordinates()[1] == s){
                    finalString += newRobot.toString();
                    robotHere = true;
                    isEmptySpace = false;

                }
                if(!robotHere) {
                    for (PileOfCoins searchPiles : listOfPiles) {
                        if (searchPiles.getCoordinates()[0] == i && searchPiles.getCoordinates()[1] == s) {
                            finalString += searchPiles;
                            isEmptySpace = false;
                            break;
                        }
                    }
                }
                if (isEmptySpace){
                    finalString += " ";
                }
            }
        }
        return finalString;
    }

    public boolean searchForWalls() {
        for(Wall searchWall: listOfWalls){
            if(newRobot.getDirection() == 0){
                if (searchWall.getCoordinates()[0] == newRobot.getCoordinates()[0]-1 && searchWall.getCoordinates()[1] == newRobot.getCoordinates()[1]){
                    return false;
                }
            }
            else if(newRobot.getDirection() == 1) {
                if (searchWall.getCoordinates()[0] == newRobot.getCoordinates()[0] && searchWall.getCoordinates()[1] == newRobot.getCoordinates()[1]+1) {
                    return false;
                }
            }
            else if(newRobot.getDirection() == 2) {
                if (searchWall.getCoordinates()[0] == newRobot.getCoordinates()[0]+1 && searchWall.getCoordinates()[1] == newRobot.getCoordinates()[1]) {
                    return false;
                }
            }
            else if (newRobot.getDirection() == 3) {
                if (searchWall.getCoordinates()[0] == newRobot.getCoordinates()[0] && searchWall.getCoordinates()[1] == newRobot.getCoordinates()[1]-1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotateRobot(){
        newRobot.rotate();
    }

    public void moveRobot(){
        if (searchForWalls()){
            newRobot.move();
        }
        else{
        }
    }

    public boolean robotOnCoins(){
        for(PileOfCoins testPile : listOfPiles){
            if(testPile.getCoordinates()[0] == newRobot.getCoordinates()[0] && testPile.getCoordinates()[1] == newRobot.getCoordinates()[1] && testPile.getQuantity()>0){
                testPile.takeOne();
                newRobot.pickOne();
                System.out.println(testPile.toString());
                return true;
            }
        }
        return false;
    }

    public void executeInstructions(ArrayList<String> instructions){
        for(String oneInstruction:instructions){
            switch (oneInstruction){
                case "MOVE":
                    this.moveRobot();
                case "ROTATE":
                    this.rotateRobot();
                case "PICK":
                    this.robotOnCoins()
            }
        }
    }
    @Override
    public String toString() {
        return "Maps{" +
                "listOfWalls=" + listOfWalls +
                ", listOfPiles=" + listOfPiles+ "}";
    }
}
