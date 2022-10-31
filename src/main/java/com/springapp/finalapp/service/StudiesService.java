package com.springapp.finalapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.finalapp.data.Studies;
import com.springapp.finalapp.fileservice.StudiesFileService;

@Service
public class StudiesService {

    @Autowired
    StudiesFileService pStudiesFileService; // Injektoidaan StudiesFileService Autowired annotaation avulla

    private List<Studies> studiesList = new ArrayList<>();

    public void writeThemStudies() throws Exception {  // Kirjoittaa opintotietoja kutsumalla StudiesFileServicen metodia writeStudiesToFiles(), ja käsittelee mahdollisem virheen omalla virheenhallinnalla 
        try {
            pStudiesFileService.writeStudiesToFiles(studiesList);
        } catch (Exception e) {
            String errmsg = e.getMessage();
            pStudiesFileService.FindAndWriteError(errmsg);
        }
    }
    
    public void addNewStudies(Studies studies) {
        studiesList.add(studies);
    }

    public List<Studies> getAllStudies() {
        return studiesList;
    }

    public List<Studies> getStudiesByStudentName(String studentName) { // Hakee opintotietoja opiskelijan nimen perusteella
        List<Studies> foundStudies = new ArrayList<>();
        for (Studies s : studiesList) {
            if(s.getStudentName().equals(studentName)) {
                foundStudies.add(s);
            }
        }
        return foundStudies;
    }

    public List<Studies> getStudiesByGrade(int grade) { // Hakee opintotietoja opiskelijan vuosikurssin perusteella
        List<Studies> foundStudiesByGrade = new ArrayList<>();
        for (Studies g : studiesList) {
            if(g.getGrade()==grade) {
                foundStudiesByGrade.add(g);
            }
        }
        return foundStudiesByGrade;
    }

    public List<Studies> getStudiesByCourseName(String courseName) { // Hakee opintotietoja kurssin nimen perusteella
        List<Studies> foundStudiesByCourseName = new ArrayList<>();
        for (Studies c : studiesList) {
            if(c.getCourseName().equals(courseName)) {
                foundStudiesByCourseName.add(c);
            }
        }
        return foundStudiesByCourseName;
    }

    public void deleteStudies() { // Poistaa kaikki tiedot listasta ja tekstitiedostosta, kutsuu StudiesFileServicessä olevaa metodia clearTheStudiesFile, muista sulkea tiedosto sen jälkeen kun tiedot on poistettu, tai ennen sitä, niin muutos päivittyy!!
        studiesList.removeAll(studiesList);
        pStudiesFileService.clearTheStudiesFile();
    }
}
