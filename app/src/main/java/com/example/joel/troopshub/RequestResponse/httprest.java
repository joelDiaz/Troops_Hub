package com.example.joel.troopshub.RequestResponse;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



/**
 * Created by AndriodDeveloper02 on 7/6/16.
 */
public class httprest {


    public static final String TAG = httprest.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    public String serve ="http://192.168.5.103/";

    //realizar la peticon y asignaer tag
    public RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req,Context context,String tag) {
        // asigna un valor a tag si tag está vacío
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue(context).add(req);
    }

    public <T> void addToRequestQueue(Request<T> req, Context context) {
        req.setTag(TAG);
        getRequestQueue(context).add(req);
    }
//    public ImageLoader getImageLoader() {
//        getRequestQueue();
//        if (mImageLoader == null) {
//            mImageLoader = new ImageLoader(this.mRequestQueue,
//                    new LruBitmapCache());
//        }
//        return this.mImageLoader;
//    }

//    public boolean cachehttp(Context context,String url){
//        Cache cache = getRequestQueue(context).getCache();
//        Log.e("cache1111111", String.valueOf(cache));
//        Cache.Entry entry = cache.get(url);
//        Log.e("cache2222", String.valueOf(entry));
//
//        if(entry != null){
//            try {
//                String data = new String(entry.data, "UTF-8");
//                // Gestionar datos, como convertir a XML, JSON, bitmap, etc.
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            return true;
//        }else{
//            return false;
//// No existe la respuesta en caché. Hacer la llamada online aquí.
//        }
//    }

    //cancelar una peticion
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }



    public void post (Context context, String url, final Map<String,String> map, final Listener listener)
    {
        String url2 = serve+url;
        String tag_json_obj = "string_obj";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.getResult(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("vError",String.valueOf(error));
//                listener.getResult(error);
            }
        }) {
            @Override
            protected Map<String,String> getParams()
            {
                return map;
            }
        };
        addToRequestQueue(postRequest,context, tag_json_obj);

    }

    public void getjson (Context context, String url,String tag,final Listener listener)
    {
        String url2 = serve+url;
        Request postRequest2 = new JsonArrayRequest(Request.Method.GET, url2,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listener.getResult(response);
                      }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e("vError",String.valueOf(error));
//                listener.getResult(error);

            }
        });
        addToRequestQueue(postRequest2,context, tag);
    }

    public void ddddjson (Context context, String url,String tag,final Response.Listener<JSONObject> callback)
    {
        String url2 = serve+url;
        Log.e("r2o", String.valueOf(callback));
        Request sss = new JsonObjectRequest(Request.Method.GET, url2,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("ro", String.valueOf(response));

//                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e("vError",String.valueOf(error));
//                listener.getResult(error);

            }
        });
        addToRequestQueue(sss,context, tag);
    }


    public JSONArray retunrjson(String json) throws JSONException {
        JSONArray w = new JSONArray(json);
        return w;
    }

}
