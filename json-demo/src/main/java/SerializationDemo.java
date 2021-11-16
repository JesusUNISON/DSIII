import com.google.gson.Gson;

public class SerializationDemo {
    public static void main(String args[])  {

        Sale saleRecord = new Sale(1,"Ashla", "Secretan",
                9461.42, "California", "Health");

        Gson gson = new Gson();

        String saleJson = gson.toJson(saleRecord);

        System.out.println( saleJson );

        System.out.println(  );

        String jsonString =  "{\"id\":2,\"firstName\":\"Homer\",\"lastName\":\"Simpson\",\"sales\":7000.00,\"state\":\"Arizona\",\"department\":\"Food\"}";

        Sale saleObject = gson.fromJson(jsonString, Sale.class);

        System.out.println( saleObject );
    }
}
