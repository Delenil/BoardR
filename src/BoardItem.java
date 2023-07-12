import java.time.*;

public class BoardItem {

    private String Title;
    private LocalDate DueDate;

    private Status status;

    public BoardItem(String Title, LocalDate DueDate) {
        this.Title = Title;
        this.DueDate = DueDate;
        this.status = Status.Open;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public Status advanceStatus() {
        Status[] statuses = Status.values();
        int index = 0;

        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i] == this.status) {
                index = i;
                break;
            }
        }
        if (index < 4){
            index = index + 1;
        }
        status = statuses[index];
        return status;
    }
    public Status revertStatus(){
        Status[] statuses = Status.values();
        int index = 0;

        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i] == this.status) {
                index = i;
                break;
            }
        }
        index = 0;
        status = statuses[index];
        return status;
    }
    public String viewInfo(){
        String information;
        information = "'" + getTitle() +"'" + ", [" + getStatus() + " | " + getDueDate() + "]";

        return information;
    }
    enum Status {

        Open, ToDo, InProgress, Done, Verified;
    }
}