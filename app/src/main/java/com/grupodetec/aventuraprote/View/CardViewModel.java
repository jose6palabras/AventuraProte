package com.grupodetec.aventuraprote.View;

/**
 * Created by android on 17/12/18.
 */

public class CardViewModel {
    public int photo_id;
    public String name;
    public String local;

    public CardViewModel(int photo_id, String name, String local) {
        this.photo_id = photo_id;
        this.name = name;
        this.local = local;
    }
}
