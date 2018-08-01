public class Robot {
    private int coordinates[] = new int[2];
    private int direction;
    private int coins = 0;

    public void pickOne(){
        this.coins = +1;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void rotate(){
        this.direction += 1;
        this.direction = direction%4;
    }

    public void move(){
        switch (direction){
            case 0:
                this.coordinates[0] -= 1;
                break;
            case 1:
                this.coordinates[1] += 1;
                break;
            case 2:
                this.coordinates[0] += 1;
                break;
            case 3:
                this.coordinates[1] -= 1;
                break;
        }
    }

    @Override
    public String toString() {
        switch (direction){
            case 0:
                return "^";
            case 1:
                return ">";
            case 2:
                return "v";
            case 3:
                return "<";
        }
        return "";
    }
}
