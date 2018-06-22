package demo.cxb.com.greendaodemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

public class DBManager {
    private static final DBManager ourInstance = new DBManager();

    public static DBManager getInstance() {
        return ourInstance;
    }

    DaoMaster.DevOpenHelper mDevOpenHelper;
    SQLiteDatabase mDatabase;
    DaoMaster mDaoMaster;
    DaoSession mDaoSession;

    private DBManager() {


    }

    public void init(Context context) {
        mDevOpenHelper = new MyOpenHelper(context, "books.db", null);
        mDatabase = mDevOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(mDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }


    public static class MyOpenHelper extends DaoMaster.DevOpenHelper {

        public MyOpenHelper(Context context, String name) {
            super(context, name);
        }

        public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {

            //noinspection unchecked
            MigrationHelper.migrate(db,
                                    BookDao.class
            );
        }
    }

}
