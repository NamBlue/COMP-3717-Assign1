package opendata.a00965170.comp3717.bcit.ca.database.schema;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATASETS".
*/
public class DatasetsDao extends AbstractDao<Datasets, Long> {

    public static final String TABLENAME = "DATASETS";

    /**
     * Properties of entity Datasets.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Datasets_name = new Property(1, String.class, "datasets_name", false, "DATASETS_NAME");
        public final static Property Datasets_metadata = new Property(2, String.class, "datasets_metadata", false, "DATASETS_METADATA");
        public final static Property Category_id = new Property(3, Long.class, "category_id", false, "CATEGORY_ID");
    }

    private DaoSession daoSession;

    private Query<Datasets> datasets_DatasetsListQuery;

    public DatasetsDao(DaoConfig config) {
        super(config);
    }
    
    public DatasetsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATASETS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DATASETS_NAME\" TEXT NOT NULL ," + // 1: datasets_name
                "\"DATASETS_METADATA\" TEXT," + // 2: datasets_metadata
                "\"CATEGORY_ID\" INTEGER);"); // 3: category_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATASETS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Datasets entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getDatasets_name());
 
        String datasets_metadata = entity.getDatasets_metadata();
        if (datasets_metadata != null) {
            stmt.bindString(3, datasets_metadata);
        }
 
        Long category_id = entity.getCategory_id();
        if (category_id != null) {
            stmt.bindLong(4, category_id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Datasets entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getDatasets_name());
 
        String datasets_metadata = entity.getDatasets_metadata();
        if (datasets_metadata != null) {
            stmt.bindString(3, datasets_metadata);
        }
 
        Long category_id = entity.getCategory_id();
        if (category_id != null) {
            stmt.bindLong(4, category_id);
        }
    }

    @Override
    protected final void attachEntity(Datasets entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Datasets readEntity(Cursor cursor, int offset) {
        Datasets entity = new Datasets( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // datasets_name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // datasets_metadata
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // category_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Datasets entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDatasets_name(cursor.getString(offset + 1));
        entity.setDatasets_metadata(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCategory_id(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Datasets entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Datasets entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Datasets entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "datasetsList" to-many relationship of Datasets. */
    public List<Datasets> _queryDatasets_DatasetsList(Long category_id) {
        synchronized (this) {
            if (datasets_DatasetsListQuery == null) {
                QueryBuilder<Datasets> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Category_id.eq(null));
                queryBuilder.orderRaw("T.'DATASETS_NAME' ASC");
                datasets_DatasetsListQuery = queryBuilder.build();
            }
        }
        Query<Datasets> query = datasets_DatasetsListQuery.forCurrentThread();
        query.setParameter(0, category_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCategoriesDao().getAllColumns());
            builder.append(" FROM DATASETS T");
            builder.append(" LEFT JOIN CATEGORIES T0 ON T.\"CATEGORY_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Datasets loadCurrentDeep(Cursor cursor, boolean lock) {
        Datasets entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Categories categories = loadCurrentOther(daoSession.getCategoriesDao(), cursor, offset);
        entity.setCategories(categories);

        return entity;    
    }

    public Datasets loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Datasets> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Datasets> list = new ArrayList<Datasets>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Datasets> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Datasets> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
