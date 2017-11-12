package edu.brandeis.cs.sigalsax.expense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ExpenseTrackerAdapter extends BaseAdapter{
    ArrayList<ExpenseLogEntryData> expenseLog;
    Context context;
    static LayoutInflater inflater= null;
    int icons[];

    String number[];

    public ExpenseTrackerAdapter(Context context, int icons[], String number[]){
//        ArrayList<ExpenseLogEntryData> expenseLog
        expenseLog = new ArrayList<ExpenseLogEntryData>();
        this.context=context;
        this.icons=icons;
        this.number=number;

    }
    @Override
    public int getCount() {
        return expenseLog.size();
    }

    @Override
    public Object getItem(int i) {
        return expenseLog.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row= view;
        if (row==null) {
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.expense_entry, null);
        }
        ImageView img= (ImageView)row.findViewById(R.id.imageView3);
        TextView tv= (TextView)row.findViewById(R.id.textView2);
        img.setImageResource(icons[i]);
        tv.setText(number[i]);
        return row;
    }
}