package np.bizdroid.fmmo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

public class RightPane extends Fragment {

	private static View v;
	 	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	
	 		try {

		        v = inflater.inflate(R.layout.nav_right, container, false);
		        // v.setBackgroundColor(Color.RED);
		        TextView tv = (TextView)v.findViewById(R.id.textView);
		        tv.setText("Pane Two");
		        YouTubePlayerSupportFragment youTubePlayerFragment =
		                (YouTubePlayerSupportFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
		            youTubePlayerFragment.initialize("AIzaSyAhW_r5PCfTdvlffumvR0DY3L2htNhbpjo", new listener());
		      
		          ViewPager pager = (ViewPager)v.findViewById(R.id.pager);
		    	pager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));
		    	TabPageIndicator titleIndicator = (TabPageIndicator)v.findViewById(R.id.indicator);
				titleIndicator.setViewPager(pager);
	 	    } catch (InflateException e) {
	 	        /* map is already there, just return view as it is */
	 	    }
	        
	        return v;
	    }
	 	private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	 		Fragment[] fragments = {new Fragment1(),new Fragment2()};
	 		CharSequence[] title = {"Pulse","Comments"};
            public MyFragmentPagerAdapter(FragmentManager fm) {
               
            	super(fm);
            }  
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
            @Override
            public Fragment getItem(int index) { 

                 return fragments[index];
            }  
            
            @Override
            public int getCount() {

                 return 2;
            }
       }
	 	class listener implements OnInitializedListener
	 	{

			@Override
			public void onInitializationFailure(Provider arg0,
					YouTubeInitializationResult arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onInitializationSuccess(Provider arg0,
					YouTubePlayer player, boolean wasRestored) {
				// TODO Auto-generated method stub
				if (!wasRestored) {
				      player.cueVideo("wKJ9KzGQq0w");
				    }
			}
			
			
	 		
	 	}
}
