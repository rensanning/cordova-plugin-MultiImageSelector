package com.rensanning.multiselect;

import android.content.Context;
import android.content.res.Resources;

public final class Utility {
    public static int resId_galleryLayout = -1;
    public static int resId_gridGallery = -1;
    public static int resId_bottomContainer = -1;
    public static int resId_imgNoMedia = -1;
    public static int resId_btnGalleryOk = -1;
    public static int resId_btnGalleryCancel = -1;
    public static int resId_tvTitleText = -1;
    public static int resId_gallery_itemLayout = -1;
    public static int resId_imgQueue = -1;
    public static int resId_imgQueueMultiSelected = -1;
    public static int resId_no_media = -1;
    public static int resId_mainLayout = -1;
    public static int resId_viewSwitcher = -1;
    public static int resId_imgSinglePick = -1;
    public static int resId_btnGalleryPick = -1;
    public static int resId_btnGalleryPickMul = -1;

	public static void loadResourceIds(Context context) {
		String packageName = context.getPackageName();
		Resources resources = context.getResources();
	    resId_galleryLayout = resources.getIdentifier("gallery", "layout", packageName);
	    resId_gridGallery = resources.getIdentifier("gridGallery", "id", packageName);
	    resId_bottomContainer = resources.getIdentifier("llBottomContainer", "id", packageName);
	    resId_imgNoMedia = resources.getIdentifier("imgNoMedia", "id", packageName);
	    resId_btnGalleryOk = resources.getIdentifier("btnGalleryOk", "id", packageName);
	    resId_btnGalleryCancel = resources.getIdentifier("btnGalleryCancel", "id", packageName);
	    resId_tvTitleText = resources.getIdentifier("tvTitleText", "id", packageName);
	    resId_gallery_itemLayout = resources.getIdentifier("gallery_item", "layout", packageName);
	    resId_imgQueue = resources.getIdentifier("imgQueue", "id", packageName);
	    resId_imgQueueMultiSelected = resources.getIdentifier("imgQueueMultiSelected", "id", packageName);
	    resId_no_media = resources.getIdentifier("no_media", "drawable", packageName);
	    resId_mainLayout = resources.getIdentifier("main", "layout", packageName);
	    resId_viewSwitcher = resources.getIdentifier("viewSwitcher", "id", packageName);
	    resId_imgSinglePick = resources.getIdentifier("imgSinglePick", "id", packageName);
	    resId_btnGalleryPick = resources.getIdentifier("btnGalleryPick", "id", packageName);
	    resId_btnGalleryPickMul = resources.getIdentifier("btnGalleryPickMul", "id", packageName);
	}
}
