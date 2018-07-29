public class Robot {
    private int coordinates[] = new int[2];
    private int direction;
    private int coins = 0;

    public void setCoordinates(int x, int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String Direction(int direction){
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
        return "Hola";
    }

    @Override
    public String toString() {
        return Direction(direction);
    }
}
