package test.service;

import entity.Todo;
import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoServiceTest {

    public static void main(String[] args) {
        testRemoveTodo();
    }

    public static void testShowTodo(){

        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        todoRepository.data[0] = new Todo("Belajar Java");
        todoRepository.data[1] = new Todo("Belajar Bahasa Inggris");

        TodoService todoService = new TodoServiceImpl(todoRepository);


        todoService.showTodo();

    }

    public static void testAddTodo(){
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);

        todoService.addTodo("Memulai bisnis starup");
        todoService.addTodo("Memulai bisnis starup");

        todoService.showTodo();
    }

    public static void testRemoveTodo(){
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);

        todoService.addTodo("Memulai bisnis startup sendiri");
        todoService.addTodo("kuliah S2");
        todoService.addTodo("Bekerja di startup");

        todoService.showTodo();

        todoService.removeTodo(20);
        todoService.removeTodo(4);
        todoService.removeTodo(2);

        todoService.showTodo();



    }

}
