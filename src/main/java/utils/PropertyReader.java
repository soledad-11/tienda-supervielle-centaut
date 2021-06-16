package utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	private Properties props;
	
    public static enum DataSource {
        login
    }

    public PropertyReader(DataSource source) {
        try (InputStream input = new FileInputStream("Datasources/" + source.toString() + ".properties")) {
            this.props = new Properties();
            this.props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String name) {
        return this.props.getProperty(name);
    }
}
