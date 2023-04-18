package fa.training.demojwd.model.dao.impl;

import fa.training.demojwd.model.dao.EventDao;
import fa.training.demojwd.model.entity.Event;
import fa.training.demojwd.model.util.HibernateConnectionConfig;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class EventDaoImpl implements EventDao {

    @Override
    public List<Event> findAll() {
        try (Session session = HibernateConnectionConfig.getSession()) {
            return session.createQuery("FROM Event e", Event.class)
                    .getResultList();
        }
    }

    @Override
    public void create(Event event) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            session.beginTransaction();
            event.setDeleted(false);
            event.setCreatedDate(LocalDateTime.now());
//            event.setCreatedBy();
            session.persist(event);
            session.getTransaction().commit();
        }
    }
}
