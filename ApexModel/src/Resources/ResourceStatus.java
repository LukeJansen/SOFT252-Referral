/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

/**
 * Status of a resource.
 * @author lpjan
 */
public enum ResourceStatus {

    /**
     * Resource can be loaned.
     */
    AVAILABLE,

    /**
     * Resource has been loaned but is not overdue.
     */
    LOANED,

    /**
     * Resource has been loaned and is overdue.
     */
    OVERDUE
}
