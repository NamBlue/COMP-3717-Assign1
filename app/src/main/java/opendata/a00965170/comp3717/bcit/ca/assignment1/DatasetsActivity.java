package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class DatasetsActivity extends ListActivity
{
    private List<String> listValues;
    private List<Datasets> datasetsList;
    private long category_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Intent intent;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.datasets_activity);
        intent = getIntent();
        category_id = intent.getLongExtra("pk", -1);

        listValues = new ArrayList<String>();
        datasetsList = DatasetsDaoHelper.getDatasetsById(category_id);
        if (datasetsList != null)
        {
            for(Datasets ds: datasetsList)
            {
                listValues.add(ds.getDatasets_name());
            }
        }



        // initiate the listadapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                R.layout.row_layout, R.id.listText, listValues);

        // assign the list adapter
        setListAdapter(myAdapter);
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        String selectedItem = (String) getListView().getItemAtPosition(position);

        final Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("name", selectedItem);
        intent.putExtra("pk", datasetsList.get(position).getId());
        startActivityForResult(intent, 1);
    }
}
