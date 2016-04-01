package se.leinonen.hmc.controllers;

import com.mongodb.rx.client.FindObservable;
import com.mongodb.rx.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import se.leinonen.hmc.domain.Device;
import se.leinonen.hmc.domain.Group;
import se.leinonen.hmc.services.GroupService;

import java.util.List;

/**
 * Created by leinonen on 2016-03-30.
 */
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<ResponseEntity<List<Group>>> index() {
        DeferredResult<ResponseEntity<List<Group>>> deferredResult = new DeferredResult<>();

        List<Group> groups = groupService.getGroups()
                .toList().toBlocking().first();

        deferredResult.setResult(ResponseEntity.accepted().body(groups));

        return deferredResult;
    }

}
