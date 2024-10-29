package actionsToDB;

import ConnectionToDB.ConnectionToDB;
import entity.User;

import java.io.Serializable;


public class PostRequestForRegistration extends ConnectionToDB implements Serializable {
    public static void postRequestinDB(User user) {
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Post DONEEEEE!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
