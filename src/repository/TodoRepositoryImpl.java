package repository;

import entity.Todo;

public class TodoRepositoryImpl implements TodoRepository {

    public Todo[] data = new Todo[10];

    @Override
    public Todo[] getAll() {
        return data;
    }


    public boolean isFull(){
        // apakah array penuh
        boolean isFull = true;

        // cek apakah array sudah penuh
        for (int i = 0; i < data.length ; i++) {
            if (data[i] == null){

                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull(){

        // resize array yang penuh dengan mengalikan 2 x lipat data array
        if (isFull()) {
            // memindahkan data array sebelumnya ke tempp
            Todo[] temp = data;
            // resize array todo
            data = new Todo[data.length * 2];

            // memasukan data di temporari ke array dengan ukuran baru
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }

        }

    }

    @Override
    public void add(Todo todo) {

        resizeIfFull();

        // menambah data array ke array yang kosong
        for (int i = 0; i < data.length ; i++) {
            if (data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer no) {
        //cek apakah nomer lebih dari panjang data array
        if ((no - 1) >= data.length){
            return false;
        }else if(data[no-1] == null){ // cek apakah data sebelumnya null atau tidak?
            return false;
        }else {
            data[no-1] = null;
            for (int i = (no - 1); i < data.length; i++) {
                if (i == (data.length - 1)){
                    data[i] = null;
                }else {
                    data[i] = data[i + 1];
                }
            }

            return true;
        }

    }
}
