package Case_Study_Module2.view;
import Case_Study_Module2.Controller.Management;
import Case_Study_Module2.model.RentalCard;
import java.util.Scanner;
public class TestManagement {
    public static void main(String[] args) {
        Management management = new Management();
        management.enterInformation();
        while (true) {
            System.out.println("----Quản lí việc thuê truyện---\n" +
                    "1. In danh sách thẻ thuê :\n" +
                    "2. Thêm thẻ thuê mới :\n" +
                    "3. Tổng số thẻ thuê:\n" +
                    "4.Sắp xếp danh từ cao đến thấp theo năm sinh :\n" +
                    "5.Danh sách thẻ thuê quá hạn :\n" +
                    "6. Tìm kiếm thẻ thuê qua mã thẻ : \n" +
                    "7.Cập nhật thẻ MemberShipcard :  \n" +
                    "8.Xóa thẻ MemberShipcard  :  \n" +
                    "9.Tổng tiền thuê truyện   :  \n" +
                    "10.Thoát chương trình");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    management.displayCard();
                    break;
                case 2:
                    System.out.println("Nhập thẻ thuê mới:");
                    RentalCard bt = new RentalCard();
                    bt.Input();
                    management.addCards(bt);
                    break;
                case 3:
                    management.borrowCardCounting();
                    System.out.println("Số lượng thẻ mượn :  " + management.borrowCardCounting());
                    break;
                case 4:
                    management.arrange();
                    management.displayCard();
                    break;
                case 5:
                    management.displayOverdueCard();
                    break;
                case 6:
                    management.findReader();
                    break;
            case 7:
                management.Update();
                    break;
                case 8:
                    management.deleteCard();
                    break;
                case 9:
                  management.totalRent();
                    System.out.println("Tổng tiền thuê truyện là "+management.totalRent()+"VND");
                case 10:
                    management.Exit();
                default:
                    System.out.println("Nhập Sai Số!");
            }
        }

    }
    }



