package com.example.sendmessagebinding.iu;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivityViewMessageBinding;

/**
 * Clase que muestra un mensaje de un usuario. Recoge un mensaje que implementa la interfaz 
 * Parcelable.
 */

public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ViewMessageActivity";
    private ActivityViewMessageBinding binding;

    //region CICLO DE VIDA DE LA ACTIVITY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 1. Recoger el Bundle que se han enviado en el Intent que se ha inciado
        // Esta actividad
        
        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        binding.setMessage(message);
        Log.d(TAG,"ViewMessageActivity -> onCreate()");
    }


    @Override
    /**
     * Este método se ejecuta cuando se activa la Activity
     */
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ViewMessageActivity -> onStart()");
    }

    /**
     * Este método se ejecuta cuando se reactiva la Activity
     */
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ViewMessageActivity -> onResume()");
    }

    @Override
    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ViewMessageActivity -> On destroy()");
    }

    /**
     * Este método se ejecuta cuando se para la Activity
     */
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ViewMessageActivity -> onStop()");
    }

    /**
     * Este método se ejecuta cuando se pausa la Activity
     */
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"ViewMessageActivity -> onPause()");
    }

    //endregion
}