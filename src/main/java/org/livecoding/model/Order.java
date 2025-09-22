package org.livecoding.model;

import java.util.List;

public class Order {

  private final int id;
  private final int userId;
  private final List<String> items;

  public Order(int id, int userId, List<String> items) {
    this.id = id;
    this.userId = userId;
    this.items = List.copyOf(items);
  }

  public int getId() {
    return id;
  }

  public int getUserId() {
    return userId;
  }

  public List<String> getItems() {
    return items;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", userId=" + userId +
            ", items=" + items +
            '}';
  }
}
