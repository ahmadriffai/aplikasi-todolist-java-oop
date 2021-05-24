package repository;

import entity.Todo;

public interface TodoRepository {

    Todo[] getAll();

    void add(Todo todo);

    boolean remove(Integer no);

}
