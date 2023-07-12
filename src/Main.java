import java.time.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner (System.in);

        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();

        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));
        BoardItem nextItem = new BoardItem(scr.nextLine(), LocalDate.now().plusDays(30));
        item.advanceStatus();

        Board board = new Board();

        board.items.add(item);
        board.items.add(anotherItem);
        board.items.add(nextItem);


        for (BoardItem boardItem : board.items) {
            boardItem.advanceStatus();
        }

        nextItem.revertStatus();

        for (BoardItem boardItem : board.items) {
            System.out.println(boardItem.viewInfo());
        }
    }
}