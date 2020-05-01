package Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportBuilder {

    public ReportBuilder(IncidentData data) {
        createFile(data);
    }

    private void createFile(IncidentData data) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String dateTime= dtf.format(now);

            String accidentType = "";

            if (data.skidVelocity != 0) {
                accidentType = "SKID";
            }
            else if (data.yawVelocity != 0) {
                accidentType = "YAW";
            }
            else if (data.airborneVelocity != 0) {
                accidentType = "AIRBORNE";
            }

            File report = new File("src/Reports/" + dateTime + "_" + accidentType);
            if (report.createNewFile()) { // create new file, false if already a file of that name

                System.out.println("----------------");
                System.out.println("File created: " + report.getName());

                writeData(data, report, accidentType);

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeData(IncidentData data, File file, String accidentType) {
        try {
            FileWriter myWriter = new FileWriter(file.getName());

            if (accidentType == "SKID") {
                myWriter.write("MPH: " + data.mph + "\n" +
                        "Weather: " + data.weather + "\n" +
                        "Road Type: " + data.roadType + "\n" +
                            "Drag Factor: " + data.dragFactorUsed + "\n" +
                                "Final Velocity: " + data.finalVelocity + "\n" +
                                "Skid Distance: " + data.skidDistance + "\n" +
                                "Velocity: " + data.skidVelocity + "\n" +
                                "Accident Time: " + data.accidentTime + "\n");
            }
            if (accidentType == "YAW") {
                myWriter.write("MPH: " + data.mph + "\n" +
                        "Weather: " + data.weather + "\n" +
                        "Road Type: " + data.roadType + "\n" +
                        "Drag Factor: " + data.dragFactorUsed + "\n" +
                        "Radius: " + data.radius + "\n" +
                        "Velocity: " + data.yawVelocity + "\n" +
                        "Accident Time: " + data.accidentTime + "\n");
            }
            if (accidentType == "AIRBORNE") {
                myWriter.write("Horizontal Distance: " + data.horizontalDistance + "\n" +
                        "Vertical Distance: " + data.verticalDistance + "\n" +
                        "Super Elevation: " + data.superElevation + "\n" +
                        "Velocity: " + data.airborneVelocity + "\n" +
                        "Accident Time: " + data.accidentTime + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to " + file.getName());
            System.out.println("----------------");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
