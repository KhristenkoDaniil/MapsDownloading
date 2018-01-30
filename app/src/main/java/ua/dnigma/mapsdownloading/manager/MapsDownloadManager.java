package ua.dnigma.mapsdownloading.manager;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;

/**
 * Created by Даниил on 29.01.2018.
 */

public class MapsDownloadManager {
    Context context;
    private DownloadManager downloadManager;
    boolean isDownloading;

    public MapsDownloadManager(Context context, DownloadManager downloadManager) {
        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        this.context = context;
    }

    Uri image_uri = Uri.parse("http://androidtutorialpoint.comli.com/DownloadManager/Beauty.jpg");

    public void startDownload(Uri uri){
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setAllowedOverRoaming(false);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setDescription("Text");
        request.setTitle("Texxt2");

        request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "name");

        long id = downloadManager.enqueue(request);
        isDownloading = true;

    }

    public void checkStatus (long id) {

        while (isDownloading) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(id);
            Cursor cursor = downloadManager.query(query);
            cursor.moveToFirst();
            int bytes_downloaded = cursor.getInt(cursor
                    .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
            int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
            if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                isDownloading = false;
            }
        }
    }

    public void cancelDownload(Long id) {

    }
}

