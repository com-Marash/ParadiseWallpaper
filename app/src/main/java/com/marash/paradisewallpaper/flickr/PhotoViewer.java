package com.marash.paradisewallpaper.flickr;

import com.marash.paradisewallpaper.flickr.api.Photo;

import java.util.List;

/**
 * An interface for an object that displays {@link com.marash.paradisewallpaper.flickr.api.Photo}
 * objects.
 */
interface PhotoViewer {
  /**
   * Called whenever new {@link com.marash.paradisewallpaper.flickr.api.Photo}s are loaded.
   *
   * @param photos The loaded photos.
   */
  void onPhotosUpdated(List<Photo> photos);
}
