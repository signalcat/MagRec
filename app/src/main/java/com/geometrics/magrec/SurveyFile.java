package com.geometrics.magrec;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hezhang on 10/19/17.
 */

public class SurveyFile
{
    public String fileName;

    public SurveyFile(String fileName) {
        this.fileName = fileName;
    }

    public static ArrayList<SurveyFile> getFiles() {
        ArrayList<SurveyFile> files = new ArrayList<SurveyFile>();
        files.add(new SurveyFile("File1"));
        files.add(new SurveyFile("File2"));
        return files;
    }
}
