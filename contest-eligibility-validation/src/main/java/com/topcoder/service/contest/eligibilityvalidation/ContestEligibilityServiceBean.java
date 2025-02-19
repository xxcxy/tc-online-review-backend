/*
 * Copyright (C) 2009 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.service.contest.eligibilityvalidation;

import com.topcoder.service.contest.eligibility.ContestEligibility;
import com.topcoder.service.contest.eligibility.dao.ContestEligibilityManager;
import com.topcoder.service.contest.eligibility.dao.ContestEligibilityManagerBean;
import com.topcoder.service.contest.eligibility.dao.ContestEligibilityPersistenceException;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * This is an implementation of <code>Contest Service Facade</code> web service
 * in form of stateless session EJB. It holds a reference to
 * {@link } which is delegated the fulfillment of requests.
 * </p>
 * 
 * <p>
 * Version 1.0.1 ((TopCoder Online Review Switch To Local Calls Assembly)) Change notes:
 *   <ol>
 *     <li>Added protected {@link #setContestEligibilityManager(ContestEligibilityManager)} and
 *     {@link #setContestEligibilityValidationManager(ContestEligibilityValidationManager)} methods to be used for
 *     injection of the managers in local environment for Online Review application.</li>
 *   </ol>
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0.1
 */
public class ContestEligibilityServiceBean implements ContestEligibilityService {

    /**
     * The logger instance for logging the information in
     * ContestServiceFacadeBean.
     *
     * @since 1.1
     */
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * <p>
     * A <code>ContestEligibilityValidationManager</code> providing access to available
     * <code>Contest Eligibility Validation EJB</code>.
     * </p>
     */
    private ContestEligibilityValidationManager contestEligibilityValidationManager = new ContestEligibilityValidationManagerBean();

    /**
     * <p>
     * A <code>ContestEligibilityManager</code> providing access to available
     * <code>Contest Eligibility Persistence EJB</code>.
     * </p>
     */
    private ContestEligibilityManager contestEligibilityManager = new ContestEligibilityManagerBean();
   
    /**
     * Returns whether a user is eligible for a particular contest.
     *
     * @param userId
     *            The user id
     * @param contestId
     *            The contest id
     * @param isStudio
     *            true if the contest is a studio contest, false otherwise.
     * @return true if the user is eligible for the specified contest, false otherwise.
     * 
     * @throws ContestEligibilityValidatorException
     *             if any other error occurs
     * @since 1.2.2
     */
    public boolean isEligible(long userId, long contestId, boolean isStudio) throws ContestEligibilityValidatorException {
        String methodName = "isEligible";
        logger.debug("Enter: " + methodName);

        boolean eligible;
    	
    	try {
			List<ContestEligibility> eligibilities = contestEligibilityManager.getContestEligibility(contestId, isStudio);
			eligible = contestEligibilityValidationManager.validate(userId, eligibilities);
		} catch (ContestEligibilityPersistenceException e) {
            logger.error(e.getMessage(), e);
            throw new ContestEligibilityValidatorException(e.getMessage(), e);
		} catch (ContestEligibilityValidationManagerException e) {
            logger.error(e.getMessage(), e);
            throw new ContestEligibilityValidatorException(e.getMessage(), e);
		}
    	    	
        logger.debug("Exit: " + methodName);
    	return eligible;
    }

     /**
     * Returns whether a contest has any eligibility
     *
     * @param contestId
     *            The contest id
     * @param isStudio
     *            true if the contest is a studio contest, false otherwise.
     * @return true if the user is eligible for the specified contest, false otherwise.
     * 
     * @throws ContestEligibilityValidatorException
     *             if any other error occurs
     * @since 1.2
     */
    public boolean hasEligibility(long contestId, boolean isStudio) throws ContestEligibilityValidatorException {

        String methodName = "hasEligibility";
        logger.debug("Enter: " + methodName);

        List<ContestEligibility> eligibilities;
    	
    	try {
			 eligibilities = contestEligibilityManager.getContestEligibility(contestId, isStudio);
		} catch (ContestEligibilityPersistenceException e) {
            logger.error(e.getMessage(), e);
            throw new ContestEligibilityValidatorException(e.getMessage(), e);
		}
    	    	
        if (eligibilities == null || eligibilities.size() == 0) {
            return false;
        }

        return true;
    }


    /**
     * Return a list of contest ids that has eligibility.
     *
     * @param contestIds
     *            the contest id list
     * @param isStudio
     *            the flag used to indicate whether it is studio
     * @return a list of contest ids
     * @throws IllegalArgumentException
     *             if contestId is not positive
     */
    public Set<Long> haveEligibility(Long[] contestIds, boolean isStudio) throws ContestEligibilityValidatorException
    {

        try {
			 return contestEligibilityManager.haveEligibility(contestIds, isStudio);
		} catch (ContestEligibilityPersistenceException e) {
            logger.error(e.getMessage(), e);
            throw new ContestEligibilityValidatorException(e.getMessage(), e);
		}
    }

    /**
     * <p>Sets the contest eligibility validation manager to be used by this service in local environment.</p>
     *
     * @param contestEligibilityValidationManager a <code>ContestEligibilityValidationManager</code> to be used by this
     *        service in local environment.
     * @throws IllegalArgumentException if specified <code>contestEligibilityValidationManager</code> is
     *         <code>null</code>.
     * @since 1.0.1
     */
    protected void setContestEligibilityValidationManager(
        ContestEligibilityValidationManager contestEligibilityValidationManager) {
        if (contestEligibilityValidationManager == null) {
            throw new IllegalArgumentException("The parameter [contestEligibilityValidationManager] is NULL");
        }
        this.contestEligibilityValidationManager = contestEligibilityValidationManager;
    }

    /**
     * <p>Sets the contest eligibility manager to be used by this service in local environment.</p>
     *
     * @param contestEligibilityManager a <code>ContestEligibilityManager</code> to be used by this
     *        service in local environment.
     * @throws IllegalArgumentException if specified <code>contestEligibilityManager</code> is <code>null</code>.
     * @since 1.0.1
     */
    protected void setContestEligibilityManager(ContestEligibilityManager contestEligibilityManager) {
        if (contestEligibilityManager == null) {
            throw new IllegalArgumentException("The parameter [contestEligibilityManager] is NULL");
        }
        this.contestEligibilityManager = contestEligibilityManager;
    }
}
