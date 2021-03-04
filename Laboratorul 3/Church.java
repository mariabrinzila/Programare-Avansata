import java.time.LocalTime;

public class Church extends Location implements Visitable {
    private LocalTime opening, closing;

    public Church() {
    }

    ;

    public Church(LocalTime opening, LocalTime closing) {
        this.opening = opening;
        this.closing = closing;
    }

    public Church(String name, String description, LocalTime opening, LocalTime closing) {
        super(name, description);
        this.opening = opening;
        this.closing = closing;
    }

    public void setOpening(LocalTime opening) {
        this.opening = opening;
    }

    public void setClosing(LocalTime closing) {
        this.closing = closing;
    }

    @Override
    public LocalTime getOpening() {
        return opening;
    }

    @Override
    public LocalTime getClosing() {
        return closing;
    }
}
