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

    public int[] getCoordinates() {
        return coordinates;
    }

    public void rotate(){
        this.direction += 1;
        this.direction = direction%4;
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
        return "Hola";
    }
}
