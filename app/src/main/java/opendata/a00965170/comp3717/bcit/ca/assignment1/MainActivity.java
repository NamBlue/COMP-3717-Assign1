package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

public class MainActivity extends ListActivity
{
    private TextView text;
    private List<String> listValues;
    private List<Categories> categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.mainText);

        //Initialise DAO
        CategoriesDaoHelper.setupDb(this);
        DatasetsDaoHelper.setupDb(this);

        ContentProvider.clearDatabase();
        ContentProvider.populateDatabase();

        listValues = new ArrayList<String>();
        categoriesList = CategoriesDaoHelper.getCategoriesFromSQL();
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
        setListAdapter(myAdapter);
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        Categories categories = categoriesList.get(position);
        text.setText("You clicked " + categories.getCategory_name() + " at position " + categories.getId());

        final Intent intent = new Intent(this, DatasetsActivity.class);
        intent.putExtra("pk", categories.getId());
        startActivityForResult(intent, 1);
    }
}


