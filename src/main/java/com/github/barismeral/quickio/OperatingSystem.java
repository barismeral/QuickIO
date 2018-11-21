package com.github.barismeral.quickio;

/**
 * @author Barış Meral
 * @version 1.0
 * @since 20118.11.12
 *
 */




/**
 * operating System info interfaces
 */
public interface OperatingSystem {
    /**
     *
     * @return operating system name
     */
    String getName();


    /**
     * @return operating system data directory for windows C:\ProgramData
     * or Linux /usr/sbin"
     *
     */
    String getPath();


}
