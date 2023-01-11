package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.course);
        ed3 = findViewById(R.id.fee);
        ed4 = findViewById(R.id.id);

        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);
        b4 = findViewById(R.id.bt4);


        Intent i = getIntent();

        String t1 = i.getStringExtra("id").toString();
        String t2 = i.getStringExtra("name").toString();
        String t3 = i.getStringExtra("course").toString();
        String t4 = i.getStringExtra("fee").toString();

        ed4.setText(t1);
        ed1.setText(t2);
        ed2.setText(t3);
        ed3.setText(t4);


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),view.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempname=ed1.getText().toString();
                String tempcourse=ed2.getText().toString();
                String tempfee=ed3.getText().toString();
                String tempid = ed4.getText().toString();
                Student s=new Student();
                s.setName(tempname);
                s.setCourse(tempcourse);
                s.setFee(tempfee);
                s.setId(tempid);
                Delete(s);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempname=ed1.getText().toString();
                String tempcourse=ed2.getText().toString();
                String tempfee=ed3.getText().toString();
                String tempid = ed4.getText().toString();
                Student s=new Student();
                s.setName(tempname);
                s.setCourse(tempcourse);
                s.setFee(tempfee);
                s.setId(tempid);
                search(s);
                Intent i1 = new Intent(edit.this,Search.class);
                i1.putExtra("id",tempid);
                startActivity(i1);

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempname=ed1.getText().toString();
                String tempcourse=ed2.getText().toString();
                String tempfee=ed3.getText().toString();
                String tempid = ed4.getText().toString();
                Student s=new Student();
                s.setName(tempname);
                s.setCourse(tempcourse);
                s.setFee(tempfee);
                s.setId(tempid);
                Edit(s);
            }
        });

    }
    public void search(Student s)
    {
        try
        {
            String id=s.getId();

            SQLiteDatabase db = openOrCreateDatabase("SlitDb", Context.MODE_PRIVATE,null);


            String sql = "select * from records where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Search sucessful",Toast.LENGTH_LONG).show();


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();


        } catch (Exception e) {
            Toast.makeText(this,"Sraech unsucessful",Toast.LENGTH_LONG).show();
        }
    }

    public void Delete(Student s)
    {
        try
        {
            String id = s.getId();

            SQLiteDatabase db = openOrCreateDatabase("SlitDb", Context.MODE_PRIVATE,null);


            String sql = "delete from records where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Record Deleted",Toast.LENGTH_LONG).show();


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();


        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
    public void Edit(Student s)
    {
        try
        {
            String name = s.getName();
            String course = s.getCourse();
            String fee = s.getFee();
            String id = s.getId();

            SQLiteDatabase db = openOrCreateDatabase("SlitDb",Context.MODE_PRIVATE,null);


            String sql = "update records set name = ?,course=?,fee=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindString(2,course);
            statement.bindString(3,fee);
            statement.bindString(4,id);
            statement.execute();
            Toast.makeText(this,"Record Updateddd",Toast.LENGTH_LONG).show();


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();


        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
}