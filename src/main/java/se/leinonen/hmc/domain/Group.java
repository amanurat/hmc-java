package se.leinonen.hmc.domain;

import java.util.List;

/**
 * Created by leinonen on 2016-03-30.
 */
public class Group {
    private String name;
    private String id;
    private List<GroupItem> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<GroupItem> getItems() {
        return items;
    }

    public void setItems(List<GroupItem> items) {
        this.items = items;
    }
}
