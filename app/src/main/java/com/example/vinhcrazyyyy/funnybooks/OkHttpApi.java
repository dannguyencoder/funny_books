package com.example.vinhcrazyyyy.funnybooks;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpApi implements Api {
    @Override
    public void getBookList(final GetBooksResponseListener responseListener) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.googleapis.com/books/v1/volumes?q=isbn")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                ThreadUtils.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        responseListener.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseString = response.body().string();

                ThreadUtils.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("response String", "run: " + responseString);

                        //TODO: convert response to object

                        BookResponse bookResponse = new Gson().fromJson(responseString, BookResponse.class);

                        List<BookModel> results = new ArrayList<>();

                        BookModel bookModel = new BookModel();

                        BookResponse.BookItem bookItem;

                        //TODO: convert response model to local BookModel
                        for (int i = 0; i < bookResponse.getItems().size(); i++) {
                            bookItem = bookResponse.getItems().get(i);

                            bookModel.setName(bookItem.getVolumeInfo().getTitle());
                            bookModel.setAuthor(bookItem.getVolumeInfo().getAuthors().get(0));
                            bookModel.setShortDesc(bookItem.getVolumeInfo().getDescription());
                            bookModel.setThumbnailLink(Uri.parse(bookItem.getVolumeInfo().getImageLinks().getThumbnail()));

                            results.add(bookModel);
                        }


                        responseListener.onResponse(results);
                    }
                });
            }
        });
    }
}
