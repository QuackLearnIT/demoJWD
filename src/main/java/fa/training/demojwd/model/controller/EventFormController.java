package fa.training.demojwd.model.controller;

import fa.training.demojwd.model.entity.Event;
import fa.training.demojwd.model.service.EventService;
import fa.training.demojwd.model.service.impl.EventServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "eventFormController", value = "/events/add")
public class EventFormController extends HttpServlet {

    EventService eventService = new EventServiceImpl();

    // HttpRequest GET /events
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/event/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        // TODO: Validate
        Event event = new Event();
        event.setName(name);
        event.setPlace(place);

        eventService.create(event);

        List<Event> eventList = eventService.findAll();
        req.setAttribute("events", eventList);
        resp.sendRedirect(req.getContextPath() + "/events"); // /demoJWD_war/events
    }
}
