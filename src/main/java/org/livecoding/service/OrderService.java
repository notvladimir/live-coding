package org.livecoding.service;

import org.livecoding.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {

  private int orderIdCounter = 1;
  private final Map<Integer, Order> orders = new ConcurrentHashMap<>();
  private final Map<Integer, List<Order>> ordersByUser = new ConcurrentHashMap<>();

  public synchronized Order createOrder(int userId, List<String> items) {
    int orderId = orderIdCounter++;
    var order = new Order(orderId, userId, items);
    orders.put(orderId, order);
    ordersByUser.computeIfAbsent(userId, id -> new ArrayList<>()).add(order);

    return order;
  }

  public Order getOrder(int orderId) {
    return orders.get(orderId);
  }

  public List<Order> getUserOrders(int userId) {
    return ordersByUser.getOrDefault(userId, Collections.emptyList());
  }

}
