package driverFrameworkCore.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    static Logger log = Logger.getLogger(Utils.class);

    public List<String> readFromFile() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/testDatas.txt"));
        } catch (
                IOException e) {
            log.warn("The testDatas file is not found!");
        }
        return lines;
    }
}
