package np.bizdroid.fmmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeftPane extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 
        View v = inflater.inflate(R.layout.nav, container, false);
 
        //v.setBackgroundColor(Color.BLUE);
//        TextView tv = (TextView)v.findViewById(R.id.textView);
//        tv.setText("Pane One");
        ListView list_cat = (ListView) v.findViewById(R.id.list_nav_cat);
        String[] values = new String[] { "A","B","C","D","E","F" };
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
          list.add(values[i]);
        }
        StableArrayAdapter adapter = new StableArrayAdapter(container.getContext(),
                android.R.layout.simple_list_item_single_choice, list);
        list_cat.setAdapter(adapter);
        return v;
    }
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }
}
