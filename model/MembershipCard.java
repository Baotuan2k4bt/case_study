package Case_Study_Module2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public abstract class MembershipCard implements Comparable<MembershipCard> {
    private String readerCode;
    private String name;
    private String adress;
    private LocalDate birthDate;

    public MembershipCard(){

    }
    public MembershipCard(String readerCode, String name, String adress, LocalDate birthDate) {
        this.readerCode = readerCode;
        this.name = name;
        this.adress = adress;
        this.birthDate = birthDate;
    }
    public String getReaderCode() {
        return readerCode;
    }
    public void setReaderCode(String readerCode) {
        this.readerCode = readerCode;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {

    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void Input() {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner duy nhất
        System.out.println("Nhập mã người đọc :");
        this.readerCode=new Scanner(System.in).nextLine();
        System.out.println("Nhập họ  và tên:");
        this.name=new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ :");
        this.adress=new Scanner(System.in).nextLine();

        while (true) {
            try {
                System.out.println("Nhập năm sinh (định dạng : yyyy-MM-dd):");
                String dateInput = scanner.nextLine();
                // Phân tích chuỗi thành LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.birthDate = LocalDate.parse(dateInput, formatter);
                break; // Thoát khỏi vòng lặp khi nhập thành công
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng năm sinh không hợp lệ. Vui lòng nhập lại!");
            }
        }
    }
    public void Output(RentalCard s) {
        System.out.printf("|%13s|%15s|%13s|%17s",s.getReaderCode(),s.getName(),s.getAdress(),s.getBirthDate());
    }


    @Override
    public String toString() {
        return "MembershipCard{" +
                "readerCode='" + readerCode + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    // Hàm so sánh 2 đối tượng MembershipCard theo năm sinh
  @Override
    public int compareTo(MembershipCard o) {
        return this.birthDate.compareTo(o.birthDate)*-1;
      };



}
