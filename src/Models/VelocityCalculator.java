package Models;

import java.util.Scanner;

public class VelocityCalculator {

    Scanner sc = new Scanner(System.in);
    IncidentData data;
    FinalVelocity fVec;
    DragFactor dragFactor;

    public VelocityCalculator() {
        data = new IncidentData();
        fVec = new FinalVelocity();
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
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dcslValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dctlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dcplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.danlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.datlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.daplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.daplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daelValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.daelValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dgplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dgllValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dgllValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dciplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dciplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drclValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.drclValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dislValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dislValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dsplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dsplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dsllValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dsllValue, GF);
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
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wcslValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wctlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wcplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wanlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watlValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.watlValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.waplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.waplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waelValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.waelValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wgplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wgllValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wgllValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wciplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wciplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrclValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wrclValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wislValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wislValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wsplValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wsplValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wsllValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wsllValue, GF);
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
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wcsmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wctmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcpmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wcpmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wanmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.watmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wapmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wapmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waemValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.waemValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgpmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wgpmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wglmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wglmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wcipmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wcipmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrcmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wrcmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wismValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wismValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wspmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wspmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wslmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.wslmValue, GF);
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
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dcsmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dctmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcpmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dcpmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.danmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.datmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dapmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dapmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daemValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.daemValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgpmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dgpmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dglmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dglmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dcipmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dcipmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drcmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.drcmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dismValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dismValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dspmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dspmValue, GF);
                            System.out.println("Velocity: " + fVec.skidVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dslmValue);
                            fVec.skidVelocity = calculateSkidVelocity(dragFactor.dslmValue, GF);
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
                    fVec.skidVelocity = fVec.skidVelocity * t / data.skidTime;
                    System.out.println("Time (Seconds): " + t + " " + "Velocity: " + fVec.skidVelocity);
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
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcslValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dctlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.danlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.datlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.daplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.daplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daelValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.daelValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dgplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dgllValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dgllValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dciplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dciplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drclValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.drclValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dislValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dislValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dsplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dsplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dsllValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dsllValue, GF);
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
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wcslValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wctlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wcplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wanlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watlValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.watlValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.waplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.waplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waelValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.waelValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wgplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wgllValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wgllValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wciplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wciplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrclValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wrclValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wislValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wislValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wsplValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wsplValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wsllValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wsllValue, GF);
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
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wcsmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.wctmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wctmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wcpmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wcpmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.wanmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wanmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.watmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.watmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.wapmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wapmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.waemValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.waemValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wgpmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcslValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wglmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wglmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wcipmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wcipmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.wrcmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wrcmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.wismValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wismValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.wspmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wspmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.wslmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.wslmValue, GF);
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
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcsmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.dctmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dctmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CEMENT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dcpmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcpmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_NEW:
                            System.out.println("Drag factor: " + dragFactor.danmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.danmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_TRAVELLED:
                            System.out.println("Drag factor: " + dragFactor.datmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.datmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_POLISHED:
                            System.out.println("Drag factor: " + dragFactor.dapmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dapmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ASPHALT_EXCESS:
                            System.out.println("Drag factor: " + dragFactor.daemValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.daemValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dgpmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dgpmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case GRAVEL_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dglmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dglmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case CINDERS_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dcipmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dcipmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ROCK_CRUSHED:
                            System.out.println("Drag factor: " + dragFactor.drcmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.drcmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case ICE_SMOOTH:
                            System.out.println("Drag factor: " + dragFactor.dismValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dismValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_PACKED:
                            System.out.println("Drag factor: " + dragFactor.dspmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dspmValue, GF);
                            System.out.println("Velocity: " + fVec.yawVelocity);
                            break;
                        case SNOW_LOOSE:
                            System.out.println("Drag factor: " + dragFactor.dslmValue);
                            fVec.yawVelocity = calculateYawVelocity(dragFactor.dslmValue, GF);
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
                    fVec.yawVelocity = fVec.yawVelocity * t / data.yawTime;
                    System.out.println("Time (Seconds): " + t + " " + "Velocity: " + fVec.yawVelocity);
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

                fVec.airborneVelocity = calculateAirborneVelocity(GF);

                System.out.println("Velocity: " + fVec.airborneVelocity);

                data.airborneTime = data.hypotenuseDistance / fVec.airborneVelocity;

                for (double t = 1; t <= data.airborneTime; t = t + 4) {
                    fVec.airborneVelocity = fVec.airborneVelocity * t / data.airborneTime;
                    System.out.println("Time (Seconds): " + t + " " + "Velocity: " + fVec.airborneVelocity);
                }

                break;

            default:
                System.out.println("Enter Case number");
        }
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
