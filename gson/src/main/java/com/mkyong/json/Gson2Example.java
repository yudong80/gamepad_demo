package com.mkyong.json;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Gson2Example {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("D:\\staff.json")) {

            // Convert JSON to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);
            System.out.println(staff);

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

