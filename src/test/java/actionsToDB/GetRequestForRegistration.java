package actionsToDB;

import ConnectionToDB.ConnectionToDB;
import entity.User;

import java.io.Serializable;
import java.util.List;


public class GetRequestForRegistration extends ConnectionToDB implements Serializable {
    public static String firstNume;

    public static String getFirstNameRequestFromDB(User user) {

        try {
            session.beginTransaction();
            List<User> nn = session.createQuery("from User where username = :username")
                    .setParameter("username", user.getUsername()).setMaxResults(1).getResultList();
            firstNume = nn.stream().findFirst().get().getFirstName();
            session.getTransaction().commit();
            System.out.println("Get DONEEEEE!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return firstNume;
    }
}
