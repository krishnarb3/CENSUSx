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
public class OtherFragment extends Fragment
{
    public String type;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public NormalAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public OtherFragment()
    {
        // Required empty public constructor
    }

    public static OtherFragment newInstance(String type)
    {
        OtherFragment fragment = new OtherFragment();
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
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext());
        items[0] = new Item();items[1]=new Item();items[2]=new Item();items[3]=new Item();
        {
            items[0].setTitle("Mother Tongue");
            items[0].setDescp("Write name of Mother Tongue in Full");
        }
        {
            items[1].setTitle("Literacy Status");
            items[1].setArray1(new ArrayList<String>(Arrays.asList("Literate","Illiterate")));
            items[1].setDescp("Literate or Illiterate");
        }
        {
            items[2].setTitle("Education Level");
            items[2].setDescp("Write the full Description\nFor diploma or degree holder also write subject of specialization");
        }
        {
            items[3].setTitle("Occupation");
            items[3].setArray1(new ArrayList<String>(Arrays.asList("Cultivator","Agricultural Labourer","Household Worker","Other worker")));
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
