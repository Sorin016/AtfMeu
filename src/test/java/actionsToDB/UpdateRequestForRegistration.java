package actionsToDB;

import ConnectionToDB.ConnectionToDB;
import entity.User;

import java.io.Serializable;

import static util.DataKey.FIRSTNAME_FOR_DB;
import static util.ScenarioContext.getData;

public class UpdateRequestForRegistration extends ConnectionToDB implements Serializable {

    public static void updateRequestinDB(User user) {
        try {
            session.beginTransaction();
            session.createQuery("update User set " +
                            "password = :password, " +
                            "confirmPassword = :confirmPassword, " +
                            "username = :username " +
                            "where firstName = :firstName")
                    .setParameter("password", user.getPassword())
                    .setParameter("confirmPassword", user.getPassword())
                    .setParameter("username", user.getUsername())
                    .setParameter("firstName", getData(FIRSTNAME_FOR_DB))
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Update DONEEEEE!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
