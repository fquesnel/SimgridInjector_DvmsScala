package scheduling.snooze;

import org.simgrid.msg.Host;
import org.simgrid.msg.Process;
import org.simgrid.msg.Task;

/**
 * Created by sudholt on 22/06/2014.
 */
public class EntryPoint extends Process {
    private Host host;
    private GroupLeader gl;
    private String inbox = "entryPointInbox";
    private String glInbox = "glInbox";

    EntryPoint() {
        host = Host.currentHost();
    }

    public void main(String args[]) {
        while (true) {
            try {
                SnoozeMsg m = (SnoozeMsg) Task.receive(inbox);
                handle(m);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    void handle(SnoozeMsg m) { Logger.log("[EP.handle] Unknown message" + m); }

    void handle(NewLCMsg m) { // join/rejoin LC
        if (gl != null) {
            NewLCMsg mGl = new NewLCMsg((String) m.getMessage(), glInbox, null, null);
            mGl.send();
        } else Logger.log("[EP.handle] New LC without GL");
    }
}