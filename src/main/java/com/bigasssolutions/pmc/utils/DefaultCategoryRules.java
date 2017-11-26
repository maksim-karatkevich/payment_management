package com.bigasssolutions.pmc.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maksim on 11/26/2017.
 */
public class DefaultCategoryRules {

    private static Map<String, String> rules = new HashMap<>();

    public static Map<String, String> getRules() {
        rules.put("Retail BLR MINSK KRASAVIK", "Food");
        rules.put("ATM BLR MINSK ATM 825", "Fuel");
        rules.put("Retail BLR MINSK SIGARETNET", "Smoke");
        rules.put("Retail BLR Minsk Dominospizza", "Pizza");
        rules.put("Retail BLR MINSK PIZZA LISIZA", "Pizza");
        return rules;
    }


}
