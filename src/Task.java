public class Task {
    public Integer taskNumber;
    public String nameOfTask;
    public String detailsOfTask;
    public String statusOfTask;

    public Task(Integer taskNumber, String nameOfTask, String detailsOfTask, String statusOfTask) {
        this.taskNumber = taskNumber;
        this.nameOfTask = nameOfTask;
        this.detailsOfTask = detailsOfTask;
        this.statusOfTask = statusOfTask;
    }


    @Override
    public String toString() {
        return "Task{" +
                "taskNumber=" + taskNumber +
                ", nameOfTask='" + nameOfTask + '\'' +
                ", detailsOfTask='" + detailsOfTask + '\'' +
                ", statusOfTask='" + statusOfTask + '\'' +
                '}';
    }
}
