package com.vbyte.p2p;

import android.net.Uri;

import cn.vbyte.p2p.OnTimeoutListener;

/**
 * Created by passion on 16-1-14.
 */
public interface IController {

    /**
     * 加载一个频道，此函数没有起始时间参数
     * @param channel 对直播是频道ID，对点播是资源链接
     * @param resolution 统一为 "UHD"
     * @param listener 当成功load时的回调函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    void load(String channel, String resolution, OnLoadedListener listener) throws Exception;

    /**
     * 加载一个频道，此函数没有起始时间参数
     * @param channel 对直播是频道ID，对点播是资源链接
     * @param netState 网络状态
     * @param listener 当成功load时的回调函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    void load(String channel, int netState, OnLoadedListener listener) throws Exception;

    /**
     * 加载一个频道
     * @param channel 资源链接，主要为点播调用
     * @param resolution 统一为 "UHD"
     * @param startTime 视频的起始位置，以秒为单位
     * @param listener 当成功load时的回调函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    void load(String channel, String resolution, double startTime, OnLoadedListener listener) throws Exception;

    /**
     * 加载一个频道
     * @param channel 资源链接，主要为点播调用
     * @param resolution 统一为 "UHD"
     * @param startTime 视频的起始位置，以秒为单位
     * @param netState 网络状态
     * @param listener 当成功load时的回调函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    void load(String channel, String resolution, double startTime, int netState, OnLoadedListener listener) throws Exception;

    /**
     * 加载一个频道
     * @param channel 资源链接，主要为点播调用
     * @param resolution 统一为 "UHD"
     * @param startTime 视频的起始位置，以秒为单位
     * @param netState 网络状态
     * @param onLoadedListener 当成功load时的回调函数
     * @param onTimeoutListener 当load超时回调的函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    void load(String channel, String resolution, double startTime, int netState,
              OnLoadedListener onLoadedListener, OnTimeoutListener onTimeoutListener) throws Exception;

    /**
     * 加载一个直播流。针对时移，该接口只为flv使用
     * @param channel 直播流频道ID
     * @param netState 网络状态
     * @param onLoadedListener 当成功load时的回调函数
     * @param onTimeoutListener 当load超时回调的函数
     * @throws Exception 当load/unload没有成对调用时，会抛出异常提示
     */
    void load(String channel, int netState,
                     OnLoadedListener onLoadedListener, OnTimeoutListener onTimeoutListener)
            throws Exception;

    /**
     * 同步加载一个频道
     * @param channel 对直播是频道ID，对点播是资源链接
     * @param resolution 统一为 "UHD"
     * @return
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    Uri loadAsync(String channel, String resolution) throws Exception;

    /**
     * 同步加载一个频道
     * @param channel 资源链接，主要为点播调用
     * @param resolution 统一为 "UHD"
     * @param startTime 视频的起始位置，以秒为单位
     * @return return
     * @throws Exception 当load/unload没有成对调用时，会抛出异常
     */
    Uri loadAsync(String channel, String resolution, double startTime) throws Exception;

    /**
     * 对点播有用
     * @param startTime 随机点播时的起始时间点
     */
    void seek(double startTime);

    void pause();

    void resume();

    /**
     * 卸载一个频道或者卸载一个vod视频，释放其占用的资源
     */
    void unload();

    /**
     * 获取播放统计信息
     * @return
     */
    String playStreamInfo();

}
