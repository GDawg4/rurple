public class Wall {
    private int coordinates[] = new int[2];

    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }

    @Override
    public String toString() {
        return "*" + this.coordinates[0] + this.coordinates[1];
    }
}
