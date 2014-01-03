package np.bizdroid.fmmo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class RightPane extends Fragment {

	 	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	 
	        View v = inflater.inflate(R.layout.nav_right, container, false);
	        
	       // v.setBackgroundColor(Color.RED);
	        TextView tv = (TextView)v.findViewById(R.id.textView);
	        tv.setText("Pane Two");
	        YouTubePlayerSupportFragment youTubePlayerFragment =
	                (YouTubePlayerSupportFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
	            youTubePlayerFragment.initialize("AIzaSyAhW_r5PCfTdvlffumvR0DY3L2htNhbpjo", new listener());
	      
	            
	        return v;
	    }
	 	private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	 		Fragment[] fragments = {new Fragment1(),new Fragment2()};
            public MyFragmentPagerAdapter(FragmentManager fm) {
                 super(fm);
            }  

            public Fragment getItem(int index) { 

                 return fragments[index];
            }  

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
