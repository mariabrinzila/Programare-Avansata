import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpening();

    LocalTime getClosing();

    static Duration getVisitingDuration(LocalTime opening, LocalTime closing) {
        Duration d = Duration.between(opening, closing);
        return d;
    }

    default void defaultOpening() {
    }

    default void defaultClosing() {
    }
}
