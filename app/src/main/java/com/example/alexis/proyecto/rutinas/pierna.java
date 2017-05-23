package com.example.alexis.proyecto.rutinas;

import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.mData.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by Alexis on 22/05/2017.
 */

public class pierna {
    public static ArrayList<SpaceCraft> getPierna()
    {
        ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
        SpaceCraft spaceCraft=null;

        //ADD DATA TO COLLECTION
        spaceCraft=new SpaceCraft();
        spaceCraft.setName("Pierna");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);


        spaceCraft=new SpaceCraft();
        spaceCraft.setName("kk");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);

        spaceCraft=new SpaceCraft();
        spaceCraft.setName("Hubble");
        spaceCraft.setImage(R.drawable.pierna);
        spaceCrafts.add(spaceCraft);


        //RETURN COLLECTION
        return spaceCrafts;
    }
}
