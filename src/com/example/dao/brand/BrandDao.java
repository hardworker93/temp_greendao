package com.example.dao.brand;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;



// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table BRAND.
*/
public class BrandDao extends AbstractDao<Brand, Long> {

    public static final String TABLENAME = "BRAND";

    /**
     * Properties of entity Brand.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property TableId = new Property(0, long.class, "tableId", true, "TABLE_ID");
        public final static Property Id = new Property(1, String.class, "id", false, "ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property PublicImage = new Property(3, String.class, "publicImage", false, "PUBLIC_IMAGE");
        public final static Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public final static Property LastDownloadedTime = new Property(5, String.class, "lastDownloadedTime", false, "LAST_DOWNLOADED_TIME");
    };


    public BrandDao(DaoConfig config) {
        super(config);
    }
    
    public BrandDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'BRAND' (" + //
                "'TABLE_ID' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: tableId
                "'ID' TEXT," + // 1: id
                "'NAME' TEXT," + // 2: name
                "'PUBLIC_IMAGE' TEXT," + // 3: publicImage
                "'DESCRIPTION' TEXT," + // 4: description
                "'LAST_DOWNLOADED_TIME' TEXT);"); // 5: lastDownloadedTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'BRAND'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Brand entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTableId());
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String publicImage = entity.getPublicImage();
        if (publicImage != null) {
            stmt.bindString(4, publicImage);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        String lastDownloadedTime = entity.getLastDownloadedTime();
        if (lastDownloadedTime != null) {
            stmt.bindString(6, lastDownloadedTime);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Brand readEntity(Cursor cursor, int offset) {
        Brand entity = new Brand( //
            cursor.getLong(offset + 0), // tableId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // publicImage
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // description
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // lastDownloadedTime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Brand entity, int offset) {
        entity.setTableId(cursor.getLong(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPublicImage(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLastDownloadedTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Brand entity, long rowId) {
        entity.setTableId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Brand entity) {
        if(entity != null) {
            return entity.getTableId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    @Override
    public void insertOrReplaceInTx(Iterable<Brand> entities,
    		boolean setPrimaryKey) {
    	super.insertOrReplaceInTx(entities, setPrimaryKey);
    }
}
