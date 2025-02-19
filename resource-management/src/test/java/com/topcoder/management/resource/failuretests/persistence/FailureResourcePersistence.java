/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.resource.failuretests.persistence;

import java.util.Map;

import com.topcoder.management.resource.Notification;
import com.topcoder.management.resource.NotificationType;
import com.topcoder.management.resource.Resource;
import com.topcoder.management.resource.ResourceRole;
import com.topcoder.management.resource.persistence.ResourcePersistence;
import com.topcoder.management.resource.persistence.ResourcePersistenceException;
import com.topcoder.util.sql.databaseabstraction.CustomResultSet;

/**
 * An implementation of <code>ResourcePersistence</code> used for failure tests.
 * <p>
 * It always throw <code>ResourcePersistenceException</code> in every method.
 * </p>
 *
 * @author mayi
 * @version 1.1
 * @since 1.0
 */
public class FailureResourcePersistence implements ResourcePersistence {

    /**
     * Default constructor.
     */
    public FailureResourcePersistence() {
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void addResource(Resource resource) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("addResource(Resource)");
    }

    
    /**
     * <p>
     * Get resources by given project ids
     * </p>
     *
     * @return The resources array
     *
     * @param projectIds The project ids
     * @param roles The resource prole map
     *
     * @throws ResourcePersistenceException If there is an error reading the persistence store
     */
    public Resource[] getResourcesByProjects(Long[] projectIds, long userId, Map<Long, ResourceRole> roles) throws ResourcePersistenceException {
        return null;
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void deleteResource(Resource resource) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("deleteResource(Resource)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void updateResource(Resource resource) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("updateResource(Resource)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public Resource loadResource(long resourceId) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadResource(long)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void addNotification(long user, long project, long notificationType,
            String operator) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("addNotification(long, long, long, String)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void removeNotification(long user, long project, long notificationType,
            String operator) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("removeNotification(long, long, long, String)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public Notification loadNotification(long user, long project, long notificationType)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadNotification(long, long, long)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void addNotificationType(NotificationType notificationType)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("addNotificationType(NotificationType)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void deleteNotificationType(NotificationType notificationType)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("deleteNotificationType(NotificationType)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void updateNotificationType(NotificationType notificationType) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("updateNotificationType(NotificationType)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public NotificationType loadNotificationType(long notificationTypeId)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadNotificationType(long)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void addResourceRole(ResourceRole resourceRole)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("addResourceRole(ResourceRole)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void deleteResourceRole(ResourceRole resourceRole)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("deleteResourceRole(ResourceRole)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @throws ResourcePersistenceException always
     */
    public void updateResourceRole(ResourceRole resourceRole)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("updateResourceRole(ResourceRole)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public ResourceRole loadResourceRole(long resourceId)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadResourceRole(long)");
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected.
     * @throws ResourcePersistenceException always
     */
    public Resource[] loadResources(long[] resourceIds)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadResources(long[])");
    }

    @Override
    public Resource[] loadResources(CustomResultSet resultSet) throws ResourcePersistenceException {
        return new Resource[0];
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public NotificationType[] loadNotificationTypes(long[] notificationTypeIds)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadNotificationTypes(long[])");
    }

    @Override
    public NotificationType[] loadNotificationTypes(CustomResultSet resultSet) throws ResourcePersistenceException {
        return new NotificationType[0];
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public ResourceRole[] loadResourceRoles(long[] resourceRoleIds)
            throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadResourceRoles(long[])");
    }

    @Override
    public ResourceRole[] loadResourceRoles(CustomResultSet resultSet) throws ResourcePersistenceException {
        return new ResourceRole[0];
    }

    /**
     * Always throw <code>ResourcePersistenceException</code>.
     *
     * @return un-expected
     * @throws ResourcePersistenceException always
     */
    public Notification[] loadNotifications(long[] userIds, long[] projectId,
            long[] notificationTypes) throws ResourcePersistenceException {
        throw new ResourcePersistenceException("loadNotifications(long[], long[], long[])");
    }

    @Override
    public Notification[] loadNotifications(CustomResultSet resultSet) throws ResourcePersistenceException {
        return new Notification[0];
    }
}
