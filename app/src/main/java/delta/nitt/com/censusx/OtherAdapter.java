package delta.nitt.com.censusx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rb on 12/12/15.
 */
public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder>
{
    Context context;
    ArrayList<Item> items;
    public OtherAdapter(Context context,ArrayList<Item> items)
    {
        this.context = context;
        this.items = items;
        Log.d(Utilities.getTAG(),"items.toString : "+items.toString());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textViewTitle;
        EditText editText;
        Spinner spinner1;
        TextView textViewDetails;
        CheckBox checkBox;

        public ViewHolder(View V)
        {
            super(V);
            textViewTitle = (TextView)V.findViewById(R.id.title);
            textViewDetails = (TextView)V.findViewById(R.id.details);
            editText = (EditText)V.findViewById(R.id.entry);
            spinner1 = (Spinner)V.findViewById(R.id.dropdown1);
            checkBox = (CheckBox)V.findViewById(R.id.checkbox);
        }
        @Override
        public void onClick(View v)
        {

        }
    }

    @Override
    public OtherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_other,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OtherAdapter.ViewHolder holder, int position)
    {
        holder.textViewTitle.setText(items.get(position).title);
        holder.textViewDetails.setText(items.get(position).descp);
        holder.spinner1.setEnabled(false);
        holder.checkBox.setEnabled(false);
        if(items.get(position).getArray1()!=null)
        {
            if(items.get(position).getArray1().size()!=2)
            {
                holder.spinner1.setEnabled(true);
                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items.get(position).array1);
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                holder.spinner1.setAdapter(arrayAdapter1);
                holder.spinner1.setVisibility(View.VISIBLE);
                holder.editText.setHeight(0);
            }
            else
            {
                holder.checkBox.setEnabled(true);
                holder.checkBox.setText("Literate");
                holder.checkBox.setVisibility(View.VISIBLE);
                holder.editText.setHeight(0);
            }
        }
        if(items.get(position).getText()!=null)
        {
            Log.d(Utilities.getTAG(),items.get(position).getText());
            holder.editText.setHeight(100);
            holder.editText.setHint("Enter here...");
        }

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

}
