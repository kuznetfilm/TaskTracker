public class SuperManager extends Manager {

    public void updateEpic (Epic epic) {
       allEpics.put(epic.epicNumberId, epic);
    }
    public void  updateTask (Task task) { // если task.taskNumber = 0 то это новая задача
        allTasks.put(task.taskNumber, task);
    }
    public void  updateSubTask (SubTask subtask) {
        allEpics.get(subtask.epicNumber).subtasks.put(subtask.subtaskNumber, subtask);
        checkEpicStatus(subtask.epicNumber);
    }
    public void addTask (Task task) {
        if (task.taskNumber == 0) {
            Integer taskNumber = allTasks.size() + 1;
            allTasks.put(taskNumber, task);
        }
        else allTasks.put(task.taskNumber, task);
    }
    public void removeTask (Task task) {
        allTasks.remove(task.taskNumber);
    }
}
