package com.example.vinhcrazyyyy.funnybooks;

import java.util.List;

interface GetBooksResponseListener {

    void onResponse(List<BookModel> results);

    void onError(Exception e);
}
