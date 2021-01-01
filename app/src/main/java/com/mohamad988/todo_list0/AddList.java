package com.mohamad988.todo_list0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mohamad988.todo_list0.classes.ListClass;

import static com.mohamad988.todo_list0.Lists.books;

public class AddList extends AppCompatActivity {
    String listName;

    EditText name1;
    static ListClass mListClass=new ListClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        name1=findViewById(R.id.edit_text_name_of_list );
    }

    public void OnClickCancle(View view) {
        Intent intent=new Intent(AddList.this,Lists.class);
        startActivity(intent);
        finish();
    }

    public void onClickSave(View view) {
        listName=name1.getText().toString();
        mListClass=new ListClass(ListClass.generateCategoryID(),listName );
        Lists.writeNotebook(mListClass);
        books.add(mListClass);
        Toast.makeText(this, "Notebook is added successfully", Toast.LENGTH_SHORT).show();
        getIntent().putExtra("CategoryName",listName);
        startActivity(new Intent(AddList.this,Lists.class));
        finish();
    }
}