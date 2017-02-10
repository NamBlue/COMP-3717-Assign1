package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoMaster;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoSession;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class DaoHelper
{
    public static DatasetsDao datasetsDao;//Singleton
    public static CategoriesDao categoriesDao;//Singleton
    public static final String DB_NAME = "DATASETS"; //Name of Db file in the Device

    //---------------------------------Category SQL QUERY Functions-----------------------------------------//
    public static List<Categories> getCategoriesFromSQL(){
        if(categoriesDao != null)
        {
            List<Categories> categoriesList = categoriesDao.queryBuilder().orderAsc(CategoriesDao.Properties.Id).build().list();

            //Get the list of all Categories in Database in descending order
            if (categoriesList.size() > 0)
            {  //if list is not null
                return categoriesList;
                //get(0)--> 1st object
                // getMetadata() is the function in Categories class
            }
        }
        return null;
    }

    public static Categories getCategoryByPK(long pk)
    {
        if(categoriesDao != null)
        {
            Categories dataset = categoriesDao.queryBuilder().where(CategoriesDao.Properties.Id.eq(pk)).unique();
            return dataset;
        }
        return null;
    }

    public static Categories getCategoryById(long fk)
    {
        return categoriesDao.queryBuilder().where(CategoriesDao.Properties.Category_id.eq(fk)).unique();
    }

    public static void SaveToCategories(Categories categories) {
        if(categoriesDao != null)
        {
            categoriesDao.insert(categories);
        }
    }

    //---------------------------------Datasets SQL QUERY Functions-----------------------------------------//
    public static List<Datasets> getDatasetsFromSQL(){
        if(datasetsDao != null)
        {
            List<Datasets> datasetsList = datasetsDao.queryBuilder().orderAsc(DatasetsDao.Properties.Category_id).build().list();

            //Get the list of all Datasets in Database in descending order
            if (datasetsList.size() > 0)
            {  //if list is not null

                return datasetsList;
                //get(0)--> 1st object
                // getMetadata() is the function in Datasets class
            }
        }
        return null;
    }

    public static List<Datasets> getDatasetsById(long id)
    {
        if(datasetsDao != null)
        {
            List<Datasets> datasetsList = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Category_id.eq(id)).orderAsc(DatasetsDao.Properties.Category_id).build().list();

            //Get the list of all Datasets in Database in descending order
            if (datasetsList.size() > 0)
            {  //if list is not null

                return datasetsList;
                //get(0)--> 1st object
                // getMetadata() is the function in Datasets class
            }
        }
        return null;
    }

    public static Datasets getDatasetByName(String name)
    {
        if(datasetsDao != null)
        {
            Datasets dataset = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Datasets_name.eq(name)).unique();
            return dataset;
        }
        return null;
    }

    public static Datasets getDatasetByPK(long pk)
    {
        if(datasetsDao != null)
        {
            Datasets dataset = datasetsDao.queryBuilder().where(DatasetsDao.Properties.Id.eq(pk)).unique();
            return dataset;
        }
        return null;
    }

    public static void SaveToDatasets(Datasets datasets_object) {
        if(datasetsDao != null)
        {
            datasetsDao.insert(datasets_object);
        }
    }
    //----------------------------***END SQL QUERY***---------------------------------------------//

    //-------------------------------DB Setup Functions---------------------------------------------//

    //Return the Configured CategoriesDao Object
    public static void setupDb(Context context){
        if(categoriesDao == null)
        {
            DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null); //create database db file if not exist

            SQLiteDatabase db = masterHelper.getWritableDatabase();  //get the created database
            // db file
            DaoMaster master = new DaoMaster(db);//create masterDao
            DaoSession masterSession = master.newSession(); //Creates Session session
            categoriesDao = masterSession.getCategoriesDao();
            datasetsDao = masterSession.getDatasetsDao();
        }
    }

    public static void closeDb()
    {
        categoriesDao = null;
        datasetsDao = null;
    }
    //-------------------------***END DB setup Functions***---------------------------------------//
}

