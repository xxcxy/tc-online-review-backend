/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.scheduler.processor;

import com.topcoder.util.file.fieldconfig.NodeList;
import com.topcoder.util.scheduler.scheduling.ScheduledEnable;

import java.util.Date;


/**
 * A v2.0 job used in test. This job will terminates 4 seconds after start.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MyJob implements ScheduledEnable {
    /** Default run time of this job. */
    public static final int DEFAULT_RUNTIME = 4000;

    /** Status. */
    private String status = ScheduledEnable.NOT_STARTED;

    /**
     * Closes the job.
     */
    public void close() {
        status = ScheduledEnable.SUCCESSFUL;
    }

    /**
     * get message.
     *
     * @return message
     */
    public NodeList getMessageData() {
        return null;
    }

    /**
     * Gets status.
     *
     * @return status
     */
    public String getRunningStatus() {
        return status;
    }

    /**
     * Gets status.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Whether is done.
     *
     * @return whether is done
     */
    public boolean isDone() {
        return (status.equals(ScheduledEnable.SUCCESSFUL) || status.equals(ScheduledEnable.FAILED));
    }

    /**
     * Run. The status will be RUNNING while this job starts, and will turn to SUCCESSFUL if it's done.
     */
    public void run() {
        System.out.println("MyJob starts at " + new Date());
        status = ScheduledEnable.RUNNING;

        try {
            Thread.sleep(DEFAULT_RUNTIME);
        } catch (InterruptedException e) {
            status = ScheduledEnable.FAILED;
        }

        status = ScheduledEnable.SUCCESSFUL;
        System.out.println("MyJob stops at " + new Date());
    }

    /**
     * Stop this job.
     */
    public void stop() {
        status = ScheduledEnable.SUCCESSFUL;
    }

    /**
     * <p>
     * Sets the job name.
     * </p>
     *
     * @param name The new job name.
     *
     * @throws IllegalArgumentException If jobName is null/empty
     *
     * @since 3.0
     */
    public void setJobName(String jobName) {
    }

    /**
     * <p>
     * Gets the job name.
     * </p>
     *
     * @return the job name.
     *
     * @since 3.0
     */
    public String getJobName() {
        return "";
    }
}
