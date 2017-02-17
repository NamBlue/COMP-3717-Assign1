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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;

public class MainActivity extends ListActivity
{
    private SimpleCursorAdapter adapter;
    private final DatabaseHelper helper = DatabaseHelper.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final LoaderManager manager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        manager.initLoader(0, null, new CategoryLoaderCallbacks());
        init();
    }

    private void init()
    {
        final DatabaseHelper _helper;

        _helper = DatabaseHelper.getInstance(this);
        _helper.openDatabaseForWriting(this);
        _helper.clearDatabase();
        _helper.populateDatabase();
        _helper.close();
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        Categories categories = helper.getCategoryByPkId(position + 1);
        System.out.println("You clicked " + categories.getCategory_name() + " at position " + categories.getId());

        final Intent intent = new Intent(this, DatasetsActivity.class);
        intent.putExtra("pk", categories.getId());
        startActivityForResult(intent, 1);
    }

    private class CategoryLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            final Uri uri;
            final CursorLoader loader;

            uri    = NameContentProvider.CATEGORY_CONTENT_URI;
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


