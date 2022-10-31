package com.springapp.finalapp.fileservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springapp.finalapp.data.Studies;

@Service
public class StudiesFileService {   // Kirjoittaa opintotietoja studies kansiossa sijaitsevaan studies.txt tiedostoon
    public void writeStudiesToFiles(List<Studies> studies) throws Exception {
        File fStudies = new File("C:\\studies");
        fStudies.mkdir();
        fStudies = new File(fStudies.getAbsolutePath() + "\\studies.txt");
        fStudies.createNewFile();
        // Kansio ja tiedosto luotu
        PrintStream write = new PrintStream(fStudies);
        for (Studies line : studies) {
            write.println("Student: "+line.getStudentName());
            write.println("Course: "+line.getCourseName());
            write.println("Teacher: "+line.getTeacher());
            write.println("Grade: "+line.getGrade());
            write.println("Classroom: "+line.getClassRoom()+"\n");
        }
        // Opintotiedot kirjoitettu tekstitiedostoon
        write.flush();
        write.close();
        // Write flushattu ja suljettu
        fileInfo();
        // fileInfo() kutsuttu, sisältää tiedostoon liittyviä tietoja
        readStudiesFromFile();
        // readStudiesFromFile() kutsuttu, lukee tiedostosta opintotiedot ja tulostaa ne konsoliin
    }

    public void fileInfo() { // Tiedoston info funktio, kertoo käyttäjälle konsoliin tiedoston nimen, sen polun, onko hakemisto ja pystyykö ohjelma kirjoittamaan tiedoston
        File file = new File("C:\\studies\\studies.txt");
        if(file.exists()) {
            System.out.println("File name: "+file.getName());
            System.out.println("Path: "+file.getAbsolutePath());
            System.out.println("Is directory? "+file.isDirectory());
            System.out.println("Write access? "+file.canWrite());
        }
    }

    public void FindAndWriteError(String errmsg) throws Exception { // Käsittelee virheen ja kirjoittaa sen omaan tiedostoon studies-kansion alle
        File errFile = new File("C:\\studies");
        errFile.mkdir();
        errFile.createNewFile();
        errFile = new File(errFile.getAbsolutePath() + "\\errFile.txt");
        // Tiedosto luotu kansiooon
        FileWriter fw = new FileWriter(errFile, true);
        fw.write(errmsg + System.lineSeparator());
        // Kirjoittaa virheen tiedostoon
        fw.flush();
        fw.close();
        // filewriter flushattu ja suljettu
        System.out.println("Tapahtui virhe, virhe viesti tulostui tiedostoon studies kansion alle, errFile.txt nimiseen tiedostoon: (C:/studies/errFile.txt");
        // Tulostaa käyttäjälle konsoliin virheestä, ja kertoo polun tiedostoon, josta virheen voi käydä lukemassa
        
    }

    public void readStudiesFromFile() { // Lukee opintotietoja tiedostosta ja kirjoittaa konsoliin
        byte[] array = new byte[1000];
        try {
            InputStream input = new FileInputStream("C:\\studies\\studies.txt");
            System.out.println("Tiedoston tavumäärä: " + input.available());
            // Lukee tavun input streamin
            input.read(array);
            System.out.println("Tiedostosta luettu tieto: ");
            // Muuttaa tavut stringiksi
            String data = new String(array);
            System.out.println(data);
            // Input kiinni
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void clearTheStudiesFile() { // Tyhjentää opintotiedot studies.txt tiedostosta, metodia kutsutaan servicen deleteStudies() metodissa
        File fStdClear = new File("C:\\studies");
        fStdClear.mkdir();
        fStdClear = new File(fStdClear.getAbsolutePath() + "\\studies.txt");
        try{
            // Tyhjennetään tiedosto
            FileWriter fw = new FileWriter(fStdClear, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
            }catch(Exception exception){
                System.out.println("Virhe havaittu!");
            }
        }
}
