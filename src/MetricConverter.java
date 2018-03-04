public class MetricConverter {

    int calculateCMfromM(int wartosc1){
        int cm=wartosc1*100;
        return cm;
    }

    int calculateMMfromM(int wartosc1) {
        int mm = wartosc1 * 1000;
        return mm;
    }

    int calculateMfromCM(int wartosc1){
        int m=wartosc1/100;
        return m;
    }

    int calculateMMfromCM(int wartosc1){
        int mm=wartosc1*10;
        return mm;
    }

    int calculateMfromMM (int wartosc1){
        int m=wartosc1/1000;
        return m;
    }

    int calculateCMfromMM(int wartosc1){
        int cm=wartosc1/10;
        return cm;
    }
}
