package opendata.a00965170.comp3717.bcit.ca.database.schema;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CATEGORIES".
*/
public class CategoriesDao extends AbstractDao<Categories, Long> {

    public static final String TABLENAME = "CATEGORIES";

    /**
     * Properties of entity Categories.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Category_name = new Property(1, String.class, "category_name", false, "CATEGORY_NAME");
        public final static Property Category_id = new Property(2, long.class, "category_id", false, "CATEGORY_ID");
    }


    public CategoriesDao(DaoConfig config) {
        super(config);
    }
    
    public CategoriesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CATEGORIES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CATEGORY_NAME\" TEXT NOT NULL ," + // 1: category_name
                "\"CATEGORY_ID\" INTEGER NOT NULL );"); // 2: category_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CATEGORIES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Categories entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getCategory_name());
        stmt.bindLong(3, entity.getCategory_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Categories entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getCategory_name());
        stmt.bindLong(3, entity.getCategory_id());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Categories readEntity(Cursor cursor, int offset) {
        Categories entity = new Categories( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // category_name
            cursor.getLong(offset + 2) // category_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Categories entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCategory_name(cursor.getString(offset + 1));
        entity.setCategory_id(cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Categories entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Categories entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Categories entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
