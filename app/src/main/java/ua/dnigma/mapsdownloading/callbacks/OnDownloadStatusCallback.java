package ua.dnigma.mapsdownloading.callbacks;

/**
 * Created by Даниил on 29.01.2018.
 */

public interface OnDownloadStatusCallback {

    void onDownLoadedStarted();
    void onDownLoadProgress(int totallSize, int currentProgress);
}
