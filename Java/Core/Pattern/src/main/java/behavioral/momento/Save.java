package behavioral.momento;

import java.util.Date;

public class Save {
    private final String version;
    private final Date date;

    public Save(String version, Date date) {
        this.version = version;
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}
