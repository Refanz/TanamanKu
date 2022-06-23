package com.dicoding.tanamanku;

public class Tanaman {

    private  int idTanaman;
    private String namaTanaman;
    private String namaIlmiah;
    private String detailTanaman;
    private int fotoTanaman;

    public Tanaman(int idTanaman, String namaTanaman, String namaIlmiah, String detailTanaman, int fotoTanaman) {
        this.idTanaman = idTanaman;
        this.namaTanaman = namaTanaman;
        this.namaIlmiah = namaIlmiah;
        this.detailTanaman = detailTanaman;
        this.fotoTanaman = fotoTanaman;
    }

    public Tanaman() {

    }

    public int getIdTanaman() {
        return idTanaman;
    }

    public void setIdTanaman(int idTanaman) {
        this.idTanaman = idTanaman;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public void setNamaTanaman(String namaTanaman) {
        this.namaTanaman = namaTanaman;
    }

    public String getDetailTanaman() {
        return detailTanaman;
    }

    public void setDetailTanaman(String detailTanaman) {
        this.detailTanaman = detailTanaman;
    }

    public int getFotoTanaman() {
        return fotoTanaman;
    }

    public void setFotoTanaman(int fotoTanaman) {
        this.fotoTanaman = fotoTanaman;
    }

    public String getNamaIlmiah() {
        return namaIlmiah;
    }

    public void setNamaIlmiah(String namaIlmiah) {
        this.namaIlmiah = namaIlmiah;
    }


}
