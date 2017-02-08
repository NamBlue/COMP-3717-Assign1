package opendata.a00965170.comp3717.bcit.ca.assignment1;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class ContentProvider
{
    public static void populateDatabase()
    {

            Categories temp_categories = new Categories(null, "Public Utilities", 1L);
            CategoriesDaoHelper.SaveToSQL(temp_categories);
            temp_categories = new Categories(null, "Street Information", 2L);
            CategoriesDaoHelper.SaveToSQL(temp_categories);

            Datasets temp_datasets = new Datasets(null, "Toilets", "This is one toilet", 1L);
            DatasetsDaoHelper.SaveToSQL(temp_datasets);
            temp_datasets = new Datasets(null, "Addresses", "Addresses of new west", 2L);
            DatasetsDaoHelper.SaveToSQL(temp_datasets);

    }

    public static void clearDatabase()
    {
        CategoriesDaoHelper.categoriesDao.dropTable(CategoriesDaoHelper.categoriesDao.getDatabase(), true);
        DatasetsDaoHelper.datasetsDao.dropTable(DatasetsDaoHelper.datasetsDao.getDatabase(), true);
    }
}
