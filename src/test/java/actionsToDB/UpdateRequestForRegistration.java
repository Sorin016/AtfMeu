package actionsToDB;

import ConnectionToDB.ConnectionToDB;
import entity.User;

import java.io.Serializable;

import static stepDefinition.UI_Classes.RegisterNewUser.user;
import static util.DataKey.USERNAME;
import static util.DataKey.USER_FOR_DB;
import static util.ScenarioContext.getData;

public class UpdateRequestForRegistration extends ConnectionToDB implements Serializable {
    public static String username = user.getUsername();
    public static String password = user.getPassword();
    public static String confirmPassword = user.getPassword();
    public static String firstName = (String) getData(USER_FOR_DB);

    public static void updateRequestinDB(User user) {


        try {
            session.beginTransaction();
            session.createQuery("update User set " +
                            "password = :password, " +
                            "confirmPassword = :confirmPassword, " +
                            "username = :username " +
                            "where firstName = :firstName")
                    .setParameter("password", password)
                    .setParameter("confirmPassword", confirmPassword)
                    .setParameter("username", username)
                    .setParameter("firstName", firstName)
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Update DONEEEEE!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
