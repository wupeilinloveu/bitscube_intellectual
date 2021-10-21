package cn.com.bitscube_intellectual.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Gson转化工具类
 * Created by Emily on 9/6/21
 */
public class GsonUtil {
    /**
     * 转化成bean
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t;
        Gson gson = new Gson();
        t = gson.fromJson(gsonString, cls);
        return t;
    }

    /**
     * 转化成list
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();
        for (final JsonElement elem : array) {
            mList.add(gson.fromJson(elem, cls));
        }
        return mList;
    }
}

