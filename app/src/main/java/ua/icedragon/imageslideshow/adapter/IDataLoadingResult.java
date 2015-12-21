package ua.icedragon.imageslideshow.adapter;

public interface IDataLoadingResult<T> {

    void onResult(T result);

    void onFailure(Throwable ex);

}
