package com.example.vinhcrazyyyy.funnybooks;

import java.util.List;

public interface GetBooksCallback {

    void onSuccess(List<BookModel> results);

    void onFailure(Exception e);
}
