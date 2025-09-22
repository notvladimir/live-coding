package org.livecoding.service;

import org.livecoding.model.Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Library {

  // Храним книги по автору → это ускоряет поиск
  private final Map<String, List<Book>> booksByAuthor = new ConcurrentHashMap<>();

  // Добавить книгу
  public void addBook(Book newBook) {
    booksByAuthor.computeIfAbsent(newBook.getAuthor(), a -> new ArrayList<>())
            .add(newBook);
  }

  // Получить книги по автору
  public List<Book> getBooksByAuthor(String author) {
    return booksByAuthor.getOrDefault(author, Collections.emptyList());
  }

  // Удалить книгу по названию и автору
  public boolean removeBook(String title, String author) {
    List<Book> books = booksByAuthor.get(author);
    if (books == null) return false;

    boolean removed = books.removeIf(b -> b.getTitle().equals(title));
    if (books.isEmpty()) {
      booksByAuthor.remove(author); // чистим пустые списки
    }
    return removed;
  }

  // Найти все книги по названию (например, для проверки дублей у разных авторов)
  public List<Book> getBooksByTitle(String title) {
    return booksByAuthor.values().stream()
            .flatMap(List::stream)
            .filter(b -> b.getTitle().equals(title))
            .collect(Collectors.toList());
  }

  // Получить всех авторов
  public Set<String> getAllAuthors() {
    return booksByAuthor.keySet();
  }
}
