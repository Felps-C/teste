package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DB {

    public static Properties loadPropiets(){

        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DBException(e.getMessage());
        }

    }
}
