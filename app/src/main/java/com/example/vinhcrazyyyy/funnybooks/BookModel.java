package com.example.vinhcrazyyyy.funnybooks;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class BookModel implements Parcelable {

    private String name;

    private Uri thumbnailLink;

    private String author;

    private String shortDesc;

    protected BookModel(Parcel in) {
        name = in.readString();
        thumbnailLink = in.readParcelable(Uri.class.getClassLoader());
        author = in.readString();
        shortDesc = in.readString();
    }

    public static final Creator<BookModel> CREATOR = new Creator<BookModel>() {
        @Override
        public BookModel createFromParcel(Parcel in) {
            return new BookModel(in);
        }

        @Override
        public BookModel[] newArray(int size) {
            return new BookModel[size];
        }
    };

    public BookModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(Uri thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(thumbnailLink, flags);
        dest.writeString(author);
        dest.writeString(shortDesc);
    }
}
