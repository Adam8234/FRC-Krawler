package com.team2052.frckrawler.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * Master of DAO (schema version 4): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 4;

    public DaoMaster(SQLiteDatabase db) {
        this(new StandardDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(GameDao.class);
        registerDaoClass(EventDao.class);
        registerDaoClass(TeamDao.class);
        registerDaoClass(MetricDao.class);
        registerDaoClass(MatchDao.class);
        registerDaoClass(MatchDataDao.class);
        registerDaoClass(MatchCommentDao.class);
        registerDaoClass(RobotDao.class);
        registerDaoClass(RobotEventDao.class);
        registerDaoClass(PitDataDao.class);
    }

    /**
     * Creates underlying database table using DAOs.
     */
    public static void createAllTables(Database db, boolean ifNotExists) {
        GameDao.createTable(db, ifNotExists);
        EventDao.createTable(db, ifNotExists);
        TeamDao.createTable(db, ifNotExists);
        MetricDao.createTable(db, ifNotExists);
        MatchDao.createTable(db, ifNotExists);
        MatchDataDao.createTable(db, ifNotExists);
        MatchCommentDao.createTable(db, ifNotExists);
        RobotDao.createTable(db, ifNotExists);
        RobotEventDao.createTable(db, ifNotExists);
        PitDataDao.createTable(db, ifNotExists);
    }

    /**
     * Drops underlying database table using DAOs.
     */
    public static void dropAllTables(Database db, boolean ifExists) {
        GameDao.dropTable(db, ifExists);
        EventDao.dropTable(db, ifExists);
        TeamDao.dropTable(db, ifExists);
        MetricDao.dropTable(db, ifExists);
        MatchDao.dropTable(db, ifExists);
        MatchDataDao.dropTable(db, ifExists);
        MatchCommentDao.dropTable(db, ifExists);
        RobotDao.dropTable(db, ifExists);
        RobotEventDao.dropTable(db, ifExists);
        PitDataDao.dropTable(db, ifExists);
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     * Convenience method using a {@link DevOpenHelper}.
     */
    public static DaoSession newDevSession(Context context, String name) {
        Database db = new DevOpenHelper(context, name).getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }

    /**
     * Calls {@link #createAllTables(Database, boolean)} in {@link #onCreate(Database)} -
     */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String name) {
            super(context, name, SCHEMA_VERSION);
        }

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

}
