package com.team2052.frckrawler.database.subscribers;

import com.team2052.frckrawler.db.Team;
import com.team2052.frckrawler.listitems.ListItem;
import com.team2052.frckrawler.listitems.elements.TeamListElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 11/20/2015.
 */
public class TeamListSubscriber extends BaseDataSubscriber<List<Team>, List<ListItem>> {
    @Override
    public void parseData() {
        dataToBind = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) dataToBind.add(new TeamListElement(data.get(i)));
    }
}