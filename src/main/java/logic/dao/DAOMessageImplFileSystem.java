package logic.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import logic.exceptions.Exceptions;
import logic.model.Message;

import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DAOMessageImplFileSystem {
    private static final String CSV_FILE_NAME = "message.csv";
    private File fd;
    public DAOMessageImplFileSystem() {
        this.fd = new File(CSV_FILE_NAME);

        if (!fd.exists()) {
            try {
                if(!fd.createNewFile()){
                    throw new FileNotFoundException("File non creato");
                }
            } catch (IOException e) {
                Exceptions.exceptionConnectionOccurred();
            }
        }
    }


    public void save(Message message) {
        List<Message> messages = getAll();
        long lastId = 0;
        for (int i=0;i<messages.size()-1;i++) {
            if(messages.get(i).getIdMsg() > messages.get(i+1).getIdMsg()){
                lastId = messages.get(i).getIdMsg();
            }else{
                lastId = messages.get(i+1).getIdMsg();
            }
        }
        message.setIdMsg(lastId+1);
        messages.add(message);
        saveAllMessages(messages);
    }


    public List<Message> getAll(){
        List<Message> messages = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new BufferedReader(new FileReader(fd)));
            String[] line;
            while ((line = reader.readNext()) != null) {
                long id = Long.parseLong(line[0]);
                long sender = Long.parseLong(line[1]);
                long receiver = Long.parseLong(line[2]);
                String text = line[3];
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(line[4]);
                Timestamp timestamp = new Timestamp(parsedDate.getTime());
                long idChat = Long.parseLong(line[5]);
                messages.add(new Message(id, sender, receiver, text, timestamp, idChat));
            }


        } catch (CsvValidationException | IOException | ParseException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        return messages;
    }


    public Message get(long id) {
        return getAll().stream()
                .filter(msg -> msg.getIdMsg() == id)
                .findFirst()
                .orElse(null);
    }


    public void update(Message msg) {
        List<Message> messages = getAll();
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getIdMsg() == msg.getIdMsg()) {
                messages.set(i, msg);
                saveAllMessages(messages);
                return;
            }
        }
        throw new IllegalArgumentException("Message con ID " + msg.getIdMsg() + " non trovato.");
    }


    public void delete(Message msg) {
        List<Message> messages = getAll();
        messages.removeIf(message -> message.getIdMsg() == msg.getIdMsg());
        saveAllMessages(messages);
    }

    private void saveAllMessages(List<Message> messages) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fd))) {
            for (Message msg : messages) {

                String[] line = {String.valueOf(msg.getIdMsg()), String.valueOf(msg.getSender()), String.valueOf(msg.getReceiver()), msg.getText(), String.valueOf(msg.getTime()), String.valueOf(msg.getIdChat())};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            Exceptions.exceptionConnectionOccurred();
        }
    }

    public List<Message> getBySendRec(long idSend, long idRec){
        List<Message> messages = getAll();
        List<Message> retMessages = new ArrayList<>();
        for (Message msg : messages) {
            if(msg.getSender()==idSend && msg.getReceiver()==idRec){
                retMessages.add(msg);
            }
        }
        return retMessages;
    }

    public List<Message> getAllByChat(long idChat){

        List<Message> messages = getAll();
        List<Message> retMessages = new ArrayList<>();
        for (Message msg : messages) {
            if(msg.getIdChat()==idChat){
                retMessages.add(msg);
            }
        }
        return retMessages;
    }
}

