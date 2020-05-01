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

                // these cases choose drag factor
                if (data.mph < 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcslValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctlValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcplValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danlValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datlValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.daplValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daelValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgplValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dgllValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dciplValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drclValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dislValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dsplValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dsllValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcslValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctlValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcplValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanlValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watlValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.waplValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waelValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgplValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wgllValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wciplValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrclValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wislValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wsplValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wsllValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcsmValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctmValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcpmValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanmValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watmValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.wapmValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waemValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgpmValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wglmValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wcipmValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrcmValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wismValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wspmValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wslmValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcsmValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctmValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcpmValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danmValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datmValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.dapmValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daemValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgpmValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dglmValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dcipmValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drcmValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dismValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dspmValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dslmValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                // dragFactorUsed is assigned inside of the cases
                System.out.println("Drag factor: " + data.dragFactorUsed);

                // calculate the velocity
                data.skidVelocity = calculateSkidVelocity(data.dragFactorUsed, GF, data.skidDistance, data.finalVelocity);
                System.out.println("Velocity: " + data.skidVelocity);

                // calculate skid time
                data.skidTime = data.skidDistance / data.skidVelocity;
                System.out.println("Time: " + data.skidTime);


                //TODO reconstruct velocity at time t

//                for (data.accidentTime = 1; data.accidentTime <= data.skidTime; data.accidentTime++) {
//                    data.skidVelocity = data.skidVelocity * data.accidentTime / data.skidTime;
//                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.skidVelocity);
//                }

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

                // these cases choose drag factor
                if (data.mph < 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcslValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctlValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcplValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danlValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datlValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.daplValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daelValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgplValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dgllValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dciplValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drclValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dislValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dsplValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dsllValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph < 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcslValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctlValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcplValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanlValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watlValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.waplValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waelValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgplValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wgllValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wciplValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrclValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wislValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wsplValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wsllValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.WET)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.wcsmValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.wctmValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.wcpmValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.wanmValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.watmValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.wapmValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.waemValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.wgpmValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.wglmValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.wcipmValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.wrcmValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.wismValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.wspmValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.wslmValue;
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (data.mph >= 30 && (data.weather == Weather.DRY)) {
                    switch (data.roadType) {
                        case CEMENT_NEW:
                            data.dragFactorUsed = dragFactor.dcsmValue;
                            break;
                        case CEMENT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.dctmValue;
                            break;
                        case CEMENT_POLISHED:
                            data.dragFactorUsed = dragFactor.dcpmValue;
                            break;
                        case ASPHALT_NEW:
                            data.dragFactorUsed = dragFactor.danmValue;
                            break;
                        case ASPHALT_TRAVELLED:
                            data.dragFactorUsed = dragFactor.datmValue;
                            break;
                        case ASPHALT_POLISHED:
                            data.dragFactorUsed = dragFactor.dapmValue;
                            break;
                        case ASPHALT_EXCESS:
                            data.dragFactorUsed = dragFactor.daemValue;
                            break;
                        case GRAVEL_PACKED:
                            data.dragFactorUsed = dragFactor.dgpmValue;
                            break;
                        case GRAVEL_LOOSE:
                            data.dragFactorUsed = dragFactor.dglmValue;
                            break;
                        case CINDERS_PACKED:
                            data.dragFactorUsed = dragFactor.dcipmValue;
                            break;
                        case ROCK_CRUSHED:
                            data.dragFactorUsed = dragFactor.drcmValue;
                            break;
                        case ICE_SMOOTH:
                            data.dragFactorUsed = dragFactor.dismValue;
                            break;
                        case SNOW_PACKED:
                            data.dragFactorUsed = dragFactor.dspmValue;
                            break;
                        case SNOW_LOOSE:
                            data.dragFactorUsed = dragFactor.dslmValue;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else {
                    System.out.println("Error");
                }

                // dragFactorUsed is assigned in cases
                System.out.println("Drag factor: " + data.dragFactorUsed);

                // calculate velocity
                data.yawVelocity = calculateYawVelocity(data.dragFactorUsed, GF, data.radius, data.superElevation);
                System.out.println("Velocity: " + data.yawVelocity);

                // calculate yaw time
                data.yawTime = data.radius / data.yawVelocity;
                System.out.println("Time: " + data.yawTime);

                //TODO reconstruct velocity at time t

//                for (data.accidentTime = 1; data.accidentTime <= data.yawTime; data.accidentTime++) {
//                    data.yawVelocity = data.yawVelocity * data.accidentTime / data.yawTime;
//                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.yawVelocity);
//                }


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

                data.airborneVelocity = calculateAirborneVelocity(GF, data.horizontalDistance, data.verticalDistance, data.superElevation);
                System.out.println("Velocity: " + data.airborneVelocity);

                // calculate airborne time
                data.airborneTime = data.hypotenuseDistance / data.airborneVelocity;
                System.out.println("Time: " + data.airborneTime);


                //TODO reconstruct velocity at time t

//                for (data.accidentTime = 1; data.accidentTime <= data.airborneTime; data.accidentTime = data.accidentTime + 4) {
//                    data.airborneVelocity = data.airborneVelocity * data.accidentTime / data.airborneTime;
//                    System.out.println("Time (Seconds): " + data.accidentTime + " " + "Velocity: " + data.airborneVelocity);
//                }

                break;

            default:
                System.out.println("Enter Case number");
        }

        return data;
    }

    private double calculateSkidVelocity(double dragFactor, double GF, double skidDistance, double finalVelocity) {
        return Math.sqrt(2.0 * dragFactor * GF * skidDistance + Math.pow(finalVelocity, 2));
    }

    private double calculateYawVelocity(double dragFactor, double GF, double radius, double superElevation) {
        return Math.sqrt(radius * GF * ((dragFactor + superElevation) / (1 - (dragFactor * superElevation))));
    }

    private double calculateAirborneVelocity(double GF, double horizontalDistance, double verticalDistance, double superElevation) {
        data.hypotenuseDistance = Math.sqrt(Math.pow(horizontalDistance, 2) + Math.pow(verticalDistance, 2));

        //validates super-elevation
        superElevation = validateSuperElevation(superElevation);

        return Math.sqrt(GF * Math.pow(horizontalDistance, 2)) / (2 * (verticalDistance + (horizontalDistance * superElevation)));
    }
}
