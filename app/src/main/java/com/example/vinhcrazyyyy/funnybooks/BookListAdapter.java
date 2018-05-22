package com.example.vinhcrazyyyy.funnybooks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinhcrazyyyy.funnybooks.BookListAdapter.BookItemViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListAdapter extends RecyclerView.Adapter<BookItemViewHolder> {

    private List<BookModel> data;

    private OnItemClickListener onItemClickListener;

    public BookListAdapter(List<BookModel> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list, parent, false);
        return new BookItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class BookItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sdw_thumbnail)
        SimpleDraweeView sdwThumbnail;

        @BindView(R.id.tv_book_name)
        TextView tvBookName;

        @BindView(R.id.tv_book_author)
        TextView tvBookAuthor;

        @BindView(R.id.tv_book_shortDesc)
        TextView tvBookShortDesc;


        public BookItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        public void bind(final BookModel dataItem) {
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(dataItem);
                }
            });

            sdwThumbnail.setImageURI(dataItem.getThumbnailLink());
            tvBookName.setText(dataItem.getName());
            tvBookAuthor.setText(dataItem.getAuthor());
            tvBookShortDesc.setText(dataItem.getShortDesc());
        }
    }

    interface OnItemClickListener {
        void onItemClick(BookModel bookModel);
    }
}
