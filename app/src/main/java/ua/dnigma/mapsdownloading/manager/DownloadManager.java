package ua.dnigma.mapsdownloading.manager;

import android.net.Uri;
import android.view.View;

import java.net.URI;

import ua.dnigma.mapsdownloading.R;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by Даниил on 28.01.2018.
 */

public class DownloadManager {

    Uri mapsUri = Uri.parse("http://download.osmand.net/download.php?standard=yes&file=France_corse_europe_2.obf.zip");


    private long DownloadData (Uri uri, View v) {

        long downloadReference;
        DownloadManager downloadManager:

        // Create request for android download manager
        downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        //Setting title of request
        request.setTitle("Data Download");

        //Setting description of request
        request.setDescription("Android Data download using DownloadManager.");

        //Set the local destination for the downloaded file to a path within the application's external files directory
        if(v.getId() == R.id.DownloadMusic)
            request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS,"AndroidTutorialPoint.mp3");
        else if(v.getId() == R.id.DownloadImage)
            request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS,"AndroidTutorialPoint.jpg");

        //Enqueue download and save into referenceId
        downloadReference = downloadManager.enqueue(request);

        Button DownloadStatus = (Button) findViewById(R.id.DownloadStatus);
        DownloadStatus.setEnabled(true);
        Button CancelDownload = (Button) findViewById(R.id.CancelDownload);
        CancelDownload.setEnabled(true);

        return downloadReference;
    }

}
