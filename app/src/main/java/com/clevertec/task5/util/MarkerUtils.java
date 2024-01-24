package com.clevertec.task5.util;

import com.clevertec.task5.dto.ApiData;
import com.clevertec.task5.dto.impl.AtmDto;
import com.clevertec.task5.dto.impl.FilialDto;
import com.clevertec.task5.dto.impl.InfoboxDto;

import static com.clevertec.task5.constants.Constants.*;

public class MarkerUtils {

    public static String getTypeObject(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ATM_TITLE;
        } else if (apiData instanceof FilialDto) {
            return FILIAL_TITLE;
        } else if (apiData instanceof InfoboxDto) {
            return INFOBOX_TITLE;
        }
        return DEFAULT_TITLE;
    }

    public static String getAddressType(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ((AtmDto) apiData).getAddressType();
        } else if (apiData instanceof FilialDto) {
            return ((FilialDto) apiData).getStreetType();
        } else if (apiData instanceof InfoboxDto) {
            return ((InfoboxDto) apiData).getAddressType();
        }
        return DEFAULT_ADDRESS_TYPE;
    }

    public static String getAddress(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ((AtmDto) apiData).getAddress();
        } else if (apiData instanceof FilialDto) {
            return ((FilialDto) apiData).getStreet();
        } else if (apiData instanceof InfoboxDto) {
            return ((InfoboxDto) apiData).getAddress();
        }
        return DEFAULT_ADDRESS;
    }

    public static String getHouse(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ((AtmDto) apiData).getHouse();
        } else if (apiData instanceof FilialDto) {
            return ((FilialDto) apiData).getHomeNumber();
        } else if (apiData instanceof InfoboxDto) {
            return ((InfoboxDto) apiData).getHouse();
        }
        return DEFAULT_HOUSE;
    }

    public static String getGpsX(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ((AtmDto) apiData).getGpsX();
        } else if (apiData instanceof FilialDto) {
            return ((FilialDto) apiData).getGpsX();
        } else if (apiData instanceof InfoboxDto) {
            return ((InfoboxDto) apiData).getGpsX();
        }
        return DEFAULT_GPS_X;
    }

    public static String getGpsY(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ((AtmDto) apiData).getGpsY();
        } else if (apiData instanceof FilialDto) {
            return ((FilialDto) apiData).getGpsY();
        } else if (apiData instanceof InfoboxDto) {
            return ((InfoboxDto) apiData).getGpsY();
        }
        return DEFAULT_GPS_Y;
    }

    public static double findDistance(ApiData apiData, double x, double y) {
        if (apiData instanceof AtmDto) {
            return Math.sqrt(Math.pow(Math.abs(Double.parseDouble(((AtmDto) apiData).getGpsX()) - x), 2) + Math.pow(Math.abs(Double.parseDouble(((AtmDto) apiData).getGpsY()) - y), 2));
        } else if (apiData instanceof FilialDto) {
            return Math.sqrt(Math.pow(Math.abs(Double.parseDouble(((FilialDto) apiData).getGpsX()) - x), 2) + Math.pow(Math.abs(Double.parseDouble(((FilialDto) apiData).getGpsY()) - y), 2));
        } else if (apiData instanceof InfoboxDto) {
            return Math.sqrt(Math.pow(Math.abs(Double.parseDouble(((InfoboxDto) apiData).getGpsX()) - x), 2) + Math.pow(Math.abs(Double.parseDouble(((InfoboxDto) apiData).getGpsY()) - y), 2));
        }
        return DEFAULT_DISTANCE;
    }
}
