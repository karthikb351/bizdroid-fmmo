package np.bizdroid.fmmo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleActivity extends ActionBarActivity {
	
	private DrawerLayout mDrawerLayout;
    private ListView mCategoriesList;
    private ListView mFeaturesList;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mEntries;
    private String mTitle;
    private String mDrawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        mTitle = mDrawerTitle = getTitle().toString();
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategoriesList = (ListView) findViewById(R.id.category_list);
        //mFeaturesList = (ListView) findViewById(R.id.features_list);

        mEntries = getResources().getStringArray(R.array.categories_array);
        mCategoriesList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mEntries));

        mEntries = getResources().getStringArray(R.array.categories_array);
        //mFeaturesList.setAdapter(new ArrayAdapter<String>(this,
         //       R.layout.drawer_list_item, mEntries));
        // Set the list's click listener
        mCategoriesList.setOnItemClickListener(new DrawerItemClickListener());
        //mFeaturesList.setOnItemClickListener(new DrawerItemClickListener());
        
        
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View view) {
                getSupportActionBar().setTitle(mDrawerTitle);
                super.onDrawerOpened(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        Fragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(CategoryFragment.KEY_POS, position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.content_frame, fragment)
                       .commit();

        // Highlight the selected item, update the title, and close the drawer
        mCategoriesList.setItemChecked(position, true);
        setTitle(mEntries[position]);
        mDrawerLayout.closeDrawer(mCategoriesList);
    }

    @Override
    public void setTitle(CharSequence title) {
        String mTitle = title.toString();
        getSupportActionBar().setTitle(mTitle);
    }
    
}
