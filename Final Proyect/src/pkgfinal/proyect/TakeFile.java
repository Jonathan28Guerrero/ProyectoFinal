/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daniela
 */
public class TakeFile {
    
    public ArrayList CreateListing(File FileStudents) throws FileNotFoundException{
        ArrayList FileData = new ArrayList();
        try(Scanner ScanFile = new Scanner(FileStudents)){
            while (ScanFile.hasNextLine()){
                ArrayList Values = Columns(ScanFile.nextLine()); 
                FileData.add(Values.get(3));
                FileData.add(Values.get(6));
                FileData.add(Values.get(7));
                FileData.add(Values.get(9));
            }
        }
        return FileData;
    }
    
    public ArrayList Columns(String Row){
        ArrayList Columns = new ArrayList();
        try(Scanner RowScanner = new Scanner(Row)){
            RowScanner.useDelimiter(",");
                while(RowScanner.hasNext()) {
                Columns.add((String)RowScanner.next());
            }
        }
        System.out.println(Columns);
        return Columns;
    }
    
    
}
