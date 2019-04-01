package sv.com.tesa.ticket.beans;

import java.sql.ResultSet;

public class CasesBean {

    public CasesBean(){
        
    }
    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the request
     */
    public int getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(int request) {
        this.request = request;
    }

    /**
     * @return the assigned_to
     */
    public int getAssigned_to() {
        return assigned_to;
    }

    /**
     * @param assigned_to the assigned_to to set
     */
    public void setAssigned_to(int assigned_to) {
        this.assigned_to = assigned_to;
    }

    /**
     * @return the case_status
     */
    public int getCase_status() {
        return case_status;
    }

    /**
     * @param case_status the case_status to set
     */
    public void setCase_status(int case_status) {
        this.case_status = case_status;
    }

    /**
     * @return the descrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * @param descrip the descrip to set
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * @return the tester
     */
    public int getTester() {
        return tester;
    }

    /**
     * @param tester the tester to set
     */
    public void setTester(int tester) {
        this.tester = tester;
    }
    
    
    private String Id;
    private int request;
    private int assigned_to;
    private int case_status;
    private String descrip;
    private double percent;
    private int tester;
    
}
