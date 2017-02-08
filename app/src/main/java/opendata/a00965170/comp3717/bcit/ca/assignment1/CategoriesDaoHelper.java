package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoMaster;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DaoSession;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class CategoriesDaoHelper
{
    //Singleton
    public static CategoriesDao categoriesDao;
    public static final String DB_NAME = "DATASETS"; //Name of Db file in the Device

    //---------------------------------SQL QUERY Functions-----------------------------------------//
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

    public static void SaveToSQL(Categories categories) {
        if(categoriesDao != null)
        {
            categoriesDao.insert(categories);
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
        }
    }

    public static void closeDb()
    {
        categoriesDao = null;
    }
    //-------------------------***END DB setup Functions***---------------------------------------//
}

