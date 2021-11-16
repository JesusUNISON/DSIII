package user;

import com.google.gson.Gson;

public class UserJson {
    public static void main(String args[]) {

        UserAddress userAddress = new UserAddress(
                "Main Street",
                "42A",
                "Magdeburg",
                "Germany"
        );

        User userObject = new User(
                "Norman",
                "norman@futurestud.io",
                true,
                26,
                userAddress
        );

        Gson gson = new Gson();


        String userWithAddressJson = gson.toJson(userObject);

        System.out.println( userWithAddressJson );


    }
}
