package materialdesign.interra.com.chips;

import android.widget.TextView;

public class Person {
    private String name;
    private int picture;

    Person(String name, int picture ) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
