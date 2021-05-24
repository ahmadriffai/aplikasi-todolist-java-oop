import java.util.Scanner;

public class AplikasiTodoList {

    public static String[] dataTodoList = new String[10];

    public static void main(String[] args) {

        viewShowTodoList();

    }

    /**
     * Menampilkan data todo list
     */
    public static void showTodoList(){

        System.out.println("============ TODO LIST ===========");

        for (int i = 0; i < dataTodoList.length; i++) {
            String todo = dataTodoList[i];
            Integer no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }


    public static void testShowTodoList(){

        dataTodoList[0] = "Belajar Pemrograman ";
        dataTodoList[1] = "Belajar Bahasa Inggris";
        dataTodoList[2] = "Belajar Menerima kenyataan yang terjadi";
        showTodoList();

    }

    /**
     * Menambah data todo list
     */
    public static void addTodoList(String todo){

        // apakah array penuh
        boolean isFull = true;

        // cek apakah array sudah penuh
        for (int i = 0; i < dataTodoList.length; i++) {
            if (dataTodoList[i] == null){

                isFull = false;
                break;
            }
        }

        // resize array yang penuh dengan mengalikan 2 x lipat data array
        if (isFull) {
            // memindahkan data array sebelumnya ke tempp
            String[] temp = dataTodoList;
            // resize array todo
            dataTodoList = new String[dataTodoList.length * 2];

            // memasukan data di temporari ke array dengan ukuran baru
            for (int i = 0; i < temp.length; i++) {
                dataTodoList[i] = temp[i];
            }

        }


        // menambah data array ke array yang kosong
        for (int i = 0; i < dataTodoList.length ; i++) {
            if (dataTodoList[i] == null){
                dataTodoList[i] = todo;

                break;
            }
        }

    }

    public static void testAddTodoList(){
        for (int i = 0; i < 100 ; i++) {
            addTodoList("Data ke - " + i);
        }

        showTodoList();

        System.out.println("Panjang array : " + dataTodoList.length);
    }

    /**
     * Menghapus data todo list
     */
    public static boolean removeTodoList(Integer no){

        //cek apakah nomer lebih dari panjang data array
        if ((no - 1) >= dataTodoList.length){
            return false;
        }else if(dataTodoList[no-1] == null){ // cek apakah data sebelumnya null atau tidak?
            return false;
        }else {
            dataTodoList[no-1] = null;
            for (int i = (no - 1); i < dataTodoList.length; i++) {
                if (i == (dataTodoList.length - 1)){
                    dataTodoList[i] = null;
                }else {
                    dataTodoList[i] = dataTodoList[i + 1];
                }
            }

            return true;
        }

    }

    public static void testRemoveTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        boolean result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);

        showTodoList();

    }


    public static String input(String title){
        Scanner scanner = new Scanner(System.in);

        System.out.print(title + " : ");
        String data = scanner.nextLine();

        return data;
    }

    public static void testInput(){
        String nama = input("Nama");
        String cinta = input("Cinta");

        System.out.println("Hallo " + nama + " kamu sedang jatuh cinta dengan " + cinta);

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList(){

        while (true){

            showTodoList();

            System.out.println("Menu");
            System.out.println("[1] . Tambah Todo List");
            System.out.println("[2] . Hapus Todo List");
            System.out.println("[x] . Keluar Aplikasi");

            String menu = input("Pilih Menu");

            if (menu.equals("1")){
                viewAddTodoList();
            } else if (menu.equals("2")){
                viewRemoveTodoList();
            }else if (menu.equals("x")){
                System.out.println("Terimakasih :)");
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public static void testViewShowTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();

    }

    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddTodoList(){

        System.out.println("============ MENAMBAH TODO ==========");
        String todo = input("Todo(x jika batal)");

        if (todo.equals("x")){
            System.out.println("Batal menambah todo");
        }else {
            addTodoList(todo);
            System.out.println("Berhasil menambahkan todo " + todo);
        }

    }

    public static void testViewAddTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        viewAddTodoList();

        showTodoList();


    }

    /**
     * Menampilkan view hapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("============ HAPUS TODO ==========");
        String nomer = input("Nomer yang dihapus (x jika batal)");

        if (nomer.equals("x")){
            System.out.println("Batal menambah todo");
        }else {
            boolean success = removeTodoList(Integer.valueOf(nomer));
            if (!success){
                System.out.println("Gagal menghapus todo");
            }else {
                System.out.println("Berhasil menghapus todo");
            }
        }
    }

    public static void testViewRemoveTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();

    }

}
