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
import android.view.inputmethod.InputMethodManager;
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

    private int titleTermNum = 0;
    private int termNum = 0;
    private int titleNum = 0;

    private String query = "";
    private String TECH_KEY = "tech";
    private String FUN_KEY = "fun";
    private String MAP_KEY = "map";
    private String CHAR_KEY = "char";
    private String TERM_KEY = "term";
    private String UNIQUE_KEY = "unique";

    private boolean canStart = true;
    private boolean[] checked;

    private Context context = this;

    private SharedPreferences prefs;

    private SearchView searchView;
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
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable
                    ("layoutManager");
        setRecyclerViewLayoutManager();

        handleIntent(getIntent());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY).replaceAll("\\s+$", "").toLowerCase();
            queries.clear();
            titleTermNum = 0;
            titleNum = 0;
            termNum = 0;
            showResults();
        }
    }

    public void search(String text) {
        query = text.toLowerCase();
        queries.clear();
        titleTermNum = 0;
        titleNum = 0;
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
        searchView = (SearchView)
                MenuItemCompat.getActionView(menu.findItem(R.id.search));

        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));
        searchView.onActionViewExpanded();
        searchView.setQuery(getIntent().getStringExtra(SearchManager.QUERY).replaceAll("\\s+$",
                ""), false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.equals(""))
                    search(newText);
                return false;
            }
        });

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

        checked = new boolean[]{prefs.getBoolean(TECH_KEY, true), prefs.getBoolean(CHAR_KEY,
                true), prefs.getBoolean(FUN_KEY, true),
                prefs.getBoolean(MAP_KEY, true), prefs.getBoolean(TERM_KEY, true), prefs
                .getBoolean(UNIQUE_KEY, true)};

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
                        checked = new boolean[]{prefs.getBoolean(TECH_KEY, true), prefs
                                .getBoolean(CHAR_KEY, true), prefs.getBoolean(FUN_KEY, true),
                                prefs.getBoolean(MAP_KEY, true), prefs.getBoolean(TERM_KEY, true)
                                , prefs.getBoolean(UNIQUE_KEY, true)};
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
        //ProgressDialog pdLoading = new ProgressDialog(SearchResultsActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            //pdLoading.setMessage("\tSearching...");
            //pdLoading.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String[] term = ArrayHelper.getTermArray();
            String[] LCTerm = ArrayHelper.getLCTermArray();
            String[] termInfo = ArrayHelper.getLCTermInfoArray(context);

            String[] tech = ArrayHelper.getTechArray();
            String[] LCTech = ArrayHelper.getLCTechArray();
            String[] techInfo = ArrayHelper.getLCTechInfoArray(context);

            String[] unique = ArrayHelper.getUniqueArray();
            String[] LCUnique = ArrayHelper.getLCUniqueArray();
            String[] uniqueInfo = ArrayHelper.getLCUniqueInfoArray(context);

            String[] fun = ArrayHelper.getFunArray();
            String[] LCFun = ArrayHelper.getLCFunArray();
            String[] funInfo = ArrayHelper.getLCFunInfoArray(context);

            String[] character = ArrayHelper.getCharacterArray();
            String[] LCCharacter = ArrayHelper.getLCCharacterArray();
            String[] characterInfo = ArrayHelper.getLCCharacterInfoArray(context);

            String[] map = ArrayHelper.getMapArray();
            String[] LCMap = ArrayHelper.getLCMapArray();
            String[] mapInfo = ArrayHelper.getLCMapInfoArray(context);

            for(int i = 0; i < term.length; i++)
                if(prefs.getBoolean(TERM_KEY, true)) {
                    if(LCTerm[i].contains(query)) {
                        queries.add(term[i]);
                        titleTermNum++;
                    }
                }

            for(int i = 0; i < tech.length; i++)
                if(prefs.getBoolean(TECH_KEY, true))
                    if(LCTech[i].contains(query)) {
                        queries.add(tech[i]);
                        titleNum++;
                    }

            for(int i = 0; i < unique.length; i++)
                if(prefs.getBoolean(UNIQUE_KEY, true))
                    if(LCUnique[i].contains(query)) {
                        queries.add(unique[i]);
                        titleNum++;
                    }

            for(int i = 0; i < ArrayHelper.getFunArray().length; i++)
                if(prefs.getBoolean(FUN_KEY, true))
                    if(LCFun[i].contains(query)) {
                        queries.add(ArrayHelper.getFunArray()[i]);
                        titleNum++;
                    }

            for(int i = 0; i < character.length; i++)
                if(prefs.getBoolean(CHAR_KEY, true))
                    if(LCCharacter[i].contains(query)) {
                        queries.add(character[i]);
                        titleNum++;
                    }

            for(int i = 0; i < map.length; i++)
                if(prefs.getBoolean(MAP_KEY, true))
                    if(LCMap[i].contains(query)) {
                        queries.add(map[i]);
                        titleNum++;
                    }

            for(int i = 0; i < ArrayHelper.getTermArray().length; i++)
                if(prefs.getBoolean(TERM_KEY, true)) {
                    if(LCTerm[i].contains(query));
                    else if(termInfo[i].contains(query)) {
                        termNum++;
                        queries.add(ArrayHelper.getTermArray()[i]);
                    }
                }

            for(int i = 0; i < tech.length; i++)
                if(prefs.getBoolean(TECH_KEY, true)) {
                    if(LCTech[i].contains(query));
                    else if(techInfo[i].contains(query))
                        queries.add(tech[i]);
                }

            for(int i = 0; i < unique.length; i++)
                if(prefs.getBoolean(UNIQUE_KEY, true)) {
                    if(LCUnique[i].contains(query));
                    else if(uniqueInfo[i].contains(query))
                        queries.add(unique[i]);
                }

            for(int i = 0; i < fun.length; i++)
                if(prefs.getBoolean(FUN_KEY, true)) {
                    if(LCFun[i].contains(query));
                    else if((funInfo[i].contains(query)))
                        queries.add(fun[i]);
                }

            for(int i = 0; i < character.length; i++)
                if(prefs.getBoolean(CHAR_KEY, true)) {
                    if(LCCharacter[i].contains(query));
                    else if((characterInfo[i].contains(query)))
                        queries.add(character[i]);
                }

            for(int i = 0; i < map.length; i++)
                if(prefs.getBoolean(MAP_KEY, true)) {
                    if(LCMap[i].contains(query));
                    else if(mapInfo[i].contains(query))
                        queries.add(map[i]);
                }

            String[] results = queries.toArray(new String[queries.size()]);
            mAdapter = new SearchAdapter(results, titleNum, titleTermNum, termNum, context, query);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //this method will be running on UI thread
            ///pdLoading.dismiss();

            mRecyclerView.setAdapter(mAdapter);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    if(position < termNum)
                        return;
                    String searchQuery = queries.get(position).toLowerCase();
                    if(canStart) {
                        Intent mIntent = SearchActivitySelector.selectTechActivity(searchQuery,
                                context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectUniqueActivity(searchQuery,
                                    context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectFunActivity(searchQuery,
                                    context);
                        if(mIntent == null)
                            mIntent = SearchActivitySelector.selectMapActivity(searchQuery,
                                    context);
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