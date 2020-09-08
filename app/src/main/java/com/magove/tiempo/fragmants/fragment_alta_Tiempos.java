package com.magove.tiempo.fragmants;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.magove.tiempo.Modelos;
import com.magove.tiempo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_alta_Tiempos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_alta_Tiempos extends Fragment implements Response.Listener<JsonObjectRequest>,Response.ErrorListener {


RequestQueue request;
JsonObjectRequest jsonObjectRequest;

EditText txt_maquina;
Spinner sp_empleado,sp_actividad,sp_proyecto;
Button btn_guardar,btn_cancelar;
ImageButton btn_maquina,btn_proyecto;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_alta_Tiempos() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragment_alta_Tiempos newInstance(String param1, String param2) {
        fragment_alta_Tiempos fragment = new fragment_alta_Tiempos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Registro de tiempos");




        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alta__tiempos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Modelos m= new Modelos();
        request= Volley.newRequestQueue(getContext());
        txt_maquina=getActivity().findViewById(R.id.id_txtCodigoMaquina);
        sp_proyecto=getActivity().findViewById(R.id.id_spProyectos);
        sp_actividad=getActivity().findViewById(R.id.id_SpActividad);
        sp_empleado=getActivity().findViewById(R.id.id_spEmpleado);
        btn_cancelar=getActivity().findViewById(R.id.id_btnCancelar);
        btn_guardar=getActivity().findViewById(R.id.id_btnGuardar);
        btn_maquina=getActivity().findViewById(R.id.id_btnCodigo);
        btn_proyecto=getActivity().findViewById(R.id.id_btnProyecto);


        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"clic a guardar",Toast.LENGTH_SHORT).show();
            }
        });



        btn_proyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp_proyecto.getSelectedItem()!=null){
                    m.indice=2;
                    Toast.makeText(getActivity(),"item",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Debe seleccionar un elemento",Toast.LENGTH_SHORT).show();
                    sp_proyecto.setFocusable(true);
                }


            }
        });

        btn_maquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escanear();
            }
        });
    }



    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getActivity(),"No se pudo establecer conexión",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JsonObjectRequest response) {

    }

    public void escanear(){
        IntentIntegrator.forSupportFragment(fragment_alta_Tiempos.this).initiateScan();
    }
 // iniciamos el lector de codigos de barras
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult resultado= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(resultado!=null){
            txt_maquina.setText(resultado.getContents());
        }else{
            Toast.makeText(getActivity(),"No se pudo leer el código",Toast.LENGTH_SHORT).show();
        }
    }

        public void consulta_indices(){
       /* if (){

        }else if(){

        }else if (){

        }
*/
        }



}