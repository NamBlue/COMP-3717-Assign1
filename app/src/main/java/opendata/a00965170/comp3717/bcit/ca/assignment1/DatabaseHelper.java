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
    private final static String DB_FILE_NAME = "OpenData.db";
    private static DatabaseHelper instance;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private CategoriesDao categoriesDao;
    private DatasetsDao datasetsDao;
    private DaoMaster.DevOpenHelper helper;

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
        categoriesDao = daoSession.getCategoriesDao();
        datasetsDao = daoSession.getDatasetsDao();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context, DB_FILE_NAME, null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context, DB_FILE_NAME, null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public Categories createCategory(final String category_name, final long category_id)
    {
        final Categories categories;

        categories = new Categories(null, category_name, category_id);
        categoriesDao.insert(categories);

        return (categories);
    }

    public Datasets createDataset(final String dataset_name, final String dataset_aboutInfo, final long dataset_category_id)
    {
        final Datasets datasets;

        datasets = new Datasets(null, dataset_name, dataset_aboutInfo, dataset_category_id);
        datasetsDao.insert(datasets);

        return (datasets);
    }

    public Categories getCategoryFromCursor(final Cursor cursor)
    {
        final Categories name;

        name = categoriesDao.readEntity(cursor, 0);

        return (name);
    }

    public Categories getCategoryByPkId(final long id)
    {
        final List<Categories> categories;
        final Categories       category;

        categories = categoriesDao.queryBuilder().where(CategoriesDao.Properties.Id.eq(id)).limit(1).list();

        if(categories.isEmpty())
        {
            category = null;
        }
        else
        {
            category = categories.get(0);
        }

        return (category);
    }

    public List<Categories> getCategories()
    {
        return (categoriesDao.loadAll());
    }
    public List<Datasets> getDatasets()
    {
        return (datasetsDao.loadAll());
    }

    public Cursor getCategoriesCursor()
    {
        final Cursor cursor;

        String orderBy = CategoriesDao.Properties.Category_id.columnName + " ASC";
        cursor = db.query(categoriesDao.getTablename(),
                          categoriesDao.getAllColumns(),
                          null,
                          null,
                          null,
                          null,
                          orderBy);

        return (cursor);
    }

    public Datasets getDatasetByID(long pk)
    {
        List<Datasets> datasets = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Id.eq(pk)).limit(1).list();
        Datasets dataset;

        if(datasets.isEmpty())
        {
            dataset = null;
        }
        else
        {
            dataset = datasets.get(0);
        }

        return (dataset);
    }

    public List<Datasets> getDatasetsByCategoryID(long fk)
    {
        List<Datasets> datasets = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Category_id.eq(fk)).list();

        if(datasets.isEmpty())
        {
            return null;
        }
        else
        {
            return datasets;
        }
    }

    public Cursor getDatasetsByFKCursor(String where)
    {
        final Cursor cursor;

        String orderBy = DatasetsDao.Properties.Id.columnName + " ASC";
        cursor = db.query(datasetsDao.getTablename(),
                datasetsDao.getAllColumns(),
                where,
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

    public long getNumberOfCategories()
    {
        return (categoriesDao.count());
    }

    public void clearDatabase()
    {
        categoriesDao.deleteAll();
        datasetsDao.deleteAll();
    }

    public void populateDatabase()
    {
        DatabasePopulator.helper = this;
        DatabasePopulator.populateDatabase();
    }
}
