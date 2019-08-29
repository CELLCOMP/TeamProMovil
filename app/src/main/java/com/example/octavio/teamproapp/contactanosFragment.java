package com.example.octavio.teamproapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contactanosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contactanosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class  contactanosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    View vista;
    Button enviar;
    ImageButton whatsapp,facebook,llamada;
    EditText nombre,correo,contenidoCorreo;



    public contactanosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactanosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contactanosFragment newInstance(String param1, String param2) {
        contactanosFragment fragment = new contactanosFragment();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contactanos, container, false);


        enviar = vista.findViewById(R.id.buttonEnviarActivity);
        nombre = vista.findViewById(R.id.nombreETActivity);
        contenidoCorreo = vista.findViewById(R.id.contenidoETActivity);

        whatsapp=  vista.findViewById(R.id.whatsappbuttonACtivity);
        facebook = vista.findViewById(R.id.facebookbuttonActivity);
        llamada = vista.findViewById(R.id.telefonoButtonActivity);

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLlamada = new Intent(Intent.ACTION_DIAL);
                intentLlamada.setData(Uri.parse("tel:95344931"));
                startActivity(intentLlamada);

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/teampro2018/?ref=br_rs");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent sendIntent = new Intent();
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.gbwhatsapp");
                    startActivity(sendIntent);

                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        });


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[]email = new String[]{"octaviogamerofa@gmail.com"};
                String subject = new String("Cotización, Opinión de la App, ect.");
                String mensaje =nombre.getText().toString() +" " + contenidoCorreo.getText().toString();
                escribirCorreo(email,subject,mensaje);
            }
        });
        return vista;
    }


    public void escribirCorreo(String[]email,String subject, String mensaje){
        Intent intentEnviarCorreo = new Intent(Intent.ACTION_SEND);
        intentEnviarCorreo.setType("*/*");

        intentEnviarCorreo.putExtra(Intent.EXTRA_SUBJECT,subject);
        intentEnviarCorreo.putExtra(Intent.EXTRA_EMAIL,email);
        intentEnviarCorreo.putExtra(Intent.EXTRA_TEXT,mensaje);
        startActivity(intentEnviarCorreo);

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
