package fa.training.demojwd.model.service.impl;

import fa.training.demojwd.model.dao.EventDao;
import fa.training.demojwd.model.dao.impl.EventDaoImpl;
import fa.training.demojwd.model.entity.Event;
import fa.training.demojwd.model.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

public class EventServiceImpl implements EventService {

    EventDao eventDao = new EventDaoImpl();

    @Override
    public List<Event> findAll() {
        return eventDao.findAll();
    }

    @Override
    public boolean create(Event event) {
        try {
            event.setDeleted(false);
            event.setCreatedDate(LocalDateTime.now());
//            event.setCreatedBy();
            eventDao.create(event);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
