import java.time.LocalTime;
import java.time.Duration;

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

    public Museum(String name, String description, LocalTime opening, LocalTime closing, double fee, int index) {
        super(name, description, index);
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

    @Override
    public void defaultOpening() {
        opening = LocalTime.of(9, 30);
    }

    @Override
    public void defaultClosing() {
        closing = LocalTime.parse("20:00");
    }
}