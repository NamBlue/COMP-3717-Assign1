package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

public class AboutActivity extends Activity
{
    private TextView textView;
    private Intent intent;
    private String name;
    private Datasets dataset;
    private long selectedPK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textView = (TextView) findViewById(R.id.textDisplay);

        intent = getIntent();
        name = intent.getStringExtra("name");
        selectedPK = intent.getLongExtra("pk", -1);

        dataset = DatasetsDaoHelper.getDatasetByPK(selectedPK);
        textView.setText(dataset.getDatasets_metadata());
    }
}