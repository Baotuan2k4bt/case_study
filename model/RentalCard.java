package Case_Study_Module2.model;

import java.time.LocalDate;
import java.util.Scanner;

public class RentalCard extends MembershipCard {
    private int borrowCount;
    private String  bookID;
    private String borrowDate ;
    private String returnDate;
    private double amountOfRent;
    public RentalCard(){}
    public RentalCard(String readerCode, String name, String adress, LocalDate birthDate, int borrowCount, String bookID, String borrowDate, String returnDate, double amountOfRent) {
        super(readerCode, name, adress, birthDate);
        this.borrowCount = borrowCount;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.amountOfRent = amountOfRent;
    }

    public RentalCard(String cardDetail, String cardDetail1, String cardDetail2, String cardDetail3, int borrowCount, String cardDetail4, String cardDetail5, String cardDetail6, int amountOfRent) {
    }

    public RentalCard(String[] cardDetails) {
    }

    public int getBorrowCount() {
        return borrowCount;
    }
    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public double getAmountOfRent() {
        return amountOfRent;
    }
    public void setAmountOfRent(double amountOfRent) {
        this.amountOfRent = amountOfRent;
    }
    @Override
    public void Input(){
        super.Input();
        System.out.println("Nhập số phiếu thuê:");
        this.borrowCount=new Scanner(System.in).nextInt();
        System.out.println("Nhập số hiệu sách :");
        this.bookID=new Scanner(System.in).nextLine();
        System.out.println("NHập ngày thuê:");
        this.borrowDate=new Scanner(System.in).nextLine();
        System.out.println("Nhập ngày trả:");
        this.returnDate=new Scanner(System.in).nextLine();
        System.out.println("Nhập số tiền thuê ");
        this.amountOfRent=new Scanner(System.in).nextDouble();

    }

    @Override
    public void Output( RentalCard s ){
        super.Output(s);
        System.out.printf("|%13s|%10s|%16s|%17s|%18s|",s.getBorrowCount(),s.getBookID(),s.getBorrowDate(),s.getReturnDate(),s.getAmountOfRent());

    }




    @Override
    public String toString() {
        return "RentalCard{" +
                "borrowCount=" + borrowCount +
                ", bookID='" + bookID + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", amountOfRent=" + amountOfRent +
                '}'+super.toString();
    }
}
