import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.api.*;
import com.okta.sdk.resource.client.*;
import com.okta.sdk.resource.group.*;
import com.okta.sdk.resource.model.*;
import com.okta.sdk.resource.user.UserBuilder;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = null;
    // START Take Home
    try {
        // Setup Your Okta Domain
        ApiClient client = (ApiClient) Clients.builder()
                .setOrgUrl("")
                .setClientCredentials(new TokenClientCredentials(""))
                .build();

        in = new Scanner(System.in);
        // =========== Step 1 ================
        // Get User Input through console interaction
        // Get First Name of test users
        // Get Last Name of test users
        // Get Number of users to be created. Valid value whole numbers between 1 and 300
        String fName = "", lName = "";
        int totalUsers = 0;

        // =========== Step 2 ================
        // Create users based on earlier input
        // Use firstname{index}.lastname@atko.email as username (For example, john1.doe@atko.email)
        UserApi userApi = new UserApi(client);

        System.out.println("=====================Creating Users=====================");

        for (int i = 1; i <= totalUsers; i++)
        {
            String email = "%s%d.%s@atko.email".formatted(fName.toLowerCase(), i, lName.toLowerCase());

            try {
                UserBuilder.instance()
                        .setEmail(email)
                        .setFirstName(fName)
                        .setLastName(lName)
                        .buildAndCreate(userApi);

                System.out.println("%s created".format(email));
            }
            catch (Exception ex)
            {
                System.out.println("Error Creating User: %s".formatted(email));
                System.out.println(ex);
            }
        }

        System.out.println("=====================Users Created Successfully=====================");

        // =========== Step 3 ================
        // Create a group, get group name through console input

        // =========== Step 4 ================
        // Add all users to particular group
        // Get Group created in prior step



        // =========== Step 5 ================
        // Delete users between start index and ending index received through console input


        // ============ Bonus =================
        // Replace API Token with oAuth authentication


        System.out.println("=====================Acitvity Complete=====================");
        System.out.println("Press Any Key to Exit...");
        in.nextLine();



    } catch (Exception e) {
      e.printStackTrace();
      ;
    }
    // END Take Home
    in.close();
  }
}