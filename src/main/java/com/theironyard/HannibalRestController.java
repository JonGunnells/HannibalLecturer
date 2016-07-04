package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HannibalRestController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> lec() {
        return lecturers.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void lecturer(String name, String topic, String image) {
        Lecturer l = new Lecturer(name, topic, image);
        lecturers.save(l);
    }


    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> rev() {
        return reviews.findAll();
    }


    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void review(String author, String text, int lecturerId, boolean isGood){
        Review r = new Review(author, text, lecturerId, isGood);
        reviews.save(r);
    }




}
