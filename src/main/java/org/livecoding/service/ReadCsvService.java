package org.livecoding.service;

import org.livecoding.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCsvService {

  public List<User> readCsv() {
    var users = new ArrayList<User>();
    var path = Paths.get("src/test/resources/my.csv");

    try(var reader = Files.newBufferedReader(path)) {
      var header = reader.readLine();
      String line;

      while ((line = reader.readLine()) != null) {
        var columns = line.split(",");
        if (columns.length != 3) continue;

        try {
          int id = Integer.parseInt(columns[0].trim());
          String name = columns[1].trim();
          String email = columns[2].trim();

          if (!email.contains("@")) continue; // простая валидация

          users.add(new User(id, name, email));
        } catch (NumberFormatException e) {
          System.out.println("Неверный ID: " + columns[0]);
        }
      }
    } catch (IOException exception) {
      System.out.println(exception.getMessage());

      return Collections.emptyList();
    }

    return users;
  }

}
