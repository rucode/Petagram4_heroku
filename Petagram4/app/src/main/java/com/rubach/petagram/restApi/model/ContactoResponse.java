package com.rubach.petagram.restApi.model;

import com.rubach.petagram.pojo.MascotaInstagram;

import java.util.ArrayList;

/**
 * Created by Ronald on 14/09/17.
 */

public class ContactoResponse {

    ArrayList<MascotaInstagram> mascotaInstagrams;

    public ArrayList<MascotaInstagram> getMascotaInstagrams() {
        return mascotaInstagrams;
    }

    public void setMascotaInstagrams(ArrayList<MascotaInstagram> mascotaInstagrams) {
        this.mascotaInstagrams = mascotaInstagrams;
    }

}
