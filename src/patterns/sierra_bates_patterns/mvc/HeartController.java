package patterns.sierra_bates_patterns.mvc;

/**
 * Created on 24.02.17.
 */
public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DJView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    public void start() {
    }

    public void stop() {
    }

    public void increaseBPM() {
    }

    public void decreaseBPM() {
    }

    public void setBPM(int bpm) {
    }
}
