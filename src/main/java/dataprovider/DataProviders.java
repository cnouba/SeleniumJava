package main.java.dataprovider;

import main.java.utility.ConfigFileReader;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataProviders {

    public static void main(String[] args) {

        ConfigFileReader configFileReader = new ConfigFileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\createAccountData\\Pracauto-52-ValidUserPwd");


    }


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

            br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\createNewAccount\\Pracauto-52-ValidUserPwd.txt"));
            //("user.dir")+"\\src\\test\\resources\\Pracauto-52-ValidUserPwd.txt")

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
    @DataProvider(name = "invalidlogin")
    public static   Object[][]  getInvalidLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\createNewAccount\\Pracauto-52-ValidUserPwd.txt"));
            //("user.dir")+"\\src\\test\\resources\\Pracauto-52-ValidUserPwd.txt")

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

    @DataProvider(name = "userNoPasswordInvalidlogin")
    public static   Object[][]  getuserNoPasswordInvalidLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\createNewAccount\\Pracauto-61-userNoPwd.txt"));
            //("user.dir")+"\\src\\test\\resources\\Pracauto-52-ValidUserPwd.txt")

            while ((sCurrentLine = br.readLine()) != null) {
                String []test = sCurrentLine.split(txtSplitBy);
                if (test!=null){

                    content.add(sCurrentLine);
                }

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

    @DataProvider(name = "alreadyLogin")
    public static   Object[][]  alreadyLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\createNewAccount\\Pracauto-69-CreateAccountWithExistantEmail.txt"));
            //("user.dir")+"\\src\\test\\resources\\Pracauto-52-ValidUserPwd.txt")

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

    @DataProvider(name = "validLogin")
    public static   Object[][]  validLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\login\\Pracauto-67-validUserPwd.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                String []test = sCurrentLine.split(txtSplitBy);
                content.add(sCurrentLine);
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

    @DataProvider(name = "validUserLogin")
    public static   Object[][]  validUserLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\login\\Pracauto-67-validUserPwd.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                String []test = sCurrentLine.split(txtSplitBy);
                content.add(sCurrentLine);
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

    @DataProvider(name = "invalidLogin")
    public static   Object[][]  invalidLogin(){
        BufferedReader br = null;
        String txtSplitBy = ",";
        String[] dat= null;
        String returnObj[][] = null;
        ArrayList<String> content = new ArrayList<String>();
        try {

            String sCurrentLine;
            int datalength = 0;
            int listsize =0;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\login\\Pracauto-55-invalidLogin.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                String []test = sCurrentLine.split(txtSplitBy);
                content.add(sCurrentLine);
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



}
