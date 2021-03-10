public class Hotel extends Location implements Payable, Classifiable {
    private int rank;
    private double fee;

    public Hotel() {
    }

    ;

    public Hotel(int rank, double fee) {
        this.rank = rank;
        this.fee = fee;
    }

    public Hotel(String name, String description, int rank, double fee, int index) {
        super(name, description, index);
        this.rank = rank;
        this.fee = fee;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public double getFee() {
        return fee;
    }
}
