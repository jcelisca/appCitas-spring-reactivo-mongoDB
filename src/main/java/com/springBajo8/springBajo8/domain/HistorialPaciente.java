package com.springBajo8.springBajo8.domain;

public class HistorialPaciente {

    private String padecimiento;

    private String tratamiento;


    public String getPadecimiento() {
        return padecimiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Historial Paciente: {" +
                "padecimiento ='" + padecimiento + '\'' +
                ", tratamiento ='" + tratamiento + '\'' +
                '}';
    }
}
