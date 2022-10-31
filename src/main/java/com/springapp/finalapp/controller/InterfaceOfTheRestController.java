package com.springapp.finalapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springapp.finalapp.data.Studies;

public interface InterfaceOfTheRestController {
    /*  
        Interface sisältää kaikki StudiesRestControllerin Mappaukset ja niiden funktiot, itse toteutukset ovat StudiesRestControllerissa
        Sieltä löydät jokaisen mappauksen ja sen funktion toteutuksen, ja erilliset kommentit, mitä jokainen funktio tekee

        Valmis pohja oppilaiden lisäämiseen 
        
        http://localhost:8080/addstudies
        {
            "studentName" : "Mikko",
            "courseName" : "Ohjelmointi",
            "teacher" : "Timoteus",
            "classRoom" : "444"
        }
    */

    @GetMapping("studies")
    List<Studies> getStudies();

    @PostMapping("addstudies")
    public Studies addStudies(@RequestBody Studies studies);

    @GetMapping("studies/{studentName}")
    public List<Studies> getStudentStudies(@PathVariable String studentName);

    @GetMapping("/grade/{grade}")
    public List<Studies> getGradeStudies(@PathVariable int grade);

    @GetMapping("/courses/{courseName}")
    public List<Studies> getCourseNameStudies(@PathVariable String courseName);

    @PostMapping("write")
    public String saveAll() throws Exception;

    @DeleteMapping("clear")
    public String clearAll() throws Exception;

    @GetMapping
    public String hiAndWelcome();
}
