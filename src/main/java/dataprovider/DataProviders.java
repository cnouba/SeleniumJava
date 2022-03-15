package main.java.dataprovider;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataProviders {


@DataProvider(name = "login")
    public static   Object[][]  getLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\Data.txt"));
            //("user.dir")+"\\src\\test\\resources\\Data.txt")

            while ((sCurrentLine = br.readLine()) != null) {
                String []test = sCurrentLine.split(txtSplitBy);
                content.add(sCurrentLine);
            }
            for (String s : content) {
                System.out.println(s);
            }

            listsize = content.size();
            //recupere le nombre de parametre de la ligne (colone)
            datalength = content.get(0).split(txtSplitBy).length;
            returnObj = new String[listsize][datalength];

            for (int i = 0; i<listsize; i++) {

                dat = content.get(i).split(txtSplitBy);
                for (int j=0; j< datalength ; j++) {
                    returnObj[i][j] = dat[j];
                }

            }
            
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return returnObj;
    }

    public static void main(String[] args) {

        DataProviders dataProviders = new DataProviders();
        dataProviders.getLogin();


    }

}
