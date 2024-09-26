package Case_Study_Module2.Write;

import Case_Study_Module2.model.RentalCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    static final String FILE_Management = "src/Case_Study_Module2/Data/ManagementFile.csv";

    public static List<RentalCard> writeToFile(ArrayList<RentalCard> card) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_Management);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            for (RentalCard rentalCard : card) {
                buffWriter.write(rentalCard.getReaderCode() + "," + rentalCard.getName() + "," + rentalCard.getAdress() + "," + rentalCard.getBirthDate() + "," + rentalCard.getBorrowCount() + "," + rentalCard.getBookID() + "," + rentalCard.getBorrowDate() + "," + rentalCard.getReturnDate

                        + "," + rentalCard.getAmountOfRent());
                buffWriter.newLine();

                buffWriter.close();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }
        public static List<RentalCard> readFromFile() {
        List<RentalCard> cards = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_Management);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            while ((line = buffReader.readLine()) != null) {
                String[] cardDetails = line.split(",");
                RentalCard card = new RentalCard(cardDetails);
                cards.add(card);
            }
            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cards;
    }

}








