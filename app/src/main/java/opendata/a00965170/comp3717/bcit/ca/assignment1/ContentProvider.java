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
        populateCategories();

        populateUndergroundData();

        Datasets temp_datasets = new Datasets(null, "Accessible Public Washrooms", "Listing of all the accessible washrooms that are available within the City.", 1L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Addresses", "A list of addresses for the City of New Westminster.", 2L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Bike Routes", "This dataset contains bike routes including planned and current bikeways, on-street and off-street, as well as dedicated lanes.", 2L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
    }

    public static void populateCategories()
    {
        Categories temp_categories = new Categories(null, "City Data", 1L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
        temp_categories = new Categories(null, "City Land Information", 2L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
        temp_categories = new Categories(null, "City Underground Related Data", 3L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
        temp_categories = new Categories(null, "Miscellaneous", 4L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
        temp_categories = new Categories(null, "Public Utilities", 5L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
        temp_categories = new Categories(null, "Street Information", 6L);
        CategoriesDaoHelper.SaveToSQL(temp_categories);
    }

    public static void populateUndergroundData()
    {
        Datasets temp_datasets = new Datasets(null, "Oil Tanks (Removed/Decommissioned)", "The number of underground storage tanks that are active, removed, or outstanding in the removal process, by year.", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Sewer Catchbasins", "No Description Available", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Sewer Culverts", "No Description Available", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Sewer Ditches", "No Description Available", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Sewer Mains", "No Description Available", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Sewer Maintenance Holes", "No Description Available", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Water Pressure Zones", "This polygon feature class represents each water pressure zone in the City of New Westminster water distribution system. The data was developed to represent the location of water pressure zones for the purpose of mapping, analysis, planning and maintenance of utilities. The accuracy of this data varies and should not be used for precise measurements or calculations.", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Water Quality Data", "A hydrant is an outlet from a " +
                "fluid main often consisting of an upright pipe with a valve attached from which " +
                "fluid (e.g. water or fuel) can be tapped. This data set presents the raw data " +
                "from which our Annual Water Quality report is generated. For full context for " +
                "the data please refer to the report.\n" +
                "\n" +
                "NWR Comp 2015.xlsm - Monthly bacteriological analysis of portable water " +
                "samples\n" +
                "\n" +
                "NWR Numbers 2015.xlsm - Monthly samples for coliform bacteria\n" +
                "\n" +
                "NWR By-station 2015.xlsm - Full year water quality testing by station (addresses" +
                " given are locations of the sampling station)\n" +
                "\n" +
                "NWR HPC 2015.xlsm - Monthly heterotrophic plate count\n" +
                "\n" +
                "NWR 4Q DBP.xlsm - 4th quarter disinfectant by product reports", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Water Valves", "A device that regulates the flow of water.", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
        temp_datasets = new Datasets(null, "Watermains", "A principal pipe in a system of pipes for conveying water, especially one installed underground.", 3L);
        DatasetsDaoHelper.SaveToSQL(temp_datasets);
    }

    public static void populatePublicUtilities()
    {

    }

    public static void clearDatabase()
    {
        CategoriesDaoHelper.categoriesDao.deleteAll();
        DatasetsDaoHelper.datasetsDao.deleteAll();
    }
}
