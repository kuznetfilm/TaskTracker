public class SubTask extends Task {

    Integer epicNumber;
    Integer subtaskNumber;

    public SubTask(Integer epicNumber, Integer subtaskNumber, String nameOfTask, String detailsOfTask, String statusOfTask) {
        super(subtaskNumber, nameOfTask, detailsOfTask, statusOfTask);
        this.epicNumber = epicNumber;
        //this.subtaskNumber = subtaskNumber;

    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicNumber=" + epicNumber +
                ", subtaskNumber=" + subtaskNumber +
                ", nameOfTask='" + nameOfTask + '\'' +
                ", detailsOfTask='" + detailsOfTask + '\'' +
                ", statusOfTask='" + statusOfTask + '\'' +
                '}';
    }
}
