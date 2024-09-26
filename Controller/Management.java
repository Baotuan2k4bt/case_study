package Case_Study_Module2.Controller;
import Case_Study_Module2.Write.WriteFile;
import Case_Study_Module2.model.MembershipCard;
import Case_Study_Module2.model.RentalCard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Management {
    ArrayList<RentalCard> cards = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
  private String  FILE_Management = "src/Case_Study_Module2/Data/ManagementFile.csv";
    public Management() {
        cards = new ArrayList<>();
    }


    public void enterInformation() {
        int n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thẻ thuê truyện  thứ :" + (i + 1));
            RentalCard bt = new RentalCard();
            bt.Input();
            cards.add(bt);
        }
    }

    public void addCards(RentalCard mb) {
        this.cards.add(mb);
        System.out.println("Thêm thẻ thuê truyện thành công!");
    }


  public void displayCard(){
        System.out.println("Danh sách thẻ thuê :");
        System.out.println("______________________________________________________________________________________________________________________________________________");
        System.out.println("|  ReaderCode " + "|" + "     Name      " + "|" + "   adress    " + "|" + "    birthDate    " + "|" + " borrowCount " + "|" + "   bookID " + "|" + "   borrowDate   " + "|" + "   returnDate    " + "|" + "   amountOfRent    " + "|");
        System.out.println("|____________________________________________________________________________________________________________________________________________|");
        for (RentalCard pt : cards) {
            pt.Output(pt);
            System.out.println("\n|--------------------------------------------------------------------------------------------------------------------------------------------|");
            WriteFile.writeToFile(cards);

        }

    }
  public int borrowCardCounting() {
        return this.cards.size();
    }


    public void arrange() {
        cards.sort(Comparator.comparing(MembershipCard::getBirthDate));
    }

    public void displayOverdueCard() {
        System.out.println("Danh sách thẻ thuê quá hạn (Ngày Hiện Tại > Ngày Trả):");
    System.out.println("__________________________________________________________________________________________________________________________");
    System.out.println("|  ReaderCode |     Name     |   Address    |    BirthDate    | BorrowCount |   BookID |   BorrowDate   |   ReturnDate    |");
    System.out.println("|__________________________________________________________________________________________________________________________|");
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    for (RentalCard card : cards) {
        try {
            LocalDate borrowDate = LocalDate.parse(card.getBorrowDate(), formatter);
            LocalDate returnDate = LocalDate.parse(card.getReturnDate(), formatter);

            if (returnDate.isBefore(borrowDate)) {
                System.out.println("Lỗi: Ngày trả trước ngày mượn - Mã thẻ " + card.getReaderCode());
            } else if (currentDate.isAfter(returnDate)) {
                card.Output(card); // In thông tin nếu quá hạn
                System.out.println("|__________________________________________________________________________________________________________________________|");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ - Mã thẻ " + card.getReaderCode());
        }
    }
}
 public void findReader() {
        System.out.println("Nhập mã thẻ thuê tìm kiếm:");
        String n = new Scanner(System.in).nextLine();
        System.out.println("Mã thẻ thuê cần tìm kiếm là:");
     System.out.println("______________________________________________________________________________________________________________________________________________");
     System.out.println("|  ReaderCode " + "|" + "     Name      " + "|" + "   adress    " + "|" + "    birthDate    " + "|" + " borrowCount " + "|" + "   bookID " + "|" + "   borrowDate   " + "|" + "   returnDate    " + "|" + "   amountOfRent    " + "|");
     System.out.println("|____________________________________________________________________________________________________________________________________________|");
        for (RentalCard find : cards) {
            if (find.getReaderCode().equals(n)) {
                find.Output(find);
                System.out.println("\n|_________________________________________________________________________________________________________________________|");
            }
        }
    }

    public void deleteCard() {

        System.out.println("Mã thẻ thuê cần xóa là:");
        String v= new Scanner(System.in).nextLine();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getReaderCode().equals(v)) {
                cards.remove(i);
                System.out.println("Đã xóa thẻ thuê  đó");
                WriteFile.writeToFile(cards);
                return;

            }

        }
        System.out.println("Không tìm thấy thẻ thuê với mã xóa " +  v);

    }

    public void edit() {
        System.out.println("Mã th�� thuê cần cập nhật là:");
        String v= new Scanner(System.in).nextLine();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getReaderCode().equals(v)) {
                System.out.println("Nhập thông tin mới cho th�� thuê:");
                cards.get(i).Input();
                System.out.println("Đã cập nhật thành công");
                WriteFile.writeToFile(cards);

                return;

            }

        }
        System.out.println("Không tìm thấy th�� thuê với mã cập nhật " +  v);




    }
    public double totalRent(){
        double total = 0;
        for (RentalCard rent : cards) {
            total += rent.getAmountOfRent();
        }
        return total;

    }

    public void Exit() {
        System.exit(0);
        System.out.println("Đã thoát chương trình");

    }
    public Scanner getScanner() {
        return scanner;
    }
}



