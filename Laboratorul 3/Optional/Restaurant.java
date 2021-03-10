import java.time.LocalTime;

public class Restaurant extends Location implements Payable, Visitable, Classifiable {
    private double fee;
    private int rank;
    private LocalTime opening, closing;

    public Restaurant() {
    }

    ;

    public Restaurant(double fee, int rank, LocalTime opening, LocalTime closing) {
        this.fee = fee;
        this.rank = rank;
        this.opening = opening;
        this.closing = closing;
    }

    public Restaurant(String name, String description, double fee, int rank, LocalTime opening, LocalTime closing, int index) {
        super(name, description, index);
        this.fee = fee;
        this.rank = rank;
        this.opening = opening;
        this.closing = closing;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

    public void setClosing(LocalTime closing) {
        this.closing = closing;
    }

    @Override
    public double getFee() {
        return fee;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public LocalTime getOpening() {
        return opening;
    }

    @Override
    public LocalTime getClosing() {
        return closing;
    }

    @Override
    public void defaultOpening() {
        opening = LocalTime.of(9, 30);
    }

    @Override
    public void defaultClosing() {
        closing = LocalTime.parse("20:00");
    }
}
