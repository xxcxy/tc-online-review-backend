/*
 * Copyright (C) 2007-2010 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.services.uploads.impl;

import com.cronos.onlinereview.services.uploads.TestHelper;
import com.topcoder.management.deliverable.*;
import com.topcoder.management.deliverable.persistence.UploadPersistenceException;
import com.topcoder.search.builder.SearchBuilderException;
import com.topcoder.search.builder.filter.Filter;

/**
 * A mock implementation of UploadManager.
 *
 * @author cyberjag, TCSDEVELOPER
 * @version 1.1
 */
public class MockUploadManager implements UploadManager {
    /**
     * A static state variable for the mock.
     */
    private static int state = 0;

    /**
     * A flag to indicate whether to throw error.
     */
    private static boolean throwError = false;

    /**
     * A flag to indicate whether to throw error on create upload.
     */
    private static boolean throwOnCreateError = false;

    /**
     * Used for testing purpose.
     */
    private Submission createdSubmission;

    /**
     * Used for testing purpose.
     */
    private Upload createdUpload;

    /**
     * Used for testing purpose.
     */
    private String createdUploadUserId;

    /**
     * Used for testing purpose.
     */
    private String createdSubmissionUserId;

    /**
     * Used for testing purpose.
     */
    private Submission submission = new Submission(10);

    /**
     * Used for testing purpose.
     */
    private Upload updatedUpload;

    /**
     * Will throw exception if the throwOnCreateError is set.
     *
     * @param arg0 upload
     * @param arg1 operator
     *
     * @throws UploadPersistenceException if the flag is set
     */
    public void createUpload(Upload arg0, String arg1) throws UploadPersistenceException {
        if (isThrowOnCreateError()) {
            throw new UploadPersistenceException("Mock");
        }
        createdUpload = arg0;
        createdUploadUserId = arg1;
    }

    /**
     * Not implemented.
     *
     * @param upload upload
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void updateUpload(Upload upload, String arg1) throws UploadPersistenceException {

        this.updatedUpload = upload;
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void removeUpload(Upload arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload
     *
     * @return always null
     *
     * @throws UploadPersistenceException not thrown
     */
    public Upload getUpload(long arg0) throws UploadPersistenceException {
        return null;
    }

