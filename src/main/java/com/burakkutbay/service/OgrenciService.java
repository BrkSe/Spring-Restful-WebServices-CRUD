package com.burakkutbay.service;

import com.burakkutbay.bean.Ogrenci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hasanburakkutbay on 13.03.2017.
 */
public class OgrenciService {

    private static HashMap<Integer, Ogrenci> ogrenciHashMap = getOgrenciHashMap();

    public OgrenciService() {
        super();
        if (ogrenciHashMap == null) {

            ogrenciHashMap = new HashMap<Integer, Ogrenci>();

            Ogrenci ogrenci1 = new Ogrenci(1, "Burak", "Kutbay", "Fen");
            Ogrenci ogrenci2 = new Ogrenci(2, "Ali", "Doğru", "Edebiyat");
            Ogrenci ogrenci3 = new Ogrenci(3, "Veli", "Yanlış", "Biyoloji");
            Ogrenci ogrenci4 = new Ogrenci(4, "Ahmet", "Mehmet", "Matematik");

            ogrenciHashMap.put(1, ogrenci1);
            ogrenciHashMap.put(2, ogrenci2);
            ogrenciHashMap.put(3, ogrenci3);
            ogrenciHashMap.put(4, ogrenci4);
        }
    }

    public static int getMaximumId() {
        int max = 0;
        for (int id : ogrenciHashMap.keySet()) {
            if (max <= id) {
                max = id;
            }
        }
        return max;
    }

    public static HashMap<Integer, Ogrenci> getOgrenciHashMap() {
        return ogrenciHashMap;
    }

    public List<Ogrenci> getAllOgrenciler() {
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>(ogrenciHashMap.values());
        return ogrenciler;
    }

    public Ogrenci getOgrenci(int id) {
        Ogrenci ogrenci = ogrenciHashMap.get(id);
        return ogrenci;
    }

    public Ogrenci ekleOgrenci(Ogrenci ogrenci) {
        ogrenci.setId(getMaximumId() + 1);
        ogrenciHashMap.put(ogrenci.getId(), ogrenci);
        return ogrenci;
    }

    public Ogrenci guncelleOgrenci(Ogrenci ogrenci) {
        if (ogrenci.getId() <= 0)
            return null;
        ogrenciHashMap.put(ogrenci.getId(), ogrenci);
        return ogrenci;
    }

    public void silOgrenci(int id) {
        ogrenciHashMap.remove(id);
    }
}
