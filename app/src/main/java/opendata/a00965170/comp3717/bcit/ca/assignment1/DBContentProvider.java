package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DBContentProvider
    extends ContentProvider
{
    private static final UriMatcher uriMatcher;
    private static final int CATEGORY_URI = 1, DATASET_URI = 2;
    public static final Uri CATEGORY_CONTENT_URI, DATASET_CONTENT_URI;
    private DatabaseHelper helper;

    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("opendata.a00965170.comp3717.bcit.ca.assignment1", "categories", CATEGORY_URI);
        uriMatcher.addURI("opendata.a00965170.comp3717.bcit.ca.assignment1", "datasets", DATASET_URI);
    }

    static
    {
        CATEGORY_CONTENT_URI = Uri.parse("content://opendata.a00965170.comp3717.bcit.ca.assignment1/categories");
        DATASET_CONTENT_URI = Uri.parse("content://opendata.a00965170.comp3717.bcit.ca.assignment1/datasets");
    }

    @Override
    public boolean onCreate()
    {
        helper = DatabaseHelper.getInstance(getContext());

        return true;
    }

    @Override
    public Cursor query(final Uri uri,
                        final String[] projection,
                        final String selection,
                        final String[] selectionArgs,
                        final String sortOrder)
    {
        final Cursor cursor;

        switch (uriMatcher.match(uri))
        {
            case CATEGORY_URI:
            {
                final SQLiteDatabase db;

                helper.openDatabaseForReading(getContext());
                cursor = helper.getCategoriesCursor();
                helper.close();
                break;
            }
            case DATASET_URI:
            {
                final SQLiteDatabase db;

                helper.openDatabaseForReading(getContext());
                cursor = helper.getDatasetsByFKCursor(selection);
                helper.close();
                break;
            }
            default:
            {
                throw new IllegalArgumentException("Unsupported URI: " + uri);
            }
        }

        return (cursor);
    }

    @Override
    public String getType(final Uri uri)
    {
        final String type;

        switch(uriMatcher.match(uri))
        {
            case CATEGORY_URI:
                type = "vnd.android.cursor.dir/vnd.opendata.a00965170.comp3717.bcit.ca.assignment1.categories";
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        return (type);
    }

    @Override
    public int delete(final Uri uri,
                      final String selection,
                      final String[] selectionArgs)
    {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(final Uri uri,
                      final ContentValues values)
    {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(final Uri uri,
                      final ContentValues values,
                      final String selection,
                      final String[]      selectionArgs)
    {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
