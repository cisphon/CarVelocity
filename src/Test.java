import java.util.Scanner;

public class Test extends DragFactor {
    static Scanner sc = new Scanner(System.in);

    // this prints the cases
    public static void prompt(int mph) {
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

    public static void main(String[] args) {

        System.out.println("Please select case number:");
        System.out.println("1.Skid Case");
        System.out.println("2.Yaw Case");
        System.out.println("3.Airborne Case");
        int Case = sc.nextInt();

        System.out.println("Please input altitude(meters):");
        double r = sc.nextDouble();

        //validates altitude
        while (r >= 5000) {
            System.out.println("Are you sure this data is correct?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int validation = sc.nextInt();
            if (validation == 1)
                break;
            else {
                System.out.println("Please input altitude(meters):");
                r = sc.nextDouble();
            }
        }

        double g = 9.80665;
        double re = 6731009;
        double GF = g * Math.pow((re / (re + r)), 2.0);

        switch (Case) {
            case 1:
                System.out.println("Please input MPH:");
                int mph = sc.nextInt();
                //validates mph
                while (mph >= 200) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please input MPH:");
                        mph = sc.nextInt();
                    }
                }

                System.out.println("Please input Wet or Dry:");
                String wod = sc.next();

                prompt(mph);
                int road = sc.nextInt();

                System.out.println("Please enter Final Velocity:");
                double vf = sc.nextDouble();
                //validates final velocity
                while (vf >= 500) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter Final Velocity:");
                        vf = sc.nextDouble();
                    }
                }

