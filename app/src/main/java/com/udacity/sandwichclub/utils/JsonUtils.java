package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich;
        JSONObject name;
        String mainName = null;
        List<String> alsoKnownAs = null;
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = null;

        try {
            JSONObject jObject = new JSONObject(json);
            name = jObject.getJSONObject("name");
            mainName = name.getString("mainName");

            JSONArray JA_alsoKnownAs = name.getJSONArray("alsoKnownAs");
            alsoKnownAs = new ArrayList<>();

            if (JA_alsoKnownAs.length() != 0){
                for (int i = 0; i < JA_alsoKnownAs.length(); i++) {
                    alsoKnownAs.add(JA_alsoKnownAs.getString(i));
                }
            }

            placeOfOrigin = jObject.getString("placeOfOrigin");
            description = jObject.getString("description");
            image = jObject.getString("image");

            JSONArray ingredients_JA = jObject.getJSONArray("ingredients");
            ingredients = new ArrayList<>();

            if (ingredients_JA.length() != 0) {
                for (int i = 0; i < ingredients_JA.length(); i++) {
                    ingredients.add(ingredients_JA.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;
    }

}
