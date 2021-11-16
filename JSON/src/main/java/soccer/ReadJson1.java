package soccer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class ReadJson1 {
    public static void main(String[] args) {

        String json1 = "[{\"dorsal\":6," + "\"name\":\"Iniesta\","
                + "\"demarcation\":[\"Right winger\",\"Midfielder\"],"
                + "\"team\":\"FC Barcelona\"}]";

        JsonArray gsonArr = JsonParser.parseString(json1).getAsJsonArray();

        // para cada elemento del array
        for (JsonElement obj : gsonArr) {

            // Object of array
            JsonObject gsonObj = obj.getAsJsonObject();

            // Primitives elements of object
            int dorsal = gsonObj.get("dorsal").getAsInt();
            String name = gsonObj.get("name").getAsString();
            String team = gsonObj.get("team").getAsString();

            // List of primitive elements
            JsonArray demarcation = gsonObj.get("demarcation").getAsJsonArray();
            List<String> listDemarcation = new ArrayList<String>();
            for (JsonElement demarc : demarcation) {
                listDemarcation.add( demarc.getAsString() );
            }

            // Object Constructor
            FootballPlayer iniesta = new FootballPlayer(dorsal, name,
                    listDemarcation, team);
            System.out.println(iniesta);
        }
    }

}
