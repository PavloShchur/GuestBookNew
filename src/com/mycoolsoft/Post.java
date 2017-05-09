package com.mycoolsoft;

/**
 * Created by User on 07.05.2017.
 */
public class Post {

    long id;
    String txt;


    public Post(String txt) {
        this.txt = txt;
    }

    public Post() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "com.mycoolsoft.Post{" +
                "id=" + id +
                ", txt='" + txt + '\'' +
                '}';
    }

}

