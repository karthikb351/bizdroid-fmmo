package np.bizdroid.fmmo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	public static View view;
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		try {

        view = inflater.inflate(R.layout.pulse, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText("Tab 1");
        
	 } catch (InflateException e) {
	        /* map is already there, just return view as it is */
	    }
     
        return view;
    }
}
