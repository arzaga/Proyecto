package com.example.alexis.proyecto.rutinas;

import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.mData.mDataRutinas;

import java.util.ArrayList;

/**
 * Created by Alexis on 22/05/2017.
 */

public class pierna {
    public static ArrayList<mDataRutinas> getPierna()
    {
        ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
        mDataRutinas spaceCraft=null;

        //ADD DATA TO COLLECTION
        spaceCraft=new mDataRutinas();
        spaceCraft.setName("Pierna");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);


        spaceCraft=new mDataRutinas();
        spaceCraft.setName("kk");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);

        spaceCraft=new mDataRutinas();
        spaceCraft.setName("Hubble");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);


        //RETURN COLLECTION
        return spaceCrafts;
    }
}
