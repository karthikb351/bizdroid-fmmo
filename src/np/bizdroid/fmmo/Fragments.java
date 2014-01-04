package np.bizdroid.fmmo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragments extends Fragment {
	
	public static final String KEY_POS = "_pos";
	public static final String KEY_LIST = "_list";
	
	public static Fragments newInstance(int pos, int list){
        Fragments obj = new Fragments();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POS, pos);
        bundle.putInt(KEY_LIST, list);
        obj.setArguments(bundle);
        return obj;
    }
	
	@Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int pos = getArguments().getInt(KEY_POS);
        int list = getArguments().getInt(KEY_LIST);
        //LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if(list == 1) {
        	view = layoutInflater.inflate(R.layout.home_fragment, viewGroup, false);
			ExpandableHeightListView latestList = (ExpandableHeightListView) view.findViewById(R.id.latest_list);
    		ExpandableHeightListView trendingList = (ExpandableHeightListView) view.findViewById(R.id.trending_list);
    		ExpandableHeightListView recommendedList = (ExpandableHeightListView) view.findViewById(R.id.recommended_list);
			String names[] = {"Video1", "Video2"};
			String views[] = {"10,000 views", "200 views"};
			Drawable images[] = {getResources().getDrawable(R.drawable.pic), getResources().getDrawable(R.drawable.pic)};
			CustomAdapter adapter = new CustomAdapter(names, views, images);
			latestList.setAdapter(adapter);
			trendingList.setAdapter(adapter);
			recommendedList.setAdapter(adapter);
			latestList.setExpanded(true);
			trendingList.setExpanded(true);
			recommendedList.setExpanded(true);
        }
        else if(list == 2) {
        	//TODO: Insert category fragment selection here
        } else {
        	//TODO: Insert feature fragment selection here
        }
        return view;
    }
	
    
    private class CustomAdapter extends BaseAdapter {

    	private String[] vidName;
    	private String[] vidViews;
    	private Drawable[] images;
    	
    	public CustomAdapter(String[] vidName, String[] vidViews, Drawable[] images) {
    		this.vidName = vidName;
    		this.vidViews = vidViews;
    		this.images = images;
    	}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return vidName.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return vidName[arg0];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(R.layout.card_layout, parent, false);
			TextView videoName = (TextView) convertView.findViewById(R.id.card_name_textview);
			TextView videoViews = (TextView) convertView.findViewById(R.id.card_views_textview);
			ImageView image = (ImageView) convertView.findViewById(R.id.card_imageview);
			videoName.setText(vidName[position]);
			videoViews.setText(vidViews[position]);
			image.setImageDrawable(images[position]);
			return convertView;
		}
    	
    }
	
}
