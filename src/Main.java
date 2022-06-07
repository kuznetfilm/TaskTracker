import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Manager daily = new Manager();
        SuperManager superDaily = new SuperManager();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Hello !");
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    daily.createNewTask();
                    break;
                case 11:
                    daily.printAllTasks();
                    break;
                case 12:
                    daily.eraseAllTasks();
                    break;
                case 13:
                    int taskNumber = scanner.nextInt();
                    daily.showTheTask(taskNumber);
                    break;
                case 14: //удалить задачу
                    System.out.println(" введите номер задачи");
                    int taskNumber1 = scanner.nextInt();
                    daily.removeTheTask(taskNumber1);
                    break;
                case 15:     // изменить статус задачи
                    System.out.println(" введите номер задачи");
                    int taskNumber2 = scanner.nextInt();
                    System.out.println(" введите новый статус");
                    String status1 = scanner1.next();
                    daily.allTasks.get(taskNumber2).statusOfTask = status1;
                    break;
                case 2:
                    daily.createNewEpic();
                    break;
                case 21: //вывести эпик по номеру
                    System.out.println(" введите номер эпика");
                    int epicNumb = scanner.nextInt();
                    daily.printEpicByNumber(epicNumb);
                    break;
                case 22:    // печать всех эпиков
                    daily.printAllEpics();
                    break;
                case 23:     ///// добавить подзадачу в эпик
                    System.out.println(" введите номер эпика");
                    int epicNumb1 = scanner.nextInt();
                    System.out.println(" введите имя задачи");
                    String nameOfSubtask = scanner1.next();
                    System.out.println(" введите детали задачи");
                    String detailsOfSubtask = scanner1.next();
                    daily.addSubtaskToEpic(epicNumb1, nameOfSubtask, detailsOfSubtask);
                    break;
                case 24: {   // изменить статус подзадачи
                    System.out.println(" введите номер эпика");
                    int epicNumb2 = scanner.nextInt();
                    System.out.println(" введите номер подзадачи");
                    int subTaskNumber = scanner.nextInt();
                    System.out.println(" введите новый статус");
                    String status = scanner1.next();

                    daily.changeSubTuskStatus(epicNumb2, subTaskNumber,status);
                    break;
                }
                case 25: //эпики по статусам
                    System.out.println(" какой статус вы хотите посмотреть ?");
                    String status = scanner.next();
                    daily.printEpicWithThisStatus(status);
                    break;
                case 26: // удалить эпик
                    System.out.println(" введите номер эпика");
                    int epicNumb3 = scanner.nextInt();
                    daily.allEpics.remove(epicNumb3);
                    break;
                case 31: // обновить эпик
                    System.out.println(" введите номер эпика");
                    int epicNumb4 = scanner.nextInt();
                    superDaily.updateEpic( daily.allEpics.get(epicNumb4) );
                    break;
                case 32: // обновить задачу
                    System.out.println(" введите номер задачи");
                    int taskNumb5 = scanner.nextInt();
                    superDaily.updateTask(daily.allTasks.get(taskNumb5));
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("1 - создать новую задачу.");
        System.out.println("11 - напечатать все задачи.");
        System.out.println("12 - удалить все задачи.");
        System.out.println("13 - показать задачу.");
        System.out.println("14 - удалить задачу.");
        System.out.println("15 -  изменить статус задачи.");
        System.out.println("2 - создать новый эпик.");
        System.out.println("21 - Вывести эпик по его номеру.");
        System.out.println("22 - напечатать все эпики.");
        System.out.println("23 - добавить подзадачу в эпик");
        System.out.println("24 - изменить статус подзадачи");
        System.out.println("25 - эпики по статусам");
        System.out.println("26 - удалить эпик");
        System.out.println("31 - обновить эпик");
        System.out.println("9 - Выйти из приложения.");

    }
}
