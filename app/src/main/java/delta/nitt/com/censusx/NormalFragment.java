package delta.nitt.com.censusx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NormalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NormalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NormalFragment extends Fragment
{
    public String type;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public NormalAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public NormalFragment()
    {
        // Required empty public constructor
    }

    public static NormalFragment newInstance(String type)
    {
        NormalFragment fragment = new NormalFragment();
        Bundle args = new Bundle();
        args.putString("type",type);
        fragment.setArguments(args);
        return fragment;
    }
    Item[] items = new Item[4];

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            this.type = getArguments().getString("type","default");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normal, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext());
            items[0] = new Item();items[1]=new Item();items[2]=new Item();items[3]=new Item();
        {
            items[0].setTitle("Name of the person");
            items[0].setDescp("Start with head of household");
        }
        {
            items[1].setTitle("Relationship to Head");
            items[1].setDescp("Write the relationship in full");
        }
        {
            items[2].setTitle("Sex");
            items[2].setArray1(new ArrayList<String>(Arrays.asList("Male","Female","Other")));
        }
        {
            items[3].setTitle("Date Of Birth And Age");
            items[3].setDescp("As per English Calender (DD-MM-YYYY)");
            items[3].setSubtext("");
        }
        Log.d(Utilities.getTAG(),items.toString());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NormalAdapter(getActivity(),new ArrayList<Item>(Arrays.asList(items)));
        recyclerView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        } else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
