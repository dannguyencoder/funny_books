package com.example.vinhcrazyyyy.funnybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vinhcrazyyyy.funnybooks.BookListContract.View;
import com.example.vinhcrazyyyy.funnybooks.detail.DetailBookActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListActivity extends AppCompatActivity implements View, BookListAdapter.OnItemClickListener {

    @BindView(R.id.rv_book_list)
    RecyclerView rvBookList;

    BookListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        ButterKnife.bind(this);

        presenter = new BookListPresenter(this, new BookListRemoteDatasource(new OkHttpApi()));
        presenter.getBooks();
    }

    @Override
    public void showBookList(List<BookModel> data) {
        Log.d("data size", "showBookList: " + data.size());

        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getName();
            String author = data.get(i).getAuthor();
            String shortDesc = data.get(i).getShortDesc();
            String thumbnail = data.get(i).getThumbnailLink().toString();
            Log.d("book item", name + " / " + author + " / " + shortDesc + " / " + thumbnail);
        }

        setupRecyclerView(data);
    }

    private void setupRecyclerView(List<BookModel> data) {
        BookListAdapter adapter = new BookListAdapter(data, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBookList.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvBookList.addItemDecoration(dividerItemDecoration);

        rvBookList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(BookModel bookModel) {
        startActivity(DetailBookActivity.makeIntent(this, bookModel));
    }
}
