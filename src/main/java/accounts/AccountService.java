package accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 14.07.17.
 */
public class AccountService {
    Map<String, UserProfile> users = new HashMap();

    public boolean registration(String login, String password, String email){
        boolean result;
        if(isUserExist(login)){
            result = false;
        }
        else{
            UserProfile user = new UserProfile(login,password,email);
            users.put(login,user);
            result=true;
        }
        return result;
    }
    public UserProfile authorization(String login, String password){
        UserProfile user = null;
        boolean result = true;
        if (isUserExist(login)){
        user = users.get(login);
        }
        return user;
    }
    private boolean isUserExist(String login){

        boolean result = false;
        if (users.containsKey(login))
        {
            result = true;
        }
        return result;
    }
}
