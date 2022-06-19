package com.dicoding.tanamanku;

import java.util.ArrayList;

public class DataTanaman {



    private static String[] namaTanaman = {
            "Anggrek",
            "Janda Bolong",
            "Kaktus",
            "Kamboja Jepang",
            "Kuping Gajah",
            "Lidah Buaya",
            "Lidah Mertua",
            "Sirih Gading",
            "Sri Rejeki",
            "Suplir"
    };

    private static String[] namaIlmiah = {
            "Orchidaceae",
            "Monstera Adansonii",
            "Cactaceae",
            "Adenium Obesum",
            "Anthurium",
            "Aloe Vera",
            "Sansevieria",
            "Epipremnum Aureum",
            "Aglaonema",
            "Adiantum"
    };

    private static String[] detailTanaman = {

            "Anggrek adalah tanaman hias berbunga yang merupakan komoditas hortikultura unggulan dengan nilai ekonomi tinggi.",
            "Janda bolong adalah jenis tanaman hias tropis monstera yang tengah naik daun. Tanaman ini sedang diganderungi masyarakat dan biasa dipakai sebagai dekorasi ruangan bergaya minimalis atau skandinavia karena bentuknya yang dinilai memiliki estetika.",
            "Kaktus merupakan tumbuhan yang termasuk dalam famili Cactaceae. Kaktus memiliki lebih dari 2000 varietas dengan berbagai warna dan bentuk. Habitat alami kaktus adalah di gurun atau padang pasir.",
            "Kemboja jepang atau adenium (Adenium obesum) adalah spesies tanaman hias, batangnya besar, bagian bawahnya menyerupai umbi, batangnya tidak berkambium, akarnya dapat membesar menyerupai umbi, bentuk daunnya panjang ada yang lonjong, runcing, kecil, dan besar, warna bunganya bermacam-macam.",
            "Kuping gajah atau Anthurium crystallinum merupakan tanaman yang banyak ditemukan di kawasan hutan hujan Amerika Tengah dan Amerika Selatan. Anthurium crystallinum disebut kuping gajah karena memiliki daun yang lebar bak kuping gajah.",
            "Lidah buaya (Aloe vera) adalah spesies tumbuhan dengan daun berdaging tebal dari genus Aloe. Tumbuhan ini bersifat menahun, berasal dari Jazirah Arab, dan tanaman liarnya telah menyebar ke kawasan beriklim tropis, semi-tropis, dan kering di berbagai belahan dunia. Tanaman lidah buaya banyak dibudidayakan untuk pertanian, pengobatan, dan tanaman hias, dan dapat juga ditanam di dalam pot.",
            "Sansevieria atau lidah mertua adalah marga tanaman hias yang cukup populer sebagai penghias bagian dalam rumah karena tanaman ini dapat tumbuh dalam kondisi yang sedikit air dan cahaya matahari. Sansevieria memiliki daun keras, sukulen, tegak, dengan ujung meruncing.",
            "Sirih gading adalah tumbuhan merambat semi-epifit yang biasa ditanam orang sebagai penghias pekarangan atau ruangan. Tumbuhan anggota suku talas-talasan (Araceae) ini mudah dikenal dari warna daunnya yang belang warna kuning cerah hingga kuning pucat, merambat di batang pohon dengan daun yang besar sehingga menutupi batang pohon yang dirambatnya",
            "Aglaonema ( Sri rezeki ) adalah tanaman hias populer dari suku talas-talasan atau Araceae. Genus Aglaonema memiliki sekitar 30 spesies. Habitat asli tanaman ini adalah di bawah hutan hujan tropis, tumbuh baik pada areal dengan intensitas penyinaran rendah dan kelembaban tinggi. Tanaman ini memiliki akar serabut serta batang yang tidak berkambium (berkayu).",
            "Suplir adalah tumbuhan paku populer untuk penghias ruangan atau taman yang termasuk dalam marga Adiantum, yang tergolong dalam anaksuku Vittarioideae, suku Pteridaceae. Suplir memiliki penampilan ental yang khas, yang membuatnya mudah dibedakan dari jenis paku-pakuan lain."
    };

    private static int[] gambarTanaman = {
            R.drawable.anggrek,
            R.drawable.janda_bolong,
            R.drawable.kaktus,
            R.drawable.kamboja_jepang,
            R.drawable.kuping_gajah,
            R.drawable.lidah_buaya,
            R.drawable.lidah_mertua,
            R.drawable.sirih_gading,
            R.drawable.sri_rejeki,
            R.drawable.suplir
    };

    static ArrayList<Tanaman> getListTanaman(){
        ArrayList<Tanaman> list = new ArrayList<>();
        for (int position = 0; position < namaTanaman.length; position++){
            Tanaman tanaman= new Tanaman();
            tanaman.setFotoTanaman(gambarTanaman[position]);
            tanaman.setNamaTanaman(namaTanaman[position]);
            tanaman.setDetailTanaman(detailTanaman[position]);
            tanaman.setNamaIlmiah(namaIlmiah[position]);
            list.add(tanaman);
        }
        return list;
    }

}
