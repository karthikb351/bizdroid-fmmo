package np.bizdroid.fmmo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoryFragment extends Fragment {
	
	public static final String KEY_POS = "_pos";
	
	public static CategoryFragment newInstance(int pos){
        CategoryFragment obj = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POS, pos);
        obj.setArguments(bundle);
        return obj;
    }
	
	@Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int pos = getArguments().getInt(KEY_POS);
        View view = new View(getActivity());
        switch(pos) {
            case 0 : view.setBackgroundColor(Color.parseColor("#330033"));
                break;
            case 1 : view.setBackgroundColor(Color.parseColor("#333333"));
                break;
        }
        return view;
    }
}
