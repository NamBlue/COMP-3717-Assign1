package opendata.a00965170.comp3717.bcit.ca.database.schema;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.DatasetsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig categoriesDaoConfig;
    private final DaoConfig datasetsDaoConfig;

    private final CategoriesDao categoriesDao;
    private final DatasetsDao datasetsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        categoriesDaoConfig = daoConfigMap.get(CategoriesDao.class).clone();
        categoriesDaoConfig.initIdentityScope(type);

        datasetsDaoConfig = daoConfigMap.get(DatasetsDao.class).clone();
        datasetsDaoConfig.initIdentityScope(type);

        categoriesDao = new CategoriesDao(categoriesDaoConfig, this);
        datasetsDao = new DatasetsDao(datasetsDaoConfig, this);

        registerDao(Categories.class, categoriesDao);
        registerDao(Datasets.class, datasetsDao);
    }
    
    public void clear() {
        categoriesDaoConfig.clearIdentityScope();
        datasetsDaoConfig.clearIdentityScope();
    }

    public CategoriesDao getCategoriesDao() {
        return categoriesDao;
    }

    public DatasetsDao getDatasetsDao() {
        return datasetsDao;
    }

}
