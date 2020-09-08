package com.magove.tiempo.fragmants;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.magove.tiempo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tiempos_fragmentMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tiempos_fragmentMenu extends Fragment {

    Button btn_alta,btn_curso,btn_pausa,btn_detalles;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tiempos_fragmentMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tiempos_fragmentMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static tiempos_fragmentMenu newInstance(String param1, String param2) {
        tiempos_fragmentMenu fragment = new tiempos_fragmentMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiempos_menu, container, false);

    }

    // METODO A SOBRE ESCRIBIR PARA TRABAJAR CON LOS ITEMS DEL FRAGMENT

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // REFERENCIA A LOS BOTONES DE LA VISTA

        btn_alta=view.findViewById(R.id.id_btnAlta);
        btn_curso=view.findViewById(R.id.id_btnEnCurso);
        btn_detalles=view.findViewById(R.id.id_btnDetalles);
        btn_pausa=view.findViewById(R.id.id_btnPausado);



        // ASIGNACION DEL METODO ONCLIC A CADA BOTON

        btn_alta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_alta_Tiempos);
            }
        });

        // INDICACION DE QUE FRAGMENT ABRIRA CADA BOTON

        btn_pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_Pausados);
            }
        });

        btn_curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_EnCurso_tiempos);
            }
        });

        btn_detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_Detalles);
            }
        });
    }

}