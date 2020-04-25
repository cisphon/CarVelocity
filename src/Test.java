import java.util.Scanner;

public class Test extends DragFactor {
    static Scanner sc = new Scanner(System.in);

    // this prints the cases
    public static void casePrompt(double mph) {
        System.out.println("MPH: " + mph);
        System.out.println("Please select road number:");
        System.out.println("1.Portland Cement: New, Sharp");
        System.out.println("2.Portland Cement: Travelled");
        System.out.println("3.Portland Cement: Polished");
        System.out.println("4.Asphalt or Tar: New, Sharp");
        System.out.println("5.Asphalt or Tar: Travelled");
        System.out.println("6.Asphalt or Tar: Polished");
        System.out.println("7.Asphalt or Tar: Excess Tar");
        System.out.println("8.Gravel: Packed, Oiled");
        System.out.println("9.Gravel: Loose");
        System.out.println("10.Cinders: Packed");
        System.out.println("11.Rock: Crushed");
        System.out.println("12.Ice: Smooth");
        System.out.println("13.Snow: Packed");
        System.out.println("14.Snow: Loose");
    }

    public static void validatePrompt() {
        System.out.println("Are you sure this data is correct?");
        System.out.println("1.Yes");
        System.out.println("2.No");
    }

    public static double validateMPH(double num) {
        while (num >= 200) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please input MPH:");
                num = sc.nextInt();
            }
        }

        return num;
    }

    public static double validateAltitude(double num) {
        //validates altitude
        while (num >= 5000) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please input altitude(meters):");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateFinalVelocity(double num) {
        //validates skid distance
        while (num >= 500) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter Skid Distance(meters):");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateSkidDistance(double num) {
        while (num >= 500) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter Skid Distance(meters):");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateRadius(double num)
    {
        while (num >= 1000) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter the Radius:");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateHorizontalDistance(double num)
    {
        while (num >= 200) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter the the horizontal distance:");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateVerticalDistance(double num)
    {
        while (num >= 200) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter the the vertical distance:");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static double validateSuperElevation(double num)
    {
        while (num >= 1) {
            validatePrompt();
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please enter super-elevation(as decimal):");
                num = sc.nextDouble();
            }
        }
        return num;
    }

    public static void main(String[] args) {

        IncidentData data = new IncidentData();
        VelocityCalculator vCalc = new VelocityCalculator();
        
        System.out.println("Please select case number:");
        System.out.println("1.Skid Case");
        System.out.println("2.Yaw Case");
        System.out.println("3.Airborne Case");

        data.incidentCase = sc.nextInt();

        System.out.println("Please input altitude(meters):");
        data.altitude = sc.nextDouble();

        data.altitude = validateAltitude(data.altitude); // validates the loop

        double GF = data.GRAVITY * Math.pow((data.RADIUS_OF_EARTH / (data.RADIUS_OF_EARTH + data.altitude)), 2.0);

        switch (data.incidentCase) {
            case 1:
                System.out.println("Please input MPH:");
                data.mph = sc.nextDouble();
                data.mph = validateMPH(data.mph); // validates with the big boss man

                System.out.println("Please select Wet or Dry:");
                System.out.println("1.Wet");
                System.out.println("2.Dry");
                data.weather = sc.nextInt() == 1 ? Weather.WET : Weather.DRY;

                casePrompt(data.mph); // huge list of road types.

                data.setRoadType(sc.nextInt()); // sets data.roadType

                System.out.println("Please enter Final Velocity:");
                data.finalVelocity = sc.nextDouble();
                data.finalVelocity = validateFinalVelocity(data.finalVelocity);

                System.out.println("Please enter Skid Distance(meters):");
                data.skidDistance = sc.nextDouble();
                data.skidDistance = validateSkidDistance(data.skidDistance);

                if (data.mph < 30 && (data.weather == Weather.DRY )) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcslValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dctlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + danlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * danlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + datlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * datlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + daplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + daelValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daelValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dciplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + drclValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * drclValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dislValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dislValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dsplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dsllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + wcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcslValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + wctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wctlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + wcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + wanlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wanlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + watlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * watlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + waplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + waelValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waelValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + wgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + wgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + wciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wciplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + wrclValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wrclValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + wislValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wislValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + wsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wsplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + wsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wsllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + wcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcsmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + wctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wctmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + wcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + wanmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wanmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + watmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * watmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + wapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wapmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + waemValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waemValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + wgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + wglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wglmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + wcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcipmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + wrcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wrcmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + wismValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wismValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + wspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wspmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + wslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wslmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY )) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcsmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dctmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + danmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * danmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + datmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * datmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dapmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + daemValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daemValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dglmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcipmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + drcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * drcmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dismValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dismValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dspmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dslmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }
                break;

            case 2:
                System.out.println("Please input MPH:");
                data.mph = sc.nextInt();

                //validates mph2
                data.mph = validateMPH(data.mph);

                System.out.println("Please select Wet or Dry:");
                System.out.println("1.Wet");
                System.out.println("2.Dry");
                data.weather = sc.nextInt() == 1 ? Weather.WET : Weather.DRY;

                casePrompt(data.mph);

                data.setRoadType(sc.nextInt());

                System.out.println("Please enter the Radius:");
                data.radius = sc.nextDouble();

                //validates radius
                data.radius = validateRadius(data.radius);

                System.out.println("Please enter super-elevation(as decimal):");
                data.superElevation = sc.nextDouble();

                //validates super-elevation
                data.superElevation = validateSuperElevation(data.superElevation);

                if (data.mph < 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * ((dcslValue + data.superElevation) / (1 - (dcslValue * data.superElevation))))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dctlValue + data.superElevation) / (1 - (dctlValue * data.superElevation)))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dcplValue + data.superElevation) / (1 - (dcplValue * data.superElevation)))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + danlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (danlValue + data.superElevation) / (1 - (danlValue * data.superElevation)))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + datlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (datlValue + data.superElevation) / (1 - (datlValue * data.superElevation)))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + daplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (daplValue + data.superElevation) / (1 - (daplValue * data.superElevation)))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + daelValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (daelValue + data.superElevation) / (1 - (daelValue * data.superElevation)))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dgplValue + data.superElevation) / (1 - (dgplValue * data.superElevation)))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dgllValue + data.superElevation) / (1 - (dgllValue * data.superElevation)))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dciplValue + data.superElevation) / (1 - (dciplValue * data.superElevation)))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + drclValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (drclValue + data.superElevation) / (1 - (drclValue * data.superElevation)))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dislValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dislValue + data.superElevation) / (1 - (dislValue * data.superElevation)))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dsplValue + data.superElevation) / (1 - (dsplValue * data.superElevation)))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dsllValue + data.superElevation) / (1 - (dsllValue * data.superElevation)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + wcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wcslValue + data.superElevation) / (1 - (wcslValue * data.superElevation)))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + wctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wctlValue + data.superElevation) / (1 - (wctlValue * data.superElevation)))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + wcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wcplValue + data.superElevation) / (1 - (wcplValue * data.superElevation)))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + wanlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wanlValue + data.superElevation) / (1 - (wanlValue * data.superElevation)))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + watlValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (watlValue + data.superElevation) / (1 - (watlValue * data.superElevation)))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + waplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (waplValue + data.superElevation) / (1 - (waplValue * data.superElevation)))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + waelValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (waelValue + data.superElevation) / (1 - (waelValue * data.superElevation)))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + wgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wgplValue + data.superElevation) / (1 - (wgplValue * data.superElevation)))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + wgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wgllValue + data.superElevation) / (1 - (wgllValue * data.superElevation)))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + wciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wciplValue + data.superElevation) / (1 - (wciplValue * data.superElevation)))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + wrclValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wrclValue + data.superElevation) / (1 - (wrclValue * data.superElevation)))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + wislValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wislValue + data.superElevation) / (1 - (wislValue * data.superElevation)))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + wsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wsplValue + data.superElevation) / (1 - (wsplValue * data.superElevation)))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + wsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wsllValue + data.superElevation) / (1 - (wsllValue * data.superElevation)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + wcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wcsmValue + data.superElevation) / (1 - (wcsmValue * data.superElevation)))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + wctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wctmValue + data.superElevation) / (1 - (wctmValue * data.superElevation)))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + wcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wcpmValue + data.superElevation) / (1 - (wcpmValue * data.superElevation)))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + wanmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wanmValue + data.superElevation) / (1 - (wanmValue * data.superElevation)))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + watmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (watmValue + data.superElevation) / (1 - (watmValue * data.superElevation)))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + wapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wapmValue + data.superElevation) / (1 - (wapmValue * data.superElevation)))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + waemValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (waemValue + data.superElevation) / (1 - (waemValue * data.superElevation)))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + wgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wgpmValue + data.superElevation) / (1 - (wgpmValue * data.superElevation)))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + wglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wglmValue + data.superElevation) / (1 - (wglmValue * data.superElevation)))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + wcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wcipmValue + data.superElevation) / (1 - (wcipmValue * data.superElevation)))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + wrcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wrcmValue + data.superElevation) / (1 - (wrcmValue * data.superElevation)))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + wismValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wismValue + data.superElevation) / (1 - (wismValue * data.superElevation)))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + wspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wspmValue + data.superElevation) / (1 - (wspmValue * data.superElevation)))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + wslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (wslmValue + data.superElevation) / (1 - (wslmValue * data.superElevation)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dcsmValue + data.superElevation) / (1 - (dcsmValue * data.superElevation)))));
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dctmValue + data.superElevation) / (1 - (dctmValue * data.superElevation)))));
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dcpmValue + data.superElevation) / (1 - (dcpmValue * data.superElevation)))));
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + danmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (danmValue + data.superElevation) / (1 - (danmValue * data.superElevation)))));
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + datmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (datmValue + data.superElevation) / (1 - (datmValue * data.superElevation)))));
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dapmValue + data.superElevation) / (1 - (dapmValue * data.superElevation)))));
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + daemValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (daemValue + data.superElevation) / (1 - (daemValue * data.superElevation)))));
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dgpmValue + data.superElevation) / (1 - (dgpmValue * data.superElevation)))));
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dglmValue + data.superElevation) / (1 - (dglmValue * data.superElevation)))));
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dcipmValue + data.superElevation) / (1 - (dcipmValue * data.superElevation)))));
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + drcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (drcmValue + data.superElevation) / (1 - (drcmValue * data.superElevation)))));
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dismValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dismValue + data.superElevation) / (1 - (dismValue * data.superElevation)))));
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dspmValue + data.superElevation) / (1 - (dspmValue * data.superElevation)))));
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(data.radius * GF * (dslmValue + data.superElevation) / (1 - (dslmValue * data.superElevation)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }
                break;

            case 3:
                System.out.println("Please enter the the horizontal distance:");
                data.horizontalDistance = sc.nextDouble();
                //validates horizontal distance
                data.horizontalDistance = validateHorizontalDistance(data.horizontalDistance);

                System.out.println("Please enter the the vertical distance:");
                data.verticalDistance = sc.nextDouble();
                //validates vertical distance
                data.verticalDistance = validateVerticalDistance(data.verticalDistance);

                System.out.println("Please enter super-elevation(as decimal):");
                data.superElevation = sc.nextDouble();

                //validates super-elevation
                data.superElevation = validateSuperElevation(data.superElevation);

                System.out.println("Velocity: " + (Math.sqrt(GF * Math.pow(data.horizontalDistance, 2)) / (2 * (data.verticalDistance + (data.horizontalDistance * data.superElevation)))));

                break;

            default:
                System.out.println("Enter Case number");
        }
    }
}

