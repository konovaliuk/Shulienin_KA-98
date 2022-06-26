package entities;

public class DiagnosisInfo {
    private int id;
    private String type;
    private int patientId;
    private int staffId;
    private int diagnosisId;
    private int drugsId;
    private int proceduresId;
    private int surgeriesId;

    public DiagnosisInfo(int id, String type, int patientId, int staffId, int diagnosisId, int drugsId, int proceduresId, int surgeriesId) {
        this.id = id;
        this.type = type;
        this.patientId = patientId;
        this.staffId = staffId;
        this.diagnosisId = diagnosisId;
        this.drugsId = drugsId;
        this.proceduresId = proceduresId;
        this.surgeriesId = surgeriesId;
    }

    public DiagnosisInfo(String type, int patientId, int staffId, int diagnosisId, int drugsId, int proceduresId, int surgeriesId) {
        this.type = type;
        this.patientId = patientId;
        this.staffId = staffId;
        this.diagnosisId = diagnosisId;
        this.drugsId = drugsId;
        this.proceduresId = proceduresId;
        this.surgeriesId = surgeriesId;
    }

    public DiagnosisInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public int getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(int drugsId) {
        this.drugsId = drugsId;
    }

    public int getProceduresId() {
        return proceduresId;
    }

    public void setProceduresId(int proceduresId) {
        this.proceduresId = proceduresId;
    }

    public int getSurgeriesId() {
        return surgeriesId;
    }

    public void setSurgeriesId(int surgeriesId) {
        this.surgeriesId = surgeriesId;
    }

    @Override
    public String toString(){
        return "Diagnosis_info {" +
                "id = " + id +
                ", type = '" + type + '\'' +
                ", patient_id = '" + patientId + '\'' +
                ", staff_id = '" + staffId + '\'' +
                ", diagnosis_id = '" + diagnosisId + '\'' +
                ", drugs_id = '" + drugsId + '\'' +
                ", procedures_id = '" + proceduresId + '\'' +
                ", surgery_id = '" + surgeriesId + '\'' +

                '}';}
}
