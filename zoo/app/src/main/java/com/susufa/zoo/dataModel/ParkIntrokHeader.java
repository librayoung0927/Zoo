package com.susufa.zoo.dataModel;

import com.susufa.zoo.adapter.ParkRecyclerAdapter;

import java.io.Serializable;

public class ParkIntrokHeader extends RecyclerBaseItem implements Serializable {
    public ParkIntrokHeader() {
        super(ParkRecyclerAdapter.HEADER_PARK_INTRO);
    }

    private ParkIntro mParkIntro;

    public ParkIntro getParkIntro() {
        return mParkIntro;
    }

    public void setParkIntro(ParkIntro parkIntro) {
        mParkIntro = parkIntro;
    }
}
