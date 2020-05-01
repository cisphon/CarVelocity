package Models;

import java.util.Scanner;

public class VelocityCalculator {

    Scanner sc = new Scanner(System.in);
    IncidentData data;
    DragFactor dragFactor;

    public VelocityCalculator() {
        data = new IncidentData();
        dragFactor = new DragFactor();
    }

    // this prints the cases
    public void casePrompt(double mph) {
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

    public void validatePrompt() {
        System.out.println("Are you sure this data is correct?");
        System.out.println("1.Yes");
        System.out.println("2.No");
    }

    public double validateMPH(double num) {
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

    public double validateAltitude(double num) {
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

    public double validateFinalVelocity(double num) {
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

    public double validateSkidDistance(double num) {
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

    public double validateRadius(double num) {
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

    public double validateHorizontalDistance(double num) {
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

    public double validateVerticalDistance(double num) {
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

    public double validateSuperElevation(double num) {
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

    public IncidentData calculate() {
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
                            data.dragFactorUsed = dragFactor.dcslValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.daplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daelValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed );
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed , GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dgllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dciplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drclValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dislValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dsplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dsllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcslValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.waplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waelValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wgllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wciplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrclValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wislValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wsplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wsllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcsmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.wapmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waemValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wglmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wcipmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrcmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wismValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wspmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wslmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcsmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.dapmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daemValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dglmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dcipmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drcmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dismValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dspmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dslmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.skidVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                data.skidTime = data.skidDistance / data.skidVelocity;
                System.out.println("Time: " + data.skidTime);
                for (data.accidentTime = 1; data.accidentTime <= data.skidTime; data.accidentTime++) {
                    data.skidVelocity = data.skidVelocity * data.accidentTime / data.skidTime;
                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.skidVelocity);
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

                if (data.mph < 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcslValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.daplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daelValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dgllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dciplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drclValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dislValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dsplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dsllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcslValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watlValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.waplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waelValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wgllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wciplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrclValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wislValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wsplValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wsllValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {

                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcsmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.wapmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waemValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wglmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wcipmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrcmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wismValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wspmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wslmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcsmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.dapmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daemValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgpmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dglmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dcipmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drcmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dismValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dspmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dslmValue;
                            System.out.println("Drag factor: " + data.dragFactorUsed);
                            data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF);
                            System.out.println("Velocity: " + data.yawVelocity);
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                data.yawTime = data.radius / data.yawVelocity;
                System.out.println("Time: " + data.yawTime);
                for (data.accidentTime = 1; data.accidentTime <= data.yawTime; data.accidentTime++) {
                    data.yawVelocity = data.yawVelocity * data.accidentTime / data.yawTime;
                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.yawVelocity);
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

                data.airborneVelocity = calculateAirborneVelocity(GF);

                System.out.println("Velocity: " + data.airborneVelocity);

                data.airborneTime = data.hypotenuseDistance / data.airborneVelocity;

                for (data.accidentTime = 1; data.accidentTime <= data.airborneTime; data.accidentTime = data.accidentTime + 4) {
                    data.airborneVelocity = data.airborneVelocity * data.accidentTime / data.airborneTime;
                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.airborneVelocity);
                }

                break;

            default:
                System.out.println("Enter Case number");
        }

        return data;
    }

    private double calculateSkidVelocity(double dragFactor, double GF) {
        return Math.sqrt(2.0 * dragFactor * GF * data.skidDistance + Math.pow(data.finalVelocity, 2));
    }

    private double calculateYawVelocity(double dragFactor, double GF) {
        return Math.sqrt(data.radius * GF * ((dragFactor + data.superElevation) / (1 - (dragFactor * data.superElevation))));
    }

    private double calculateAirborneVelocity(double GF) {
        data.hypotenuseDistance = Math.sqrt(Math.pow(data.horizontalDistance, 2) + Math.pow(data.verticalDistance, 2));

        //validates super-elevation
        data.superElevation = validateSuperElevation(data.superElevation);

        return Math.sqrt(GF * Math.pow(data.horizontalDistance, 2)) / (2 * (data.verticalDistance + (data.horizontalDistance * data.superElevation)));
    }
}
