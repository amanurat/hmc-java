package se.leinonen.hmc.services;

import com.mongodb.rx.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import se.leinonen.hmc.domain.Group;
import se.leinonen.hmc.domain.GroupItem;

import java.util.List;

/**
 * Created by leinonen on 2016-03-30.
 */
@Service
public class GroupService {

    @Autowired
    private MongoDatabase database;

    public Observable<Group> getGroups() {

        return database
                .getCollection("groups")
                .find()
                .toObservable()
                .map(doc -> convert(doc));
    }

    private Group convert(Document document) {
        // TODO: Use objectMapper to handle these things.
        Group group = new Group();
        ObjectId id = (ObjectId) document.get("_id");
        group.setId(id.toString());
        group.setName(document.getString("name"));
        List<Document> items = (List<Document>) document.get("items");

/*        List<GroupItem> itemList = items.stream()
                .map(item -> new GroupItem(item.getString("id"), item.getString("type")))
                .collect(Collectors.toList());*/

        List<GroupItem> itemList = Observable.from(items)
                .map(item -> new GroupItem(item.getString("id"), item.getString("type")))
                .toList().toBlocking().first();

        group.setItems(itemList);
        return group;
    }
}
