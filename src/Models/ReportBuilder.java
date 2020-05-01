package Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportBuilder {

    public ReportBuilder(IncidentData data, String username) {
        createFile(data, username);
    }

    private void createFile(IncidentData data, String username) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

            long cT = System.currentTimeMillis() / 1000000; // for random file name really

            File report = new File( "src/Reports/" + username + "_" + dateTime + "_" + accidentType + "_" + cT);
            if (report.createNewFile()) { // create new file, false if already a file of that name

                System.out.println("----------------");
                System.out.println("File created: " + report.getName());

                writeData(data, report, accidentType, username);

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeData(IncidentData data, File file, String accidentType, String username) {
        try {
            FileWriter myWriter = new FileWriter(file.getName());

            if (accidentType == "SKID") {
                myWriter.write("Username: " + username + "\n" +
                        "Time of program calculation: " + java.util.Calendar.getInstance().getTime() + "\n" +
                        "MPH: " + data.mph + "\n" +
                        "Weather: " + data.weather + "\n" +
                        "Road Type: " + data.roadType + "\n" +
                            "Drag Factor: " + data.dragFactorUsed + "\n" +
                                "Final Velocity: " + data.finalVelocity + "\n" +
                                "Skid Distance: " + data.skidDistance + "\n" +
                                "Velocity: " + data.skidVelocity + "\n" +
                                "Accident Time: " + data.accidentTime + "\n");
            }
            if (accidentType == "YAW") {
                myWriter.write("Username: " + username + "\n" +
                        "MPH: " + data.mph + "\n" +
                        "Weather: " + data.weather + "\n" +
                        "Road Type: " + data.roadType + "\n" +
                        "Drag Factor: " + data.dragFactorUsed + "\n" +
                        "Radius: " + data.radius + "\n" +
                        "Velocity: " + data.yawVelocity + "\n" +
                        "Accident Time: " + data.accidentTime + "\n");
            }
            if (accidentType == "AIRBORNE") {
                myWriter.write("Username: " + username + "\n" +
                        "Horizontal Distance: " + data.horizontalDistance + "\n" +
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
