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

            Datasets temp_datasets = new Datasets(null, "Accessible Public Washrooms", "Listing of all the accessible washrooms that are available within the City.", 1L);
            DatasetsDaoHelper.SaveToSQL(temp_datasets);
            temp_datasets = new Datasets(null, "Addresses", "A list of addresses for the City of New Westminster.", 2L);
            DatasetsDaoHelper.SaveToSQL(temp_datasets);
            temp_datasets = new Datasets(null, "Bike Routes", "This dataset contains bike routes including planned and current bikeways, on-street and off-street, as well as dedicated lanes.", 2L);
            DatasetsDaoHelper.SaveToSQL(temp_datasets);
    }

    public static void clearDatabase()
    {
        CategoriesDaoHelper.categoriesDao.deleteAll();
        DatasetsDaoHelper.datasetsDao.deleteAll();
    }
}
