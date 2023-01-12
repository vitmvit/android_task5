package com.clevertec.task5.util;

import com.clevertec.task5.model.Markers;

import java.util.Collections;
import java.util.List;

public class MarkerSorter {

    public List<Markers> sortMarkersList(List<Markers> list, double x, double y) {
        for (Markers m : list) {
            m.setDistance(x, y);
        }
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - 1 - i; j++)
                if (list.get(j).getDistance() > list.get(j + 1).getDistance()) {
                    Collections.swap(list, list.indexOf(list.get(j)), list.indexOf(list.get(j + 1)));
                }
        return list;
    }
}
