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
import com.rubach.petagram.db.ConstructorUsuarioApp;
import com.rubach.petagram.pojo.UsuarioInstagram;

public class UsuarioActivity extends AppCompatActivity {

    private EditText txtUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        //muestro flecha de retroceder
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //cargo el txt de usuario
        txtUsuario = (EditText) findViewById(R.id.tvUserName);
        //cargo accion del boton
        Button btnAgregarUsuario = (Button)findViewById(R.id.cmdGuardarCuenta);
        assert btnAgregarUsuario != null;
        btnAgregarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardoDatos();
            }
        });

        //cargo los datos del usuario si ya esta cargado
        ConstructorUsuarioApp constructorUsuarioApp=new ConstructorUsuarioApp(this);

        txtUsuario.setText(constructorUsuarioApp.obtenerUsuarioApp());
    }

    public void GuardoDatos(){
        //Guardo en base de datos
        ConstructorUsuarioApp constructorUsuarioApp=new ConstructorUsuarioApp(this);
        UsuarioInstagram usuarioInstagram=new UsuarioInstagram(1,txtUsuario.getText().toString());
        constructorUsuarioApp.guardarUsuario(usuarioInstagram);
        Toast.makeText(getBaseContext(),"Usuario almacenado con exito", Toast.LENGTH_SHORT).show();

    }

    //metodo para cuando pulsa el boton de ir atras.
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
