package ua.com.alevel;

import java.util.Date;

public abstract class BaseCreatedClass extends BaseClass {

    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
