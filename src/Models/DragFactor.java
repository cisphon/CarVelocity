package Models;

import java.util.*;

public final class DragFactor {
    Random random = new Random();

    public final double dcslMin = 0.80;
    public final double dcslMax = 1.20;
    public final double dcslValue = dcslMin + (dcslMax - dcslMin) * random.nextDouble();

    public final double dcsmMin = 0.70;
    public final double dcsmMax = 1.00;
    public final double dcsmValue = dcsmMin + (dcsmMax - dcsmMin) * random.nextDouble();

    public final double wcslMin = 0.50;
    public final double wcslMax = 0.80;
    public final double wcslValue = wcslMin + (wcslMax - wcslMin) * random.nextDouble();

    public final double wcsmMin = 0.40;
    public final double wcsmMax = 0.75;
    public final double wcsmValue = wcsmMin + (wcsmMax - wcsmMin) * random.nextDouble();

    //cement travelled ct
    public final double dctlMin = 0.60;
    public final double dctlMax = 0.80;
    public final double dctlValue = dctlMin + (dctlMax - dctlMin) * random.nextDouble();

    public final double dctmMin = 0.60;
    public final double dctmMax = 0.75;
    public final double dctmValue = dctmMin + (dctmMax - dctmMin) * random.nextDouble();

    public final double wctlMin = 0.45;
    public final double wctlMax = 0.70;
    public final double wctlValue = wctlMin + (wctlMax - wctlMin) * random.nextDouble();

    public final double wctmMin = 0.45;
    public final double wctmMax = 0.65;
    public final double wctmValue = wctmMin + (wctmMax - wctmMin) * random.nextDouble();

    //cement polished cp
    public final double dcplMin = 0.55;
    public final double dcplMax = 0.75;
    public final double dcplValue = dcplMin + (dcplMax - dcplMin) * random.nextDouble();

    public final double dcpmMin = 0.50;
    public final double dcpmMax = 0.65;
    public final double dcpmValue = dcpmMin + (dcpmMax - dcpmMin) * random.nextDouble();

    public final double wcplMin = 0.45;
    public final double wcplMax = 0.65;
    public final double wcplValue = wcplMin + (wcplMax - wcplMin) * random.nextDouble();

    public final double wcpmMin = 0.45;
    public final double wcpmMax = 0.60;
    public final double wcpmValue = wcpmMin + (wcpmMax - wcpmMin) * random.nextDouble();

    //asphalt new an
    public final double danlMin = 0.80;
    public final double danlMax = 1.20;
    public final double danlValue = danlMin + (danlMax - danlMin) * random.nextDouble();

    public final double danmMin = 0.65;
    public final double danmMax = 1.00;
    public final double danmValue = danmMin + (danmMax - danmMin) * random.nextDouble();

    public final double wanlMin = 0.50;
    public final double wanlMax = 0.80;
    public final double wanlValue = wanlMin + (wanlMax - wanlMin) * random.nextDouble();

    public final double wanmMin = 0.45;
    public final double wanmMax = 0.75;
    public final double wanmValue = wanmMin + (wanmMax - wanmMin) * random.nextDouble();

    //asphalt travelled at
    public final double datlMin = 0.60;
    public final double datlMax = 0.80;
    public final double datlValue = datlMin + (datlMax - datlMin) * random.nextDouble();

    public final double datmMin = 0.55;
    public final double datmMax = 0.70;
    public final double datmValue = datmMin + (datmMax - datmMin) * random.nextDouble();

    public final double watlMin = 0.45;
    public final double watlMax = 0.70;
    public final double watlValue = watlMin + (watlMax - watlMin) * random.nextDouble();

    public final double watmMin = 0.40;
    public final double watmMax = 0.65;
    public final double watmValue = watmMin + (watmMax - watmMin) * random.nextDouble();

    //asphalt polished ap
    public final double daplMin = 0.55;
    public final double daplMax = 0.75;
    public final double daplValue = daplMin + (daplMax - daplMin) * random.nextDouble();

    public final double dapmMin = 0.45;
    public final double dapmMax = 0.65;
    public final double dapmValue = dapmMin + (dapmMax - dapmMin) * random.nextDouble();

    public final double waplMin = 0.45;
    public final double waplMax = 0.65;
    public final double waplValue = waplMin + (waplMax - waplMin) * random.nextDouble();

    public final double wapmMin = 0.40;
    public final double wapmMax = 0.60;
    public final double wapmValue = wapmMin + (wapmMax - wapmMin) * random.nextDouble();

    //asphalt excess tar ae
    public final double daelMin = 0.50;
    public final double daelMax = 0.60;
    public final double daelValue = daelMin + (daelMax - daelMin) * random.nextDouble();

    public final double daemMin = 0.35;
    public final double daemMax = 0.60;
    public final double daemValue = daemMin + (daemMax - daemMin) * random.nextDouble();

    public final double waelMin = 0.30;
    public final double waelMax = 0.60;
    public final double waelValue = waelMin + (waelMax - waelMin) * random.nextDouble();

    public final double waemMin = 0.25;
    public final double waemMax = 0.55;
    public final double waemValue = waemMin + (waemMax - waemMin) * random.nextDouble();

