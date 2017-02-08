package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator
{
    public static void main(String[] args)  throws Exception {

        //place where db folder will be created inside the project folder
        Schema schema = new Schema(1,"opendata.a00965170.comp3717.bcit.ca.database.schema");

        //Entity i.e. Class to be stored in the database // ie table LOG
        Entity categories= schema.addEntity("Categories");
        Entity datasets= schema.addEntity("Datasets");

        categories.addIdProperty(); //It is the primary key for uniquely identifying a row
        datasets.addIdProperty(); //It is the primary key for uniquely identifying a row

        categories.addStringProperty("Category").notNull();  //Not null is SQL constrain
        datasets.addStringProperty("Name");
        datasets.addStringProperty("Metadata");
        datasets.addIntProperty("CategoryID").notNull();

        //  ./app/src/main/java/   ----   com/codekrypt/greendao/db is the full path
        new DaoGenerator().generateAll(schema, "./app/src/main/java");

    }
}
