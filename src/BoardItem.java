import java.time.*;

public class BoardItem {

    //private fields
    private String Title;
    private LocalDate DueDate;

    private Status status;

    public BoardItem(String Title, LocalDate DueDate) { //constructor for BoardItem
        this.Title = Title;
        this.DueDate = DueDate;
        this.status = Status.Open;
    }

    public Status getStatus() { //getters
        return status;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public Status advanceStatus() { //method which iterates through the enum and advances the status with one
        Status[] statuses = Status.values();
        int index = 0;

        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i] == this.status) {
                index = i;
                break;
            }
        }
        if (index < 4){ // check which ensures the output won't break once it reaches "Verified"
            index = index + 1;
        }
        status = statuses[index];
        return status;
    }
    public Status revertStatus(){ //method which iterates through the enum and reverts the status to base
        Status[] statuses = Status.values();
        int index = 0;

        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i] == this.status) {
                index = i;
                break;
            }
        }
        if (index != 0){
            index = index -1;
        }
        status = statuses[index];
        return status;
    }
    public String viewInfo(){
        StringBuilder information = new StringBuilder(); //method which formats the output with StringBuilder
        information.append("'").append(getTitle()).append("', [")
                .append(getStatus()).append(" | ").append(getDueDate()).append("]");

        return information.toString();

        /*String information;
        information = "'" + getTitle() +"'" + ", [" + getStatus() + " | " + getDueDate() + "]";

        return information; */ // variant without SB
    }
    enum Status { //enumeration

        Open, ToDo, InProgress, Done, Verified
    }
}