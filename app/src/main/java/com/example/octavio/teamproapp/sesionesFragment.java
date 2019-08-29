package com.example.octavio.teamproapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toolbar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link sesionesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link sesionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sesionesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<SesionesVo> listaSesiones;
    RecyclerView recyclerViewSesiones;
    ImageButton botonGrid ,botonLista;
    View vista;
     ImageView ismg;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public sesionesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sesionesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sesionesFragment newInstance(String param1, String param2) {
        sesionesFragment fragment = new sesionesFragment();
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

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_sesiones, container, false);
        construirRecycler();
        llenarSesiones();
        botonGrid = vista.findViewById(R.id.buttonGrid);
        botonLista =vista.findViewById(R.id.buttonLista);


        botonGrid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Utilidades.visualizacion=Utilidades.GRID;
                construirRecycler();
            }
        });
        botonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilidades.visualizacion=Utilidades.LIST;
                construirRecycler();


            }

        });

        return vista;
    }
    private void construirRecycler() {

        listaSesiones = new ArrayList<>();
        recyclerViewSesiones = vista.findViewById(R.id.recyclerSesiones);
        if(Utilidades.visualizacion==Utilidades.LIST){
            recyclerViewSesiones.setLayoutManager(new LinearLayoutManager(getContext()));

        }else{
            recyclerViewSesiones.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        llenarSesiones();
        Adaptador_Sesiones adaptador_sesiones = new Adaptador_Sesiones(listaSesiones,getContext());
        recyclerViewSesiones.setAdapter(adaptador_sesiones);


    }




    private void llenarSesiones() {
        listaSesiones.add(new SesionesVo("Boda",R.drawable.bodas));
        listaSesiones.add(new SesionesVo("Familiar",R.drawable.familiar));
        listaSesiones.add(new SesionesVo("Pregnancy",R.drawable.pregnancy));
        listaSesiones.add(new SesionesVo("Pre-Wedding",R.drawable.prewedding));
        listaSesiones.add(new SesionesVo("Bautizos",R.drawable.bautizos));
        listaSesiones.add(new SesionesVo("Aniversario de Bodas",R.drawable.aniversarioboda));
        listaSesiones.add(new SesionesVo("Bebes",R.drawable.bebes));
        listaSesiones.add(new SesionesVo("Catálogo Corporativo",R.drawable.corporativa));
        listaSesiones.add(new SesionesVo("Eventos Sociales",R.drawable.social));
        listaSesiones.add(new SesionesVo("Concierto",R.drawable.concierto));
        listaSesiones.add(new SesionesVo("Cumpleaños",R.drawable.cumpleaneos));
        listaSesiones.add(new SesionesVo("Fiestas",R.drawable.fiestas));
        listaSesiones.add(new SesionesVo("Navideñas",R.drawable.navidenias));
        listaSesiones.add(new SesionesVo("Parejas",R.drawable.parejas));
        listaSesiones.add(new SesionesVo("Pre-Cumpleaños",R.drawable.precumple));
        listaSesiones.add(new SesionesVo("Tomas Aéreas",R.drawable.tomasaereas));
        listaSesiones.add(new SesionesVo("Urbanas",R.drawable.urbanas));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }






    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
