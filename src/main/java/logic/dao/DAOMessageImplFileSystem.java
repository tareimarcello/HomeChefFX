package logic.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import logic.exceptions.Exceptions;
import logic.model.Message;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DAOMessageImplFileSystem implements DAOInterface<Message> {
    private final String filePath;

    public DAOMessageImplFileSystem(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Message message) {
        List<Message> messages = getAll();
        messages.add(message);
        saveAllMessages(messages);
    }

    @Override
    public List<Message> getAll(){
        List<Message> users = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                long id = Integer.parseInt(line[0]);
                long sender = Long.parseLong(line[1]);
                long receiver = Long.parseLong(line[2]);
                String text = line[3];
                Timestamp timestamp = new Timestamp(Long.parseLong(line[4]));
                long idChat = Long.parseLong(line[5]);
                users.add(new Message(id, sender, receiver, text, timestamp, idChat));
            }
        } catch (CsvValidationException | IOException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        return users;
    }

    @Override
    public Message get(long id) {
        return getAll().stream()
                .filter(msg -> msg.getIdMsg() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
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

    @Override
    public void delete(Message msg) {
        List<Message> messages = getAll();
        messages.removeIf(message -> message.getIdMsg() == msg.getIdMsg());
        saveAllMessages(messages);
    }

    private void saveAllMessages(List<Message> messages) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (Message msg : messages) {
                String[] line = {String.valueOf(msg.getIdMsg()), String.valueOf(msg.getSender()), String.valueOf(msg.getReceiver()), msg.getText(), String.valueOf(msg.getTime()), String.valueOf(msg.getIdChat())};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            Exceptions.exceptionConnectionOccurred();
        }
    }

    public List<Message> getBySendRec(long idSend, long idRec){

        return (List<Message>) getAll().stream()
                .filter(msg -> msg.getSender() == idSend && msg.getReceiver() == idRec)
                .findFirst()
                .orElse(null);
    }

    public List<Message> getAllByChat(long idChat){

        List<Message> messages;
        messages = (List<Message>) getAll().stream()
                .filter(msg -> msg.getIdChat() == idChat)
                .findFirst()
                .orElse(null);
        return messages;
    }
}

