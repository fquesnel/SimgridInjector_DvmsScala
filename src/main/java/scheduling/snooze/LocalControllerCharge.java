package scheduling.snooze;

/**
 * Created by sudholt on 25/05/2014.
 */
public class LocalControllerCharge {
    private LocalController lc = null;
    private int procCharge;
    private int memUsed;

    LocalControllerCharge(LocalController lc, int proc, int mem) {
        this.lc = lc; this.procCharge = proc; this.memUsed = mem;
    }

    public LocalController getLc() {
        return lc;
    }

    public void setLc(LocalController lc) {
        this.lc = lc;
    }

    public int getProcCharge() {
        return procCharge;
    }

    public void setProcCharge(int procCharge) {
        this.procCharge = procCharge;
    }

    public int getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(int memUsed) {
        this.memUsed = memUsed;
    }
}
