package fa.training.demojwd.model.service;

import fa.training.demojwd.model.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> findAll();

    boolean create(Event event);

}
