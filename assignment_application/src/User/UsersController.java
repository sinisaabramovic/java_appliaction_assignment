package User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Main user controller

public class UsersController {
    private static UsersController ourInstance = new UsersController();

    public static UsersController getInstance() {
        return ourInstance;
    }

    private List<User> users;
    private JSONParser jsonParser;

    private UsersController() {
        users = new ArrayList<User>();
        jsonParser = new JSONParser();
    }

    private void addUser(User user){
        users.add(user);
    }

    // Parse file (from path) to User objects
    private void Parse(String path){
        try {
            FileReader reader = new FileReader(path);
            Object object = jsonParser.parse(reader);

            JSONArray users = (JSONArray) object;
            int length = users.size();

            for(int i=0; i<length; i++){
                JSONObject jsonObject = (JSONObject) users.get(i);
                Set s = jsonObject.entrySet();
                Iterator iter = ((Set) s).iterator();
                User user = new User();
                boolean canAddUser = false;
                while(iter.hasNext()){
                    Map.Entry entry = (Map.Entry) iter.next();
                    if (user.insertKeyValue(entry.getKey().toString(), entry.getValue().toString())) canAddUser = true;
                    else canAddUser = false;
                    if(!canAddUser){
                        System.out.println("WARNING!");
                        System.out.println("User at index " + i + " will not be added!");
                        break;
                    }
                }
                if (canAddUser) addUser(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public void importUsers(String path){
        Parse(path);
    }

    public void printUsers(){
        System.out.println("Print users \nTotal number of users :" + users.size() + "\n");

        for(User u : users){
            System.out.println(u.toString());
        }
    }
}