    //gravel packed gp
    public final double dgplMin = 0.55;
    public final double dgplMax = 0.85;
    public final double dgplValue = dgplMin + (dgplMax - dgplMin) * random.nextDouble();

    public final double dgpmMin = 0.50;
    public final double dgpmMax = 0.80;
    public final double dgpmValue = dgpmMin + (dgpmMax - dgpmMin) * random.nextDouble();

    public final double wgplMin = 0.40;
    public final double wgplMax = 0.80;
    public final double wgplValue = wgplMin + (wgplMax - wgplMin) * random.nextDouble();

    public final double wgpmMin = 0.40;
    public final double wgpmMax = 0.60;
    public final double wgpmValue = wgpmMin + (wgpmMax - wgpmMin) * random.nextDouble();

    //gravel loose gl
    public final double dgllMin = 0.40;
    public final double dgllMax = 0.70;
    public final double dgllValue = dgllMin + (dgllMax - dgllMin) * random.nextDouble();

    public final double dglmMin = 0.40;
    public final double dglmMax = 0.70;
    public final double dglmValue = dglmMin + (dglmMax - dglmMin) * random.nextDouble();

    public final double wgllMin = 0.45;
    public final double wgllMax = 0.75;
    public final double wgllValue = wgllMin + (wgllMax - wgllMin) * random.nextDouble();

    public final double wglmMin = 0.45;
    public final double wglmMax = 0.75;
    public final double wglmValue = wglmMin + (wglmMax - wglmMin) * random.nextDouble();

    //cinder packed cip
    public final double dciplMin = 0.50;
    public final double dciplMax = 0.70;
    public final double dciplValue = dciplMin + (dciplMax - dciplMin) * random.nextDouble();

    public final double dcipmMin = 0.50;
    public final double dcipmMax = 0.70;
    public final double dcipmValue = dcipmMin + (dcipmMax - dcipmMin) * random.nextDouble();

    public final double wciplMin = 0.65;
    public final double wciplMax = 0.75;
    public final double wciplValue = wciplMin + (wciplMax - wciplMin) * random.nextDouble();

    public final double wcipmMin = 0.65;
    public final double wcipmMax = 0.75;
    public final double wcipmValue = wcipmMin + (wcipmMax - wcipmMin) * random.nextDouble();

    //rock crushed rc
    public final double drclMin = 0.55;
    public final double drclMax = 0.75;
    public final double drclValue = drclMin + (drclMax - drclMin) * random.nextDouble();

    public final double drcmMin = 0.55;
    public final double drcmMax = 0.75;
    public final double drcmValue = drcmMin + (drcmMax - drcmMin) * random.nextDouble();

    public final double wrclMin = 0.55;
    public final double wrclMax = 0.75;
    public final double wrclValue = wrclMin + (wrclMax - wrclMin) * random.nextDouble();

    public final double wrcmMin = 0.55;
    public final double wrcmMax = 0.75;
    public final double wrcmValue = wrcmMin + (wrcmMax - wrcmMin) * random.nextDouble();

    //ice smooth is
    public final double dislMin = 0.10;
    public final double dislMax = 0.25;
    public final double dislValue = dislMin + (dislMax - dislMin) * random.nextDouble();

    public final double dismMin = 0.07;
    public final double dismMax = 0.20;
    public final double dismValue = dismMin + (dismMax - dismMin) * random.nextDouble();

    public final double wislMin = 0.05;
    public final double wislMax = 0.10;
    public final double wislValue = wislMin + (wislMax - wislMin) * random.nextDouble();

    public final double wismMin = 0.05;
    public final double wismMax = 0.10;
    public final double wismValue = wismMin + (wismMax - wismMin) * random.nextDouble();

    //snow packed sp
    public final double dsplMin = 0.30;
    public final double dsplMax = 0.55;
    public final double dsplValue = dsplMin + (dsplMax - dsplMin) * random.nextDouble();

    public final double dspmMin = 0.35;
    public final double dspmMax = 0.55;
    public final double dspmValue = dspmMin + (dspmMax - dspmMin) * random.nextDouble();

    public final double wsplMin = 0.30;
    public final double wsplMax = 0.60;
    public final double wsplValue = wsplMin + (wsplMax - wsplMin) * random.nextDouble();

    public final double wspmMin = 0.30;
    public final double wspmMax = 0.60;
    public final double wspmValue = wspmMin + (wspmMax - wspmMin) * random.nextDouble();

    //snow loose sl
    public final double dsllMin = 0.10;
    public final double dsllMax = 0.25;
    public final double dsllValue = dsllMin + (dsllMax - dsllMin) * random.nextDouble();

    public final double dslmMin = 0.10;
    public final double dslmMax = 0.20;
    public final double dslmValue = dslmMin + (dslmMax - dslmMin) * random.nextDouble();

    public final double wsllMin = 0.30;
    public final double wsllMax = 0.60;
    public final double wsllValue = wsllMin + (wsllMax - wsllMin) * random.nextDouble();

    public final double wslmMin = 0.30;
    public final double wslmMax = 0.60;
    public final double wslmValue = wslmMin + (wslmMax - wslmMin) * random.nextDouble();
}