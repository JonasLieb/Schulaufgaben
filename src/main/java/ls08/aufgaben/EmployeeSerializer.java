package ls08.aufgaben;

import ls05.aufgaben.mitarbeiter.employee.Employee;
import ls05.aufgaben.mitarbeiter.employee.Manager;
import ls05.aufgaben.mitarbeiter.employee.OfficeWorker;
import ls05.aufgaben.mitarbeiter.employee.ShiftWorker;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeSerializer {

    public static final String HOURLY_RATE = "HOURLY_RATE";
    public static final String SALARY = "SALARY";
    public static final String HOURS = "HOURS";
    public static final String PERCENTAGE = "PERCENTAGE";
    public static final String NAME = "NAME";
    public static final String EMPLOYEE_ID = "ID";
    private static final String STANDARD_PATH = System.getProperty("user.home") + File.separator + "employees";
    private static final String JSON_FILE_ENDING = ".json";
    private static final String XML_FILE_ENDING = ".xml";


    public static void main(String[] args) {
        //Test

        //Store XML:

        System.out.println("XML:");
        Manager m = new Manager("Hans Müller", 5060, 5000, .5);
        OfficeWorker o = new OfficeWorker("Officemann Peter", 5200, 4500);
        ShiftWorker s = new ShiftWorker("Shiftmann Shifto", 3050, 10);
        s.work(15);

        if (storeAsXML(m)) {
            System.out.println("Mitarbeiter " + m + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + m + " konnte nicht gespeichert werden...");
        }
        if (storeAsXML(o)) {
            System.out.println("Mitarbeiter " + o + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + o + " konnte nicht gespeichert werden...");
        }
        if (storeAsXML(s)) {
            System.out.println("Mitarbeiter " + s + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + s + " konnte nicht gespeichert werden...");
        }

        //Restore XML:
        Employee m2 = restoreFromXML(new File(STANDARD_PATH + File.separator + m.getClass().getName() + File.separator + m.getId() + XML_FILE_ENDING));
        if (m2 != null)
            System.out.println(m2);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");

        Employee o2 = restoreFromXML(new File(STANDARD_PATH + File.separator + o.getClass().getName() + File.separator + o.getId() + XML_FILE_ENDING));
        if (o2 != null)
            System.out.println(o2);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");

        Employee s2 = restoreFromXML(new File(STANDARD_PATH + File.separator + s.getClass().getName() + File.separator + s.getId() + XML_FILE_ENDING));
        if (s2 != null)
            System.out.println(s2);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");


        //Store JSON
        System.out.println("\n\nJSON:");
        if (storeAsJSON(m)) {
            System.out.println("Mitarbeiter " + m + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + m + " konnte nicht gespeichert werden...");
        }

        if (storeAsJSON(o)) {
            System.out.println("Mitarbeiter " + o + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + o + " konnte nicht gespeichert werden...");
        }

        if (storeAsJSON(s)) {
            System.out.println("Mitarbeiter " + s + " gespeichert!");
        } else {
            System.out.println("Mitarbeiter " + s + " konnte nicht gespeichert werden...");
        }

        //Restore from JSON
        Employee m3 = restoreFromJSON(new File(STANDARD_PATH + File.separator + m.getClass().getName() + File.separator + m.getId() + JSON_FILE_ENDING));
        if (m3 != null)
            System.out.println(m3);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");

        Employee o3 = restoreFromJSON(new File(STANDARD_PATH + File.separator + o.getClass().getName() + File.separator + o.getId() + JSON_FILE_ENDING));
        if (o3 != null)
            System.out.println(o3);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");

        Employee s3 = restoreFromJSON(new File(STANDARD_PATH + File.separator + s.getClass().getName() + File.separator + s.getId() + JSON_FILE_ENDING));
        if (s3 != null)
            System.out.println(s3);
        else
            System.out.println("Mitarbeiter konnte nicht wiederhergestellt werden!");
    }


    public static boolean storeAsXML(Employee e) {
        //festes:
        Element root = new Element(e.getClass().getName());
        Element id = new Element(EMPLOYEE_ID);
        id.addContent(String.valueOf(e.getId()));
        Element name = new Element(NAME);
        name.addContent(e.getName());
        //feste Werte hinzufügen
        root.addContent(id);
        root.addContent(name);

        //variables
        if (e instanceof ShiftWorker) {
            Element hourlyRate = new Element(HOURLY_RATE);
            hourlyRate.addContent(String.valueOf(((ShiftWorker) e).getHourlyRate()));
            Element hours = new Element(HOURS);
            hours.addContent(String.valueOf(((ShiftWorker) e).getHourCount()));
            root.addContent(hourlyRate);
            root.addContent(hours);
        }
        if (e instanceof OfficeWorker) {
            Element salary = new Element(SALARY);
            salary.addContent(String.valueOf(((OfficeWorker) e).getSalary()));
            root.addContent(salary);
        }
        if (e instanceof Manager) {
            Element percentage = new Element(PERCENTAGE);
            percentage.addContent(String.valueOf(((Manager) e).getPercentage()));
            root.addContent(percentage);
        }

        Document doc = new Document();
        doc.setRootElement(root);

        //Create the XML
        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        File output = new File(STANDARD_PATH + File.separator + e.getClass().getName() + File.separator + e.getId() + XML_FILE_ENDING);
        if (!createFile(output)) return false;

        try {
            outter.output(doc, new FileWriter(output));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean storeAsJSON(Employee e) {
        //festes:
        JSONObject employeeDetails = new JSONObject();
        //feste Werte hinzufügen
        employeeDetails.put(NAME, e.getName());
        employeeDetails.put(EMPLOYEE_ID, e.getId());

        //variables
        if (e instanceof ShiftWorker) {
            ShiftWorker sw = (ShiftWorker) e;
            employeeDetails.put(HOURLY_RATE, sw.getHourlyRate());
            employeeDetails.put(HOURS, sw.getHourCount());
        }
        if (e instanceof OfficeWorker) {
            OfficeWorker ow = (OfficeWorker) e;
            employeeDetails.put(SALARY, ow.getSalary());
        }
        if (e instanceof Manager) {
            Manager ma = (Manager) e;
            employeeDetails.put(PERCENTAGE, ma.getPercentage());
        }

        JSONObject employeeObject = new JSONObject();
        employeeObject.put(e.getClass().getName(), employeeDetails);

        //Create the JSON

        File output = new File(STANDARD_PATH + File.separator + e.getClass().getName() + File.separator + e.getId() + JSON_FILE_ENDING);
        try (FileWriter file = new FileWriter(output)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(employeeObject.toJSONString());
            file.flush();
            return true;
        } catch (IOException ex) {
            return false;
        }

    }

    public static Employee restoreFromXML(File f) {
        if (f.isDirectory() || !f.exists()) return null;

        SAXBuilder sax = new SAXBuilder();

        Document doc;
        try {
            doc = sax.build(f);
        } catch (JDOMException | IOException e) {
            return null;
        }

        Element root = doc.getRootElement();
        String type = root.getName();
        int id;
        try {
            id = Integer.parseInt(root.getChild(EMPLOYEE_ID).getText());
        } catch (NumberFormatException e) {
            return null;
        }
        String name = root.getChild(NAME).getText();


        double salary;
        double percentage;
        int hours;
        if (type.equals(OfficeWorker.class.getName()) || type.equals(Manager.class.getName())) {
            try {
                salary = Double.parseDouble(root.getChild(SALARY).getText());
            } catch (NumberFormatException e) {
                return null;
            }
            if (type.equals(Manager.class.getName())) {
                try {
                    percentage = Double.parseDouble(root.getChild(PERCENTAGE).getText());
                } catch (NumberFormatException e) {
                    return null;
                }
                return new Manager(name, id, salary, percentage);
            }
            return new OfficeWorker(name, id, salary);
        } else if (type.equals(ShiftWorker.class.getName())) {
            //salary nutze ich hier für den Stundenlohn
            try {
                salary = Double.parseDouble(root.getChild(HOURLY_RATE).getText());
            } catch (NumberFormatException e) {
                return null;
            }
            try {
                hours = Integer.parseInt(root.getChild(HOURS).getText());
            } catch (NumberFormatException e) {
                return null;
            }
            ShiftWorker sw = new ShiftWorker(name, id, salary);
            sw.work(hours);
            return sw;
        }
        return null;
    }

    public static Employee restoreFromJSON(File f) {
        if (f.isDirectory() || !f.exists()) return null;


        JSONParser jsonParser = new JSONParser();
        JSONObject employeeJSON;
        try (FileReader reader = new FileReader(f)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            employeeJSON = (JSONObject) obj;
        } catch (Exception e) {
            return null;
        }

        JSONObject type = null;
        String name;
        int id;
        double salary;
        double percent;
        int hours;
        if ((type = (JSONObject) employeeJSON.get(ShiftWorker.class.getName())) != null) {
            //Shiftworker
            //constant values
            name = type.get(NAME).toString();
            id = Integer.parseInt(String.valueOf(type.get(EMPLOYEE_ID)));

            //variable values
            salary = Double.parseDouble(String.valueOf(type.get(HOURLY_RATE)));
            hours = Integer.parseInt(String.valueOf(type.get(HOURS)));

            ShiftWorker sw = new ShiftWorker(name, id, salary);
            sw.work(hours);
            return sw;
        } else if ((type = (JSONObject) employeeJSON.get(OfficeWorker.class.getName())) != null) {
            //Office Worker
            //constant values
            name = type.get(NAME).toString();
            id = Integer.parseInt(String.valueOf(type.get(EMPLOYEE_ID)));

            //variable values
            salary = Double.parseDouble(String.valueOf(type.get(SALARY)));
            return new OfficeWorker(name, id, salary);
        } else if ((type = (JSONObject) employeeJSON.get(Manager.class.getName())) != null) {
            //Manager
            //constant values
            name = type.get(NAME).toString();
            id = Integer.parseInt(String.valueOf(type.get(EMPLOYEE_ID)));

            //variable values
            salary = Double.parseDouble(type.get(SALARY).toString());
            percent = Double.parseDouble(type.get(PERCENTAGE).toString());
            return new Manager(name, id, salary, percent);
        } else {
            return null;
        }
    }


    private static boolean createFile(File output) {
        //Parent-File erstellen, false returnen, wenn das nicht möglich ist
        if (!output.getParentFile().exists() && !output.getParentFile().mkdirs()) return false;
        if (!output.exists()) {
            try {
                //File erstellen, false returnen, wenn das nicht möglich ist
                if (!output.createNewFile()) return false;
            } catch (IOException ex) {
                return false;
            }
        }
        return true;
    }

}
