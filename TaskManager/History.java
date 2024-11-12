package TaskManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class History {
    private static final int MAX_HISTORY_SIZE = 5;
    private LinkedList<Task> recentHistory;

    public History() {
        this.recentHistory = new LinkedList<>();
    }

    public void addToHistory(Task task) {
        if (recentHistory.size() == MAX_HISTORY_SIZE) {
            recentHistory.removeFirst();
        }
        recentHistory.add(task);
    }

    public List<Task> getRecentHistory() {
        return new ArrayList<>(recentHistory);
    }
}

