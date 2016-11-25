package br.uff.labmoveis.sobrazero.Models;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Claudio Big Data on 17/11/2016.
 */

public class DataConsuming {
    private static DataConsuming INSTANCE = new DataConsuming();
    public static DataConsuming getINSTANCE() { return INSTANCE; }

    private String alimento1;
    private String alimento2;
    private String alimento3;
    private int votosAliment1;
    private int votosAliment2;
    private int votosAliment3;
    private int totalVotos;

    private String saudacao;
    private Map<String, Integer> mesGasto ;

    public DataConsuming() {
        InitComponents();
    }

    private void InitComponents() {
        this.alimento1 = "";
        this.alimento2 = "";
        this.alimento3 = "";

        this.votosAliment1 = 0;
        this.votosAliment2 = 0;
        this.votosAliment3 = 0;
        this.totalVotos = 0;
        this.saudacao = "";
        this.mesGasto = new TreeMap<>();
    }

    public void incrementaVoto1() { this.votosAliment1++; this.totalVotos++; }

    public void incrementaVoto2() { this.votosAliment2++; this.totalVotos++; }

    public void incrementaVoto3() { this.votosAliment3++; this.totalVotos++; }

    public int getVotosAliment1() {
        return votosAliment1;
    }

    public void setVotosAliment1(int votosAliment1) {
        this.votosAliment1 = votosAliment1;
    }

    public int getVotosAliment2() {
        return votosAliment2;
    }

    public void reiniciaVotacao(){ this.votosAliment1 = this.votosAliment2 = this.votosAliment3 = this.totalVotos = 0; }

    public void setVotosAliment2(int votosAliment2) {
        this.votosAliment2 = votosAliment2;
    }

    public int getVotosAliment3() {
        return votosAliment3;
    }

    public void setVotosAliment3(int votosAliment3) {
        this.votosAliment3 = votosAliment3;
    }

    public static void setINSTANCE(DataConsuming INSTANCE) {
        DataConsuming.INSTANCE = INSTANCE;
    }

    public String getAlimento1() {
        return alimento1;
    }

    public void setAlimento1(String alimento1) {
        this.alimento1 = alimento1;
    }

    public String getAlimento2() {
        return alimento2;
    }

    public void setAlimento2(String alimento2) {
        this.alimento2 = alimento2;
    }

    public String getAlimento3() {
        return alimento3;
    }

    public void setAlimento3(String alimento3) {
        this.alimento3 = alimento3;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }

    public Map<String, Integer> getMesGasto() {
        return mesGasto;
    }

    public void setMesGasto(Map<String, Integer> mesGasto) {
        this.mesGasto = mesGasto;
    }
}
