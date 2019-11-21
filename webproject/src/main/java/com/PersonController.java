package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonController extends HttpServlet {
    private List<Person> personsList = new ArrayList(Arrays.asList(new Person("xxx", 12, 1),
            new Person("yyy", 12, 2)));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("persons", personsList);
            req.getRequestDispatcher("/personsList.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            String id = req.getParameter("id");
            for (Person p : personsList) {
                if (p.getId() == Integer.valueOf(id)) {
                    personsList.remove(p);
                    break;
                }
            }
            req.setAttribute("persons", personsList);
            req.getRequestDispatcher("/personsList.jsp").forward(req, resp);
        } else if (action.equals("addNewPerson")) {
            Person person = new Person();
            req.setAttribute("person", person);
            req.getRequestDispatcher("/addPerson.jsp").forward(req, resp);
        } else if (action.equals("update")) {
            String id = req.getParameter("id");
            for (Person p : personsList) {
                if (p.getId() == Integer.valueOf(id)) {
                    req.setAttribute("person", p);
                    break;
                }
            }
            req.getRequestDispatcher("/addPerson.jsp").forward(req, resp);
        }

    }

    private Person getPersonById(String id) {
        for (Person p : personsList) {
            if (p.getId() == Integer.valueOf(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = Integer.valueOf(req.getParameter("id")) == 0 ? new Person() : getPersonById((req.getParameter("id")));
        person.setName(req.getParameter("name"));
        person.setAge(Integer.valueOf(req.getParameter("age")));
        if (Integer.valueOf(req.getParameter("id")) == 0) {
            person.setId(personsList.size() + 1);//Integer.valueOf(req.getParameter("id")));
            personsList.add(person);
        }
        req.setAttribute("persons", person);
        resp.sendRedirect("persons");
//        req.getRequestDispatcher("/personList.jsp").include(req, resp);
    }
}

