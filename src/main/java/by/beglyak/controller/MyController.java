package by.beglyak.controller;

import by.beglyak.entity.Cinema;
import by.beglyak.service.CinemaServiceImpl;
import by.beglyak.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
//
//    @Autowired
//    private CinemaServiceImpl cinemaService;
//
//    @RequestMapping("/all")
//    public String getAllCinemas(Model model){
//
//        List<Cinema> allCinemas = cinemaService.getAll();
//        model.addAttribute("allCinemas",allCinemas);
//
//        return "all-cinemas";
//    }
}
