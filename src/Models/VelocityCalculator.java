package Models;

import java.util.Scanner;

public class VelocityCalculator {

    static Scanner sc = new Scanner(System.in);
    IncidentData data;
    FinalVelocity fVec;
    DragFactor dragFactor;

    public VelocityCalculator(IncidentData data, FinalVelocity fVec, DragFactor dragFactor) {
        this.data = data;
        this.fVec = fVec;
        this.dragFactor = dragFactor;
    }

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

    public static double validateRadius(double num) {
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

    public static double validateHorizontalDistance(double num) {
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

    public static double validateVerticalDistance(double num) {
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

    public static double validateSuperElevation(double num) {
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

    public void calculate() {
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

                if (data.mph < 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.dcslValue);
                            fVec.skidVelocity = Math.sqrt(2.0 * dragFactor.dcslValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dctlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dcplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.danlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.datlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.daplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.daplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daelValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.daelValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dgplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dgllValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dgllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dciplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dciplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drclValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.drclValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dislValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dislValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dsplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dsplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dsllValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dsllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wcslValue);
                            fVec.skidVelocity = Math.sqrt(2.0 * dragFactor.wcslValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wctlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wcplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wanlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watlValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.watlValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.waplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.waplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waelValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.waelValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wgplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wgllValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wgllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wciplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wciplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrclValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wrclValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wislValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wislValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wsplValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wsplValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wsllValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wsllValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wcsmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wcsmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wctmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcpmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wcpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wanmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.watmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wapmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wapmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waemValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.waemValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgpmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wgpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wglmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wglmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wcipmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wcipmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrcmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wrcmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wismValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wismValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wspmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wspmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wslmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.wslmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.dcsmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dcsmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dctmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcpmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dcpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.danmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.datmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dapmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dapmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daemValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.daemValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgpmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dgpmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dglmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dglmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dcipmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dcipmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drcmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.drcmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dismValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dismValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dspmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dspmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dslmValue);
                            fVec.skidVelocity = (Math.sqrt(2.0 * dragFactor.dslmValue * GF * data.skidDistance + Math.pow(data.finalVelocity, 2)));
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                data.skidTime = data.skidDistance / fVec.skidVelocity;
                System.out.println("Time: " + data.skidTime);
                for (double t = 1; t <= data.skidTime; t++) {
                    fVec.sv = fVec.skidVelocity * t / data.skidTime;
                    System.out.println("Time (Seconds): " + t + " " + "Veloctiy: " + fVec.sv);
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
                            System.out.println("Drag factor: " + dragFactor.dcslValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dcslValue + data.superElevation) / (1 - (dragFactor.dcslValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dctlValue + data.superElevation) / (1 - (dragFactor.dctlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dcplValue + data.superElevation) / (1 - (dragFactor.dcplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.danlValue + data.superElevation) / (1 - (dragFactor.danlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.datlValue + data.superElevation) / (1 - (dragFactor.datlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.daplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.daplValue + data.superElevation) / (1 - (dragFactor.daplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daelValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.daelValue + data.superElevation) / (1 - (dragFactor.daelValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dgplValue + data.superElevation) / (1 - (dragFactor.dgplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dgllValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dgllValue + data.superElevation) / (1 - (dragFactor.dgllValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dciplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dciplValue + data.superElevation) / (1 - (dragFactor.dciplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drclValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.drclValue + data.superElevation) / (1 - (dragFactor.drclValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dislValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dislValue + data.superElevation) / (1 - (dragFactor.dislValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dsplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dsplValue + data.superElevation) / (1 - (dragFactor.dsplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dsllValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dsllValue + data.superElevation) / (1 - (dragFactor.dsllValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wcslValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wcslValue + data.superElevation) / (1 - (dragFactor.wcslValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wctlValue + data.superElevation) / (1 - (dragFactor.wctlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wcplValue + data.superElevation) / (1 - (dragFactor.wcplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wanlValue + data.superElevation) / (1 - (dragFactor.wanlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watlValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.watlValue + data.superElevation) / (1 - (dragFactor.watlValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.waplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.waplValue + data.superElevation) / (1 - (dragFactor.waplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waelValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.waelValue + data.superElevation) / (1 - (dragFactor.waelValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wgplValue + data.superElevation) / (1 - (dragFactor.wgplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wgllValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wgllValue + data.superElevation) / (1 - (dragFactor.wgllValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wciplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wciplValue + data.superElevation) / (1 - (dragFactor.wciplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrclValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wrclValue + data.superElevation) / (1 - (dragFactor.wrclValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wislValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wislValue + data.superElevation) / (1 - (dragFactor.wislValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wsplValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wsplValue + data.superElevation) / (1 - (dragFactor.wsplValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wsllValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wsllValue + data.superElevation) / (1 - (dragFactor.wsllValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wcsmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wcsmValue + data.superElevation) / (1 - (dragFactor.wcsmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wctmValue + data.superElevation) / (1 - (dragFactor.wctmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcpmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wcpmValue + data.superElevation) / (1 - (dragFactor.wcpmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wanmValue + data.superElevation) / (1 - (dragFactor.wanmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.watmValue + data.superElevation) / (1 - (dragFactor.watmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wapmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wapmValue + data.superElevation) / (1 - (dragFactor.wapmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waemValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.waemValue + data.superElevation) / (1 - (dragFactor.waemValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgpmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wgpmValue + data.superElevation) / (1 - (dragFactor.wgpmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wglmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wglmValue + data.superElevation) / (1 - (dragFactor.wglmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wcipmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wcipmValue + data.superElevation) / (1 - (dragFactor.wcipmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrcmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wrcmValue + data.superElevation) / (1 - (dragFactor.wrcmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wismValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wismValue + data.superElevation) / (1 - (dragFactor.wismValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wspmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wspmValue + data.superElevation) / (1 - (dragFactor.wspmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wslmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.wslmValue + data.superElevation) / (1 - (dragFactor.wslmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            System.out.println("Drag factor: " + dragFactor.dcsmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dcsmValue + data.superElevation) / (1 - (dragFactor.dcsmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dctmValue + data.superElevation) / (1 - (dragFactor.dctmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcpmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dcpmValue + data.superElevation) / (1 - (dragFactor.dcpmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.danmValue + data.superElevation) / (1 - (dragFactor.danmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.datmValue + data.superElevation) / (1 - (dragFactor.datmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dapmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dapmValue + data.superElevation) / (1 - (dragFactor.dapmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daemValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.daemValue + data.superElevation) / (1 - (dragFactor.daemValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgpmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dgpmValue + data.superElevation) / (1 - (dragFactor.dgpmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dglmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dglmValue + data.superElevation) / (1 - (dragFactor.dglmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dcipmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dcipmValue + data.superElevation) / (1 - (dragFactor.dcipmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drcmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.drcmValue + data.superElevation) / (1 - (dragFactor.drcmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dismValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dismValue + data.superElevation) / (1 - (dragFactor.dismValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dspmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dspmValue + data.superElevation) / (1 - (dragFactor.dspmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dslmValue);
                            fVec.yawVelocity = (Math.sqrt(data.radius * GF * ((dragFactor.dslmValue + data.superElevation) / (1 - (dragFactor.dslmValue * data.superElevation)))));
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                data.yawTime = data.radius / fVec.yawVelocity;
                System.out.println("Time: " + data.yawTime);
                for (double t = 1; t <= data.yawTime; t++) {
                    fVec.yv = fVec.yawVelocity * t / data.yawTime;
                    System.out.println("Time (Seconds): " + t + " " + "Veloctiy: " + fVec.yv);
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

                data.hypotenuseDistance = Math.sqrt(Math.pow(data.horizontalDistance, 2) + Math.pow(data.verticalDistance, 2));

                //validates super-elevation
                data.superElevation = validateSuperElevation(data.superElevation);

                fVec.airborneVelocity = Math.sqrt(GF * Math.pow(data.horizontalDistance, 2)) / (2 * (data.verticalDistance + (data.horizontalDistance * data.superElevation)));

                System.out.println("Velocity: " + fVec.airborneVelocity);

                data.airborneTime = data.hypotenuseDistance / fVec.airborneVelocity;

                for (double t = 1; t <= data.airborneTime; t = t + 4) {
                    fVec.av = fVec.airborneVelocity * t / data.airborneTime;
                    System.out.println("Time (Seconds): " + t + " " + "Veloctiy: " + fVec.av);
                }

                break;

            default:
                System.out.println("Enter Case number");
        }
    }
}
