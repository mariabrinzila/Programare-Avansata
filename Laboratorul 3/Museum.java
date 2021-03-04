import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    private LocalTime opening, closing;
    private double fee;

    public Museum() {
    }

    ;

    public Museum(LocalTime opening, LocalTime closing, double fee) {
        this.opening = opening;
        this.closing = closing;
        this.fee = fee;
    }

    public Museum(String name, String description, LocalTime opening, LocalTime closing, double fee) {
        super(name, description);
        this.opening = opening;
        this.closing = closing;
        this.fee = fee;
    }

    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

    public void setClosing(LocalTime closing) {
        this.closing = closing;
    }

    public void setFee(double fee) {
        this.fee = fee;
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
    public double getFee() {
        return fee;
    }
}