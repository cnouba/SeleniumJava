package main.java.utility;
import main.java.commun.ApplicationCommonScript;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileReader {
   protected static final Logger log = LogManager.getLogger(ApplicationCommonScript.class);
    private Properties properties;
    private Properties data;
    //private final String propertyFilePath = "src//test//resources//configuration.properties";
    private final String propertyFilePath = "src//test//resources//data//createAccountData//Pracauto-US1.txt";

    public ConfigFileReader() {
        BufferedReader reader;
        try {  reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {  properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            throw new RuntimeException("Le fichier de configuration n'est pas disponible: " + propertyFilePath);
        }

    }

    public ConfigFileReader(String filepath) {
        BufferedReader reader;
        try {   reader = new BufferedReader(new FileReader(filepath));

            data = new Properties();
            try {data.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw new RuntimeException("Le fichier n'est pas disponible: " + filepath);

        }

    }



    public long getImplicitlyWait() {

        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try { return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;


    }
    public String getApplicationUrl() {

        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");

    }    public String getApplication() {

        String application = properties.getProperty("application");
        if (application != null) return application;
        else return null;

    }

    public String getSpeed() {


        String speed = properties.getProperty("speed");

        if (speed != null)
            return speed;

        else

            return "fast";

    }

    public String getChromeVersion() { String chromeVersion = properties.getProperty("chromeVersion");

        if (chromeVersion != null) return chromeVersion;

        else return null;


    }

    public String getPathChromeDriver() {

        String pathChromeDriver = properties.getProperty("pathChromeDriver");

        if (pathChromeDriver != null) return pathChromeDriver;

        else return null;    }

    public String getIeVersion() {

        String ieVersion = properties.getProperty("ieVersion");

        if (ieVersion != null) return ieVersion;

        else return null;

    }

    public String getEdgeVersion() {

        String edgeVersion = properties.getProperty("edgeVersion");

        if (edgeVersion != null) return edgeVersion;

        else return null;

    }

    public String getApplicationUrlToken() {

        String url = properties.getProperty("urlToken");

        if (url != null) return url;

        else
            throw new RuntimeException("Application Url token not specified in the Configuration.properties file for the Key:url");    }

    public String get(String property) {        String prop = properties.getProperty(property);        if (prop != null) return prop;        else return null;    }

    public String getConfigProperties(String name) {        if (properties.containsKey(name)) {            return properties.getProperty(name);        } else {            return null;        }    }
    public String getXrayReportPath() {        return getConfigProperties("path_to_report_ticket");    }
    public String getJiraServerUrl() {        return getConfigProperties("url_jira_server");    }
    public String getUrl() {        return getConfigProperties("url");    }
    public String getJiraToken() {return getConfigProperties("jira_token");}

    public String getJiraProjectCode() {return getConfigProperties("jira_code");}

    public String getData(String dataName){

        String dataValue = data.getProperty(dataName);

        if(dataValue==null){
            String msg="La donnee '"+dataName+"' n'existe pas dans le fichier";

            log.error(msg);            //throw new SeleniumException(msg);
        }else if(dataValue.equals("")){
            log.warn("La donnee '"+dataName+"' n'a pas ete renseignee dans le fichier");
        }
        return dataValue;
    }

}
