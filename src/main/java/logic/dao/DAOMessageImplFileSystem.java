package logic.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import logic.exceptions.Exceptions;
import logic.model.Message;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DAOMessageImplFileSystem{
    private static final String CSV_FILE_NAME = "book.csv";
    private File fd;

    public DAOMessageImplFileSystem()  {
        this.fd = new File(CSV_FILE_NAME);

        if (!fd.exists()) {
            try {
                fd.createNewFile();
            } catch (IOException e) {
                Exceptions.exceptionConnectionOccurred();
            }
        }
    }

    private static synchronized Message get(long id, File fd) throws CsvValidationException, IOException {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        } catch (FileNotFoundException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        String[] record;
        List<Message> messageList = new ArrayList<Message>();
        while ((record = csvReader.readNext()) != null) {
            int posId = 0;

            boolean recordFound = record[posId].equals(String.valueOf(id));
            if (recordFound) {
                long idMsg = Integer.parseInt(record[posId]);
                long sender = Long.parseLong(record[1]);
                long receiver = Long.parseLong(record[2]);
                String text = record[3];
                Timestamp timestamp = Timestamp.valueOf(record[4]);
                long chat = Long.parseLong(record[5]);

                Message message = new Message(idMsg, sender, receiver, text, timestamp, chat);
                messageList.add(message);
            }
        }
        csvReader.close();
        return messageList.getFirst();
    }

}
