/*
    This file is part of Melee Handbook.

    Melee Handbook is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Melee Handbook is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Melee Handbook.  If not, see <http://www.gnu.org/licenses/>
 */

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
        assert getSupportActionBar() != null;
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
            String[] termInfo = ArrayHelper.getLCTermInfoArray(context);

            String[] tech = ArrayHelper.getTechArray();
            String[] techInfo = ArrayHelper.getLCTechInfoArray(context);

            String[] unique = ArrayHelper.getUniqueArray();
            String[] uniqueInfo = ArrayHelper.getLCUniqueInfoArray(context);

            String[] fun = ArrayHelper.getFunArray();
            String[] funInfo = ArrayHelper.getLCFunInfoArray(context);

            String[] character = ArrayHelper.getCharacterArray(context);
            String[] characterInfo = ArrayHelper.getLCCharacterInfoArray(context);

            String[] map = ArrayHelper.getMapArray();
            String[] mapInfo = ArrayHelper.getLCMapInfoArray(context);

            if(prefs.getBoolean(TERM_KEY, true))
                for(String aTerm : term) {
                    if(aTerm.toLowerCase().contains(query)) {
                        queries.add(aTerm);
                        titleTermNum++;
                    }
                }

            if(prefs.getBoolean(TECH_KEY, true))
                for(String aTech : tech) {
                    if(aTech.toLowerCase().contains(query)) {
                        queries.add(aTech);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(UNIQUE_KEY, true))
                for(String anUnique : unique) {
                    if(anUnique.toLowerCase().contains(query)) {
                        queries.add(anUnique);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(FUN_KEY, true))
                for(int i = 0; i < fun.length; i++) {
                    if(fun[i].toLowerCase().contains(query)) {
                        queries.add(ArrayHelper.getFunArray()[i]);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(CHAR_KEY, true))
                for(String aCharacter : character) {
                    if(aCharacter.toLowerCase().contains(query)) {
                        queries.add(aCharacter);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(MAP_KEY, true))
                for(String aMap : map) {
                    if(aMap.toLowerCase().contains(query)) {
                        queries.add(aMap);
                        titleNum++;
                    }
                }

            if(prefs.getBoolean(TERM_KEY, true))
                for(int i = 0; i < term.length; i++) {
                    if(!term[i].toLowerCase().contains(query))
                        if(termInfo[i].contains(query)) {
                        termNum++;
                        queries.add(ArrayHelper.getTermArray()[i]);
                    }
                }

            if(prefs.getBoolean(TECH_KEY, true))
                for(int i = 0; i < tech.length; i++) {
                    if(!tech[i].toLowerCase().contains(query))
                        if(techInfo[i].contains(query))
                        queries.add(tech[i]);
                }

            if(prefs.getBoolean(UNIQUE_KEY, true))
                for(int i = 0; i < unique.length; i++) {
                    if(!unique[i].toLowerCase().contains(query))
                        if(uniqueInfo[i].contains(query))
                        queries.add(unique[i]);
                }

            if(prefs.getBoolean(FUN_KEY, true))
                for(int i = 0; i < fun.length; i++) {
                    if(!fun[i].toLowerCase().contains(query))
                        if((funInfo[i].contains(query)))
                        queries.add(fun[i]);
                }

            if(prefs.getBoolean(CHAR_KEY, true))
                for(int i = 0; i < character.length; i++) {
                    if(!character[i].toLowerCase().contains(query))
                        if((characterInfo[i].contains(query)))
                        queries.add(character[i]);
                }

            if(prefs.getBoolean(MAP_KEY, true))
                for(int i = 0; i < map.length; i++) {
                    if(!map[i].toLowerCase().contains(query))
                        if(mapInfo[i].contains(query))
                            queries.add(map[i]);
                }

            mAdapter = new SearchAdapter(queries.toArray(new String[queries.size()])
                    , titleNum, titleTermNum, termNum, context, query);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mRecyclerView.setAdapter(mAdapter);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(
                    new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(int position) {
                            if((position < titleTermNum || (position
                                    < titleTermNum + titleNum + termNum && position >= titleNum +
                                    titleTermNum)))
                                return;
                            if(canStart) {
                                startActivity(selectRightIntent(queries.get(position).toLowerCase()));
                                canStart = false;
                            }
                        }
                    });
        }

    }

    private Intent selectRightIntent(String searchQuery){
        Intent mIntent = selectTechActivity(searchQuery, context);
        if(mIntent == null)
            mIntent = selectUniqueActivity(searchQuery, context);
        if(mIntent == null)
            mIntent = selectFunActivity(searchQuery, context);
        if(mIntent == null)
            mIntent = selectMapActivity(searchQuery, context);
        if(mIntent == null)
            mIntent = selectCharacterActivity(searchQuery, context);
        return mIntent;
    }

    private Intent selectUniqueActivity(String query, Context context) {
        String[] uniqueTechs = ArrayHelper.getUniqueArray();

        for(String uniqueTech : uniqueTechs) {
            if(uniqueTech.toLowerCase().contains(query)) {
                if(uniqueTech.toLowerCase().equals("super wavedash & sdwd") ||
                        uniqueTech.toLowerCase().equals("extended & homing grapple"))
                    return new Intent(context, TechTabActivity.class)
                            .putExtra("option", uniqueTech);
                else
                    return new Intent(context, UniqueTechActivity.class)
                            .putExtra("option", uniqueTech);
            }
        }

        return null;
    }

    private Intent selectTechActivity(String query, Context context) {
        String[] techs = ArrayHelper.getTechArray();

        for(String tech : techs) {
            if(tech.toLowerCase().contains(query) && !"fox".contains(query)) {
                if(tech.equals("Wall jump") || tech.equals("Directional Influence") || tech.equals("Shield dropping"))
                    return new Intent(context, TechTabActivity.class).putExtra("option", tech);
                else
                    return new Intent(context, TechActivity.class).putExtra("option", tech);
            }
        }
        return null;
    }

    private Intent selectCharacterActivity(String query, Context context) {
        String[] characters = ArrayHelper.getCharacterArray(context);

        boolean hasFrame;

        for(String character : characters) {
            if(character.toLowerCase().contains(query)) {
                switch(character) {
                    case "Captain Falcon":
                        hasFrame = true;
                        break;
                    case "Ganondorf":
                        hasFrame = true;
                        break;
                    case "Falco":
                        hasFrame = true;
                        break;
                    case "Fox":
                        hasFrame = true;
                        break;
                    case "Ice Climbers":
                        hasFrame = true;
                        break;
                    case "Jigglypuff":
                        hasFrame = true;
                        break;
                    case "Marth":
                        hasFrame = true;
                        break;
                    case "Pikachu":
                        hasFrame = true;
                        break;
                    case "Samus Aran":
                        hasFrame = true;
                        break;
                    case "Sheik":
                        hasFrame = true;
                        break;
                    case "Yoshi":
                        hasFrame = true;
                        break;
                    case "Dr. Mario":
                        hasFrame = true;
                        break;
                    case "Princess Peach":
                        hasFrame = true;
                        break;
                    default:
                        hasFrame = false;
                        break;
                }
                if("falco".contains(query))
                    return new Intent(context, CharacterFrameActivity.class).putExtra
                            ("option", "Falco");
                else if(hasFrame) {
                    return new Intent(context, CharacterFrameActivity.class).putExtra("option",
                            character);
                } else
                    return new Intent(context, CharacterActivity.class).putExtra("option",
                            character);
            }
        }
        return null;
    }

    private Intent selectFunActivity(String query, Context context) {
        String[] funs = ArrayHelper.getFunArray();

        for(String fun : funs) {
            if(fun.toLowerCase().contains(query))
                return new Intent(context, FunActivity.class).putExtra("option", fun);
        }
        return null;
    }

    private Intent selectMapActivity(String query, Context context) {
        String[] maps = ArrayHelper.getMapArray();

        for(String map : maps) {
            if(map.toLowerCase().contains(query) && !"yoshi".contains(query))
                return new Intent(context, StageActivity.class).putExtra("option", map);
        }
        return null;
    }
}