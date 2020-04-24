import java.util.*;

public class DragFactor {
    static Random random = new Random();

    static double dcslMin = 0.80;
    static double dcslMax = 1.20;
    static double dcslValue = dcslMin + (dcslMax - dcslMin) * random.nextDouble();

    static double dcsmMin = 0.70;
    static double dcsmMax = 1.00;
    static double dcsmValue = dcsmMin + (dcsmMax - dcsmMin) * random.nextDouble();

    static double wcslMin = 0.50;
    static double wcslMax = 0.80;
    static double wcslValue = wcslMin + (wcslMax - wcslMin) * random.nextDouble();

    static double wcsmMin = 0.40;
    static double wcsmMax = 0.75;
    static double wcsmValue = wcsmMin + (wcsmMax - wcsmMin) * random.nextDouble();

    //cement travelled ct
    static double dctlMin = 0.60;
    static double dctlMax = 0.80;
    static double dctlValue = dctlMin + (dctlMax - dctlMin) * random.nextDouble();

    static double dctmMin = 0.60;
    static double dctmMax = 0.75;
    static double dctmValue = dctmMin + (dctmMax - dctmMin) * random.nextDouble();

    static double wctlMin = 0.45;
    static double wctlMax = 0.70;
    static double wctlValue = wctlMin + (wctlMax - wctlMin) * random.nextDouble();

    static double wctmMin = 0.45;
    static double wctmMax = 0.65;
    static double wctmValue = wctmMin + (wctmMax - wctmMin) * random.nextDouble();

    //cement polished cp
    static double dcplMin = 0.55;
    static double dcplMax = 0.75;
    static double dcplValue = dcplMin + (dcplMax - dcplMin) * random.nextDouble();

    static double dcpmMin = 0.50;
    static double dcpmMax = 0.65;
    static double dcpmValue = dcpmMin + (dcpmMax - dcpmMin) * random.nextDouble();

    static double wcplMin = 0.45;
    static double wcplMax = 0.65;
    static double wcplValue = wcplMin + (wcplMax - wcplMin) * random.nextDouble();

    static double wcpmMin = 0.45;
    static double wcpmMax = 0.60;
    static double wcpmValue = wcpmMin + (wcpmMax - wcpmMin) * random.nextDouble();

    //asphalt new an
    static double danlMin = 0.80;
    static double danlMax = 1.20;
    static double danlValue = danlMin + (danlMax - danlMin) * random.nextDouble();

    static double danmMin = 0.65;
    static double danmMax = 1.00;
    static double danmValue = danmMin + (danmMax - danmMin) * random.nextDouble();

    static double wanlMin = 0.50;
    static double wanlMax = 0.80;
    static double wanlValue = wanlMin + (wanlMax - wanlMin) * random.nextDouble();

    static double wanmMin = 0.45;
    static double wanmMax = 0.75;
    static double wanmValue = wanmMin + (wanmMax - wanmMin) * random.nextDouble();

    //asphalt travelled at
    static double datlMin = 0.60;
    static double datlMax = 0.80;
    static double datlValue = datlMin + (datlMax - datlMin) * random.nextDouble();

    static double datmMin = 0.55;
    static double datmMax = 0.70;
    static double datmValue = datmMin + (datmMax - datmMin) * random.nextDouble();

    static double watlMin = 0.45;
    static double watlMax = 0.70;
    static double watlValue = watlMin + (watlMax - watlMin) * random.nextDouble();

    static double watmMin = 0.40;
    static double watmMax = 0.65;
    static double watmValue = watmMin + (watmMax - watmMin) * random.nextDouble();

    //asphalt polished ap
    static double daplMin = 0.55;
    static double daplMax = 0.75;
    static double daplValue = daplMin + (daplMax - daplMin) * random.nextDouble();

    static double dapmMin = 0.45;
    static double dapmMax = 0.65;
    static double dapmValue = dapmMin + (dapmMax - dapmMin) * random.nextDouble();

    static double waplMin = 0.45;
    static double waplMax = 0.65;
    static double waplValue = waplMin + (waplMax - waplMin) * random.nextDouble();

    static double wapmMin = 0.40;
    static double wapmMax = 0.60;
    static double wapmValue = wapmMin + (wapmMax - wapmMin) * random.nextDouble();

    //asphalt excess tar ae
    static double daelMin = 0.50;
    static double daelMax = 0.60;
    static double daelValue = daelMin + (daelMax - daelMin) * random.nextDouble();

    static double daemMin = 0.35;
    static double daemMax = 0.60;
    static double daemValue = daemMin + (daemMax - daemMin) * random.nextDouble();

    static double waelMin = 0.30;
    static double waelMax = 0.60;
    static double waelValue = waelMin + (waelMax - waelMin) * random.nextDouble();

    static double waemMin = 0.25;
    static double waemMax = 0.55;
    static double waemValue = waemMin + (waemMax - waemMin) * random.nextDouble();

