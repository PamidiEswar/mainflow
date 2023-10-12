import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Task {
    private String name;
    private String description;
    private String dueDate;

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }
}

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter task name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter due date: ");
                        String dueDate = scanner.nextLine();
                        tasks.add(new Task(name, description, dueDate));
                        System.out.println("Task added successfully.");
                        break;

                    case 2:
                        System.out.println("Tasks List:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ". " + tasks.get(i).getName());
                        }
                        if (tasks.size() == 0) {
                            System.out.println("No tasks to remove.");
                            break;
                        }

                        System.out.print("Enter the task number to remove: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            tasks.remove(taskNumber - 1);
                            System.out.println("Task removed successfully.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;

                    case 3:
                        System.out.println("Tasks List:");
                        for (int i = 0; i < tasks.size(); i++) {
                            Task task = tasks.get(i);
                            System.out.println(i + 1 + ". Name: " + task.getName() + ", Description: " + task.getDescription() + ", Due Date: " + task.getDueDate());
                        }
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks available.");
                        }
                        break;

                    case 4:
                        System.out.println("finished");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.next(); 
            }
        }
    }
}
