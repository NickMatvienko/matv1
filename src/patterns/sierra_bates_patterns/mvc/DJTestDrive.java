package patterns.sierra_bates_patterns.mvc;

/**
 * Created on 24.02.17.
 */
public class DJTestDrive {
    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
