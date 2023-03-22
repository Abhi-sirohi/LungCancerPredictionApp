package com.abhinaysirohi.lungcancerprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lungcancerprediction.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8,ed9, ed10, ed11, ed12, ed13,
            ed14, ed15, ed16,ed17, ed18, ed19, ed20, ed21, ed22, ed23;
    private Button predict;
    AlertDialog.Builder builder;
    private ImageButton info1, info2, info3, info4, info5, info6, info7, info8,info9, info10, info11, info12, info13,
            info14, info15, info16,info17, info18, info19, info20, info21, info22, info23;
    private TextView result;
    private Button tips;
    String url = "https://geustudents.herokuapp.com/predict/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7);
        ed8 = findViewById(R.id.ed8);
        ed9 = findViewById(R.id.ed9);
        ed10 = findViewById(R.id.ed10);
        ed11 = findViewById(R.id.ed11);
        ed12 = findViewById(R.id.ed12);
        ed13 = findViewById(R.id.ed13);
        ed14 = findViewById(R.id.ed14);
        ed15 = findViewById(R.id.ed15);
        ed16 = findViewById(R.id.ed16);
        ed17 = findViewById(R.id.ed17);
        ed18 = findViewById(R.id.ed18);
        ed19 = findViewById(R.id.ed19);
        ed20 = findViewById(R.id.ed20);
        ed21 = findViewById(R.id.ed21);
        ed22 = findViewById(R.id.ed22);
        ed23 = findViewById(R.id.ed23);

        info1 = findViewById(R.id.info1);
        info2 = findViewById(R.id.info2);
        info3 = findViewById(R.id.info3);
        info4 = findViewById(R.id.info4);
        info5 = findViewById(R.id.info5);
        info6 = findViewById(R.id.info6);
        info7 = findViewById(R.id.info7);
        info8 = findViewById(R.id.info8);
        info9 = findViewById(R.id.info1);
        info10 = findViewById(R.id.info2);
        info11 = findViewById(R.id.info3);
        info12 = findViewById(R.id.info4);
        info13 = findViewById(R.id.info5);
        info14 = findViewById(R.id.info6);
        info15 = findViewById(R.id.info7);
        info16 = findViewById(R.id.info8);
        info17 = findViewById(R.id.info1);
        info18 = findViewById(R.id.info2);
        info19 = findViewById(R.id.info3);
        info20 = findViewById(R.id.info4);
        info21 = findViewById(R.id.info5);
        info22 = findViewById(R.id.info6);
        info23 = findViewById(R.id.info7);



        predict = findViewById(R.id.predict);
        result = findViewById(R.id.result);
        tips = findViewById(R.id.tips);

