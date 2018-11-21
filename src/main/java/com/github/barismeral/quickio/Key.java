package com.github.barismeral.quickio;

/**
 * @author Barış Meral
 * @version 1.0
 * @since 20118.11.12
 *
 */



/**
 *  Key interface
 *
 * @param <T>
 */
public interface Key <T> {
    /**
     *
     * @return key as String
     */
    String getKey();

    /**
     *
     * @return key path as String
     */
    String getPath();

    /**
     *
     * @return key as generic type e.g double, boolean
     */
    T getValue();


}
