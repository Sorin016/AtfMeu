package forDataTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Store {
    private List<ErrorMessages> errorMessagesList = new ArrayList<>();
    private List<RegisterNewUserFields> registerNewUserFieldsList = new ArrayList<>();
    private List<EnterUserNamePassAndConfirmPass> userNameAndPassAndConfirmPasses = new ArrayList<>();

    public void addErrorMessageValues(ErrorMessages errorMessages) {
        this.errorMessagesList.add(errorMessages);
    }

    public void addInputFieldsValues(RegisterNewUserFields registerNewUserFields) {
        this.registerNewUserFieldsList.add(registerNewUserFields);
    }

    public void insertUserNameAndPasswordAndConfirmPassword(EnterUserNamePassAndConfirmPass enterUserNamePassAndConfirmPass) {
        this.userNameAndPassAndConfirmPasses.add(enterUserNamePassAndConfirmPass);
    }

}
