package test.view;

import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoView;

public class TodoViewTest {

    public static void main(String[] args) {
        testRemoveTodo();
    }

    public static void testShowTodo(){

        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoView todoView = new TodoView(todoService);

        todoService.addTodo("Belajar java");
        todoService.addTodo("Belajar Bahasa Inggris");
        todoService.addTodo("Belajar Startup");

        todoView.showTodo();

    }

    public static void testAddTodo(){

        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoView todoView = new TodoView(todoService);

        todoView.addTodo();

        todoService.showTodo();

        todoView.addTodo();

        todoService.showTodo();

        todoView.addTodo();

        todoService.showTodo();

    }

    public static void testRemoveTodo(){

        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoView todoView = new TodoView(todoService);

        todoService.addTodo("Belajar java");
        todoService.addTodo("Belajar Bahasa Inggris");
        todoService.addTodo("Belajar Startup");

        todoService.showTodo();

        todoView.removeTodo();

        todoService.showTodo();

    }


}
