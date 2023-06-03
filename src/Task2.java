import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        String file_path = "homework10\src\file.txt";
        String output_path = "user.json";

        List<User> users = readUsersFromFile(file_path);
        writeUsersToJsonFile(output_path, users);
    }

    private static List<User> readUsersFromFile(String file_path) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private static void writeUsersToJsonFile(String output_path, List<User> users) {
        JSONArray userArray = new JSONArray();

        for (User user : users) {
            JSONObject userObj = new JSONObject();
            try {
                userObj.put("name", user.getName());
                userObj.put("age", user.getAge());
                userArray.put(userObj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(output_path)) {
            fileWriter.write(userArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
