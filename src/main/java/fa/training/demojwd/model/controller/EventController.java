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

@WebServlet(name = "eventController", value = "/events")
public class EventController extends HttpServlet {

    EventService eventService = new EventServiceImpl();

    // HttpRequest GET /events
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> eventList = eventService.findAll();
        req.setAttribute("events", eventList);
        req.getRequestDispatcher("/WEB-INF/view/event/list.jsp")
                .forward(req, resp);
    }
}
