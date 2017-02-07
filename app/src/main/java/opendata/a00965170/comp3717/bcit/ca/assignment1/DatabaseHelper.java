package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoMaster;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoSession;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

/**
 * Created by namblue on 2/6/2017.
 */

public class DatabaseHelper
{
    private final static String TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper          instance;
    private SQLiteDatabase db;
    private        DaoMaster               daoMaster;
    private        DaoSession              daoSession;
    private        DatasetsDao             datasetsDao;
    private        DaoMaster.DevOpenHelper helper;

    private DatabaseHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static DatabaseHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseHelper(context);
        }

        return (instance);
    }

    public static DatabaseHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private void openDatabase()
    {
        daoMaster  = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        datasetsDao    = daoSession.getDatasetsDao();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                "names.db",
                null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                "names.db",
                null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public Datasets createDatasets(final String nm)
    {
        final Datasets name;

        name = new Datasets(null,
                nm);
        datasetsDao.insert(name);

        return (name);
    }

    public Datasets getDatasetsFromCursor(final Cursor cursor)
    {
        final Datasets name;

        name = datasetsDao.readEntity(cursor,
                0);

        return (name);
    }

    public Datasets getDatasetsByObjectId(final long id)
    {
        final List<Datasets> names;
        final Datasets       name;

        names = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Id.eq(id)).limit(1).list();

        if(names.isEmpty())
        {
            name = null;
        }
        else
        {
            name = names.get(0);
        }

        return (name);
    }

    public List<Datasets> getDatasets()
    {
        return (datasetsDao.loadAll());
    }

    public Cursor getDatasetsCursor()
    {
        final Cursor cursor;

        String orderBy = DatasetsDao.Properties.Id.columnName + " ASC";
        cursor = db.query(datasetsDao.getTablename(),
                datasetsDao.getAllColumns(),
                null,
                null,
                null,
                null,
                orderBy);

        return (cursor);
    }

    public static void upgrade(final Database db,
                               final int      oldVersion,
                               final int      newVersion)
    {
    }

    public long getNumberOfDatasets()
    {
        return (datasetsDao.count());
    }
}
