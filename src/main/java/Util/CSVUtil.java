package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.zip.DataFormatException;

public class CSVUtil {

    public HashMap<String, String> getHash(File file) {

    }

    private HashMap<String, String> hashWrapper(List<String[]> stringList) throws DataFormatException {
        if (line.size() != firstLine.size()) {
            throw new DataFormatException("missing parameters");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < firstLine.size() && i < line.size(); i++) {
            if (line.get(i).replace(" ", "").equals("")) {
                hashMap.put(firstLine.get(i), null);
            } else {
                hashMap.put(firstLine.get(i), line.get(i));
            }
        }
        return hashMap;
    }

    private List<String[]> importCSV(File csv) throws DataFormatException, FileNotFoundException {
        Scanner in = new Scanner(csv);
        List<String[]> csvList = new ArrayList<>();
        while (in.hasNextLine()) {
            csvList.add(splitLine(in.nextLine()));
        }
        return csvList;
    }

    private static String[] splitLine(String line) {
        String s = line.replace(",,", ", ,").replace("?", " ");
        return s.split("\\s*,\\s*");
    }
}
