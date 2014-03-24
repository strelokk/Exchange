package com.exchange.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.exchange.R;
import com.exchange.dao.Bank;

import java.util.List;

/**
 * @author vlad.fargutu
 */
public class BanksAdapter extends ArrayAdapter<Bank> {

    private List<Bank> banks;
    private LayoutInflater inflater;

    public BanksAdapter(Context context, List<Bank> banks) {
        super(context, R.layout.banks_list_item, banks);
        this.banks = banks;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return banks != null ? banks.size() : 0;
    }

    @Override
    public Bank getItem(int position) {
        return banks != null && banks.size() > position ? banks.get(position) : null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder = null;

        if (rowView == null) {
            rowView = inflater.inflate(R.layout.banks_list_item, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.bank_name);
            holder.resultValue = (TextView) rowView.findViewById(R.id.exchange_result_value);
            holder.distance = (TextView) rowView.findViewById(R.id.bank_distance_to);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        Bank bank = getItem(position);
        assert bank != null;
        holder.name.setText(bank.getName());
        holder.resultValue.setText("100");
        holder.distance.setText("2.7km");

        return rowView;
    }

    // this class holds all elements in one bank row
    public class ViewHolder {
        public TextView name;
        public TextView resultValue;
        public TextView distance;
    }

}
