/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.services.uploads.accuracytests;

import com.topcoder.management.deliverable.*;
import com.topcoder.management.deliverable.persistence.UploadPersistenceException;
import com.topcoder.search.builder.SearchBuilderException;
import com.topcoder.search.builder.filter.Filter;

/**
 * A mock implementation of UploadManager.
 *
 * @author kshatriyan
 * @version 1.0
 */
public class MockUploadManager implements UploadManager {

    /**
     * Used for testing.
     */
    private Upload createdUpload;

    /**
     * Used for testing.
     */
    private String createdUploadUserId;

    /**
     * Used for testing.
     */
    private Submission createdSubmission;

    /**
     * Used for testing.
     */
    private String createdSubmissionUserId;

    /**
     * Used for testing.
     */
    private Submission updatedSubmission;

    /**
     * Used for testing.
     */
    private String updatedSubmissionUserId;

    /**
     * Used for testing.
     */
    private Submission submission = new Submission(10);

    /**
     * Not used.
     *
     * @param arg0
     *            upload
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             if the flag is set
     */
    public void createUpload(Upload arg0, String arg1) throws UploadPersistenceException {
        createdUpload = arg0;
        createdUploadUserId = arg1;
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void updateUpload(Upload arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void removeUpload(Upload arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload
     * @return always null
     * @throws UploadPersistenceException
     *             not thrown
     */
    public Upload getUpload(long arg0) throws UploadPersistenceException {
        return null;
    }

    /**
     * Not used.
     *
     * @param arg0
     *            filter
     * @return always null
     * @throws UploadPersistenceException
     *             not thrown
     * @throws SearchBuilderException
     *             not thrown
     */
    public Upload[] searchUploads(Filter arg0) throws UploadPersistenceException, SearchBuilderException {
        return new Upload[] { new Upload(1) };
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload type
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void createUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload type
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void updateUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload type
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void removeUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @return upload types
     * @throws UploadPersistenceException
     *             not thrown
     */
    public UploadType[] getAllUploadTypes() throws UploadPersistenceException {
        UploadType[] types = new UploadType[4];
        types[0] = new UploadType();
        types[1] = new UploadType();
        types[2] = new UploadType();
        types[3] = new UploadType();
        types[0].setName("Submission");
        types[0].setId(1);
        types[1].setName("Review");
        types[1].setId(2);
        types[2].setName("Final Fix");
        types[2].setId(2);
        types[3].setName("Test Case");
        types[3].setId(3);
        return types;
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void createUploadStatus(UploadStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void updateUploadStatus(UploadStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            upload status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void removeUploadStatus(UploadStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation. Will throw exception if the throwError is set.
     *
     * @return upload status
     * @throws UploadPersistenceException
     *             will be thrown if the flag is set
     */
    public UploadStatus[] getAllUploadStatuses() throws UploadPersistenceException {
        UploadStatus[] status = new UploadStatus[1];
        status[0] = new UploadStatus();
        status[0].setName("Active");
        status[0].setId(1);
        return status;
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            submission
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void createSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
        createdSubmission = arg0;
        arg0.setId(AccuracyHelper.SUBMISSION_ID);
        createdSubmissionUserId = arg1;
    }

    /**
     * Not used.
     *
     * @param arg0
     *            submission
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void updateSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
        updatedSubmission = arg0;
        updatedSubmissionUserId = arg1;
    }

    /**
     * Not used.
     *
     * @param arg0
     *            submission
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void removeSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            id
     * @return submission
     * @throws UploadPersistenceException
     *             not thrown
     */
    public Submission getSubmission(long arg0) throws UploadPersistenceException {
        return submission;
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            filter
     * @return submission array
     * @throws UploadPersistenceException
     *             not thrown
     * @throws SearchBuilderException
     *             not thrown
     */
    public Submission[] searchSubmissions(Filter arg0) throws UploadPersistenceException, SearchBuilderException {
        return new Submission[] { submission };
    }

    /**
     * Not used.
     *
     * @param arg0
     *            submission status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void createSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            submission status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void updateSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not used.
     *
     * @param arg0
     *            submission status
     * @param arg1
     *            operator
     * @throws UploadPersistenceException
     *             not thrown
     */
    public void removeSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @return submission status
     * @throws UploadPersistenceException
     *             not thrown
     */
    public SubmissionStatus[] getAllSubmissionStatuses() throws UploadPersistenceException {
        SubmissionStatus[] status = new SubmissionStatus[2];
        status[0] = new SubmissionStatus(1);
        status[0].setName("Active");
        status[1] = new SubmissionStatus(2);
        status[1].setName("Deleted");
        return status;
    }

    /**
     * @return the createdSubmission
     */
    public Submission getCreatedSubmission() {
        return createdSubmission;
    }

    /**
     * @return the createdUpload
     */
    public Upload getCreatedUpload() {
        return createdUpload;
    }

    /**
     * @return the createdSubmissionUserId
     */
    public String getCreatedSubmissionUserId() {
        return createdSubmissionUserId;
    }

    /**
     * @return the createdUploadUserId
     */
    public String getCreatedUploadUserId() {
        return createdUploadUserId;
    }

    /**
     * @return the updatedSubmission
     */
    public Submission getUpdatedSubmission() {
        return updatedSubmission;
    }

    /**
     * @return the updatedSubmissionUserId
     */
    public String getUpdatedSubmissionUserId() {
        return updatedSubmissionUserId;
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            the submission type.
     * @param arg1
     *            the operator.
     */
    public void createSubmissionType(SubmissionType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @return all submission type.
     */
    public SubmissionType[] getAllSubmissionTypes() throws UploadPersistenceException {
        SubmissionType[] types = new SubmissionType[2];
        types[0] = new SubmissionType(1);
        types[0].setName("Contest Submission");
        types[1] = new SubmissionType(2);
        types[1].setName("Specification Submission");
        return types;
    }

    @Override
    public void createSubmissionImage(SubmissionImage submissionImage, String operator) throws UploadPersistenceException {

    }

    @Override
    public void updateSubmissionImage(SubmissionImage submissionImage, String operator) throws UploadPersistenceException {

    }

    @Override
    public void removeSubmissionImage(SubmissionImage submissionImage, String operator) throws UploadPersistenceException {

    }

    @Override
    public MimeType getMimeType(long id) throws UploadPersistenceException {
        return null;
    }

    @Override
    public MimeType[] getAllMimeTypes() throws UploadPersistenceException {
        return new MimeType[0];
    }

    @Override
    public SubmissionImage[] getImagesForSubmission(long submissionId) throws UploadPersistenceException {
        return new SubmissionImage[0];
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            the first argument.
     * @param arg1
     *            the second argument.
     */
    public void removeSubmissionType(SubmissionType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @param arg0
     *            the first argument.
     * @param arg1
     *            the second argument.
     */
    public void updateSubmissionType(SubmissionType arg0, String arg1) throws UploadPersistenceException {
    }
}
