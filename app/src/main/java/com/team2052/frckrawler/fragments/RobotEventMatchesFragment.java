package com.team2052.frckrawler.fragments;

import android.os.Bundle;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.team2052.frckrawler.database.metric.Compiler;
import com.team2052.frckrawler.db.Event;
import com.team2052.frckrawler.db.Robot;
import com.team2052.frckrawler.subscribers.StringListSubscriber;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class RobotEventMatchesFragment extends ListViewFragment<List<String>, StringListSubscriber> {
    public static final String ROBOT_ID = "ROBOT_ID";
    public static final String EVENT_ID = "EVENT_ID";
    @Inject
    Compiler compiler;
    private long robot_id, event_id;

    public static RobotEventMatchesFragment newInstance(long robot_id, long event_id) {
        RobotEventMatchesFragment robotEventMatchesFragment = new RobotEventMatchesFragment();
        Bundle args = new Bundle();
        args.putLong(ROBOT_ID, robot_id);
        args.putLong(EVENT_ID, event_id);
        robotEventMatchesFragment.setArguments(args);
        return robotEventMatchesFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        robot_id = getArguments().getLong(ROBOT_ID);
        event_id = getArguments().getLong(EVENT_ID);
    }

    @Override
    public void inject() {
        mComponent.inject(this);
    }

    @Override
    protected Observable<? extends List<String>> getObservable() {
        return Observable.defer(() -> {
            Robot robot = rxDbManager.getRobotsTable().load(robot_id);
            Event event = rxDbManager.getEventsTable().load(event_id);
            return compiler.getMatchNumbers(event, robot)
                    .map(matchNumbers -> Lists.transform(matchNumbers, Functions.toStringFunction()));
        });
    }
}
