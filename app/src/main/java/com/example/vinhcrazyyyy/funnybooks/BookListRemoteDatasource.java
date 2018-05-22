package com.example.vinhcrazyyyy.funnybooks;

import java.util.List;

public class BookListRemoteDatasource implements BookListDatasource {

    private Api api;

    public BookListRemoteDatasource(Api api) {
        this.api = api;
    }

    @Override
    public void getBooks(final GetBooksCallback callback) {
        api.getBookList(new GetBooksResponseListener() {
            @Override
            public void onResponse(List<BookModel> results) {
                callback.onSuccess(results);
            }

            @Override
            public void onError(Exception e) {
                callback.onFailure(e);
            }
        });
    }
}
