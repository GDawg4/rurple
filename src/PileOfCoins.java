public class PileOfCoins {
    private int quantity;
    private int coordinates[] = new int[2];

    public void setCoordinates(int x, int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String returnQuantity = String.valueOf(this.quantity);
        return returnQuantity;
    }
}
