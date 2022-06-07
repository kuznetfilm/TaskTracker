import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    public int taskNumber = 0;
    public int epicNumber = 0;
    public int subtaskNumber = 0;

    protected HashMap<Integer, Task> allTasks = new HashMap<>();
    protected HashMap<Integer, Epic> allEpics = new HashMap<>();


    public void createNewTask() {
        taskNumber++;
        //Epic = new Epic()
        Scanner scanner = new Scanner(System.in);
        System.out.println(" введите название задачи ");
        String taskName = scanner.next();
        System.out.println(" введите детали задачи ");
        String taskDetail = scanner.next();
        Task newItem = new Task(taskNumber, taskName, taskDetail, "NEW");
        allTasks.put(taskNumber, newItem);
    }

    public void createNewEpic() {
        Scanner scanner = new Scanner(System.in);
        epicNumber++;
        subtaskNumber = 0;
        System.out.println(" введите название Эпика ");
        String epicName = scanner.nextLine();
        HashMap<Integer, SubTask> subtasks = new HashMap<>();

        while (true) {
            subtaskNumber++;
            System.out.println(" введите название подзадачи ");
            String subTaskName = scanner.nextLine();

            System.out.println(" введите детали подзадачи ");
            String subTaskDetail = scanner.nextLine();

            SubTask newSubTask = new SubTask(epicNumber, subtaskNumber, subTaskName, subTaskDetail, "NEW");
            subtasks.put(subtaskNumber, newSubTask);

            System.out.println(" хотите добавить еще подзадачу ? y/n");
            String answer = scanner.nextLine();
            if ( answer.equals("n") ) {
                break;
            }
        }
        Epic newEpic = new Epic(epicNumber, epicName, subtasks, "NEW");
        allEpics.put(epicNumber, newEpic);
    }

    public void printAllTasks() {
        for (Integer indexOfTasks : allTasks.keySet()) {
            System.out.println(allTasks.get(indexOfTasks).toString());
        }
    }
    public void showTheTask (int taskNumber){
        System.out.println( allTasks.get(taskNumber).toString() );
    }
    public void removeTheTask (int taskNumber){
        if (taskNumber > 0 && taskNumber <= allTasks.size()) {
            allTasks.remove(taskNumber);
        }
        else {
            System.out.println(" неверный номер задачи");
        }
    }

    public void printAllEpics() {
        for (Integer indexOfEpic : allEpics.keySet()) {
            //printEpicByNumber(indexOfEpic);
            System.out.println(allEpics.get(indexOfEpic).toString());
        }
    }
    public void printEpicByNumber(int epicNumb) {
        if (epicNumb > 0 && epicNumb <= allEpics.size()) {
            System.out.println(allEpics.get(epicNumb).toString());
        }
        else {
            System.out.println(" неверный номер эпика'");
        }
    }
    public void addSubtaskToEpic(int epicNumb, String nameOfSubtask, String detailsOfSubtask) {

        int newSubTaskNumb = allEpics.get(epicNumb).subtasks.size() + 1;// номера Subtask всегда 1,2,3...

        SubTask newSubtask = new SubTask(epicNumb, newSubTaskNumb, nameOfSubtask, detailsOfSubtask, "NEW");
        allEpics.get(epicNumb).subtasks.put(newSubTaskNumb, newSubtask);
        //allEpics.get(epicNumb).status = "NEW";
        checkEpicStatus(epicNumb);
    }
    public void changeSubTuskStatus(int epicNumb, int subTaskNumb, String status) {
        allEpics.get(epicNumb).subtasks.get(subTaskNumb).statusOfTask = status;
        checkEpicStatus(epicNumb);
    }
    public void changeTaskStatus(int taskNumb, String status) {
        allTasks.get(taskNumb).statusOfTask = status;
    }
    public void checkEpicStatus(Integer epicNumb) {
        //Integer status = "NEW";
        int flagInprogress = 0;
        int flagDone = 1;
        for ( Integer subTaskNumb : allEpics.get(epicNumb).subtasks.keySet() ) {
            String st = allEpics.get(epicNumb).subtasks.get(subTaskNumb).statusOfTask;
            if ( !st.equals("NEW") ) {
                flagInprogress = 1;
            }
            if ( st.equals("DONE") ) {
                flagDone = flagDone * 1;
            }
            else  flagDone = flagDone * 0;
        }
        if (flagDone == 1) {
           allEpics.get(epicNumb).status = "DONE";
        } else if ( flagInprogress == 1) {
            allEpics.get(epicNumb).status = "IN PROGRESS";
        } else {
            allEpics.get(epicNumb).status = "NEW";
        }
    }

    public void printEpicWithThisStatus(String status) {
        for (Integer epicNumb : allEpics.keySet()) {
            if (allEpics.get(epicNumb).status.equals(status)) {
                System.out.println("status" + status + ": ");
                System.out.println( "Epicname " + allEpics.get(epicNumb).epicName);
            }
        }
    }
    public void eraseAllTasks() {
        allTasks.clear();
    }
}
