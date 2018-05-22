package com.example.vinhcrazyyyy.funnybooks;

import com.example.vinhcrazyyyy.funnybooks.BookListContract.View;

import java.util.List;

public class BookListPresenter implements BookListContract.Presenter {

    BookListContract.View view;

    BookListDatasource bookListDatasource;

    public BookListPresenter(View view, BookListDatasource bookListDatasource) {
        this.view = view;
        this.bookListDatasource = bookListDatasource;
    }

    @Override
    public void getBooks() {
        bookListDatasource.getBooks(new GetBooksCallback() {
            @Override
            public void onSuccess(List<BookModel> results) {
                view.showBookList(results);
            }

            @Override
            public void onFailure(Exception e) {
                view.showError(e.toString());
            }
        });
    }
}
