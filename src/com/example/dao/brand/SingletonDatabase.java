package com.example.dao.brand;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SingletonDatabase {
	
	private static SingletonDatabase mInstance;
	private DaoMaster.OpenHelper mHelper;
	private DaoSession mDaoSessionForUI;
	private DaoMaster mDaoMaster;
    private static Context mCtx;

    private SingletonDatabase(Context context) {
        mCtx = context;
        setupDb();
    }

    public static synchronized SingletonDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SingletonDatabase(context);
        }
        return mInstance;
    }
    
    private void setupDb() {
        mHelper = new DaoMaster.OpenHelper(
        		mCtx.getApplicationContext(), "mydb", null) {

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion,
                    int newVersion) {
                // Handle upgrade
            }
        };
              
        SQLiteDatabase db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSessionForUI = mDaoMaster.newSession();
        

    }

    public DaoSession getDaoSessionForUI() {
    	return mDaoSessionForUI;

    }
    
    public DaoSession getDaoSeesion(){
    	
    	return mDaoMaster.newSession();
    }
    
}
