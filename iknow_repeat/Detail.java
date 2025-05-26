package com.example.iknow_repeat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int number = getIntent().getIntExtra("number",+1);

        String url = "https://raw.githubusercontent.com/ahmaddabeer/iknow_json/refs/heads/main/" + number + "";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null,response -> {

            try {

                JSONObject data = response.getJSONObject("data");

                String lname = data.getString("language");
                String devName = data.getString("developed_by");
                String img_url = data.getString("image_url");
                String redate = data.getString("first_release_year");
                String oName = data.getString("original_name");
                String ab = data.getString("about");
                String maintext = data.getString("text");




                TextView text = findViewById(R.id.current_name);
                TextView dName = findViewById(R.id.developer);
                TextView rDate = findViewById(R.id.relese_date);
                TextView orname = findViewById(R.id.old_name);
                TextView about = findViewById(R.id.About);
                TextView mText = findViewById(R.id.text_example);


                CircleImageView devImage = findViewById(R.id.dev_img);

                Glide.with(this).load(img_url).into(devImage);

                text.setText("Current Name : "+lname);
                dName.setText("Develop by : "+devName);
                rDate.setText("Relese Date : "+redate);
                orname.setText("Old Name : "+oName);
                about.setText(ab);

                mText.setText(maintext);






            }catch (JSONException e){

                e.printStackTrace();
                Toast.makeText(this, "Parsing error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }, error -> {

            error.printStackTrace();
            Toast.makeText(this, "Network Error : "+error.getMessage(), Toast.LENGTH_SHORT).show();
        });
        Volley.newRequestQueue(this).add(request);




    }


}