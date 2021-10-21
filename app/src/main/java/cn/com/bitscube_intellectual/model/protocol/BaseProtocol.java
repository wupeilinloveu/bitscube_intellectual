package cn.com.bitscube_intellectual.model.protocol;

import android.os.Message;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 封装的Protocol类
 * Created by Emily on 9/6/21
 */
public class BaseProtocol {
    private final IHttpService mHttpService;
    private String errorMessage;

    public IHttpService getService() {
        return mHttpService;
    }

    public BaseProtocol() {
        mHttpService = RetrofitManager.getInstance().getHttpService();
    }

    /**
     * 执行网络请求
     * @param call
     * @param callback
     * @param reqType 请求的是哪一个接口
     * @param clazz 请求json字符串后得到的javabean对象的类型
     * @param what 用来区分不同网络请求的一个参数，比如用来区分是下拉刷新还是加载更多
     * 大部分情况下，此参数用不到
     */
    public <T> void execute(Call<JsonObject> call,
                            final HttpCallback callback,
                            final int reqType,
                            final Class<T> clazz,
                            final int what) {

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                int code = response.code();
                if (code >= 500) {
                    callback.onServerError(reqType);
                    return;
                }else if (response.body() == null) {
                    try {
                        String str = Objects.requireNonNull(response.errorBody()).string();
                        JSONObject jsonObject = new JSONObject(str);
                        JSONArray message = jsonObject.getJSONArray("msg");

                        ArrayList<String> error = new ArrayList<>();
                        for (int i = 0; i < message.length(); i++) {
                            errorMessage = message.get(i).toString();
                            error.add(errorMessage);
                        }
                        callback.onHttpError(reqType, code, error);

                        StringBuilder sb = new StringBuilder();
                        for (Object obj : error) {
                            sb.append(obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }

                String json = response.body().toString();
                //手动解析json数据
                try {
                    //请求成功
                    if (response.isSuccessful()) {
                        if (callback != null) {
                            Message msg = new Message();
                            msg.obj = json;
                            msg.what = what;
                            callback.onHttpSuccess(reqType, msg);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                callback.onHttpFailure(reqType);
            }
        });
    }

    public <T> void execute(Call<JsonObject> call,
                            final HttpCallback callback,
                            final int reqType,
                            final Class<T> clazz) {
        execute(call, callback, reqType, clazz, 0);
    }


    /**
     * 网络请求回调接口
     */
    public interface HttpCallback {
        /**
         * 请求成功
         * @param reqType 请求哪一个接口
         * @param msg 请求返回的javabean对象
         */
        void onHttpSuccess(int reqType, Message msg);

        /**
         * 请求失败
         * @param reqType 请求哪一个接口
         * @param error 失败原因
         */
        void onHttpError(int reqType, int code, ArrayList<String> error);

        /**
         * 请求timeout超时
         * @param reqType 请求哪一个接口
         */
        void onHttpFailure(int reqType);

        /**
         * 请求服务器失败
         * @param reqType 请求哪一个接口
         */
        void onServerError(int reqType);
    }
}


