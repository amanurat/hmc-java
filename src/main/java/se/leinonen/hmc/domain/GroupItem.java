package se.leinonen.hmc.domain;

/**
 * Created by leinonen on 2016-04-01.
 */
public class GroupItem {
    private String id;
    private String type;

    public GroupItem(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