//        Test Data to be needed to predict the Lung cancer
//        "Age": "39",
//    "Gender": "2",
//    "Air Pollution": "1",
//    "Alcohol use": "1",
//    "Dust Allergy": "1",
//    "OccuPational Hazards": "1",
//    "Genetic Risk": "1",
//    "chronic Lung Disease": "1",
//    "Balanced Diet": "10",
//    "Obesity": "1",
//    "Smoking": "2",
//    "Passive Smoker": "1",
//    "Chest Pain": "1",
//    "Coughing of Blood": "1",
//    "Fatigue": "2",
//    "Weight Loss": "2",
//    "Shortness of Breath": "4",
//    "Wheezing": "1",
//    "Swallowing Difficulty": "4",
//    "Clubbing of Finger Nails": "2",
//    "Frequent Cold": "2",
//    "Dry Cough": "2",
//    "Snoring": "3"

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed1.getText().toString().isEmpty() || Integer.parseInt( ed1.getText().toString()) > 100 || Integer.parseInt(ed2.getText().toString()) < 0){
                    ed1.setError("Should be in 0-10 range");
                }else if (ed2.getText().toString().isEmpty() || Integer.parseInt(ed2.getText().toString()) > 2 ||Integer.parseInt(ed2.getText().toString()) < 0){
                    ed2.setError("Cannot be Empty");
                }else if (ed3.getText().toString().isEmpty() || Integer.parseInt(ed3.getText().toString()) > 10 ||Integer.parseInt(ed2.getText().toString()) < 0){
                    ed3.setError("Should be in 0-10 range");
                }else if (ed4.getText().toString().isEmpty() || Integer.parseInt(ed4.getText().toString()) > 10 ||Integer.parseInt(ed4.getText().toString()) < 0){
                    ed4.setError("Should be in 0-10 range");
                }else if (ed5.getText().toString().isEmpty() || Integer.parseInt( ed5.getText().toString()) > 10 || Integer.parseInt(ed5.getText().toString()) < 0){ed5.setError("Should be in 0-10 range");}
                else if (ed6.getText().toString().isEmpty() || Integer.parseInt( ed6.getText().toString()) > 10 || Integer.parseInt(ed6.getText().toString()) < 0){ed6.setError("Should be in 0-10 range");}
                else if (ed7.getText().toString().isEmpty() || Integer.parseInt( ed7.getText().toString()) > 10 || Integer.parseInt(ed7.getText().toString()) < 0){ed7.setError("Should be in 0-10 range");}
                else if (ed8.getText().toString().isEmpty() || Integer.parseInt( ed8.getText().toString()) > 10 || Integer.parseInt(ed8.getText().toString()) < 0){ed8.setError("Should be in 0-10 range");}
                else if (ed9.getText().toString().isEmpty() || Integer.parseInt( ed9.getText().toString()) > 10 || Integer.parseInt(ed9.getText().toString()) < 0){ed9.setError("Should be in 0-10 range");}
                else if (ed10.getText().toString().isEmpty() || Integer.parseInt( ed10.getText().toString()) > 10 || Integer.parseInt(ed10.getText().toString()) < 0){ed10.setError("Should be in 0-10 range");}
                else if (ed11.getText().toString().isEmpty() || Integer.parseInt( ed11.getText().toString()) > 10 || Integer.parseInt(ed11.getText().toString()) < 0){ed11.setError("Should be in 0-10 range");}
                else if (ed12.getText().toString().isEmpty() || Integer.parseInt( ed12.getText().toString()) > 10 || Integer.parseInt(ed12.getText().toString()) < 0){ed12.setError("Should be in 0-10 range");}
                else if (ed13.getText().toString().isEmpty() || Integer.parseInt( ed13.getText().toString()) > 10 || Integer.parseInt(ed13.getText().toString()) < 0){ed13.setError("Should be in 0-10 range");}
                else if (ed14.getText().toString().isEmpty() || Integer.parseInt( ed14.getText().toString()) > 10 || Integer.parseInt(ed14.getText().toString()) < 0){ed14.setError("Should be in 0-10 range");}
                else if (ed15.getText().toString().isEmpty() || Integer.parseInt( ed15.getText().toString()) > 10 || Integer.parseInt(ed15.getText().toString()) < 0){ed15.setError("Should be in 0-10 range");}
                else if (ed16.getText().toString().isEmpty() || Integer.parseInt( ed16.getText().toString()) > 10 || Integer.parseInt(ed16.getText().toString()) < 0){ed16.setError("Should be in 0-10 range");}
                else if (ed17.getText().toString().isEmpty() || Integer.parseInt( ed17.getText().toString()) > 10 || Integer.parseInt(ed17.getText().toString()) < 0){ed17.setError("Should be in 0-10 range");}
                else if (ed18.getText().toString().isEmpty() || Integer.parseInt( ed18.getText().toString()) > 10 || Integer.parseInt(ed18.getText().toString()) < 0){ed18.setError("Should be in 0-10 range");}
                else if (ed19.getText().toString().isEmpty() || Integer.parseInt( ed19.getText().toString()) > 10 || Integer.parseInt(ed19.getText().toString()) < 0){ed19.setError("Should be in 0-10 range");}
                else if (ed20.getText().toString().isEmpty() || Integer.parseInt( ed20.getText().toString()) > 10 || Integer.parseInt(ed20.getText().toString()) < 0){ed20.setError("Should be in 0-10 range");}
                else if (ed21.getText().toString().isEmpty() || Integer.parseInt( ed21.getText().toString()) > 10 || Integer.parseInt(ed21.getText().toString()) < 0){ed21.setError("Should be in 0-10 range");}
                else if (ed22.getText().toString().isEmpty() || Integer.parseInt( ed22.getText().toString()) > 10 || Integer.parseInt(ed22.getText().toString()) < 0){ed22.setError("Should be in 0-10 range");}
                else if (ed23.getText().toString().isEmpty() || Integer.parseInt( ed23.getText().toString()) > 10 || Integer.parseInt(ed23.getText().toString()) < 0){ed23.setError("Should be in 0-10 range");}
                else {
                    //API -> Volley

                    try {
                        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                        JSONObject jsonBody = new JSONObject();
                        jsonBody.put("Age",ed1.getText().toString());
                        jsonBody.put("Gender",ed2.getText().toString());
                        jsonBody.put("Air Pollution",ed3.getText().toString());
                        jsonBody.put("Alcohol use",ed4.getText().toString());
                        jsonBody.put("Dust Allergy",ed5.getText().toString());
                        jsonBody.put("OccuPational Hazards",ed6.getText().toString());
                        jsonBody.put("Genetic Risk",ed7.getText().toString());
                        jsonBody.put("chronic Lung Disease",ed8.getText().toString());
                        jsonBody.put("Balanced Diet",ed9.getText().toString());
                        jsonBody.put("Obesity",ed10.getText().toString());
                        jsonBody.put("Smoking",ed11.getText().toString());
                        jsonBody.put("Passive Smoker",ed12.getText().toString());
                        jsonBody.put("Chest Pain",ed13.getText().toString());
                        jsonBody.put("Coughing of Blood",ed14.getText().toString());
                        jsonBody.put("Fatigue",ed15.getText().toString());
                        jsonBody.put("Weight Loss",ed16.getText().toString());
                        jsonBody.put("Shortness of Breath",ed17.getText().toString());
                        jsonBody.put("Wheezing",ed18.getText().toString());
                        jsonBody.put("Swallowing Difficulty",ed19.getText().toString());
                        jsonBody.put("Clubbing of Finger Nails",ed20.getText().toString());
                        jsonBody.put("Frequent Cold",ed21.getText().toString());
                        jsonBody.put("Dry Cough",ed22.getText().toString());
                        jsonBody.put("Snoring",ed23.getText().toString());

                        JsonObjectRequest request_json = new JsonObjectRequest(url, jsonBody,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            builder = new AlertDialog.Builder(MainActivity.this);
                                            int resultVal = Integer.parseInt(response.getString("Predicted result"));
                                            Log.e("Volley: ", String.valueOf(resultVal));

                                            if (resultVal ==0){
                                                result.setText("You are Diagnosed with Lung Cancer!");
                                                result.setTextColor(Color.parseColor("#FF0000"));
                                                builder.setMessage("You are Diagnosed with Lung Cancer!").setTitle("Result");

                                            }else{
                                                result.setText("Congratulations, Your Lungs are Healthy");
                                                result.setTextColor(Color.parseColor("#FFFFFF"));
                                                builder.setMessage("Congratulations, Your Lungs are Healthy").setTitle("Result");

                                            }



                                            //Setting message manually and performing action on button click
                                            builder.setMessage("Click close to Test with new Data")
                                                    .setCancelable(false)
                                                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            ed1.setText("");
                                                            ed2.setText("");
                                                            ed3.setText("");
                                                            ed4.setText("");
                                                            ed5.setText("");
                                                            ed6.setText("");
                                                            ed7.setText("");
                                                            ed8.setText("");
                                                            ed9.setText("");
                                                            ed10.setText("");
                                                            ed11.setText("");
                                                            ed12.setText("");
                                                            ed13.setText("");
                                                            ed14.setText("");
                                                            ed15.setText("");
                                                            ed16.setText("");
                                                            ed17.setText("");
                                                            ed18.setText("");
                                                            ed19.setText("");
                                                            ed20.setText("");
                                                            ed21.setText("");
                                                            ed22.setText("");
                                                            ed23.setText("");
                                                            dialog.cancel();
                                                        }
                                                    })
                                                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            //  Action for 'NO' Button
                                                            dialog.cancel();
                                                            Toast.makeText(MainActivity.this,"Exiting App!",
                                                                    Toast.LENGTH_SHORT).show();
                                                            finish();
                                                        }
                                                    });
                                            //Creating dialog box
                                            AlertDialog alert = builder.create();
                                            //Setting the title manually
                                            alert.setTitle("Predicted  Result");
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    alert.show();

                                                }
                                            });

                                } catch (JSONException e) {
                                            throw new RuntimeException(e);
                                        }

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.e("Error: ", error.getMessage());
                            }
                        });


                        requestQueue.add(request_json);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                            new Response.Listener<String>() {
//                                @SuppressLint("WrongConstant")
//                                @Override
//                                public void onResponse(String response) {
//
//                                    try {
//                                        JSONObject jsonObject = new JSONObject(response);
//                                        String data = jsonObject.getString("Predicted result");
//                                        tips.setVisibility(1);
//
//                                        result.setTextColor(Color.parseColor("#5bdeac"));
//                                        result.setText(data);
//
//                                        ed1.setText("");
//                                        ed2.setText("");
//                                        ed3.setText("");
//                                        ed4.setText("");
//                                        ed5.setText("");
//                                        ed6.setText("");
//                                        ed7.setText("");
//                                        ed8.setText("");
//                                        ed9.setText("");
//                                        ed10.setText("");
//                                        ed11.setText("");
//                                        ed12.setText("");
//                                        ed13.setText("");
//                                        ed14.setText("");
//                                        ed15.setText("");
//                                        ed16.setText("");
//                                        ed17.setText("");
//                                        ed18.setText("");
//                                        ed19.setText("");
//                                        ed20.setText("");
//                                        ed21.setText("");
//                                        ed22.setText("");
//                                        ed23.setText("");
//
//
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            String err = (error.getMessage()==null)?"Failed! Please Try Again":error.getMessage();
//                            Toast.makeText(MainActivity.this,err,Toast.LENGTH_SHORT).show();
//                            Log.d("API ERROR : ", err);
//                        }
//                    }){
//                        @Override
//                        protected Map<String,String> getParams(){
//
//                            Map<String,String> params = new HashMap<String, String>();
//                            params.put("Age",ed1.getText().toString());
//                            params.put("Gender",ed2.getText().toString());
//                            params.put("Air Pollution",ed3.getText().toString());
//                            params.put("Alcohol use",ed4.getText().toString());
//                            params.put("Dust Allergy",ed5.getText().toString());
//                            params.put("OccuPational Hazards",ed6.getText().toString());
//                            params.put("Genetic Risk",ed7.getText().toString());
//                            params.put("chronic Lung Disease",ed8.getText().toString());
//                            params.put("Balanced Diet",ed9.getText().toString());
//                            params.put("Obesity",ed10.getText().toString());
//                            params.put("Smoking",ed11.getText().toString());
//                            params.put("Passive Smoker",ed12.getText().toString());
//                            params.put("Chest Pain",ed13.getText().toString());
//                            params.put("Coughing of Blood",ed14.getText().toString());
//                            params.put("Fatigue",ed15.getText().toString());
//                            params.put("Weight Loss",ed16.getText().toString());
//                            params.put("Shortness of Breath",ed17.getText().toString());
//                            params.put("Wheezing",ed18.getText().toString());
//                            params.put("Swallowing Difficulty",ed19.getText().toString());
//                            params.put("Clubbing of Finger Nails",ed20.getText().toString());
//                            params.put("Frequent Cold",ed21.getText().toString());
//                            params.put("Dry Cough",ed22.getText().toString());
//                            params.put("Snoring",ed23.getText().toString());
//
//                            return params;
//                        }
//                    };
//
//                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                    queue.add(stringRequest);
                }
            }
        });

        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It should display the type of chest-pain experienced by the individual using the following format :\n" +
                        "0 = typical angina\n" +
                        "1 = atypical angina\n" +
                        "2 = non — anginal pain\n" +
                        "3 = asymptotic";
                infoDialog("Chest-pain type:",info);
            }
        });

        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It should display the max heart rate achieved by an individual.";
                infoDialog("Max heart rate:",info);
            }
        });

        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "Peak exercise ST segment :\n" +
                        "0 = upsloping\n" +
                        "1 = flat\n" +
                        "2 = downsloping";
                infoDialog("Exercise ST:",info);
            }
        });

        info4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It should display resting electrocardiographic results\n" +
                        "0 = normal\n" +
                        "1 = having ST-T wave abnormality\n" +
                        "2 = left ventricular hyperthrophy";
                infoDialog("Resting ECG:",info);
            }
        });

        info5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It should display the serum cholesterol in mg/dl (unit)";
                infoDialog("Cholestrol:",info);
            }
        });

        info6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It should display the resting blood pressure value of an individual in mmHg (unit)";
                infoDialog("Resting Blood Pressure:",info);
            }
        });

        info7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "It compares the fasting blood sugar value of an individual with 120mg/dl.\n" +
                        "If fasting blood sugar > 120mg/dl then : 1 (true)\n" +
                        "else : 0 (false)";
                infoDialog("Fasting Blood Sugar:",info);
            }
        });

        info8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "ST depression induced by exercise relative to rest, should display the value which is an integer or float. Write zero (0) if nothing.";
                infoDialog("ST depression:",info);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InfoActivity.class));
                finish();
            }
        });
    }

    private void infoDialog(String i, String string) {

        Dialog dialog;
        dialog = new Dialog(MainActivity.this);

        dialog.setContentView(R.layout.info_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView close = dialog.findViewById(R.id.closeDialog);
        TextView nameDialog = dialog.findViewById(R.id.nameDialog);
        TextView infoDialog = dialog.findViewById(R.id.infoDialog);

        nameDialog.setText(""+i);
        infoDialog.setText(string);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}