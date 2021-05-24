package service;

import entity.Todo;
import repository.TodoRepository;

public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void showTodo() {

        Todo[] dataTodoList = todoRepository.getAll();

        System.out.println("============ TODO LIST ===========");

        for (int i = 0; i < dataTodoList.length; i++) {
            Todo todo = dataTodoList[i];
            Integer no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodo(String todo) {
        Todo todolist = new Todo(todo);
        todoRepository.add(todolist);
        System.out.println("SUCCES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodo(Integer no) {

        boolean success = todoRepository.remove(no);

        if (success){
            System.out.println("SUCCESS MENGHAPUS TODO : " + no);
        }else {
            System.out.println("GAGAL MENGHAPUS TODO : " + no);
        }

    }
}
