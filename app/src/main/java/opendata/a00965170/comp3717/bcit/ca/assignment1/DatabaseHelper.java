package opendata.a00965170.comp3717.bcit.ca.assignment1;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoMaster;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoSession;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;


/**
 * Created by darcy on 2016-10-19.
 */
public class DatabaseHelper
{
    private final static String TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper          instance;
    private        SQLiteDatabase          db;
    private        DaoMaster               daoMaster;
    private        DaoSession              daoSession;
    private        CategoriesDao                 nameDao;
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
        nameDao    = daoSession.getCategoriesDao();
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

    public Categories createName(final String nm, final int category_id)
    {
        final Categories name;

        name = new Categories(null,
                        nm,category_id);
        nameDao.insert(name);

        return (name);
    }

    public Categories getNameFromCursor(final Cursor cursor)
    {
        final Categories name;

        name = nameDao.readEntity(cursor,
                                  0);

        return (name);
    }

    public Categories getNameByObjectId(final long id)
    {
        final List<Categories> names;
        final Categories       name;

        names = nameDao.queryBuilder().where(CategoriesDao.Properties.Id.eq(id)).limit(1).list();

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

    public List<Categories> getNames()
    {
        return (nameDao.loadAll());
    }

    public Cursor getNamesCursor()
    {
        final Cursor cursor;

        String orderBy = CategoriesDao.Properties.Category_name.columnName + " ASC";
        cursor = db.query(nameDao.getTablename(),
                          nameDao.getAllColumns(),
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

    public long getNumberOfNames()
    {
        return (nameDao.count());
    }
}
