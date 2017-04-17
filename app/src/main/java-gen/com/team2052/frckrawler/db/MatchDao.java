package com.team2052.frckrawler.db;

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
 * DAO for table "MATCH".
*/
public class MatchDao extends AbstractDao<Match, Long> {

    public static final String TABLENAME = "MATCH";

    /**
     * Properties of entity Match.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Match_key = new Property(1, String.class, "match_key", false, "MATCH_KEY");
        public final static Property Match_type = new Property(2, String.class, "match_type", false, "MATCH_TYPE");
        public final static Property Match_number = new Property(3, Integer.class, "match_number", false, "MATCH_NUMBER");
        public final static Property Event_id = new Property(4, long.class, "event_id", false, "EVENT_ID");
        public final static Property Data = new Property(5, String.class, "data", false, "DATA");
    }

    private DaoSession daoSession;

    private Query<Match> event_MatchListQuery;

    public MatchDao(DaoConfig config) {
        super(config);
    }
    
    public MatchDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MATCH\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MATCH_KEY\" TEXT UNIQUE ," + // 1: match_key
                "\"MATCH_TYPE\" TEXT," + // 2: match_type
                "\"MATCH_NUMBER\" INTEGER," + // 3: match_number
                "\"EVENT_ID\" INTEGER NOT NULL ," + // 4: event_id
                "\"DATA\" TEXT);"); // 5: data
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MATCH\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Match entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String match_key = entity.getMatch_key();
        if (match_key != null) {
            stmt.bindString(2, match_key);
        }
 
        String match_type = entity.getMatch_type();
        if (match_type != null) {
            stmt.bindString(3, match_type);
        }
 
        Integer match_number = entity.getMatch_number();
        if (match_number != null) {
            stmt.bindLong(4, match_number);
        }
        stmt.bindLong(5, entity.getEvent_id());
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(6, data);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Match entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String match_key = entity.getMatch_key();
        if (match_key != null) {
            stmt.bindString(2, match_key);
        }
 
        String match_type = entity.getMatch_type();
        if (match_type != null) {
            stmt.bindString(3, match_type);
        }
 
        Integer match_number = entity.getMatch_number();
        if (match_number != null) {
            stmt.bindLong(4, match_number);
        }
        stmt.bindLong(5, entity.getEvent_id());
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(6, data);
        }
    }

    @Override
    protected final void attachEntity(Match entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Match readEntity(Cursor cursor, int offset) {
        Match entity = new Match( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // match_key
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // match_type
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // match_number
            cursor.getLong(offset + 4), // event_id
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // data
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Match entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMatch_key(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMatch_type(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMatch_number(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setEvent_id(cursor.getLong(offset + 4));
        entity.setData(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Match entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Match entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Match entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "matchList" to-many relationship of Event. */
    public List<Match> _queryEvent_MatchList(long event_id) {
        synchronized (this) {
            if (event_MatchListQuery == null) {
                QueryBuilder<Match> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Event_id.eq(null));
                event_MatchListQuery = queryBuilder.build();
            }
        }
        Query<Match> query = event_MatchListQuery.forCurrentThread();
        query.setParameter(0, event_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getEventDao().getAllColumns());
            builder.append(" FROM MATCH T");
            builder.append(" LEFT JOIN EVENT T0 ON T.\"EVENT_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Match loadCurrentDeep(Cursor cursor, boolean lock) {
        Match entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Event event = loadCurrentOther(daoSession.getEventDao(), cursor, offset);
         if(event != null) {
            entity.setEvent(event);
        }

        return entity;    
    }

    public Match loadDeep(Long key) {
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
    public List<Match> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Match> list = new ArrayList<Match>(count);
        
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
    
    protected List<Match> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Match> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
