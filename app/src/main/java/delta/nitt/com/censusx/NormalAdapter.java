package delta.nitt.com.censusx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rb on 12/12/15.
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.ViewHolder>
{
    Context context;
    ArrayList<Item> items;
    public NormalAdapter(Context context,ArrayList<Item> items)
    {
        this.context = context;
        this.items = items;
        Log.d(Utilities.getTAG(),"items.toString : "+items.toString());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textViewTitle;
        EditText editText;
        EditText subEntry;
        Spinner spinner1,spinner2;
        TextView textViewDetails;

        public ViewHolder(View V)
        {
            super(V);
            textViewTitle = (TextView)V.findViewById(R.id.title);
            textViewDetails = (TextView)V.findViewById(R.id.details);
            editText = (EditText)V.findViewById(R.id.entry);
            spinner1 = (Spinner)V.findViewById(R.id.dropdown1);
            spinner2 = (Spinner)V.findViewById(R.id.dropdown2);
            subEntry = (EditText)V.findViewById(R.id.subentry);
        }
        @Override
        public void onClick(View v)
        {

        }
    }

    @Override
    public NormalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_biorelation,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NormalAdapter.ViewHolder holder, int position)
    {
        holder.textViewTitle.setText(items.get(position).title);
        holder.textViewDetails.setText(items.get(position).descp);
        holder.spinner1.setEnabled(false);
        holder.spinner1.setEnabled(false);
        holder.subEntry.setHeight(0);
        if(items.get(position).getArray1()!=null)
        {
            holder.spinner1.setEnabled(true);
            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items.get(position).array1);
            arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.spinner1.setAdapter(arrayAdapter1);
            holder.spinner1.setVisibility(View.VISIBLE);
        }
        if(items.get(position).getArray2()!=null)
        {
            holder.spinner2.setEnabled(true);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items.get(position).array2);
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.spinner1.setAdapter(arrayAdapter2);
        }
        if(items.get(position).getSubtext()!=null)
        {
            holder.subEntry.setHeight(100);
            holder.subEntry.setHint("Enter Age ..");
        }
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

}
