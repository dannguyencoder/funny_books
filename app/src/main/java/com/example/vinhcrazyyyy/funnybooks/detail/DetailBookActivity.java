package com.example.vinhcrazyyyy.funnybooks.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.vinhcrazyyyy.funnybooks.BookModel;
import com.example.vinhcrazyyyy.funnybooks.R;

public class DetailBookActivity extends Activity {

    private static final String BOOK_ITEM = "BOOK_ITEM";

    private BookModel bookItemData;

    public static Intent makeIntent(Context context, BookModel bookModel) {
        Intent intent = new Intent(context, DetailBookActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BOOK_ITEM, bookModel);
        intent.putExtra(BOOK_ITEM, bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        Bundle bundle;

        if (savedInstanceState != null) {
            bundle = savedInstanceState.getParcelable(BOOK_ITEM);
        } else {
            bundle = getIntent().getParcelableExtra(BOOK_ITEM);
        }

        if (bundle != null) {
            bookItemData = bundle.getParcelable(BOOK_ITEM);
        }

        Log.d("a_book", "onCreate: " + bookItemData.getName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BOOK_ITEM, bookItemData);
    }
}
