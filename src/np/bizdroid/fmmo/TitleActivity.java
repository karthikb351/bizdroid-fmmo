package np.bizdroid.fmmo;

import android.app.ActionBar;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TitleActivity extends ActionBarActivity {
	
	private DrawerLayout mDrawerLayout;
	private LinearLayout navBar;
    private ListView mCategoriesList;
    private ListView mFeaturesList;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] categoryEntries;
    private String[] featureEntries;
    private String mTitle;
    private String mDrawerTitle;
    
    
    private TextView categories;
    private TextView features;
    private TextView homeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        mTitle = mDrawerTitle = getTitle().toString();
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategoriesList = (ListView) findViewById(R.id.category_list);
        mFeaturesList = (ListView) findViewById(R.id.features_list);
        navBar = (LinearLayout) findViewById(R.id.navbar_layout);
        homeTextView = (TextView) findViewById(R.id.home_textview);
        
        //declaring categories and features for underlining them
        categories = (TextView) findViewById(R.id.categories);
        features = (TextView) findViewById(R.id.features);
        Paint paint = new Paint();
        paint.setARGB(0, 255, 245, 245);
        paint.setFlags(Paint.UNDERLINE_TEXT_FLAG);
        categories.setPaintFlags(paint.getFlags());
        categories.setText(R.string.categories);
        features.setPaintFlags(paint.getFlags());
        features.setText(R.string.features);

        categoryEntries = getResources().getStringArray(R.array.categories_array);
        mCategoriesList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, categoryEntries));

        featureEntries = getResources().getStringArray(R.array.features_array);
        mFeaturesList.setAdapter(new ArrayAdapter<String>(this,
               R.layout.drawer_list_item, featureEntries));
        showHome();
        // Set the list's click listener
        homeTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showHome();
			}
		});
        mCategoriesList.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
		        Fragment fragment = new Fragments();
		        Bundle args = new Bundle();
		        args.putInt(Fragments.KEY_POS, position);
		        args.putInt(Fragments.KEY_LIST, 2);
		        fragment.setArguments(args);
		        
		        // Insert the fragment by replacing any existing fragment
		        FragmentManager fragmentManager = getSupportFragmentManager();
		        fragmentManager.beginTransaction()
		                       .replace(R.id.content_frame, fragment)
		                       .commit();

		        // Highlight the selected item, update the title, and close the drawer
		        mCategoriesList.setItemChecked(position, true);
		        setTitle(categoryEntries[position]);
		        mDrawerLayout.closeDrawer(navBar);
			}
        	
		});
        mFeaturesList.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Fragment fragment = new Fragments();
		        Bundle args = new Bundle();
		        args.putInt(Fragments.KEY_POS, position);
		        args.putInt(Fragments.KEY_LIST, 3);
		        fragment.setArguments(args);
		        
		        // Insert the fragment by replacing any existing fragment
		        FragmentManager fragmentManager = getSupportFragmentManager();
		        fragmentManager.beginTransaction()
		                       .replace(R.id.content_frame, fragment)
		                       .commit();

		        // Highlight the selected item, update the title, and close the drawer
		        mFeaturesList.setItemChecked(position, true);
		        setTitle(featureEntries[position]);
		        mDrawerLayout.closeDrawer(navBar);
				
			}
        });
        
        
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_background));
        getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.action_bar_text_padded));
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
        	@Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        	@Override
            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        /**setting up main activity**/
    }
    
    private void showHome() {
		Fragment fragment = new Fragments();
        Bundle args = new Bundle();
        args.putInt(Fragments.KEY_POS, 0);
        args.putInt(Fragments.KEY_LIST, 1);
        fragment.setArguments(args);
        
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.content_frame, fragment)
                       .commit();

        // Highlight the selected item, update the title, and close the drawer
        setTitle(R.string.home);
        mDrawerLayout.closeDrawer(navBar);
    }
    
    @Override
    public void setTitle(CharSequence title) {
        String mTitle = title.toString();
        getSupportActionBar().setTitle(mTitle);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.category, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(navBar);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons switch(item.getItemId()) {
        switch(item.getItemId()) {
        case R.id.action_websearch:
            // create intent to perform web search for this planet
            /*Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
            // catch event that there's no activity to handle intent
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
            }*/
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    
}
