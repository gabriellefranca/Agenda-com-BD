package com.example.gabi2.agendacontato;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class cadastro extends Activity implements View.OnClickListener  {

    private Button enviar;
    private EditText nome;
    private EditText email;
    private EditText telefone;
    public static final String JSON_URL = "http://projetosfranca.com/android.php";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        enviar = (Button) findViewById(R.id.enviar);
        enviar.setOnClickListener(this);

    }

    public void SendData(View v)
    {
        final EditText nome=(EditText)findViewById(R.id.nome);
        final EditText email=(EditText) findViewById(R.id.email);
        final EditText telefone=(EditText) findViewById(R.id.telefone);
        final String Nome = nome.getText().toString().trim();
        final String Email = email.getText().toString().trim();
        final String Telefone = telefone.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        Toast.makeText(cadastro.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(cadastro.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(NOME,Nome);
                params.put(EMAIL, Email);
                params.put(TELEFONE, Telefone);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.enviar:
                Intent it = new Intent(cadastro.this, contatos.class);
                startActivity(it);
                break;


        }
    }
}
