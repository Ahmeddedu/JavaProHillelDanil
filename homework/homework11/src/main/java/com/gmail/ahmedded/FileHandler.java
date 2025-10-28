package com.gmail.ahmedded;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile = Path.of(path);
        try {
            Files.createFile(newFile);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
        return "Created " + path;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
        return "Recorded in " + path.toString();
    }

    public String readFromFile(String path) {
        Path filePath = Path.of(path);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
    }
}
