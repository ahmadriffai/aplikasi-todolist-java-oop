package view;

import service.TodoService;
import util.InputUtil;

public class TodoView {

    private TodoService todoService;

    public TodoView(TodoService todoService) {
        this.todoService = todoService;
    }

    public void showTodo(){
        while (true){

            todoService.showTodo();

            System.out.println("Menu");
            System.out.println("[1] . Tambah Todo List");
            System.out.println("[2] . Hapus Todo List");
            System.out.println("[x] . Keluar Aplikasi");

            String menu = InputUtil.input("Pilih Menu");

            if (menu.equals("1")){
                addTodo();
            } else if (menu.equals("2")){
                removeTodo();
            }else if (menu.equals("x")){
                System.out.println("Terimakasih :)");
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodo(){
        System.out.println("============ MENAMBAH TODO ==========");
        String todo = InputUtil.input("Todo(x jika batal)");

        if (todo.equals("x")){
            // batal
        }else {
            todoService.addTodo(todo);
        }
    }

    public void removeTodo(){
        System.out.println("============ HAPUS TODO ==========");
        String nomer = InputUtil.input("Nomer yang dihapus (x jika batal)");

        if (nomer.equals("x")){
            System.out.println("Batal menambah todo");
        }else {
            todoService.removeTodo(Integer.valueOf(nomer));
        }
    }

}