    //gravel packed gp
    static double dgplMin = 0.55;
    static double dgplMax = 0.85;
    static double dgplValue = dgplMin + (dgplMax - dgplMin) * random.nextDouble();

    static double dgpmMin = 0.50;
    static double dgpmMax = 0.80;
    static double dgpmValue = dgpmMin + (dgpmMax - dgpmMin) * random.nextDouble();

    static double wgplMin = 0.40;
    static double wgplMax = 0.80;
    static double wgplValue = wgplMin + (wgplMax - wgplMin) * random.nextDouble();

    static double wgpmMin = 0.40;
    static double wgpmMax = 0.60;
    static double wgpmValue = wgpmMin + (wgpmMax - wgpmMin) * random.nextDouble();

    //gravel loose gl
    static double dgllMin = 0.40;
    static double dgllMax = 0.70;
    static double dgllValue = dgllMin + (dgllMax - dgllMin) * random.nextDouble();

    static double dglmMin = 0.40;
    static double dglmMax = 0.70;
    static double dglmValue = dglmMin + (dglmMax - dglmMin) * random.nextDouble();

    static double wgllMin = 0.45;
    static double wgllMax = 0.75;
    static double wgllValue = wgllMin + (wgllMax - wgllMin) * random.nextDouble();

    static double wglmMin = 0.45;
    static double wglmMax = 0.75;
    static double wglmValue = wglmMin + (wglmMax - wglmMin) * random.nextDouble();

    //cinder packed cip
    static double dciplMin = 0.50;
    static double dciplMax = 0.70;
    static double dciplValue = dciplMin + (dciplMax - dciplMin) * random.nextDouble();

    static double dcipmMin = 0.50;
    static double dcipmMax = 0.70;
    static double dcipmValue = dcipmMin + (dcipmMax - dcipmMin) * random.nextDouble();

    static double wciplMin = 0.65;
    static double wciplMax = 0.75;
    static double wciplValue = wciplMin + (wciplMax - wciplMin) * random.nextDouble();

    static double wcipmMin = 0.65;
    static double wcipmMax = 0.75;
    static double wcipmValue = wcipmMin + (wcipmMax - wcipmMin) * random.nextDouble();

    //rock crushed rc
    static double drclMin = 0.55;
    static double drclMax = 0.75;
    static double drclValue = drclMin + (drclMax - drclMin) * random.nextDouble();

    static double drcmMin = 0.55;
    static double drcmMax = 0.75;
    static double drcmValue = drcmMin + (drcmMax - drcmMin) * random.nextDouble();

    static double wrclMin = 0.55;
    static double wrclMax = 0.75;
    static double wrclValue = wrclMin + (wrclMax - wrclMin) * random.nextDouble();

    static double wrcmMin = 0.55;
    static double wrcmMax = 0.75;
    static double wrcmValue = wrcmMin + (wrcmMax - wrcmMin) * random.nextDouble();

    //ice smooth is
    static double dislMin = 0.10;
    static double dislMax = 0.25;
    static double dislValue = dislMin + (dislMax - dislMin) * random.nextDouble();

    static double dismMin = 0.07;
    static double dismMax = 0.20;
    static double dismValue = dismMin + (dismMax - dismMin) * random.nextDouble();

    static double wislMin = 0.05;
    static double wislMax = 0.10;
    static double wislValue = wislMin + (wislMax - wislMin) * random.nextDouble();

    static double wismMin = 0.05;
    static double wismMax = 0.10;
    static double wismValue = wismMin + (wismMax - wismMin) * random.nextDouble();

    //snow packed sp
    static double dsplMin = 0.30;
    static double dsplMax = 0.55;
    static double dsplValue = dsplMin + (dsplMax - dsplMin) * random.nextDouble();

    static double dspmMin = 0.35;
    static double dspmMax = 0.55;
    static double dspmValue = dspmMin + (dspmMax - dspmMin) * random.nextDouble();

    static double wsplMin = 0.30;
    static double wsplMax = 0.60;
    static double wsplValue = wsplMin + (wsplMax - wsplMin) * random.nextDouble();

    static double wspmMin = 0.30;
    static double wspmMax = 0.60;
    static double wspmValue = wspmMin + (wspmMax - wspmMin) * random.nextDouble();

    //snow loose sl
    static double dsllMin = 0.10;
    static double dsllMax = 0.25;
    static double dsllValue = dsllMin + (dsllMax - dsllMin) * random.nextDouble();

    static double dslmMin = 0.10;
    static double dslmMax = 0.20;
    static double dslmValue = dslmMin + (dslmMax - dslmMin) * random.nextDouble();

    static double wsllMin = 0.30;
    static double wsllMax = 0.60;
    static double wsllValue = wsllMin + (wsllMax - wsllMin) * random.nextDouble();

    static double wslmMin = 0.30;
    static double wslmMax = 0.60;
    static double wslmValue = wslmMin + (wslmMax - wslmMin) * random.nextDouble();
}