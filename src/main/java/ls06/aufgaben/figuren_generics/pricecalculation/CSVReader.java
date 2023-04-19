package ls06.aufgaben.figuren_generics.pricecalculation;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CSVReader {

    private ArrayList<Row> content;
    private File currentFile;

    public CSVReader(URL source, char columnDelimiter) {
        setSource(source, columnDelimiter);
    }

    private void setSource(URL source, char columnDelimiter) {
        this.currentFile = new File(source.getFile());
        if (!currentFile.exists()) {
            throw new IllegalArgumentException("Die mitgegebene Datei " + source.getFile() + " existiert nicht.");
        }
        content = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            reader.lines().forEach(line -> content.add(new Row(line, columnDelimiter)));
            reader.close();
        } catch (Exception e) {
            content = null;
            throw new IllegalArgumentException("Beim Lesen der Datei ist ein Fehler aufgetreten.");
        }
    }

    public File getSource() {
        return currentFile;
    }

    public URL getSourceAsURL() throws MalformedURLException {
        return currentFile.toURI().toURL();
    }

    public ArrayList<Row> getContent() {
        return content;
    }


    static class Row {
        String[] content;

        public Row(String row, char seperator) {
            if (row == null) content = new String[]{};
            content = row.split(String.valueOf(seperator));
        }

        public String getCol(int columnindex) {
            if (content.length < columnindex || columnindex < 0) return "";
            return content[columnindex];
        }
    }

//    public static ArrayList<Row> getContent(File file, char seperator) throws FileNotFoundException {
//        if (file == null || !file.exists()) {
//            throw new IllegalArgumentException("Die zu lesende Datei ist nicht vorhanden.");
//        }
//
//        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
//        ArrayList<Row> ret = new ArrayList<>();
//        reader.lines().forEach(line -> ret.add(new Row(line, seperator)));
//        return ret;
//    }
}
