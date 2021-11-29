package util;

import com.google.gson.Gson;
import models.WebData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class DataProviderForWeb {

    @DataProvider(name = "dataProviderForWebTest")
    public Object[][] dataProviderForWebTest() throws FileNotFoundException {

        Reader reader = new FileReader("src/test/resources/parameters-for-web.json");
        WebData data = new Gson().fromJson(reader, WebData.class);
        return new Object[][]{
                {data.getUrl(), data.getKeyWord()}
        };
    }
}
