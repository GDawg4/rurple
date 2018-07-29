public class Robot {
    private int coordinates[] = new int[2];
    private int direction;
    private int coins;

    public String Direction(int direction){
        switch (direction){
            case 0:
                return "^";
            case 1:
                return ">";
            case 2:
                return "<";
            case 3:
                return "v";
        }
        return "Hola";
    }

    @Override
    public String toString() {
        return Direction(direction);
    }
}
