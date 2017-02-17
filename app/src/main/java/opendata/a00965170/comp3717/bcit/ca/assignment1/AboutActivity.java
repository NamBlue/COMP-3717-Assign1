package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

public class AboutActivity extends Activity
{
    private TextView textView;
    private Intent intent;
    private final DatabaseHelper helper = DatabaseHelper.getInstance(this);
    private Datasets dataset;
    private long selectedPK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textView = (TextView) findViewById(R.id.textDisplay);

        intent = getIntent();
        selectedPK = intent.getLongExtra("pk", -1);

        dataset = helper.getDatasetByID(selectedPK);
        textView.setText(dataset.getDatasets_metadata());
        if(dataset.getDatasets_metadata().equalsIgnoreCase(""))
        {
            textView.setText("No Description Available");
        }
    }

    public void return_button_onClick(View view)
    {
        finish();
    }
}
