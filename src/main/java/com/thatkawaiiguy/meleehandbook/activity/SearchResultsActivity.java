package com.thatkawaiiguy.meleehandbook.activity;

import android.app.AlertDialog;
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
    private final String TECH_KEY = "tech";
    private final String FUN_KEY = "fun";
    private final String MAP_KEY = "map";
    private final String CHAR_KEY = "char";
    private final String TERM_KEY = "term";
    private final String UNIQUE_KEY = "unique";

    private boolean canStart = true;
    private boolean[] checked;

    private final Context context = this;

    private SharedPreferences prefs;

    private SearchView searchView;
    private SearchAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private final ArrayList<String> queries = new ArrayList<>();

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

        setRecyclerViewLayoutManager();

        handleIntent(getIntent());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY).replaceAll("\\s+$", "")
                    .toLowerCase();
            queries.clear();
            titleTermNum = 0;
            titleNum = 0;
            termNum = 0;
            showResults();
        }
    }

    private void search(String text) {
        query = text.toLowerCase().trim();
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
            case R.id.searchview:
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
                MenuItemCompat.getActionView(menu.findItem(R.id.searchview));

        searchView.onActionViewExpanded();

        if(Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            searchView.setQuery(getIntent().getStringExtra(SearchManager.QUERY).replaceAll("\\s+$",
                    ""), false);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));
            searchView.clearFocus();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!query.equals(""))
                    search(query);
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

    private void setRecyclerViewLayoutManager() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(0);
    }

    private void showDialog() {
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

            String[] character = ArrayHelper.getCharacterArray(context);
            String[] LCCharacter = ArrayHelper.getLCCharacterArray(context);
            String[] characterInfo = ArrayHelper.getLCCharacterInfoArray(context);

            String[] map = ArrayHelper.getMapArray();
            String[] LCMap = ArrayHelper.getLCMapArray();
            String[] mapInfo = ArrayHelper.getLCMapInfoArray(context);

            if(prefs.getBoolean(TERM_KEY, true))
                for(int i = 0; i < term.length; i++) {
                    if(LCTerm[i].contains(query)) {
                        queries.add(term[i]);
                        titleTermNum++;
                    }
                }

            if(prefs.getBoolean(TECH_KEY, true))
                for(int i = 0; i < tech.length; i++) {
                    if(LCTech[i].contains(query)) {
                        queries.add(tech[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(UNIQUE_KEY, true))
                for(int i = 0; i < unique.length; i++) {
                    if(LCUnique[i].contains(query)) {
                        queries.add(unique[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(FUN_KEY, true))
                for(int i = 0; i < fun.length; i++) {
                    if(LCFun[i].contains(query)) {
                        queries.add(ArrayHelper.getFunArray()[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(CHAR_KEY, true))
                for(int i = 0; i < character.length; i++) {
                    if(LCCharacter[i].contains(query)) {
                        queries.add(character[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(MAP_KEY, true))
                for(int i = 0; i < map.length; i++) {
                    if(LCMap[i].contains(query)) {
                        queries.add(map[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(TERM_KEY, true))
                for(int i = 0; i < term.length && LCTerm[i].contains(query); i++)
                    if(termInfo[i].contains(query)) {
                        termNum++;
                        queries.add(ArrayHelper.getTermArray()[i]);
                    }

            if(prefs.getBoolean(TECH_KEY, true))
                for(int i = 0; i < tech.length && LCTech[i].contains(query); i++)
                    if(techInfo[i].contains(query))
                        queries.add(tech[i]);

            if(prefs.getBoolean(UNIQUE_KEY, true))
                for(int i = 0; i < unique.length && !LCUnique[i].contains(query); i++)
                    if(uniqueInfo[i].contains(query))
                        queries.add(unique[i]);

            if(prefs.getBoolean(FUN_KEY, true))
                for(int i = 0; i < fun.length && LCFun[i].contains(query); i++)
                    if((funInfo[i].contains(query)))
                        queries.add(fun[i]);

            if(prefs.getBoolean(CHAR_KEY, true))
                for(int i = 0; i < character.length && LCCharacter[i].contains(query); i++)
                    if((characterInfo[i].contains(query)))
                        queries.add(character[i]);

            if(prefs.getBoolean(MAP_KEY, true))
                for(int i = 0; i < map.length && LCMap[i].contains(query); i++)
                    if(mapInfo[i].contains(query))
                        queries.add(map[i]);

            String[] results = queries.toArray(new String[queries.size()]);
            mAdapter = new SearchAdapter(results, titleNum, titleTermNum, termNum, context,
                    query);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mRecyclerView.setAdapter(mAdapter);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if((position < titleTermNum || (position
                            < titleTermNum + titleNum + termNum && position >= titleNum +
                            titleTermNum)))
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