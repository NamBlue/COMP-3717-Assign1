package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoMaster;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoSession;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;

public class MainActivity extends ListActivity
{
    private TextView text;
    private List<String> listValues;
    private Datasets temp_datasets; // Used for creating a LOG Object
    private List<Datasets> datasetsList;
    private  final String DB_NAME ="DATASETS-db" ;  //Name of Db file in the Device

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.mainText);

        //Initialise DAO
        DatasetsDaoHelper.setupDb(this);

        temp_datasets = new Datasets(null, "Toilets", "This is one toilet", 0);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);

        listValues = new ArrayList<String>();
        datasetsList = DatasetsDaoHelper.getDatasetsFromSQL();
        if (datasetsList != null)
        {
            for(Datasets ds: datasetsList)
            {
                listValues.add(ds.getMetadata());
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
        //String selectedItem = (String) getListAdapter().getItem(position);
        text.setText("You clicked " + selectedItem + " at position " + position);

        String country;
        country = selectedItem;


    }
}


