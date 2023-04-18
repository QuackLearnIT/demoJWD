package fa.training.demojwd.model.dao;

import fa.training.demojwd.model.entity.Event;

import java.util.List;

public interface EventDao {

    List<Event> findAll();

    void create(Event event);
}
