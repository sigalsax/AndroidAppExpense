package edu.brandeis.cs.sigalsax.expense;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class expense_add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_add);
        // communicate back to main activity, passing in once saved
        final Intent intent = new Intent(this, MainActivity.class);

        Button cancelButton = (Button) findViewById(R.id.button2);
        Button saveButton = (Button) findViewById(R.id.button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            boolean clicked = false;

            @Override
            public void onClick(View view) {
                clicked = true;
                if (view.getId() == R.id.button2) {
                    finish();
//                    setContentView(R.layout.activity_main);
                }
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            boolean clicked = false;
            @Override
            public void onClick(View view) {
                clicked = true;
                if (view.getId() == R.id.button) {
                    EditText expense = (EditText) findViewById(R.id.editText);
                    EditText notes = (EditText) findViewById(R.id.editText2);
                    Intent resultIntent = new Intent ();
                    resultIntent.putExtra("expense", expense.getText().toString());
                    resultIntent.putExtra("notes", notes.getText().toString());
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }

}


