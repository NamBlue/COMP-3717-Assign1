package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;

public class MainActivity extends ListActivity
{
    private List<String> listValues;
    private List<Categories> categoriesList;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final DatabaseHelper helper;
        final LoaderManager manager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        //Initialise DAO
        DaoHelper.setupDb(this);

        ContentProvider.clearDatabase();
        ContentProvider.populateDatabase();

        listValues = new ArrayList<String>();
        categoriesList = DaoHelper.getCategoriesFromSQL();
        if (categoriesList != null)
        {
            for(Categories cl: categoriesList)
            {
                listValues.add(cl.getCategory_name());
            }
        }



        // initiate the listadapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                R.layout.row_layout, R.id.listText, listValues);

        // assign the list adapter
        setListAdapter(myAdapter);*/

        helper = DatabaseHelper.getInstance(this);
        helper.openDatabaseForReading(this);
        adapter = new SimpleCursorAdapter(getBaseContext(),
                android.R.layout.simple_list_item_1,
                null,
                new String[]
                        {
                                CategoriesDao.Properties.Category_name.columnName,
                        },
                new int[]
                        {
                                android.R.id.text1,
                        },
                0);
        setListAdapter(adapter);
        manager = getLoaderManager();
        manager.initLoader(0, null, new NameLoaderCallbacks());
        init();
    }

    private void init()
    {
        final DatabaseHelper helper;
        final long           numEntries;

        helper = DatabaseHelper.getInstance(this);
        helper.openDatabaseForWriting(this);
        numEntries = helper.getNumberOfNames();

        if(numEntries == 0)
        {
            helper.createName("D'Arcy", 1);
            helper.createName("Medhat", 2);
            helper.createName("Jason" , 3);
            helper.createName("Albert", 4);
        }

        helper.close();
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        Categories categories = categoriesList.get(position);
        System.out.println("You clicked " + categories.getCategory_name() + " at position " + categories.getId());

        final Intent intent = new Intent(this, DatasetsActivity.class);
        intent.putExtra("pk", categories.getId());
        startActivityForResult(intent, 1);
    }

    private class NameLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            final Uri uri;
            final CursorLoader loader;

            uri    = NameContentProvider.CONTENT_URI;
            loader = new CursorLoader(MainActivity.this, uri, null, null, null, null);

            return (loader);
        }

        @Override
        public void onLoadFinished(final Loader<Cursor> loader,
                                   final Cursor         data)
        {
            adapter.swapCursor(data);
        }

        @Override
        public void onLoaderReset(final Loader<Cursor> loader)
        {
            adapter.swapCursor(null);
        }
    }
}


