public class Wall {
    private int coordinates[] = new int[2];

    public Wall(int x,int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "*";
    }
}
