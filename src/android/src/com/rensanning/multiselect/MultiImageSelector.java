package com.rensanning.multiselect;

import java.util.ArrayList;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

public class MultiImageSelector extends CordovaPlugin {
    
    public static String TAG = "MultiImageSelector";

    private CallbackContext callbackContext;
    private JSONObject params;

    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        this.params = args.getJSONObject(0);
        if (action.equals("getPictures")) {
            Intent intent = new Intent(cordova.getActivity(), CustomGalleryActivity.class);
            int max = 15;
            String cancelButtonText = "Cancel";
            String okButtonText = "Done";
            String titleText = "Gallery";
            String errorMessageText = "Max limit reached!";
            String type = "multiple";
            int requestCode=0;

            LOG.d(TAG, "params: " + params);
            if (this.params.has("limit")) {
                max = this.params.getInt("limit");
            }
            if (this.params.has("cancelButtonText")) {
                cancelButtonText = this.params.getString("cancelButtonText");
            }
            if (this.params.has("okButtonText")) {
                okButtonText = this.params.getString("okButtonText");
            }
            if (this.params.has("titleText")) {
                titleText = this.params.getString("titleText");
            }
            if (this.params.has("errorMessageText")) {
                errorMessageText = this.params.getString("errorMessageText");
            }
            if (this.params.has("type")) {
                type = this.params.getString("type");
            }
            intent.putExtra("limit", max);
            intent.putExtra("cancelButtonText", cancelButtonText);
            intent.putExtra("okButtonText", okButtonText);
            intent.putExtra("titleText", titleText);
            intent.putExtra("errorMessageText", errorMessageText);
            if (type.equalsIgnoreCase("multiple")) {
                intent.putExtra("action", "luminous.ACTION_MULTIPLE_PICK");
                requestCode=200;
            } else {
                intent.putExtra("action", "luminous.ACTION_PICK");
                requestCode=100;
            }
            if (this.cordova != null) {
                Utility.loadResourceIds(cordova.getActivity());
                this.cordova.startActivityForResult((CordovaPlugin) this, intent, requestCode);
            }
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (resultCode == Activity.RESULT_CANCELED) {
                JSONObject res = new JSONObject();
                res.put("cancelled", true);
                this.callbackContext.success(res);
            } else if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
                String single_path = data.getStringExtra("single_path");
                JSONObject res = new JSONObject();
                res.put("cancelled", false);
                res.put("path", single_path);
                this.callbackContext.success(res);
            } else if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
                String[] fileNames = data.getStringArrayExtra("all_path");
                JSONArray p = new JSONArray();
                for(int i = 0;i < fileNames.length; i++) {
                    p.put(fileNames[i]);
                }
                JSONObject res = new JSONObject();
                res.put("cancelled", false);
                res.put("paths", p);
                this.callbackContext.success(res);
            } else {
                this.callbackContext.error("Error!");
            }
        } catch (JSONException e) {
        }
    }
}
