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
 * {@link MarriageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MarriageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarriageFragment extends Fragment
{
    public String type;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public MarriageAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public MarriageFragment()
    {
        // Required empty public constructor
    }

    public static MarriageFragment newInstance(String type)
    {
        MarriageFragment fragment = new MarriageFragment();
        Bundle args = new Bundle();
        args.putString("type",type);
        fragment.setArguments(args);
        return fragment;
    }
    Item[] items = new Item[5];

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
        items[0] = new Item();items[1]=new Item();items[2]=new Item();items[3]=new Item();items[4]=new Item();
        {
            items[0].setTitle("Current Marital Status");
            items[0].setArray1(new ArrayList<String>(Arrays.asList("Never Married","Currently Married","Widowed","Separated","Divorced")));
            items[0].setDescp("As described above");
        }
        {
            items[1].setTitle("Age at Marriage");
            items[1].setDescp("Not Applicable for never married");
            items[1].setText("aas");
        }
        {
            items[2].setTitle("Religion");
            items[2].setArray1(new ArrayList<String>(Arrays.asList("Hindu","Muslim","Christian","Sikh","Buddhist","Jain")));
            items[2].setDescp("Specify Religion even if you are atheist");
        }
        {
            items[3].setTitle("Scheduled Caste (SC) / Scheduled Tribe (ST)");
            items[3].setArray1(new ArrayList<String>(Arrays.asList("FC","SC","ST")));
            items[3].setDescp("Is the Person SC/ST");
        }
        {
            items[4].setTitle("Disability");
            items[4].setArray1(new ArrayList<String>(Arrays.asList("No Disability","In Seeing","In Hearing","In Speech","In movement","Mentally Retarded","Mental Illness","Any Other")));
            items[4].setDescp("Is the person Mentally/Physically disabled\nIn case of multiple illnesses specify maximum of 3");
        }
        Log.d(Utilities.getTAG(),items.toString());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MarriageAdapter(getActivity(),new ArrayList<Item>(Arrays.asList(items)));
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
