package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kai on 29.01.2018.
 */

public class Registrieren_Tab3 extends Fragment
{
    public static String vorname, name, email, telnr, pw, pwWiederholen, titel, anrede;
    private EditText et_praxisName, et_adresse, et_plz, et_stadt, et_praxisTel, et_praxisMail;
    private String praxisName, adresse, plz, stadt, praxisTel, praxisMail;
    private int nid;
    private CheckBox checkBox;
    private RequestQueue requestQueue;
    private String insertUrl = "http://192.168.1.34/android_connect/insertUser.php";
    private String getNidUrl = "http://192.168.1.34/android_connect/getNID.php";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab3_praxis, container, false);
        Button registrieren = view.findViewById(R.id.but_tab3register);
        Button back = view.findViewById(R.id.but_tab3zur);

        et_praxisName = view.findViewById(R.id.et_praxisName);
        et_adresse = view.findViewById(R.id.et_adresse);
        et_plz = view.findViewById(R.id.et_plz);
        et_stadt = view.findViewById(R.id.et_stadt);
        et_praxisTel = view.findViewById(R.id.et_praxisTelNr);
        et_praxisMail = view.findViewById(R.id.et_praxisMail);
        checkBox = view.findViewById(R.id.checkBox);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        checkBox.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, getNidUrl, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            JSONArray userNid = response.getJSONArray("user");
                            JSONObject objNid = userNid.getJSONObject(0);
                            nid = Integer.parseInt(objNid.getString("max(NID)"));
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

        registrieren.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (checkBox.isChecked())
                {

                    praxisMail = et_praxisMail.getText().toString();
                    if (praxisMail.matches("(\\w{1,}(\\w|\\.){1,})@(\\w{1,}(\\w|\\.){1,}\\.\\w{2,})") || praxisMail.isEmpty())
                    {
                        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                Intent i = new Intent(getActivity(),Anmelden.class);
                                startActivity(new Intent(i));
                            }
                        }, new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError
                            {
                                praxisName = et_praxisName.getText().toString();
                                adresse = et_adresse.getText().toString();
                                plz = et_plz.getText().toString();
                                stadt = et_stadt.getText().toString();
                                praxisTel = et_praxisTel.getText().toString();
                                praxisMail = et_praxisMail.getText().toString();

                                if(titel == null)
                                {
                                    titel = "";
                                }
                                Map<String, String> parameters = new HashMap<String, String>();
                                parameters.put("nid", "" + (nid + 1));
                                parameters.put("name", ""+name);
                                parameters.put("vorname", ""+vorname);
                                parameters.put("anrede", ""+anrede);
                                parameters.put("namenszusatz", ""+titel);
                                parameters.put("praxis", ""+praxisName);
                                parameters.put("adresse", ""+adresse);
                                parameters.put("plz", ""+plz);
                                parameters.put("stadt", ""+stadt);
                                parameters.put("email", ""+email);
                                parameters.put("praxisnr", ""+praxisTel);
                                parameters.put("handynr", ""+telnr);
                                parameters.put("passwort", ""+pw);
                                parameters.put("adresszusatz", ""+praxisMail);
                                return parameters;
                            }
                        };
                        requestQueue.add(request);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setMessage("Bitte geben Sie eine gültige E-Mail Adresse ein!")
                                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id)
                                    {

                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Sie müssen unsere Datenschutzbestimmungen und AGBs akzeptieren!")
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                ((Registrieren) getActivity()).setCurrentItem(1, true);
            }
        });
        return view;
    }
}
