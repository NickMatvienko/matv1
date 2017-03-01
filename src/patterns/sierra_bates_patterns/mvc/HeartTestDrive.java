package patterns.sierra_bates_patterns.mvc;

/**
 * Created on 24.02.17.
 */
public class HeartTestDrive {
    public static void main (String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
