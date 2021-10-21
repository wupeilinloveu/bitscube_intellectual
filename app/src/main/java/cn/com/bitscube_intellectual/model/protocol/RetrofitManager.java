package cn.com.bitscube_intellectual.model.protocol;

import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.com.bitscube_intellectual.common.base.Global;
import cn.com.bitscube_intellectual.common.util.NetWorkUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit管理的类
 * Created by Emily on 9/6/21
 */
public class RetrofitManager {
    private IHttpService mHttpService;

    private void initRetrofit() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        //添加请求头
//        client.interceptors().add(new TokenInterceptor());
        //Set interceptor, print log
//        if (LogUtil.mDebug) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            //Print request header and returned data.
//            interceptor.level(HttpLoggingInterceptor.Level.BODY);
//            client.addInterceptor(interceptor);
//        }
        //添加网络
        client.addInterceptor(provideOfflineCacheInterceptor())
                .addNetworkInterceptor(provideCacheInterceptor())
                .connectTimeout(60, TimeUnit.SECONDS)
                .cache(provideCache());

        Retrofit mRetrofit = new Retrofit.Builder()
//                .baseUrl(IHttpService.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        mHttpService = mRetrofit.create(IHttpService.class);
    }

    //设置缓存目录和缓存空间大小
    private static Cache provideCache() {
        Cache cache = null;
        try {
            // preserve cached data
            cache = new Cache(new File(Global.mContext.getExternalCacheDir(), "http-cache"),
                    200 * 1024 * 1024); // 200 MB
        } catch (Exception e) {
//            Log.e("cache", "Could not create Cache!");
        }
        return cache;
    }

    private static Interceptor provideOfflineCacheInterceptor() {
        return chain -> {
            Request request = chain.request();

            if (!NetWorkUtil.isNetAvailable(Global.mContext)) {
                //缓存有效时间为3600秒
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(3600, TimeUnit.SECONDS)
                        .build();

                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }

            return chain.proceed(request);
        };
    }

    private static Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());
            // 重写响应头以强制使用缓存
            // 缓存有效时间为3600秒
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(3600, TimeUnit.SECONDS)
                    .build();

            return response.newBuilder()
                    .header("CACHE_CONTROL", cacheControl.toString())
                    .build();
        };
    }

    public IHttpService getHttpService() {
        return mHttpService;
    }

    private RetrofitManager() {
        initRetrofit();
    }

    private static class SingleHolder {
        static RetrofitManager instance = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return SingleHolder.instance;
    }
}

