package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

import java.util.Locale;

public class MainGenerator
{
    public static void main(String[] args)  throws Exception {

        //place where db folder will be created inside the project folder
        Schema schema = new Schema(1,"opendata.a00965170.comp3717.bcit.ca.database.schema");

        //Entity i.e. Class to be stored in the database // ie table Datasets
        Entity categories= schema.addEntity("Categories");
        categories.addIdProperty().primaryKey().autoincrement(); //It is the primary key for uniquely identifying a row
        categories.addStringProperty("category_name").notNull();  //Not null is SQL constrain
        categories.addLongProperty("category_id").notNull(); //FK for datasets

        Entity datasets= schema.addEntity("Datasets");
        datasets.addIdProperty().primaryKey().autoincrement(); //It is the primary key for uniquely identifying a row
        Property datasetsName = datasets.addStringProperty("datasets_name").notNull().getProperty();
        datasets.addStringProperty("datasets_metadata");

        //Relate Datasets to Category
        Property categoryId = datasets.addLongProperty("category_id").getProperty();
        datasets.addToOne(categories, categoryId);

        //Relate Category to Datasets
        ToMany categoryToDatasets = datasets.addToMany(datasets, categoryId);
        categoryToDatasets.orderAsc(datasetsName);

        //  ./app/src/main/java/   ----   com/codekrypt/greendao/db is the full path
        new DaoGenerator().generateAll(schema, "./app/src/main/java");

    }
}
