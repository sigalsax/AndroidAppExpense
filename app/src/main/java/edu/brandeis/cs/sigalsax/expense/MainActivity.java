package edu.brandeis.cs.sigalsax.expense;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    int icon [] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four, R.drawable.five};
    String numbers[] ={"ONE", "TWO", "THREE", "FOUR", "FIVE"};
    static final String EXTRA_ARRAY = "com.package.app.STRARRAY";
    ArrayList<ExpenseLogEntryData> expenseLog;
    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;
    ArrayAdapter <ExpenseLogEntryData> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);
        Intent intent= getIntent();

        expenseLog= new ArrayList<ExpenseLogEntryData>();
        expenseLog.add(new ExpenseLogEntryData("Dress\n", "Dress from H&M"));
        expenseLog.add(new ExpenseLogEntryData("Shoes\n", "Shoes from DSW"));
        expenseLog.add(new ExpenseLogEntryData("Pants\n", "Pants from Macy's"));
        adapter= new ArrayAdapter<ExpenseLogEntryData>(this, android.R.layout.simple_list_item_1, expenseLog);
        // assign adapter to listview
        listView.setAdapter(adapter);
        //when click on item then onItemClick Listener is called
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // listview clicked item index
                int itemPosition=position;
                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);
            }
        });
        String message = intent.getStringExtra(String.valueOf(expense_add.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
              //  startActivityForResult(new Intent(this, expense_add.class));
                Intent i= new Intent(this, expense_add.class);
                startActivityForResult(i,1);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // get String data from Intent
                String returnExpense = data.getStringExtra("expense");
                String returnNote= data.getStringExtra("notes");
                expenseLog.add(new ExpenseLogEntryData(returnExpense+"\n", returnNote));
                adapter.notifyDataSetChanged();

            }
        }
    }
}
