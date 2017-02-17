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

import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class DatasetsActivity extends ListActivity
{
    private final DatabaseHelper helper = DatabaseHelper.getInstance(this);
    private SimpleCursorAdapter adapter;
    private List<Datasets> datasetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Intent intent;
        final LoaderManager manager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.datasets_activity);
        intent = getIntent();
        long category_id = intent.getLongExtra("pk", -1);
        Bundle bundle = new Bundle();
        bundle.putLong("pk", category_id);
        datasetsList = helper.getDatasetsByCategoryID(category_id);

        helper.openDatabaseForReading(this);
        adapter = new SimpleCursorAdapter(getBaseContext(),
                android.R.layout.simple_list_item_1,
                null,
                new String[]
                        {
                                DatasetsDao.Properties.Datasets_name.columnName,
                        },
                new int[]
                        {
                                android.R.id.text1,
                        },
                0);
        setListAdapter(adapter);
        manager = getLoaderManager();
        manager.initLoader(0, bundle, new DatasetsLoaderCallbacks());
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        Datasets datasets = datasetsList.get(position);
        System.out.println("You clicked " + datasets.getDatasets_name() + " at position " + datasets.getId());

        final Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("pk", datasets.getId());
        startActivityForResult(intent, 1);
    }

    private class DatasetsLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            final Uri uri;
            final CursorLoader loader;

            uri    = NameContentProvider.DATASET_CONTENT_URI;
            String where = "category_id=" + args.getLong("pk");
            loader = new CursorLoader(DatasetsActivity.this, uri, null, where, null, null);

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
