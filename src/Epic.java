import java.util.ArrayList;
import java.util.HashMap;

public class Epic {
    Integer  epicNumberId;
    String epicName;
    String status;
    HashMap<Integer, SubTask> subtasks;

    public Epic(Integer epicNumberId, String epicName, HashMap<Integer, SubTask> subtasks, String status) {
        this.epicNumberId = epicNumberId;
        this.epicName = epicName;
        this.subtasks = subtasks;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "epicNumberId=" + epicNumberId +
                ", epicName='" + epicName + '\'' +
                ", status='" + status + '\'' +
                ", subtasks=" + subtasks +
                '}';
    }
}
