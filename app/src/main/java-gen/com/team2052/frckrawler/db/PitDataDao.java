package com.team2052.frckrawler.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "PIT_DATA".
 */
public class PitDataDao extends AbstractDao<PitData, Long> {

    public static final String TABLENAME = "PIT_DATA";
    private DaoSession daoSession;
    private Query<PitData> event_PitDataListQuery;
    private Query<PitData> robot_PitDataListQuery;
    private Query<PitData> metric_PitDataListQuery;
    private String selectDeep;

    public PitDataDao(DaoConfig config) {
        super(config);
    }

    public PitDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"PIT_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ROBOT_ID\" INTEGER NOT NULL ," + // 1: robot_id
                "\"METRIC_ID\" INTEGER NOT NULL ," + // 2: metric_id
                "\"EVENT_ID\" INTEGER NOT NULL ," + // 3: event_id
                "\"DATA\" TEXT," + // 4: data
                "\"LAST_UPDATED\" INTEGER);"); // 5: last_updated
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PIT_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PitData entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getRobot_id());
        stmt.bindLong(3, entity.getMetric_id());
        stmt.bindLong(4, entity.getEvent_id());

        String data = entity.getData();
        if (data != null) {
            stmt.bindString(5, data);
        }

        java.util.Date last_updated = entity.getLast_updated();
        if (last_updated != null) {
            stmt.bindLong(6, last_updated.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PitData entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getRobot_id());
        stmt.bindLong(3, entity.getMetric_id());
        stmt.bindLong(4, entity.getEvent_id());

        String data = entity.getData();
        if (data != null) {
            stmt.bindString(5, data);
        }

        java.util.Date last_updated = entity.getLast_updated();
        if (last_updated != null) {
            stmt.bindLong(6, last_updated.getTime());
        }
    }

    @Override
    protected final void attachEntity(PitData entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    public PitData readEntity(Cursor cursor, int offset) {
        PitData entity = new PitData( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.getLong(offset + 1), // robot_id
                cursor.getLong(offset + 2), // metric_id
                cursor.getLong(offset + 3), // event_id
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // data
                cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)) // last_updated
        );
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, PitData entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRobot_id(cursor.getLong(offset + 1));
        entity.setMetric_id(cursor.getLong(offset + 2));
        entity.setEvent_id(cursor.getLong(offset + 3));
        entity.setData(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLast_updated(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
    }

    @Override
    protected final Long updateKeyAfterInsert(PitData entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    @Override
    public Long getKey(PitData entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PitData entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

    /**
     * Internal query to resolve the "pitDataList" to-many relationship of Event.
     */
    public List<PitData> _queryEvent_PitDataList(long event_id) {
        synchronized (this) {
            if (event_PitDataListQuery == null) {
                QueryBuilder<PitData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Event_id.eq(null));
                event_PitDataListQuery = queryBuilder.build();
            }
        }
        Query<PitData> query = event_PitDataListQuery.forCurrentThread();
        query.setParameter(0, event_id);
        return query.list();
    }

    /**
     * Internal query to resolve the "pitDataList" to-many relationship of Robot.
     */
    public List<PitData> _queryRobot_PitDataList(long robot_id) {
        synchronized (this) {
            if (robot_PitDataListQuery == null) {
                QueryBuilder<PitData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Robot_id.eq(null));
                robot_PitDataListQuery = queryBuilder.build();
            }
        }
        Query<PitData> query = robot_PitDataListQuery.forCurrentThread();
        query.setParameter(0, robot_id);
        return query.list();
    }

    /**
     * Internal query to resolve the "pitDataList" to-many relationship of Metric.
     */
    public List<PitData> _queryMetric_PitDataList(long metric_id) {
        synchronized (this) {
            if (metric_PitDataListQuery == null) {
                QueryBuilder<PitData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Metric_id.eq(null));
                metric_PitDataListQuery = queryBuilder.build();
            }
        }
        Query<PitData> query = metric_PitDataListQuery.forCurrentThread();
        query.setParameter(0, metric_id);
        return query.list();
    }

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getRobotDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getMetricDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getEventDao().getAllColumns());
            builder.append(" FROM PIT_DATA T");
            builder.append(" LEFT JOIN ROBOT T0 ON T.\"ROBOT_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN METRIC T1 ON T.\"METRIC_ID\"=T1.\"_id\"");
            builder.append(" LEFT JOIN EVENT T2 ON T.\"EVENT_ID\"=T2.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected PitData loadCurrentDeep(Cursor cursor, boolean lock) {
        PitData entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Robot robot = loadCurrentOther(daoSession.getRobotDao(), cursor, offset);
        if (robot != null) {
            entity.setRobot(robot);
        }
        offset += daoSession.getRobotDao().getAllColumns().length;

        Metric metric = loadCurrentOther(daoSession.getMetricDao(), cursor, offset);
        if (metric != null) {
            entity.setMetric(metric);
        }
        offset += daoSession.getMetricDao().getAllColumns().length;

        Event event = loadCurrentOther(daoSession.getEventDao(), cursor, offset);
        if (event != null) {
            entity.setEvent(event);
        }

        return entity;
    }

    public PitData loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[]{key.toString()};
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

    /**
     * Reads all available rows from the given cursor and returns a list of new ImageTO objects.
     */
    public List<PitData> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PitData> list = new ArrayList<PitData>(count);

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

    protected List<PitData> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /**
     * A raw-style query where you can pass any WHERE clause and arguments.
     */
    public List<PitData> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

    /**
     * Properties of entity PitData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Robot_id = new Property(1, long.class, "robot_id", false, "ROBOT_ID");
        public final static Property Metric_id = new Property(2, long.class, "metric_id", false, "METRIC_ID");
        public final static Property Event_id = new Property(3, long.class, "event_id", false, "EVENT_ID");
        public final static Property Data = new Property(4, String.class, "data", false, "DATA");
        public final static Property Last_updated = new Property(5, java.util.Date.class, "last_updated", false, "LAST_UPDATED");
    }

}
