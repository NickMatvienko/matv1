package patterns.sierra_bates_patterns.mvc;

/**
 * Created on 24.02.17.
 */
public interface ControllerInterface {
    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}
