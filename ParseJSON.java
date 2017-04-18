package com.example.gabi2.agendacontato;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] ids;
    public static String[] nomes;
    public static String[] emails;
    public static String[] telefones;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NOME = "nome";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TELEFONE = "telefone";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            nomes = new String[users.length()];


            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                nomes[i] = jo.getString(KEY_NOME);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}