package com.example.vinhcrazyyyy.funnybooks;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

class BookResponse {

    @SerializedName("kind")
    String kind;

    @SerializedName("totalItems")
    String totalItems;

    @SerializedName("items")
    List<BookItem> items;

    public String getKind() {
        return kind;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public List<BookItem> getItems() {
        return items;
    }

    public class BookItem {

        @SerializedName("volumeInfo")
        VolumeInfo volumeInfo;

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        class VolumeInfo {

            @NonNull
            @SerializedName("title")
            String title;

            @NonNull
            @SerializedName("authors")
            List<String> authors;

            @NonNull
            @SerializedName("description")
            String description;

            @NonNull
            @SerializedName("imageLinks")
            ImageLinks imageLinks;

            @NonNull
            public String getTitle() {
                return title;
            }

            @NonNull
            public List<String> getAuthors() {
                if (authors == null) {
                    return Arrays.asList("This doesn't have author");
                }
                return authors;
            }

            @NonNull
            public String getDescription() {
                if (description == null) {
                    return "This doesn't have author";
                }
                return description;
            }

            @NonNull
            public ImageLinks getImageLinks() {
                if (imageLinks == null) {
                    return new ImageLinks("https://i.ebayimg.com/images/g/G1oAAOxygPtSv6b0/s-l300.jpg", "https://i.ebayimg.com/images/g/G1oAAOxygPtSv6b0/s-l300.jpg");
                }
                return imageLinks;
            }

            public class ImageLinks {
                @SerializedName("smallThumbnail")
                String smallThumbnail;

                @SerializedName("thumbnail")
                String thumbnail;

                public ImageLinks(String smallThumbnail, String thumbnail) {
                    this.smallThumbnail = smallThumbnail;
                    this.thumbnail = thumbnail;
                }

                public String getSmallThumbnail() {
                    if (smallThumbnail == null) {
                        return "This doesn't have small thumbnail";
                    }
                    return smallThumbnail;
                }

                public String getThumbnail() {
                    if (thumbnail == null) {
                        return "This doesn't have large thumbnail";
                    }
                    return thumbnail;
                }
            }
        }
    }
}
