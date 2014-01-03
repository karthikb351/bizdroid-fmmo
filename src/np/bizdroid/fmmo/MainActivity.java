package np.bizdroid.fmmo;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;

public class MainActivity extends Activity {
	SlidingPaneLayout mPane;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPane = (SlidingPaneLayout) findViewById(R.id.pane);
		 
	    mPane.openPane();
	 
	    getFragmentManager().beginTransaction()
	        .add(R.id.pane1, new LeftPane(), "pane1").commit();
	    getFragmentManager().beginTransaction()
	        .add(R.id.pane2, new RightPane(), "pane2").commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
