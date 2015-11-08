package com.thatkawaiiguy.meleehandbook.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.SearchAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.other.Preferences;
import com.thatkawaiiguy.meleehandbook.other.SearchActivitySelector;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    int termNum = 0;

    String query = "";
    String upperCaseQuery = "";

    boolean canStart = true;

    boolean[] checked;

    public Context context = this;

    SharedPreferences prefs;

    String[] results;

    String TECH_KEY = "tech";
    String FUN_KEY = "fun";
    String MAP_KEY = "map";
    String CHAR_KEY = "char";
    String TERM_KEY = "term";
    String UNIQUE_KEY = "unique";

    protected SearchAdapter mAdapter;

    protected RecyclerView mRecyclerView;

    ArrayList<String> queries = new ArrayList<>();

    private enum LayoutManagerType {LINEAR_LAYOUT_MANAGER}

    protected LayoutManagerType mCurrentLayoutManagerType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        Slidr.attach(this);
        setContentView(R.layout.search_layout);
        prefs = getPreferences(MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if(savedInstanceState != null)
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable("layoutManager");
        setRecyclerViewLayoutManager();

        handleIntent(getIntent());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            upperCaseQuery = intent.getStringExtra(SearchManager.QUERY).replaceAll("\\s+$", "");
            query = upperCaseQuery.toLowerCase();
            queries.clear();
            termNum = 0;
            showResults();
        }
    }

    public void search(String text) {
        query = text.toLowerCase();
        queries.clear();
        termNum = 0;
        showResults();
    }

    private void showResults() {
        mRecyclerView.setAdapter(null);
        new AsyncCaller().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.search:
                onSearchRequested();
                return true;
            case R.id.filter:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchactivity, menu);

        ComponentName cn = new ComponentName(this, SearchResultsActivity.class);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(menu.findItem(R.id.search));

        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    public void setRecyclerViewLayoutManager() {
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(0);
    }

    public void showDialog() {
        AlertDialog dialog;

        checked = new boolean[]{prefs.getBoolean(TECH_KEY, true), prefs.getBoolean(CHAR_KEY, true), prefs.getBoolean(FUN_KEY, true),
                prefs.getBoolean(MAP_KEY, true), prefs.getBoolean(TERM_KEY, true), prefs.getBoolean(UNIQUE_KEY, true)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select which list items you want to appear");
        builder.setMultiChoiceItems(R.array.filter_options, checked,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected,
                                        boolean isChecked) {
                        AlertDialog d = (AlertDialog) dialog;
                        ListView v = d.getListView();
                        int i = 0;
                        while(i < checked.length) {
                            v.setItemChecked(i, checked[i]);
                            i++;
                        }
                        checked[indexSelected] = isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        prefs.edit().putBoolean(TECH_KEY, checked[0]).apply();
                        prefs.edit().putBoolean(CHAR_KEY, checked[1]).apply();
                        prefs.edit().putBoolean(FUN_KEY, checked[2]).apply();
                        prefs.edit().putBoolean(MAP_KEY, checked[3]).apply();
                        prefs.edit().putBoolean(TERM_KEY, checked[4]).apply();
                        prefs.edit().putBoolean(UNIQUE_KEY, checked[5]).apply();
                        checked = new boolean[]{prefs.getBoolean(TECH_KEY, true), prefs.getBoolean(CHAR_KEY, true), prefs.getBoolean(FUN_KEY, true),
                                prefs.getBoolean(MAP_KEY, true), prefs.getBoolean(TERM_KEY, true), prefs.getBoolean(UNIQUE_KEY, true)};
                        search(query);
                    }
                })
                .setNegativeButton("Cancel", null);

        dialog = builder.create();//AlertDialog dialog; create like this outside onClick
        dialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onResume() {
        canStart = true;
        super.onResume();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {
        ProgressDialog pdLoading = new ProgressDialog(SearchResultsActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\tSearching...");
            pdLoading.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            for(int i = 0; i < ArrayHelper.getTermArray().length; i++)
                if((ArrayHelper.getLCTermArray()[i].contains(query) || ArrayHelper.getLCTermInfoArray(context)[i].contains(query)) && prefs.getBoolean(TERM_KEY, true)) {
                    termNum++;
                    queries.add(ArrayHelper.getTermArray()[i]);
                }

            for(int i = 0; i < ArrayHelper.getTechArray().length; i++)
                if((ArrayHelper.getLCTechArray()[i].contains(query) || ArrayHelper.getLCTechInfoArray(context)[i].
                        contains(query)) && prefs.getBoolean(TECH_KEY, true))
                    queries.add(ArrayHelper.getTechArray()[i]);

            for(int i = 0; i < ArrayHelper.getUniqueArray().length; i++)
                if((ArrayHelper.getLCUniqueArray()[i].contains(query) || ArrayHelper.getLCUniqueInfoArray(context)[i].
                        contains(query)) && prefs.getBoolean(UNIQUE_KEY, true))
                    queries.add(ArrayHelper.getUniqueArray()[i]);

            for(int i = 0; i < ArrayHelper.getCharacterArray().length; i++)
                if((ArrayHelper.getLCCharacterArray()[i].contains(query) || ArrayHelper.getLCCharacterInfoArray(context)[i].
                        contains(query)) && prefs.getBoolean(CHAR_KEY, true))
                    queries.add(ArrayHelper.getCharacterArray()[i]);

            for(int i = 0; i < ArrayHelper.getFunArray().length; i++)
                if((ArrayHelper.getLCFunArray()[i].contains(query) || ArrayHelper.getLCFunInfoArray(context)[i].
                        contains(query)) && prefs.getBoolean(FUN_KEY, true))
                    queries.add(ArrayHelper.getFunArray()[i]);

            for(int i = 0; i < ArrayHelper.getMapArray().length; i++)
                if((ArrayHelper.getLCMapArray()[i].contains(query) || ArrayHelper.getLCMapInfoArray(context)[i].
                        contains(query)) && prefs.getBoolean(MAP_KEY, true))
                    queries.add(ArrayHelper.getMapArray()[i]);

            results = queries.toArray(new String[queries.size()]);
            mAdapter = new SearchAdapter(results, termNum, context, query);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //this method will be running on UI thread
            pdLoading.dismiss();
            getSupportActionBar().setTitle(upperCaseQuery);

            mRecyclerView.setAdapter(mAdapter);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    if(position < termNum)
                        return;
                    String searchQuery = queries.get(position).toLowerCase();
                    if(canStart) {
                        Intent mIntent = SearchActivitySelector.selectTechActivity(searchQuery, context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectUniqueActivity(searchQuery, context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectFunActivity(searchQuery, context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectMapActivity(searchQuery, context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectCharacterActivity(searchQuery,
                                    context);
                        startActivity(mIntent);
                        canStart = false;
                    }
                }
            });
        }

    }
}