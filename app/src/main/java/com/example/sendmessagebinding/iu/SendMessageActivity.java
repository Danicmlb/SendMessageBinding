package com.example.sendmessagebinding.iu;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Send Message's Project</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones:
 * <ol>
 *     <li>Crear un evento en un componente Button en codigo XML</li>
 *     <li>Crear un listener del evento <code>OnClick(</code>)</li>
 *     <li>El ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de actividades</li>
 * </ol>
 * @author Daniel
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;


    // private SendMessageOnClickListener delegate;

    /**
     * Crea el menú de opciones en la vida. Se devuelve true para indicar
     * que se ha realizado en
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este método callback se llaa cuando se pulsa sobre una de las opciones del menu de la aplicación
     * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_aboutus:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
         }
        return true;
    }


    //region CICLO DE VIDA DE LA ACTIVITY

    @Override

    /**
     * Método que se ejecuta cuando se crea una actividad
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "SendMessageActivity -> onCreate()");

        /**
         *      //Se inicializa el delegado
         *         delegate = new SendMessageOnClickListener();
         *         //sE ESTABLECE EL VINCULO ENTRE LE BOTÓN Y SU DELEGADO
         *         btSend.setOnClickListener(delegate);
         */


        /**
         *      Esto es una clase anonima, es una alternativa al uso de los delegados ya que
         *      se simplica el codigo y consume menos
         *
         *      //Establecer el listener OnClickListener al botón
         *         // implemento la interfaz View.OnClickListener
         *
         *         Actualmente el codigo que hay debajo es un lamda ya que tras hacer la clase
         *         anonima vemos que podemos convertirla en lamda para así simplificar y dejar
         *         más limpio el código
         */

        //Un unico método
        //Que el objeto de la definición sea el mismo que tengas que meter dentro
        // Expresión lamda es un el valor que se mete dentro de los parentesis
        binding.setMessage(new Message(((SendMessageApplication)getApplication()).getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());
                //view -> Toast.makeText(SendMessageActivity.this,"Esto es a traves de una clase anonima",Toast.LENGTH_LONG).show());
    }

    @Override
    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG, "SendMessageActivity -> On destroy()");
    }

    @Override
    /**
     * Este método se ejecuta cuando se activa la Activity
     */
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessageActivity -> onStart()");
    }

    /**
     * Este método se ejecuta cuando se para la Activity
     */
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessageActivity -> onStop()");
    }

    /**
     * Este método se ejecuta cuando se reactiva la Activity
     */
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessageActivity -> onResume()");
    }

    /**
     * Este método se ejecuta cuando se pausa la Activity
     */
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SendMessageActivity -> onPause()");
    }

    //endregion

    /**
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML android:onclick="sendMessage"
     */

    public void sendMessage () {


           //TODO Se modificará este ejercicio para estudiar ViewBinding
                  //Toast.makeText(this, "Enviado",Toast.LENGTH_LONG).show();

                  // 1. Crear el contenedor para añadir los datos
                  Bundle bundle = new Bundle();

                  // 1.1 Pasar dato a dato
                    //bundle.putString("user",etUser.getText().toString());
                   // bundle.putString("message",etMessage.getText().toString());

                  // 1.2 Crear un objeto Message
                  bundle.putParcelable("message", binding.getMessage());

                  // 2. Vamos a crear el objeto Intent explicito porque se conoce la actividad
                  // destino
                 Intent intent = new Intent(this,ViewMessageActivity.class);
                  intent.putExtras(bundle);

        // 3. Se inicia la transición entre una vista y otra
                  startActivity(intent);


    }

    /**
     * Esta clase no anonima implementa el listener que responde al evento
     * <code>OnClick</code>
     */

    /**
     *
     * <h1>DELEGADO</h1>
     *
     *     class SendMessageOnClickListener implements View.OnClickListener {
     *
     *         @Override
     *         public void onClick(View view) {
     *             Toast.makeText(SendMessageActivity.this,"Esto es a traves de un delegado",Toast.LENGTH_LONG).show();
     *         }
     *     }
     */

}