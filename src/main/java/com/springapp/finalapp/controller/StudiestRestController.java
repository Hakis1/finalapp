package com.springapp.finalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.finalapp.data.Studies;
import com.springapp.finalapp.service.StudiesService;

@RestController
public class StudiestRestController implements InterfaceOfTheRestController{
    
    @Autowired
    StudiesService pService;
    

    @Override
    public List<Studies> getStudies() { // Hakee kaikki opintotiedot
        return pService.getAllStudies();
    }

    @Override
    public Studies addStudies(Studies studies) { // Lisää uusia opintotietoja
        pService.addNewStudies(studies);
        return studies;
    }

    @Override
    public List<Studies> getStudentStudies(String studentName) { // Hakee opiskelijan nimellä opintotietoja
        return pService.getStudiesByStudentName(studentName);
    }

    @Override
    public List<Studies> getGradeStudies(int grade) { // Hakee vuosiluokalla (grade) opintotietoja
        return pService.getStudiesByGrade(grade);
    }

    @Override
    public String saveAll() throws Exception{ // Kirjoittaa opintotietoja tekstitiedostoon
        pService.writeThemStudies();
        return "Tietojen tallennus onnistui";
    }

    @Override
    public String clearAll() throws Exception { // Poistaa opintotiedot
        pService.deleteStudies();
        return "Tietojen poistaminen onnistui";
    }

    @Override
    public String hiAndWelcome() { // ihan huvin vuoksi tehty, käyttäjän tervehdys 
        return "Tervetuloa käyttämään sovellusta!";
    }

    @Override
    public List<Studies> getCourseNameStudies(String courseName) { // Hakee opintotietoja kurssin nimellä
        return pService.getStudiesByCourseName(courseName);
    }
}