                System.out.println("Please enter Skid Distance(meters):");
                double sd = sc.nextDouble();
                //validates skid distance
                while (sd >= 500) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter Skid Distance(meters):");
                        sd = sc.nextDouble();
                    }
                }

                if (mph < 30 && (wod.contains("dry") || wod.contains("Dry"))) {
                    switch (road) {

                        case 1:
                            System.out.println("Drag factor: " + dcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcslValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + dctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dctlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + dcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + danlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * danlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + datlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * datlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + daplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + daelValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daelValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + dgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + dgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgllValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + dciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dciplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + drclValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * drclValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + dislValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dislValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + dsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dsplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + dsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dsllValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph < 30 && (wod.contains("wet") || wod.contains("Wet"))) {
                    switch (road) {

                        case 1:
                            System.out.println("Drag factor: " + wcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcslValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + wctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wctlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + wcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + wanlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wanlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + watlValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * watlValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + waplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + waelValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waelValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + wgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + wgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgllValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + wciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wciplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + wrclValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wrclValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + wislValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wislValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + wsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wsplValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + wsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wsllValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph >= 30 && (wod.contains("wet") || wod.contains("Wet"))) {
                    switch (road) {

                        case 1:
                            System.out.println("Drag factor: " + wcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcsmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + wctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wctmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + wcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcpmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + wanmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wanmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + watmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * watmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + wapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wapmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + waemValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * waemValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + wgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wgpmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + wglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wglmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + wcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wcipmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + wrcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wrcmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + wismValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wismValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + wspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wspmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + wslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * wslmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph >= 30 && (wod.contains("dry") || wod.contains("Dry"))) {
                    switch (road) {

                        case 1:
                            System.out.println("Drag factor: " + dcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcsmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + dctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dctmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + dcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcpmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + danmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * danmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + datmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * datmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + dapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dapmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + daemValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * daemValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + dgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dgpmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + dglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dglmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + dcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dcipmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + drcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * drcmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + dismValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dismValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + dspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dspmValue * GF * sd + Math.pow(vf, 2))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + dslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(2.0 * dslmValue * GF * sd + Math.pow(vf, 2))));
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
                int mph2 = sc.nextInt();
                //validates mph2
                while (mph2 >= 200) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please input MPH:");
                        mph2 = sc.nextInt();
                    }
                }

                System.out.println("Please input Wet or Dry:");
                String wod2 = sc.next();

                prompt(mph2);
                int road2 = sc.nextInt();

                System.out.println("Please enter the Radius:");
                double R = sc.nextDouble();
                //validates radius
                while (R >= 1000) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter the Radius:");
                        R = sc.nextDouble();
                    }
                }

                System.out.println("Please enter super-elevation(as decimal):");
                double e = sc.nextDouble();
                //validates super-elevation
                while (e >= 1) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter super-elevation(as decimal):");
                        e = sc.nextDouble();
                    }
                }

                if (mph2 < 30 && (wod2.contains("dry") || wod2.contains("Dry"))) {
                    switch (road2) {

                        case 1:
                            System.out.println("Drag factor: " + dcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * ((dcslValue + e) / (1 - (dcslValue * e))))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + dctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dctlValue + e) / (1 - (dctlValue * e)))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + dcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dcplValue + e) / (1 - (dcplValue * e)))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + danlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (danlValue + e) / (1 - (danlValue * e)))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + datlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (datlValue + e) / (1 - (datlValue * e)))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + daplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (daplValue + e) / (1 - (daplValue * e)))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + daelValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (daelValue + e) / (1 - (daelValue * e)))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + dgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dgplValue + e) / (1 - (dgplValue * e)))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + dgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dgllValue + e) / (1 - (dgllValue * e)))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + dciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dciplValue + e) / (1 - (dciplValue * e)))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + drclValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (drclValue + e) / (1 - (drclValue * e)))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + dislValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dislValue + e) / (1 - (dislValue * e)))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + dsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dsplValue + e) / (1 - (dsplValue * e)))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + dsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dsllValue + e) / (1 - (dsllValue * e)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph2 < 30 && (wod2.contains("wet") || wod2.contains("Wet"))) {
                    switch (road2) {

                        case 1:
                            System.out.println("Drag factor: " + wcslValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wcslValue + e) / (1 - (wcslValue * e)))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + wctlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wctlValue + e) / (1 - (wctlValue * e)))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + wcplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wcplValue + e) / (1 - (wcplValue * e)))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + wanlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wanlValue + e) / (1 - (wanlValue * e)))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + watlValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (watlValue + e) / (1 - (watlValue * e)))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + waplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (waplValue + e) / (1 - (waplValue * e)))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + waelValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (waelValue + e) / (1 - (waelValue * e)))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + wgplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wgplValue + e) / (1 - (wgplValue * e)))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + wgllValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wgllValue + e) / (1 - (wgllValue * e)))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + wciplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wciplValue + e) / (1 - (wciplValue * e)))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + wrclValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wrclValue + e) / (1 - (wrclValue * e)))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + wislValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wislValue + e) / (1 - (wislValue * e)))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + wsplValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wsplValue + e) / (1 - (wsplValue * e)))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + wsllValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wsllValue + e) / (1 - (wsllValue * e)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph2 >= 30 && (wod2.contains("wet") || wod2.contains("Wet"))) {
                    switch (road2) {

                        case 1:
                            System.out.println("Drag factor: " + wcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wcsmValue + e) / (1 - (wcsmValue * e)))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + wctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wctmValue + e) / (1 - (wctmValue * e)))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + wcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wcpmValue + e) / (1 - (wcpmValue * e)))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + wanmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wanmValue + e) / (1 - (wanmValue * e)))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + watmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (watmValue + e) / (1 - (watmValue * e)))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + wapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wapmValue + e) / (1 - (wapmValue * e)))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + waemValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (waemValue + e) / (1 - (waemValue * e)))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + wgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wgpmValue + e) / (1 - (wgpmValue * e)))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + wglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wglmValue + e) / (1 - (wglmValue * e)))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + wcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wcipmValue + e) / (1 - (wcipmValue * e)))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + wrcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wrcmValue + e) / (1 - (wrcmValue * e)))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + wismValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wismValue + e) / (1 - (wismValue * e)))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + wspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wspmValue + e) / (1 - (wspmValue * e)))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + wslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (wslmValue + e) / (1 - (wslmValue * e)))));
                            break;
                        default:
                            System.out.println("Select Road Surface");
                            break;
                    }
                } else if (mph2 >= 30 && (wod2.contains("dry") || wod2.contains("Dry"))) {
                    switch (road2) {

                        case 1:
                            System.out.println("Drag factor: " + dcsmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dcsmValue + e) / (1 - (dcsmValue * e)))));
                            break;
                        case 2:
                            System.out.println("Drag factor: " + dctmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dctmValue + e) / (1 - (dctmValue * e)))));
                            break;
                        case 3:
                            System.out.println("Drag factor: " + dcpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dcpmValue + e) / (1 - (dcpmValue * e)))));
                            break;
                        case 4:
                            System.out.println("Drag factor: " + danmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (danmValue + e) / (1 - (danmValue * e)))));
                            break;
                        case 5:
                            System.out.println("Drag factor: " + datmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (datmValue + e) / (1 - (datmValue * e)))));
                            break;
                        case 6:
                            System.out.println("Drag factor: " + dapmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dapmValue + e) / (1 - (dapmValue * e)))));
                            break;
                        case 7:
                            System.out.println("Drag factor: " + daemValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (daemValue + e) / (1 - (daemValue * e)))));
                            break;
                        case 8:
                            System.out.println("Drag factor: " + dgpmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dgpmValue + e) / (1 - (dgpmValue * e)))));
                            break;
                        case 9:
                            System.out.println("Drag factor: " + dglmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dglmValue + e) / (1 - (dglmValue * e)))));
                            break;
                        case 10:
                            System.out.println("Drag factor: " + dcipmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dcipmValue + e) / (1 - (dcipmValue * e)))));
                            break;
                        case 11:
                            System.out.println("Drag factor: " + drcmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (drcmValue + e) / (1 - (drcmValue * e)))));
                            break;
                        case 12:
                            System.out.println("Drag factor: " + dismValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dismValue + e) / (1 - (dismValue * e)))));
                            break;
                        case 13:
                            System.out.println("Drag factor: " + dspmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dspmValue + e) / (1 - (dspmValue * e)))));
                            break;
                        case 14:
                            System.out.println("Drag factor: " + dslmValue);
                            System.out.println("Velocity: " + (Math.sqrt(R * GF * (dslmValue + e) / (1 - (dslmValue * e)))));
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
                double D = sc.nextDouble();
                //validates horizontal distance
                while (D >= 200) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter the the horizontal distance:");
                        D = sc.nextDouble();
                    }
                }

                System.out.println("Please enter the the vertical distance:");
                double H = sc.nextDouble();
                //validates vertical distance
                while (H >= 200) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter the the vertical distance:");
                        H = sc.nextDouble();
                    }
                }

                System.out.println("Please enter super-elevation(as decimal):");
                double se = sc.nextDouble();
                //validates super-elevation
                while (se >= 1) {
                    System.out.println("Are you sure this data is correct?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int validation = sc.nextInt();
                    if (validation == 1)
                        break;
                    else {
                        System.out.println("Please enter super-elevation(as decimal):");
                        se = sc.nextDouble();
                    }
                }

                System.out.println("Velocity: " + (Math.sqrt(GF * Math.pow(D, 2)) / (2 * (H + (D * se)))));

                break;

            default:
                System.out.println("Enter Case number");
        }
    }
}

