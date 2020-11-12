package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVUtil {
    public static List<HashMap<String, String>> getHashList(File file) throws FileNotFoundException {
        return hashWrapper(importCSV(file));

    }

    private static List<HashMap<String, String>> hashWrapper(List<String[]> stringList) {
        List<HashMap<String, String>> hashMapList = new ArrayList<>();
        String[] firstLine = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            String[] line = stringList.get(i);
            hashMapList.add(hashCreator(firstLine, line));
        }
        return hashMapList;
    }

    private static HashMap<String, String> hashCreator(String[] firstLine, String[] line) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < firstLine.length && i < line.length; i++) {
            if (line[i].equals("")) {
                hashMap.put(firstLine[i], "-1");
            } else {
                hashMap.put(firstLine[i], line[i]);
            }
        }
        return hashMap;
    }

    private static List<String[]> importCSV(File csv) throws FileNotFoundException {
        Scanner in = new Scanner(csv);
        List<String[]> csvList = new ArrayList<>();
        while (in.hasNextLine()) {
            csvList.add(splitLine(in.nextLine()));
        }
        return csvList;
    }

    private static String[] splitLine(String line) {
        String s = line.replace("?", "");
        return s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    }
}
