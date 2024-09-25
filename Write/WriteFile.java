package Case_Study_Module2.Write;

import Case_Study_Module2.model.RentalCard;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    static final String FILE_Management = "src/Case_Study_Module2/Data/ManagementFile.csv";

    public static List<RentalCard> writeToFile(RentalCard card) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_Management, true);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.write(card.getReaderCode() + "," + card.getName() + "," + card.getAdress() + "," + card.getBirthDate() + "," + card.getBorrowCount() + "," + card.getBookID() + "," + card.getBorrowDate() + "," + card.getReturnDate() + "," + card.getAmountOfRent());
            buffWriter.newLine();
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return List.of();
    }
    public static void overwriteFile(List<RentalCard> cards) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_Management, true)) {}) {
            for (RentalCard card : cards) {
                writer.write(card.toString());  // Ghi thông tin thẻ ra file (đảm bảo hàm toString của RentalCard chính xác)
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }



}


