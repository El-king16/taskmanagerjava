package TaskManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private History history;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.history = new History();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksForDay(LocalDate date) {
        List<Task> tasksForDay = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDate().equals(date)) {
                tasksForDay.add(task);
                history.addToHistory(task);
            }
        }
        return tasksForDay;
    }

    public List<Task> getTasksForWeek(LocalDate startDate) {
        List<Task> tasksForWeek = new ArrayList<>();
        LocalDate endDate = startDate.plusDays(7);

        for (Task task : tasks) {
            if (!task.getDate().isBefore(startDate) && !task.getDate().isAfter(endDate)) {
                tasksForWeek.add(task);
                history.addToHistory(task);
            }
        }
        return tasksForWeek;
    }

    public List<Task> getHistory() {
        return history.getRecentHistory();
    }
}



