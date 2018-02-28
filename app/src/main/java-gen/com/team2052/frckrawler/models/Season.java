package com.team2052.frckrawler.models;

import org.greenrobot.greendao.annotation.*;

import java.util.List;

import com.team2052.frckrawler.models.DaoSession;

import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "SEASON".
 */
@Entity(active = true)
public class Season implements java.io.Serializable {

    @Id(autoincrement = true)
    @Unique
    private Long id;
    private String name;

    /**
     * Used to resolve relations
     */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient SeasonDao myDao;

    @ToMany(joinProperties = {
            @JoinProperty(name = "id", referencedName = "season_id")
    })
    private List<Event> eventList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "id", referencedName = "season_id")
    })
    private List<Robot> robotList;

    @ToMany(joinProperties = {
            @JoinProperty(name = "id", referencedName = "season_id")
    })
    private List<Metric> metricList;

    @Generated
    public Season() {
    }

    public Season(Long id) {
        this.id = id;
    }

    @Generated
    public Season(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSeasonDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Event> getEventList() {
        if (eventList == null) {
            __throwIfDetached();
            EventDao targetDao = daoSession.getEventDao();
            List<Event> eventListNew = targetDao._querySeason_EventList(id);
            synchronized (this) {
                if (eventList == null) {
                    eventList = eventListNew;
                }
            }
        }
        return eventList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetEventList() {
        eventList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Robot> getRobotList() {
        if (robotList == null) {
            __throwIfDetached();
            RobotDao targetDao = daoSession.getRobotDao();
            List<Robot> robotListNew = targetDao._querySeason_RobotList(id);
            synchronized (this) {
                if (robotList == null) {
                    robotList = robotListNew;
                }
            }
        }
        return robotList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetRobotList() {
        robotList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Metric> getMetricList() {
        if (metricList == null) {
            __throwIfDetached();
            MetricDao targetDao = daoSession.getMetricDao();
            List<Metric> metricListNew = targetDao._querySeason_MetricList(id);
            synchronized (this) {
                if (metricList == null) {
                    metricList = metricListNew;
                }
            }
        }
        return metricList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetMetricList() {
        metricList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}