package np.bizdroid.fmmo;

import com.fedorvlasov.lazylist.ImageLoader;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class PlaylistFragment extends Fragment {
	
	public static View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try {
			v=inflater.inflate(R.layout.fragment_playlist, container, false);
			GridView gridview = (GridView) v.findViewById(R.id.gridview);
		    gridview.setAdapter(new ImageAdapter(getActivity()));
		    gridview.setSelector(getResources().getDrawable(R.drawable.griditem_selector));
		    gridview.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
		        }
		    });
		}
		catch (InflateException x)
		{
			
		}
		return v;
	}
	
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;
	    public ImageLoader imageLoader; 
	    public View v;

	    private String[] urls = {
	    		"https://i.ytimg.com/vi/cyWiHmToBEc/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/e0jJgHTSP50/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/o0Gfg_0WC_I/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/cKQz7xYSNto/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/b4E8liqdtCA/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/rGyuCtdtCyY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/Duqj2NHELsY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/mC_4ndpl8cM/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/sA0kfN88gH0/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/2F4G5x2iGj0/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/-3F5pHJBpic/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/PsBlU_uMR6Y/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/6GT1gjd0TO8/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/gDg2pQhfLb0/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/A7QeupbAdNY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/D1KhDNBg73g/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/D1KhDNBg73g/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/21ggVIm5MrE/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/f1bN1LWo3Do/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/52x9k1SBkkI/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/hOFO1gXyVBE/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/tbBq5KvTOv0/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/0xyr7a_k3yY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/fZYHXDA3ukk/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/kdIuaK1PvX8/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/SBHj4PXGHjw/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/sY256cfguJk/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/VuVFdohx0K0/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/z3IL_32bawI/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/JOerq3UhmH8/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/IOMzpT9J4bw/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/G_yIz8axv-g/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/kdTjktKCLwY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/fbYCFaQKyN4/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/fbYCFaQKyN4/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/y500C9u3lvI/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/vC52FyOyixo/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/X91cjB_nCVE/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/5crGpE1gopo/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/9BvzKGS2nzU/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/P0dGufP8aNM/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/1QOceMsdZxE/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/P0dGufP8aNM/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/z-kPdbGQR5g/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/aDDDjgc75oU/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/gM5dD3_CzWY/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/aDDDjgc75oU/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/L60IabzMjBA/hqdefault.jpg",
	    		"https://i.ytimg.com/vi/sS-kjnLOBN0/hqdefault.jpg"
	    };
	    public ImageAdapter(Context c) {
	        mContext = c;
	        imageLoader=new ImageLoader(c);
	    }

	    public int getCount() {
	        return urls.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            LayoutInflater inflator = LayoutInflater.from(mContext);
	            v = inflator.inflate(R.layout.gridview_item, null);
	            imageView = (ImageView)v.findViewById(R.id.gridview_item_image);
	        } else {
	            imageView = (ImageView) convertView.findViewById(R.id.gridview_item_image);
	            v=convertView;
	        }
	        imageLoader.DisplayImage(urls[position], imageView);
	        return v;
	    }

	}

}
