package com.rubach.petagram.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rubach.petagram.R;
import com.rubach.petagram.email.SendMail;

public class contactoActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtBodyEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        //muestro flecha de retroceder
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //cargo los textview
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo= (EditText) findViewById(R.id.txtCorreo);
        txtBodyEmail= (EditText) findViewById(R.id.txtBodyEmail);
        //cargo accion del boton
        Button btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        assert btnSiguiente != null;
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargoDatos();
            }
        });

    }
    public void CargoDatos(){
        //envio el email
        Toast.makeText(getBaseContext(),"favor configurar casilla y passord para el envio", Toast.LENGTH_SHORT).show();
        //Para testear esta funcionalidad, se debe probar con usuario y clave (gmail) de cada uno, en la clase Config.java.
        //luego descomentar la funcion sendEmail();
        //sendEmail();
    }

    //metodo para cuando pulsa el boton de ir atras.
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void sendEmail() {
        //seteo las variables.
        String email = txtCorreo.getText().toString().trim();
        String subject = txtNombre.getText().toString().trim();
        String message = txtBodyEmail.getText().toString().trim();

        //Creo el objeto
        SendMail sm = new SendMail(this, email, subject, message);

        //Envio el email
        sm.execute();
    }
}
