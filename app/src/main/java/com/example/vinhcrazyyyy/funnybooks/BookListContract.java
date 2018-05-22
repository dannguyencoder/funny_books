package com.example.vinhcrazyyyy.funnybooks;

import java.util.List;

public interface BookListContract {

    interface View {
        void showBookList(List<BookModel> data);

        void showError(String errorMessage);
    }

    interface Presenter {
        void getBooks();
    }
}
