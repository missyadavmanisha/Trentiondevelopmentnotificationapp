package com.codingblocks.trentiondevelopment;

public class Note {

    String name;
    String time;
      int count=0;

    public Note(String name, String time, String date) {
        this.name = name;
        this.time = time;
        this.date = date;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    String date;

    public Note() {

    }


    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

}
