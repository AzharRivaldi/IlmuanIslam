package com.azhar.ilmuanislam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel implements Parcelable {

    private String name, year, desc, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.year);
        dest.writeString(this.desc);
        dest.writeString(this.photo);
    }

    public MainModel() {
    }

    private MainModel(Parcel in) {
        this.name = in.readString();
        this.year = in.readString();
        this.desc = in.readString();
        this.photo = in.readString();
    }

    public static final Creator<MainModel> CREATOR = new Creator<MainModel>() {
        @Override
        public MainModel createFromParcel(Parcel source) {
            return new MainModel(source);
        }

        @Override
        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };
}
