package TaskManager;

import java.time.LocalDate;

public class Task {
    private String title;
    private String text;
    private LocalDate date;

    public Task(String title, String text, LocalDate date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Задание{ " +
                "название = '" + title + '\'' +
                ", описание = '" + text + '\'' +
                ", дата = " + date +
                '}';
    }
}