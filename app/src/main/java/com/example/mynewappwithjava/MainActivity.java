package com.example.mynewappwithjava;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout=new RelativeLayout(this);
        Button myButton=new Button(this);

        myLayout.setBackgroundColor(Color.BLUE);
        myButton.setBackgroundColor(Color.WHITE);
        myButton.setText("Click Here!");

        RelativeLayout.LayoutParams buttonDetails=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        myLayout.addView(myButton,buttonDetails);

        EditText username=new EditText(this);

        myButton.setId(1);
        username.setId(2);

        RelativeLayout.LayoutParams usernameDetails=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        usernameDetails.addRule(RelativeLayout.ABOVE,myButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        //this use for sizing in the DisplayMetrics
        Resources resources=getResources();
        int px= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,resources.getDisplayMetrics());
        username.setWidth(px);

        usernameDetails.setMargins(0,0,0,50);
        myLayout.addView(username,usernameDetails);

        setContentView(myLayout);
    }
}