    /**
     * Not implemented.
     *
     * @param arg0 filter
     *
     * @return always null
     *
     * @throws UploadPersistenceException not thrown
     * @throws SearchBuilderException     not thrown
     */
    public Upload[] searchUploads(Filter arg0) throws UploadPersistenceException, SearchBuilderException {

        // modified in version 1.1 to allow test pass

        return new Upload[] {new Upload(1)};
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload type
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void createUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload type
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void updateUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload type
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void removeUploadType(UploadType arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @return upload types
     *
     * @throws UploadPersistenceException not thrown
     */
    public UploadType[] getAllUploadTypes() throws UploadPersistenceException {
        if (getState() == 0) {
            UploadType[] types = new UploadType[4];
            for (int i = 0; i < types.length; i++) {

                // modified in version 1.1 - because upload type id needs to be grated then zero
                types[i] = new UploadType(i + 1);
            }
            types[0].setName("Submission");
            types[1].setName("Review");
            types[2].setName("Final Fix");
            // added in version 1.1
            types[3].setName("Test Case");
            return types;
        }
        return null;
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void createUploadStatus(UploadStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param upload upload status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void updateUploadStatus(UploadStatus upload, String arg1) throws UploadPersistenceException {
        // does nothing
    }

    /**
     * Not implemented.
     *
     * @param arg0 upload status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void removeUploadStatus(UploadStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation. Will throw exception if the throwError is set.
     *
     * @return upload status
     *
     * @throws UploadPersistenceException will be thrown if the flag is set
     */
    public UploadStatus[] getAllUploadStatuses() throws UploadPersistenceException {
        if (isThrowError()) {
            throw new UploadPersistenceException("Mock");
        }

        if (getState() == 0) {
            UploadStatus[] status = new UploadStatus[2];

            // modified in version 1.1 - because upload id needs to be grated then zero
            status[0] = new UploadStatus(1);
            status[0].setName("Active");

            status[1] = new UploadStatus(2);
            status[1].setName("Deleted");
            return status;
        }
        return null;
    }

    /**
     * Mock implementation.
     *
     * @param arg0 submission
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void createSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
        arg0.setId(TestHelper.SUBMISSION_ID);
        createdSubmission = arg0;
        createdSubmissionUserId = arg1;
    }

    /**
     * Not implemented.
     *
     * @param arg0 submission
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void updateSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 submission
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void removeSubmission(Submission arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @param arg0 id
     *
     * @return submission
     *
     * @throws UploadPersistenceException not thrown
     */
    public Submission getSubmission(long arg0) throws UploadPersistenceException {
        if (isThrowError()) {
            throw new UploadPersistenceException("Mock");
        }
        if (getState() == 0) {
            return submission;
        }
        return null;
    }

    /**
     * Mock implementation.
     *
     * @param arg0 filter
     *
     * @return submission array
     *
     * @throws UploadPersistenceException not thrown
     * @throws SearchBuilderException     not thrown
     */
    public Submission[] searchSubmissions(Filter arg0) throws UploadPersistenceException, SearchBuilderException {
        Submission[] submissions = new Submission[1];
        submissions[0] = submission;
        return submissions;
    }

    /**
     * Not implemented.
     *
     * @param arg0 submission status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void createSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 submission status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void updateSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Not implemented.
     *
     * @param arg0 submission status
     * @param arg1 operator
     *
     * @throws UploadPersistenceException not thrown
     */
    public void removeSubmissionStatus(SubmissionStatus arg0, String arg1) throws UploadPersistenceException {
    }

    /**
     * Mock implementation.
     *
     * @return submission status
     *
     * @throws UploadPersistenceException not thrown
     */
    public SubmissionStatus[] getAllSubmissionStatuses() throws UploadPersistenceException {
        if (getState() == 0) {
            SubmissionStatus[] status = new SubmissionStatus[2];
            status[0] = new SubmissionStatus(1);
            status[0].setName("Active");
            status[1] = new SubmissionStatus(2);
            status[1].setName("Deleted");
            return status;
        }
        return null;
    }

    /**
     * Not implemented
     *
     * @param submissionType submission type
     * @param operator       operator
     *
     * @throws UploadPersistenceException never thrown
     */
    public void createSubmissionType(SubmissionType submissionType, String operator) throws UploadPersistenceException {
        // does nothing
    }

    /**
     * Not implemented
     *
     * @param submissionType submission type
     * @param operator       operator
     *
     * @throws UploadPersistenceException never thrown
     */
    public void updateSubmissionType(SubmissionType submissionType, String operator) throws UploadPersistenceException {
        // does nothing
    }

    /**
     * Not implemented
     *
     * @param submissionType submission type
     * @param operator       operator
     *
     * @throws UploadPersistenceException never thrown
     */
    public void removeSubmissionType(SubmissionType submissionType, String operator) throws UploadPersistenceException {
        // does nothing
    }

    /**
     * Not implemented
     *
     * @return array of submission types
     *
     * @throws UploadPersistenceException never thrown
     */
    public SubmissionType[] getAllSubmissionTypes() throws UploadPersistenceException {

        if (getState() == 0) {
            SubmissionType[] status = new SubmissionType[2];
            status[0] = new SubmissionType(1);
            status[0].setName("Contest Submission");
            status[1] = new SubmissionType(2);
            status[1].setName("Specification Submission");
            return status;
        }

        return new SubmissionType[0];
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
     * Sets the state.
     *
     * @param state the state to set
     */
    public static void setState(int state) {
        MockUploadManager.state = state;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    static int getState() {
        return state;
    }

    /**
     * Sets the throwError.
     *
     * @param throwError the throwError to set
     */
    static void setThrowError(boolean throwError) {
        MockUploadManager.throwError = throwError;
    }

    /**
     * Gets the throwError.
     *
     * @return the throwError
     */
    static boolean isThrowError() {
        return throwError;
    }

    /**
     * Sets the throwOnCreateError.
     *
     * @param throwOnCreateError the throwOnCreateError to set
     */
    static void setThrowOnCreateError(boolean throwOnCreateError) {
        MockUploadManager.throwOnCreateError = throwOnCreateError;
    }

    /**
     * Gets the throwOnCreateError.
     *
     * @return the throwOnCreateError
     */
    static boolean isThrowOnCreateError() {
        return throwOnCreateError;
    }

    /**
     * Gets the created upload.
     *
     * @return the created upload
     */
    Upload getCreatedUpload() {
        return createdUpload;
    }

    /**
     * Gets the created upload user id.
     *
     * @return the created user id
     */
    String getCreatedUploadUserId() {
        return createdUploadUserId;
    }

    /**
     * Gets the created submission.
     *
     * @return the created submission
     */
    Submission getCreatedSubmission() {
        return createdSubmission;
    }

    /**
     * Gets the created submission user id.
     *
     * @return the created submission user id
     */
    String getCreatedSubmissionUserId() {
        return createdSubmissionUserId;
    }

    /**
     * Gets the updated upload.
     *
     * @return the updated upload
     */
    public Upload getUpdatedUpload() {
        return updatedUpload;
    }

    /**
     * Sets the updated upload.
     *
     * @param updatedUpload the updated upload
     */
    public void setUpdatedUpload(Upload updatedUpload) {
        this.updatedUpload = updatedUpload;
    }
}
