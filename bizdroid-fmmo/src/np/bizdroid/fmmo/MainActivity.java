package np.bizdroid.fmmo;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {
	SlidingPaneLayout mPane;
	private static View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		LayoutInflater inflator=LayoutInflater.from(this);
		view=inflator.inflate(R.layout.activity_main, null);
		setContentView(view);
		mPane = (SlidingPaneLayout) findViewById(R.id.pane);
		 
	    mPane.openPane();
	 
	    getSupportFragmentManager().beginTransaction()
	        .add(R.id.pane1, new RightPane(), "pane1").commit();
	    getSupportFragmentManager().beginTransaction()
	        .add(R.id.pane2, new PlaylistFragment(), "pane2").commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy();
	    if (view != null) {
	        ViewGroup parentViewGroup = (ViewGroup) view.getParent();
	        if (parentViewGroup != null) {
	            parentViewGroup.removeAllViewsInLayout();;
	        }
	    }
	}

}
