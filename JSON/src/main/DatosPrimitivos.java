package main;

import com.google.gson.Gson;

public class DatosPrimitivos {

    public static void main(String args[])  {

        Gson gson = new Gson();

        // Serialization
        System.out.println( gson.toJson(1) );  // ==> 1
        System.out.println( gson.toJson("abcd") ); // ==> "abcd"

        System.out.println( gson.toJson(10L) ); // ==> 10L
        int[] values = { 1, 2 };
        System.out.println( gson.toJson(values) );       // ==> [1, 2]

        System.out.println( );

        // Deserialization
        int intVal = gson.fromJson("1", int.class);
        Integer integerVal = gson.fromJson("1", Integer.class);
        Long longVal = gson.fromJson("1", Long.class);
        Boolean aBoolean = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);

    }
}
