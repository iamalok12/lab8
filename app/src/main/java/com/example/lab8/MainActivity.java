package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnten,btneleven,btntwelve;
    Button btncall,btnsave,btndel;
    EditText dialno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnone=(Button)findViewById(R.id.btn_one);
        btnone.setOnClickListener(this);

        btntwo=(Button)findViewById(R.id.btn_two);
        btntwo.setOnClickListener(this);

        btnthree=(Button)findViewById(R.id.btn_three);
        btnthree.setOnClickListener(this);

        btnfour=(Button)findViewById(R.id.btn_four);
        btnfour.setOnClickListener(this);

        btnfive=(Button)findViewById(R.id.btn_five);
        btnfive.setOnClickListener(this);

        btnsix=(Button)findViewById(R.id.btn_six);
        btnsix.setOnClickListener(this);

        btnseven=(Button)findViewById(R.id.btn_seven);
        btnseven.setOnClickListener(this);

        btneight=(Button)findViewById(R.id.btn_eight);
        btneight.setOnClickListener(this);

        btnnine=(Button)findViewById(R.id.btn_nine);
        btnnine.setOnClickListener(this);

        btnten=(Button)findViewById(R.id.btn_zero);
        btnten.setOnClickListener(this);

        btneleven=(Button)findViewById(R.id.btn_star);
        btneleven.setOnClickListener(this);

        btntwelve=(Button)findViewById(R.id.btn_hash);
        btntwelve.setOnClickListener(this);

        btndel=(Button)findViewById(R.id.btn_delete);
        btndel.setOnClickListener(this);

        btncall=(Button)findViewById(R.id.btn_call);
        btncall.setOnClickListener(this);

        btnsave=(Button)findViewById(R.id.btn_save);
        btnsave.setOnClickListener(this);

        dialno=(EditText)findViewById(R.id.txt_phonenumber);
        dialno.setText("");//To create empty text box & set text-remove old put new
    }
    public void onClick(View v)
    {
        if(v.equals(btnone))
        {
            dialno.append("1");//append means it adds one at the end
        }
        else if(v.equals(btntwo))
        {
            dialno.append("2");
        }
        else if(v.equals(btnthree))
        {
            dialno.append("3");
        }
        else if(v.equals(btnfour))
        {
            dialno.append("4");
        }
        else if(v.equals(btnfive))
        {
            dialno.append("5");
        }
        else if(v.equals(btnsix))
        {
            dialno.append("6");
        }
        else if(v.equals(btnseven))
        {
            dialno.append("7");
        }
        else if(v.equals(btneight))
        {
            dialno.append("8");
        }
        else if(v.equals(btnnine))
        {
            dialno.append("9");
        }
        else if(v.equals(btnten))
        {
            dialno.append("0");
        }
        else if(v.equals(btneleven))
        {
            dialno.append("*");
        }
        else if(v.equals(btntwelve))
        {
            dialno.append("#");
        }
        else if(v.equals(btncall))
        {
            String data=dialno.getText().toString();
            Intent it=new Intent(Intent.ACTION_DIAL);
            it.setData(Uri.parse("tel:"+data));
            startActivity(it);
        }
        else if(v.equals(btnsave))
        {
            Intent contactIntent= new Intent (ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType (ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent .putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, dialno.getText().toString());
            startActivity(contactIntent);
        }
        else if(v.equals(btndel))
        {
            String data=dialno.getText().toString();
            if(data.length()>0)
            {
                dialno.setText(data.substring(0,data.length()-1));
            }
        }
    }
}